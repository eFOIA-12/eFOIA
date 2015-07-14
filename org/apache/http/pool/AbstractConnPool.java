package org.apache.http.pool;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPool;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolEntry;
import org.apache.http.pool.PoolEntryCallback;
import org.apache.http.pool.PoolEntryFuture;
import org.apache.http.pool.PoolStats;
import org.apache.http.pool.RouteSpecificPool;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@ThreadSafe
public abstract class AbstractConnPool implements ConnPool, ConnPoolControl {
   private final LinkedList available;
   private final ConnFactory connFactory;
   private volatile int defaultMaxPerRoute;
   private volatile boolean isShutDown;
   private final Set leased;
   private final Lock lock;
   private final Map maxPerRoute;
   private volatile int maxTotal;
   private final LinkedList pending;
   private final Map routeToPool;

   public AbstractConnPool(ConnFactory var1, int var2, int var3) {
      this.connFactory = (ConnFactory)Args.notNull(var1, "Connection factory");
      this.defaultMaxPerRoute = Args.notNegative(var2, "Max per route value");
      this.maxTotal = Args.notNegative(var3, "Max total value");
      this.lock = new ReentrantLock();
      this.routeToPool = new HashMap();
      this.leased = new HashSet();
      this.available = new LinkedList();
      this.pending = new LinkedList();
      this.maxPerRoute = new HashMap();
   }

   // $FF: synthetic method
   static PoolEntry access$000(AbstractConnPool var0, Object var1, Object var2, long var3, TimeUnit var5, PoolEntryFuture var6) throws IOException, InterruptedException, TimeoutException {
      return var0.getPoolEntryBlocking(var1, var2, var3, var5, var6);
   }

   private void enumEntries(Iterator var1, PoolEntryCallback var2) {
      while(var1.hasNext()) {
         PoolEntry var3 = (PoolEntry)var1.next();
         var2.process(var3);
         if(var3.isClosed()) {
            this.getPool(var3.getRoute()).remove(var3);
            var1.remove();
         }
      }

   }

   private int getMax(Object var1) {
      Integer var2 = (Integer)this.maxPerRoute.get(var1);
      return var2 != null?var2.intValue():this.defaultMaxPerRoute;
   }

   private RouteSpecificPool getPool(final Object var1) {
      RouteSpecificPool var3 = (RouteSpecificPool)this.routeToPool.get(var1);
      RouteSpecificPool var2 = var3;
      if(var3 == null) {
         var2 = new RouteSpecificPool(var1) {
            protected PoolEntry createEntry(Object var1x) {
               return AbstractConnPool.this.createEntry(var1, var1x);
            }
         };
         this.routeToPool.put(var1, var2);
      }

      return var2;
   }

   private PoolEntry getPoolEntryBlocking(Object param1, Object param2, long param3, TimeUnit param5, PoolEntryFuture param6) throws IOException, InterruptedException, TimeoutException {
      // $FF: Couldn't be decompiled
   }

   private void purgePoolMap() {
      Iterator var1 = this.routeToPool.entrySet().iterator();

      while(var1.hasNext()) {
         RouteSpecificPool var2 = (RouteSpecificPool)((Entry)var1.next()).getValue();
         if(var2.getPendingCount() + var2.getAllocatedCount() == 0) {
            var1.remove();
         }
      }

   }

   public void closeExpired() {
      this.enumAvailable(new PoolEntryCallback() {
         // $FF: synthetic field
         final long val$now;

         {
            this.val$now = var2;
         }

         public void process(PoolEntry var1) {
            if(var1.isExpired(this.val$now)) {
               var1.close();
            }

         }
      });
      this.purgePoolMap();
   }

