package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

class RetryManager {
   private static final long NANOSECONDS_IN_MS = 1000000L;
   long lastRetry;
   private RetryState retryState;

   public RetryManager(RetryState var1) {
      if(var1 == null) {
         throw new NullPointerException("retryState must not be null");
      } else {
         this.retryState = var1;
      }
   }

   public boolean canRetry(long var1) {
      long var3 = this.retryState.getRetryDelay();
      return var1 - this.lastRetry >= 1000000L * var3;
   }

   public void recordRetry(long var1) {
      this.lastRetry = var1;
      this.retryState = this.retryState.nextRetryState();
   }

   public void reset() {
      this.lastRetry = 0L;
      this.retryState = this.retryState.initialRetryState();
   }
}
