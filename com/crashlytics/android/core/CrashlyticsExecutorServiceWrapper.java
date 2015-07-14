package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class CrashlyticsExecutorServiceWrapper {
   private final ExecutorService executorService;

   public CrashlyticsExecutorServiceWrapper(ExecutorService var1) {
      this.executorService = var1;
   }

   Future executeAsync(final Runnable var1) {
      try {
         Future var3 = this.executorService.submit(new Runnable() {
            public void run() {
               try {
                  var1.run();
               } catch (Exception var2) {
                  Fabric.getLogger().e("Fabric", "Failed to execute task.", var2);
               }
            }
         });
         return var3;
      } catch (RejectedExecutionException var2) {
         Fabric.getLogger().d("Fabric", "Executor is shut down because we\'re handling a fatal crash.");
         return null;
      }
   }

   Future executeAsync(final Callable var1) {
      try {
         Future var3 = this.executorService.submit(new Callable() {
            public Object call() throws Exception {
               try {
                  Object var1x = var1.call();
                  return var1x;
               } catch (Exception var2) {
                  Fabric.getLogger().e("Fabric", "Failed to execute task.", var2);
                  return null;
               }
            }
         });
         return var3;
      } catch (RejectedExecutionException var2) {
         Fabric.getLogger().d("Fabric", "Executor is shut down because we\'re handling a fatal crash.");
         return null;
      }
   }

   Object executeSyncLoggingException(Callable var1) {
      try {
         if(Looper.getMainLooper() == Looper.myLooper()) {
            return this.executorService.submit(var1).get(4L, TimeUnit.SECONDS);
         } else {
            Object var4 = this.executorService.submit(var1).get();
            return var4;
         }
      } catch (RejectedExecutionException var2) {
         Fabric.getLogger().d("Fabric", "Executor is shut down because we\'re handling a fatal crash.");
         return null;
      } catch (Exception var3) {
         Fabric.getLogger().e("Fabric", "Failed to execute task.", var3);
         return null;
      }
   }
}
