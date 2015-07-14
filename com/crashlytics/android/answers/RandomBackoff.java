package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

class RandomBackoff implements Backoff {
   final Backoff backoff;
   final double jitterPercent;
   final Random random;

   public RandomBackoff(Backoff var1, double var2) {
      this(var1, var2, new Random());
   }

   public RandomBackoff(Backoff var1, double var2, Random var4) {
      if(var2 >= 0.0D && var2 <= 1.0D) {
         if(var1 == null) {
            throw new NullPointerException("backoff must not be null");
         } else if(var4 == null) {
            throw new NullPointerException("random must not be null");
         } else {
            this.backoff = var1;
            this.jitterPercent = var2;
            this.random = var4;
         }
      } else {
         throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
      }
   }

   public long getDelayMillis(int var1) {
      return (long)(this.randomJitter() * (double)this.backoff.getDelayMillis(var1));
   }

   double randomJitter() {
      double var1 = 1.0D - this.jitterPercent;
      return (1.0D + this.jitterPercent - var1) * this.random.nextDouble() + var1;
   }
}
