package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.settings.SettingsRequest;
import org.json.JSONObject;

public interface SettingsSpiCall {
   JSONObject invoke(SettingsRequest var1);
}
