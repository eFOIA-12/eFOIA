package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.Dependency;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DependencyPriorityBlockingQueue extends PriorityBlockingQueue {
   static final int PEEK = 1;
   static final int POLL = 2;
   static final int POLL_WITH_TIMEOUT = 3;
   static final int TAKE = 0;
   final Queue blockedQueue = new LinkedList();
   private final ReentrantLock lock = new ReentrantLock();

   boolean canProcess(Dependency var1) {
      return var1.areDependenciesMet();
   }

   public void clear() {
      try {
         this.lock.lock();
         this.blockedQueue.clear();
         super.clear();
      } finally {
         this.lock.unlock();
      }

   }

   Object[] concatenate(Object[] var1, Object[] var2) {
      int var3 = var1.length;
      int var4 = var2.length;
      Object[] var5 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var3 + var4));
      System.arraycopy(var1, 0, var5, 0, var3);
      System.arraycopy(var2, 0, var5, var3, var4);
      return var5;
   }

   public boolean contains(Object var1) {
      boolean var4 = false;

      boolean var2;
      label43: {
         label42: {
            try {
               var4 = true;
               this.lock.lock();
               if(super.contains(var1)) {
                  var4 = false;
                  break label42;
               }

               var2 = this.blockedQueue.contains(var1);
               var4 = false;
            } finally {
               if(var4) {
                  this.lock.unlock();
               }
            }

            if(!var2) {
               var2 = false;
               break label43;
            }
         }

         var2 = true;
      }

      this.lock.unlock();
      return var2;
   }

   public int drainTo(Collection param1) {
      // $FF: Couldn't be decompiled
   }

   public int drainTo(Collection param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   Dependency get(int var1, Long var2, TimeUnit var3) throws InterruptedException {
      while(true) {
         Dependency var4 = this.performOperation(var1, var2, var3);
         if(var4 == null || this.canProcess(var4)) {
            return var4;
         }

         this.offerBlockedResult(var1, var4);
      }
   }

   boolean offerBlockedResult(int param1, Dependency param2) {
      // $FF: Couldn't be decompiled
   }

   public Dependency peek() {
      try {
         Dependency var1 = this.get(1, (Long)null, (TimeUnit)null);
         return var1;
      } catch (InterruptedException var2) {
         return null;
      }
   }

   Dependency performOperation(int var1, Long var2, TimeUnit var3) throws InterruptedException {
      switch(var1) {
      case 0:
         return (Dependency)super.take();
      case 1:
         return (Dependency)super.peek();
      case 2:
         return (Dependency)super.poll();
      case 3:
         return (Dependency)super.poll(var2.longValue(), var3);
      default:
         return null;
      }
   }

   public Dependency poll() {
      try {
         Dependency var1 = this.get(2, (Long)null, (TimeUnit)null);
         return var1;
      } catch (InterruptedException var2) {
         return null;
      }
   }

   public Dependency poll(long var1, TimeUnit var3) throws InterruptedException {
      return this.get(3, Long.valueOf(var1), var3);
   }

   public void recycleBlockedQueue() {
      // $FF: Couldn't be decompiled
   }

   public boolean remove(Object var1) {
      boolean var4 = false;

      boolean var2;
      label43: {
         label42: {
            try {
               var4 = true;
               this.lock.lock();
               if(super.remove(var1)) {
                  var4 = false;
                  break label42;
               }

               var2 = this.blockedQueue.remove(var1);
               var4 = false;
            } finally {
               if(var4) {
                  this.lock.unlock();
               }
            }

            if(!var2) {
               var2 = false;
               break label43;
            }
         }

         var2 = true;
      }

      this.lock.unlock();
      return var2;
   }

   public boolean removeAll(Collection var1) {
      boolean var2;
      boolean var3;
      try {
         this.lock.lock();
         var2 = super.removeAll(var1);
         var3 = this.blockedQueue.removeAll(var1);
      } finally {
         this.lock.unlock();
      }

      return var2 | var3;
   }

   public int size() {
      int var1;
      int var2;
      try {
         this.lock.lock();
         var1 = this.blockedQueue.size();
         var2 = super.size();
      } finally {
         this.lock.unlock();
      }

      return var1 + var2;
   }

   public Dependency take() throws InterruptedException {
      return this.get(0, (Long)null, (TimeUnit)null);
   }

   public Object[] toArray() {
      Object[] var1;
      try {
         this.lock.lock();
         var1 = this.concatenate(super.toArray(), this.blockedQueue.toArray());
      } finally {
         this.lock.unlock();
      }

      return var1;
   }

   public Object[] toArray(Object[] var1) {
      try {
         this.lock.lock();
         var1 = this.concatenate(super.toArray(var1), this.blockedQueue.toArray(var1));
      } finally {
         this.lock.unlock();
      }

      return var1;
   }
}
