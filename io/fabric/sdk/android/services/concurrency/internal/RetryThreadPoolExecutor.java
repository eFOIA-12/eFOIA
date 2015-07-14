package io.fabric.sdk.android.services.concurrency.internal;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryFuture;
import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class RetryThreadPoolExecutor extends ScheduledThreadPoolExecutor {
   private final Backoff backoff;
   private final RetryPolicy retryPolicy;

   public RetryThreadPoolExecutor(int var1, RetryPolicy var2, Backoff var3) {
      this(var1, Executors.defaultThreadFactory(), var2, var3);
   }

   public RetryThreadPoolExecutor(int var1, ThreadFactory var2, RetryPolicy var3, Backoff var4) {
      super(var1, var2);
      if(var3 == null) {
         throw new NullPointerException("retry policy must not be null");
      } else if(var4 == null) {
         throw new NullPointerException("backoff must not be null");
      } else {
         this.retryPolicy = var3;
         this.backoff = var4;
      }
   }

   private Future scheduleWithRetryInternal(Callable var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         RetryFuture var2 = new RetryFuture(var1, new RetryState(this.backoff, this.retryPolicy), this);
         this.execute(var2);
         return var2;
      }
   }

   public Backoff getBackoff() {
      return this.backoff;
   }

   public RetryPolicy getRetryPolicy() {
      return this.retryPolicy;
   }

   public Future scheduleWithRetry(Runnable var1) {
      return this.scheduleWithRetryInternal(Executors.callable(var1));
   }

   public Future scheduleWithRetry(Runnable var1, Object var2) {
      return this.scheduleWithRetryInternal(Executors.callable(var1, var2));
   }

   public Future scheduleWithRetry(Callable var1) {
      return this.scheduleWithRetryInternal(var1);
   }
}
