package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.settings.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

public interface SettingsJsonTransform {
   SettingsData buildFromJson(CurrentTimeProvider var1, JSONObject var2) throws JSONException;

   JSONObject sanitizeTraceInfo(JSONObject var1) throws JSONException;

   JSONObject toJson(SettingsData var1) throws JSONException;
}
