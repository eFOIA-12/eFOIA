package io.fabric.sdk.android.services.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.CachedSettingsIo;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import io.fabric.sdk.android.services.settings.SettingsController;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.SettingsJsonTransform;
import io.fabric.sdk.android.services.settings.SettingsRequest;
import io.fabric.sdk.android.services.settings.SettingsSpiCall;
import org.json.JSONException;
import org.json.JSONObject;

class DefaultSettingsController implements SettingsController {
   private static final String LOAD_ERROR_MESSAGE = "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.";
   private static final String PREFS_BUILD_INSTANCE_IDENTIFIER = "existing_instance_identifier";
   private final CachedSettingsIo cachedSettingsIo;
   private final CurrentTimeProvider currentTimeProvider;
   private final Kit kit;
   private final PreferenceStore preferenceStore;
   private final SettingsJsonTransform settingsJsonTransform;
   private final SettingsRequest settingsRequest;
   private final SettingsSpiCall settingsSpiCall;

   public DefaultSettingsController(Kit var1, SettingsRequest var2, CurrentTimeProvider var3, SettingsJsonTransform var4, CachedSettingsIo var5, SettingsSpiCall var6) {
      this.kit = var1;
      this.settingsRequest = var2;
      this.currentTimeProvider = var3;
      this.settingsJsonTransform = var4;
      this.cachedSettingsIo = var5;
      this.settingsSpiCall = var6;
      this.preferenceStore = new PreferenceStoreImpl(this.kit);
   }

   private SettingsData getCachedSettingsData(SettingsCacheBehavior param1) {
      // $FF: Couldn't be decompiled
   }

   private void logSettings(JSONObject var1, String var2) throws JSONException {
      JSONObject var3 = var1;
      if(!CommonUtils.isClsTrace(this.kit.getContext())) {
         var3 = this.settingsJsonTransform.sanitizeTraceInfo(var1);
      }

      Fabric.getLogger().d("Fabric", var2 + var3.toString());
   }

   boolean buildInstanceIdentifierChanged() {
      return !this.getStoredBuildInstanceIdentifier().equals(this.getBuildInstanceIdentifierFromContext());
   }

   String getBuildInstanceIdentifierFromContext() {
      return CommonUtils.createInstanceIdFrom(new String[]{CommonUtils.resolveBuildId(this.kit.getContext())});
   }

   String getStoredBuildInstanceIdentifier() {
      return this.preferenceStore.get().getString("existing_instance_identifier", "");
   }

   public SettingsData loadSettingsData() {
      return this.loadSettingsData(SettingsCacheBehavior.USE_CACHE);
   }

   public SettingsData loadSettingsData(SettingsCacheBehavior param1) {
      // $FF: Couldn't be decompiled
   }

   @SuppressLint({"CommitPrefEdits"})
   boolean setStoredBuildInstanceIdentifier(String var1) {
      Editor var2 = this.preferenceStore.edit();
      var2.putString("existing_instance_identifier", var1);
      return this.preferenceStore.save(var2);
   }
}
