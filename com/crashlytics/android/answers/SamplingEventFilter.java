package com.crashlytics.android.answers;

import com.crashlytics.android.answers.EventFilter;
import com.crashlytics.android.answers.SessionEvent;
import java.util.HashSet;
import java.util.Set;

public class SamplingEventFilter implements EventFilter {
   static final Set EVENTS_TYPE_TO_SAMPLE = new HashSet() {
      {
         this.add(SessionEvent.Type.CREATE);
         this.add(SessionEvent.Type.START);
         this.add(SessionEvent.Type.RESUME);
         this.add(SessionEvent.Type.SAVE_INSTANCE_STATE);
         this.add(SessionEvent.Type.PAUSE);
         this.add(SessionEvent.Type.STOP);
         this.add(SessionEvent.Type.DESTROY);
         this.add(SessionEvent.Type.ERROR);
         this.add(SessionEvent.Type.CRASH);
      }
   };
   final int samplingRate;

   public SamplingEventFilter(int var1) {
      this.samplingRate = var1;
   }

   boolean isNeverSampledEvent(SessionEvent var1) {
      return !EVENTS_TYPE_TO_SAMPLE.contains(var1.type) || var1.sessionEventMetadata.betaDeviceToken != null;
   }

   boolean shouldSkipEventBasedOnInstallID(SessionEvent var1) {
      return Math.abs(var1.sessionEventMetadata.installationId.hashCode() % this.samplingRate) != 0;
   }

   public boolean skipEvent(SessionEvent var1) {
      return this.isNeverSampledEvent(var1)?false:this.shouldSkipEventBasedOnInstallID(var1);
   }
}
