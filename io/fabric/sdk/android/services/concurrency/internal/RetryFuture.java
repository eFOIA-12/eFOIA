package io.fabric.sdk.android.services.concurrency.internal;

import io.fabric.sdk.android.services.concurrency.internal.AbstractFuture;
import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.concurrency.internal.RetryThreadPoolExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class RetryFuture extends AbstractFuture implements Runnable {
   private final RetryThreadPoolExecutor executor;
   RetryState retryState;
   private final AtomicReference runner;
   private final Callable task;

   RetryFuture(Callable var1, RetryState var2, RetryThreadPoolExecutor var3) {
      this.task = var1;
      this.retryState = var2;
      this.executor = var3;
      this.runner = new AtomicReference();
   }

   private Backoff getBackoff() {
      return this.retryState.getBackoff();
   }

   private int getRetryCount() {
      return this.retryState.getRetryCount();
   }

   private RetryPolicy getRetryPolicy() {
      return this.retryState.getRetryPolicy();
   }

   protected void interruptTask() {
      Thread var1 = (Thread)this.runner.getAndSet((Object)null);
      if(var1 != null) {
         var1.interrupt();
      }

   }

   public void run() {
      if(!this.isDone() && this.runner.compareAndSet((Object)null, Thread.currentThread())) {
         try {
            this.set(this.task.call());
            return;
         } catch (Throwable var6) {
            if(this.getRetryPolicy().shouldRetry(this.getRetryCount(), var6)) {
               long var1 = this.getBackoff().getDelayMillis(this.getRetryCount());
               this.retryState = this.retryState.nextRetryState();
               this.executor.schedule(this, var1, TimeUnit.MILLISECONDS);
            } else {
               this.setException(var6);
            }
         } finally {
            this.runner.getAndSet((Object)null);
         }

      }
   }
}