   public void closeIdle(long var1, TimeUnit var3) {
      Args.notNull(var3, "Time unit");
      long var4 = var3.toMillis(var1);
      var1 = var4;
      if(var4 < 0L) {
         var1 = 0L;
      }

      this.enumAvailable(new PoolEntryCallback() {
         // $FF: synthetic field
         final long val$deadline;

         {
            this.val$deadline = var2;
         }

         public void process(PoolEntry var1) {
            if(var1.getUpdated() <= this.val$deadline) {
               var1.close();
            }

         }
      });
      this.purgePoolMap();
   }

   protected abstract PoolEntry createEntry(Object var1, Object var2);

   protected void enumAvailable(PoolEntryCallback var1) {
      this.lock.lock();

      try {
         this.enumEntries(this.available.iterator(), var1);
      } finally {
         this.lock.unlock();
      }

   }

   protected void enumLeased(PoolEntryCallback var1) {
      this.lock.lock();

      try {
         this.enumEntries(this.leased.iterator(), var1);
      } finally {
         this.lock.unlock();
      }

   }

   public int getDefaultMaxPerRoute() {
      this.lock.lock();

      int var1;
      try {
         var1 = this.defaultMaxPerRoute;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public int getMaxPerRoute(Object var1) {
      Args.notNull(var1, "Route");
      this.lock.lock();

      int var2;
      try {
         var2 = this.getMax(var1);
      } finally {
         this.lock.unlock();
      }

      return var2;
   }

   public int getMaxTotal() {
      this.lock.lock();

      int var1;
      try {
         var1 = this.maxTotal;
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public PoolStats getStats(Object var1) {
      Args.notNull(var1, "Route");
      this.lock.lock();

      PoolStats var5;
      try {
         RouteSpecificPool var2 = this.getPool(var1);
         var5 = new PoolStats(var2.getLeasedCount(), var2.getPendingCount(), var2.getAvailableCount(), this.getMax(var1));
      } finally {
         this.lock.unlock();
      }

      return var5;
   }

   public PoolStats getTotalStats() {
      this.lock.lock();

      PoolStats var1;
      try {
         var1 = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public boolean isShutdown() {
      return this.isShutDown;
   }

   public Future lease(Object var1, Object var2) {
      return this.lease(var1, var2, (FutureCallback)null);
   }

   public Future lease(final Object var1, final Object var2, final FutureCallback var3) {
      Args.notNull(var1, "Route");
      boolean var4;
      if(!this.isShutDown) {
         var4 = true;
      } else {
         var4 = false;
      }

      Asserts.check(var4, "Connection pool shut down");
      return new PoolEntryFuture(this.lock, var3) {
         public PoolEntry getPoolEntry(long var1x, TimeUnit var3) throws InterruptedException, TimeoutException, IOException {
            PoolEntry var4 = AbstractConnPool.access$000(AbstractConnPool.this, var1, var2, var1x, var3, this);
            AbstractConnPool.this.onLease(var4);
            return var4;
         }
      };
   }

   protected void onLease(PoolEntry var1) {
   }

   protected void onRelease(PoolEntry var1) {
   }

   public void release(PoolEntry param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void setDefaultMaxPerRoute(int var1) {
      Args.notNegative(var1, "Max per route value");
      this.lock.lock();

      try {
         this.defaultMaxPerRoute = var1;
      } finally {
         this.lock.unlock();
      }

   }

   public void setMaxPerRoute(Object var1, int var2) {
      Args.notNull(var1, "Route");
      Args.notNegative(var2, "Max per route value");
      this.lock.lock();

      try {
         this.maxPerRoute.put(var1, Integer.valueOf(var2));
      } finally {
         this.lock.unlock();
      }

   }

   public void setMaxTotal(int var1) {
      Args.notNegative(var1, "Max value");
      this.lock.lock();

      try {
         this.maxTotal = var1;
      } finally {
         this.lock.unlock();
      }

   }

   public void shutdown() throws IOException {
      // $FF: Couldn't be decompiled
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[leased: ");
      var1.append(this.leased);
      var1.append("][available: ");
      var1.append(this.available);
      var1.append("][pending: ");
      var1.append(this.pending);
      var1.append("]");
      return var1.toString();
   }
}
