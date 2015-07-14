package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FileRollOverManager;

public class TimeBasedFileRollOverRunnable implements Runnable {
   private final Context context;
   private final FileRollOverManager fileRollOverManager;

   public TimeBasedFileRollOverRunnable(Context var1, FileRollOverManager var2) {
      this.context = var1;
      this.fileRollOverManager = var2;
   }

   public void run() {
      try {
         CommonUtils.logControlled(this.context, "Performing time based file roll over.");
         if(!this.fileRollOverManager.rollFileOver()) {
            this.fileRollOverManager.cancelTimeBasedFileRollOver();
         }

      } catch (Exception var2) {
         CommonUtils.logControlledError(this.context, "Failed to roll over file", var2);
      }
   }
}
