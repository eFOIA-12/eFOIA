package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.BackgroundPriorityRunnable;
import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.RetryThreadPoolExecutor;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
   private static final long DEFAULT_TERMINATION_TIMEOUT = 2L;

   private static final void addDelayedShutdownHook(String var0, ExecutorService var1) {
      addDelayedShutdownHook(var0, var1, 2L, TimeUnit.SECONDS);
   }

   public static final void addDelayedShutdownHook(final String var0, final ExecutorService var1, final long var2, final TimeUnit var4) {
      Runtime.getRuntime().addShutdownHook(new Thread(new BackgroundPriorityRunnable() {
         public void onRun() {
            try {
               Fabric.getLogger().d("Fabric", "Executing shutdown hook for " + var0);
               var1.shutdown();
               if(!var1.awaitTermination(var2, var4)) {
                  Fabric.getLogger().d("Fabric", var0 + " did not shut down in the" + " allocated time. Requesting immediate shutdown.");
                  var1.shutdownNow();
               }

            } catch (InterruptedException var2x) {
               Fabric.getLogger().d("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{var0}));
               var1.shutdownNow();
            }
         }
      }, "Crashlytics Shutdown Hook for " + var0));
   }

   public static RetryThreadPoolExecutor buildRetryThreadPoolExecutor(String var0, int var1, RetryPolicy var2, Backoff var3) {
      RetryThreadPoolExecutor var4 = new RetryThreadPoolExecutor(var1, getNamedThreadFactory(var0), var2, var3);
      addDelayedShutdownHook(var0, var4);
      return var4;
   }

   public static ExecutorService buildSingleThreadExecutorService(String var0) {
      ExecutorService var1 = Executors.newSingleThreadExecutor(getNamedThreadFactory(var0));
      addDelayedShutdownHook(var0, var1);
      return var1;
   }

   public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String var0) {
      ScheduledExecutorService var1 = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(var0));
      addDelayedShutdownHook(var0, var1);
      return var1;
   }

   public static final ThreadFactory getNamedThreadFactory(final String var0) {
      return new ThreadFactory() {
         // $FF: synthetic field
         final AtomicLong val$count;

         {
            this.val$count = var2;
         }

         public Thread newThread(final Runnable var1) {
            Thread var2 = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable() {
               public void onRun() {
                  var1.run();
               }
            });
            var2.setName(var0 + this.val$count.getAndIncrement());
            return var2;
         }
      };
   }
}
