package io.fabric.sdk.android.services.concurrency.internal;

import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;

public class DefaultRetryPolicy implements RetryPolicy {
   private final int maxRetries;

   public DefaultRetryPolicy() {
      this(1);
   }

   public DefaultRetryPolicy(int var1) {
      this.maxRetries = var1;
   }

   public boolean shouldRetry(int var1, Throwable var2) {
      return var1 < this.maxRetries;
   }
}
