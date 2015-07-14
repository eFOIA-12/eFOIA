package io.fabric.sdk.android.services.events;

public interface EventsManager {
   void deleteAllEvents();

   void recordEvent(Object var1);

   void sendEvents();
}
