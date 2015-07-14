package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.crashlytics.android.beta.BuildProperties;
import com.crashlytics.android.beta.CheckForUpdatesController;
import com.crashlytics.android.beta.DeviceTokenLoader;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.cache.MemoryValueCache;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeviceIdentifierProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.BetaSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.util.HashMap;
import java.util.Map;

public class Beta extends Kit implements DeviceIdentifierProvider {
   private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
   private static final String CRASHLYTICS_BUILD_PROPERTIES = "crashlytics-build.properties";
   static final String NO_DEVICE_TOKEN = "";
   public static final String TAG = "Beta";
   private final MemoryValueCache deviceTokenCache = new MemoryValueCache();
   private final DeviceTokenLoader deviceTokenLoader = new DeviceTokenLoader();

   private void checkForUpdates(Context var1, IdManager var2, BetaSettingsData var3, BuildProperties var4) {
      (new CheckForUpdatesController(var1, this, var2, var3, var4, new PreferenceStoreImpl(Fabric.getKit(Beta.class)), new SystemCurrentTimeProvider(), new DefaultHttpRequestFactory(Fabric.getLogger()))).checkForUpdates();
   }

   private String getBetaDeviceToken(Context var1, String var2) {
      if(this.isAppPossiblyInstalledByBeta(var2, VERSION.SDK_INT)) {
         Fabric.getLogger().d("Beta", "App was installed by Beta. Getting device token");

         boolean var3;
         String var5;
         try {
            var5 = (String)this.deviceTokenCache.get(var1, this.deviceTokenLoader);
            var3 = "".equals(var5);
         } catch (Exception var4) {
            Fabric.getLogger().e("Beta", "Failed to load the Beta device token", var4);
            return null;
         }

         return var3?null:var5;
      } else {
         Fabric.getLogger().d("Beta", "App was not installed by Beta. Skipping device token");
         return null;
      }
   }

   private BetaSettingsData getBetaSettingsData() {
      SettingsData var1 = Settings.getInstance().awaitSettingsData();
      return var1 != null?var1.betaSettingsData:null;
   }

   public static Beta getInstance() {
      return (Beta)Fabric.getKit(Beta.class);
   }

   private BuildProperties loadBuildProperties(Context param1) {
      // $FF: Couldn't be decompiled
   }

   boolean canCheckForUpdates(BetaSettingsData var1, BuildProperties var2) {
      return var1 != null && !TextUtils.isEmpty(var1.updateUrl) && var2 != null;
   }

   protected Boolean doInBackground() {
      Fabric.getLogger().d("Beta", "Beta kit initializing...");
      Context var1 = this.getContext();
      IdManager var2 = this.getIdManager();
      if(TextUtils.isEmpty(this.getBetaDeviceToken(var1, var2.getInstallerPackageName()))) {
         Fabric.getLogger().d("Beta", "A Beta device token was not found for this app");
         return Boolean.valueOf(false);
      } else {
         Fabric.getLogger().d("Beta", "Beta device token is present, checking for app updates.");
         BetaSettingsData var3 = this.getBetaSettingsData();
         BuildProperties var4 = this.loadBuildProperties(var1);
         if(this.canCheckForUpdates(var3, var4)) {
            this.checkForUpdates(var1, var2, var3, var4);
         }

         return Boolean.valueOf(true);
      }
   }

   public Map getDeviceIdentifiers() {
      String var1 = this.getIdManager().getInstallerPackageName();
      var1 = this.getBetaDeviceToken(this.getContext(), var1);
      HashMap var2 = new HashMap();
      if(!TextUtils.isEmpty(var1)) {
         var2.put(IdManager.DeviceIdentifierType.FONT_TOKEN, var1);
      }

      return var2;
   }

   public String getIdentifier() {
      return "com.crashlytics.sdk.android:beta";
   }

   String getOverridenSpiEndpoint() {
      return CommonUtils.getStringsFileValue(this.getContext(), "com.crashlytics.ApiEndpoint");
   }

   public String getVersion() {
      return "1.1.2.37";
   }

   @TargetApi(11)
   boolean isAppPossiblyInstalledByBeta(String var1, int var2) {
      return var2 < 11?var1 == null:"io.crash.air".equals(var1);
   }
}
