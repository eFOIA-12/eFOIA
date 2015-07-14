package com.crashlytics.android.answers;

import com.crashlytics.android.answers.RandomBackoff;
import com.crashlytics.android.answers.RetryManager;
import com.crashlytics.android.answers.SessionAnalyticsFilesSender;
import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import java.util.List;

class AnswersRetryFilesSender implements FilesSender {
   private static final int BACKOFF_MS = 1000;
   private static final int BACKOFF_POWER = 8;
   private static final double JITTER_PERCENT = 0.1D;
   private static final int MAX_RETRIES = 5;
   private final SessionAnalyticsFilesSender filesSender;
   private final RetryManager retryManager;

   AnswersRetryFilesSender(SessionAnalyticsFilesSender var1, RetryManager var2) {
      this.filesSender = var1;
      this.retryManager = var2;
   }

   public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender var0) {
      return new AnswersRetryFilesSender(var0, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000L, 8), 0.1D), new DefaultRetryPolicy(5))));
   }

   public boolean send(List var1) {
      boolean var2 = false;
      long var3 = System.nanoTime();
      if(this.retryManager.canRetry(var3)) {
         if(!this.filesSender.send(var1)) {
            this.retryManager.recordRetry(var3);
            return false;
         }

         this.retryManager.reset();
         var2 = true;
      }

      return var2;
   }
}
