package io.fabric.sdk.android;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.InitializationException;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

class InitializationTask extends PriorityAsyncTask {
   private static final String TIMING_METRIC_TAG = "KitInitialization";
   final Kit kit;

   public InitializationTask(Kit var1) {
      this.kit = var1;
   }

   private TimingMetric createAndStartTimingMetric(String var1) {
      TimingMetric var2 = new TimingMetric(this.kit.getIdentifier() + "." + var1, "KitInitialization");
      var2.startMeasuring();
      return var2;
   }

   protected Object doInBackground(Void... var1) {
      TimingMetric var2 = this.createAndStartTimingMetric("doInBackground");
      Object var3 = null;
      if(!this.isCancelled()) {
         var3 = this.kit.doInBackground();
      }

      var2.stopMeasuring();
      return var3;
   }

   public Priority getPriority() {
      return Priority.HIGH;
   }

   protected void onCancelled(Object var1) {
      this.kit.onCancelled(var1);
      InitializationException var2 = new InitializationException(this.kit.getIdentifier() + " Initialization was cancelled");
      this.kit.initializationCallback.failure(var2);
   }

   protected void onPostExecute(Object var1) {
      this.kit.onPostExecute(var1);
      this.kit.initializationCallback.success(var1);
   }

   protected void onPreExecute() {
      super.onPreExecute();
      TimingMetric var2 = this.createAndStartTimingMetric("onPreExecute");
      boolean var7 = false;

      boolean var1;
      label82: {
         try {
            var7 = true;
            var1 = this.kit.onPreExecute();
            var7 = false;
            break label82;
         } catch (UnmetDependencyException var8) {
            throw var8;
         } catch (Exception var9) {
            Fabric.getLogger().e("Fabric", "Failure onPreExecute()", var9);
            var7 = false;
         } finally {
            if(var7) {
               var2.stopMeasuring();
               if(true) {
                  this.cancel(true);
               }

            }
         }

         var2.stopMeasuring();
         if(true) {
            this.cancel(true);
            return;
         }

         return;
      }

      var2.stopMeasuring();
      if(!var1) {
         this.cancel(true);
      }

   }
}
