package io.fabric.sdk.android.services.common;

import android.util.Log;

public class TimingMetric {
   private final boolean disabled;
   private long duration;
   private final String eventName;
   private long start;
   private final String tag;

   public TimingMetric(String var1, String var2) {
      this.eventName = var1;
      this.tag = var2;
      boolean var3;
      if(!Log.isLoggable(var2, 2)) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.disabled = var3;
   }

   private void reportToLog() {
      Log.v(this.tag, this.eventName + ": " + this.duration + "ms");
   }

   public long getDuration() {
      return this.duration;
   }

   public void startMeasuring() {
      // $FF: Couldn't be decompiled
   }

   public void stopMeasuring() {
      // $FF: Couldn't be decompiled
   }
}
