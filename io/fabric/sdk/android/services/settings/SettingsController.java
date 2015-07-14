package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import io.fabric.sdk.android.services.settings.SettingsData;

public interface SettingsController {
   SettingsData loadSettingsData();

   SettingsData loadSettingsData(SettingsCacheBehavior var1);
}
