package io.fabric.sdk.android.services.events;

import io.fabric.sdk.android.services.events.EventsManager;
import io.fabric.sdk.android.services.events.FileRollOverManager;
import io.fabric.sdk.android.services.events.FilesSender;

public interface EventsStrategy extends FileRollOverManager, EventsManager {
   FilesSender getFilesSender();
}
