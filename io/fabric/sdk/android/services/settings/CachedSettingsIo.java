package io.fabric.sdk.android.services.settings;

import org.json.JSONObject;

public interface CachedSettingsIo {
   JSONObject readCachedSettings();

   void writeCachedSettings(long var1, JSONObject var3);
}
