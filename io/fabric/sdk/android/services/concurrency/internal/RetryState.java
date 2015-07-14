package io.fabric.sdk.android.services.concurrency.internal;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;

public class RetryState {
   private final Backoff backoff;
   private final int retryCount;
   private final RetryPolicy retryPolicy;

   public RetryState(int var1, Backoff var2, RetryPolicy var3) {
      this.retryCount = var1;
      this.backoff = var2;
      this.retryPolicy = var3;
   }

   public RetryState(Backoff var1, RetryPolicy var2) {
      this(0, var1, var2);
   }

   public Backoff getBackoff() {
      return this.backoff;
   }

   public int getRetryCount() {
      return this.retryCount;
   }

   public long getRetryDelay() {
      return this.backoff.getDelayMillis(this.retryCount);
   }

   public RetryPolicy getRetryPolicy() {
      return this.retryPolicy;
   }

   public RetryState initialRetryState() {
      return new RetryState(this.backoff, this.retryPolicy);
   }

   public RetryState nextRetryState() {
      return new RetryState(this.retryCount + 1, this.backoff, this.retryPolicy);
   }
}
