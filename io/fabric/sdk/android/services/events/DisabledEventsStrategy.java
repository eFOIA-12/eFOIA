package io.fabric.sdk.android.services.events;

import io.fabric.sdk.android.services.events.EventsStrategy;
import io.fabric.sdk.android.services.events.FilesSender;

public class DisabledEventsStrategy implements EventsStrategy {
   public void cancelTimeBasedFileRollOver() {
   }

   public void deleteAllEvents() {
   }

   public FilesSender getFilesSender() {
      return null;
   }

   public void recordEvent(Object var1) {
   }

   public boolean rollFileOver() {
      return false;
   }

   public void scheduleTimeBasedRollOverIfNeeded() {
   }

   public void sendEvents() {
   }
}
