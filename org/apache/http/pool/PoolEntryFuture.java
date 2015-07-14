package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.util.Args;

@ThreadSafe
abstract class PoolEntryFuture implements Future {
   private final FutureCallback callback;
   private volatile boolean cancelled;
   private volatile boolean completed;
   private final Condition condition;
   private final Lock lock;
   private Object result;

   PoolEntryFuture(Lock var1, FutureCallback var2) {
      this.lock = var1;
      this.condition = var1.newCondition();
      this.callback = var2;
   }

   public boolean await(Date param1) throws InterruptedException {
      // $FF: Couldn't be decompiled
   }

   public boolean cancel(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public Object get() throws InterruptedException, ExecutionException {
      try {
         Object var1 = this.get(0L, TimeUnit.MILLISECONDS);
         return var1;
      } catch (TimeoutException var2) {
         throw new ExecutionException(var2);
      }
   }

   public Object get(long var1, TimeUnit var3) throws InterruptedException, ExecutionException, TimeoutException {
      Args.notNull(var3, "Time unit");
      this.lock.lock();

      Object var8;
      try {
         if(this.completed) {
            var8 = this.result;
            return var8;
         }

         this.result = this.getPoolEntry(var1, var3);
         this.completed = true;
         if(this.callback != null) {
            this.callback.completed(this.result);
         }

         var8 = this.result;
      } catch (IOException var6) {
         this.completed = true;
         this.result = null;
         if(this.callback != null) {
            this.callback.failed(var6);
         }

         throw new ExecutionException(var6);
      } finally {
         this.lock.unlock();
      }

      return var8;
   }

   protected abstract Object getPoolEntry(long var1, TimeUnit var3) throws IOException, InterruptedException, TimeoutException;

   public boolean isCancelled() {
      return this.cancelled;
   }

   public boolean isDone() {
      return this.completed;
   }

   public void wakeup() {
      this.lock.lock();

      try {
         this.condition.signalAll();
      } finally {
         this.lock.unlock();
      }

   }
}
