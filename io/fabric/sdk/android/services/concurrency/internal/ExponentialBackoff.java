package io.fabric.sdk.android.services.concurrency.internal;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;

public class ExponentialBackoff implements Backoff {
   private static final int DEFAULT_POWER = 2;
   private final long baseTimeMillis;
   private final int power;

   public ExponentialBackoff(long var1) {
      this(var1, 2);
   }

   public ExponentialBackoff(long var1, int var3) {
      this.baseTimeMillis = var1;
      this.power = var3;
   }

   public long getDelayMillis(int var1) {
      return (long)((double)this.baseTimeMillis * Math.pow((double)this.power, (double)var1));
   }
}
