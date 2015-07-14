package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public abstract class PoolEntry {
   private final Object conn;
   private final long created;
   @GuardedBy("this")
   private long expiry;
   private final String id;
   private final Object route;
   private volatile Object state;
   @GuardedBy("this")
   private long updated;
   private final long validUnit;

   public PoolEntry(String var1, Object var2, Object var3) {
      this(var1, var2, var3, 0L, TimeUnit.MILLISECONDS);
   }

   public PoolEntry(String var1, Object var2, Object var3, long var4, TimeUnit var6) {
      Args.notNull(var2, "Route");
      Args.notNull(var3, "Connection");
      Args.notNull(var6, "Time unit");
      this.id = var1;
      this.route = var2;
      this.conn = var3;
      this.created = System.currentTimeMillis();
      if(var4 > 0L) {
         this.validUnit = this.created + var6.toMillis(var4);
      } else {
         this.validUnit = Long.MAX_VALUE;
      }

      this.expiry = this.validUnit;
   }

   public abstract void close();

   public Object getConnection() {
      return this.conn;
   }

   public long getCreated() {
      return this.created;
   }

   public long getExpiry() {
      synchronized(this){}

      long var1;
      try {
         var1 = this.expiry;
      } finally {
         ;
      }

      return var1;
   }

   public String getId() {
      return this.id;
   }

   public Object getRoute() {
      return this.route;
   }

   public Object getState() {
      return this.state;
   }

   public long getUpdated() {
      synchronized(this){}

      long var1;
      try {
         var1 = this.updated;
      } finally {
         ;
      }

      return var1;
   }

   public long getValidUnit() {
      return this.validUnit;
   }

   public abstract boolean isClosed();

   public boolean isExpired(long var1) {
      synchronized(this){}
      boolean var8 = false;

      long var3;
      try {
         var8 = true;
         var3 = this.expiry;
         var8 = false;
      } finally {
         if(var8) {
            ;
         }
      }

      boolean var5;
      if(var1 >= var3) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public void setState(Object var1) {
      this.state = var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[id:");
      var1.append(this.id);
      var1.append("][route:");
      var1.append(this.route);
      var1.append("][state:");
      var1.append(this.state);
      var1.append("]");
      return var1.toString();
   }

   public void updateExpiry(long param1, TimeUnit param3) {
      // $FF: Couldn't be decompiled
   }
}
