package io.fabric.sdk.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.DeliveryMechanism;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.CreateAppSpiCall;
import io.fabric.sdk.android.services.settings.IconRequest;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import io.fabric.sdk.android.services.settings.UpdateAppSpiCall;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;

class Onboarding extends Kit {
   private static final String BINARY_BUILD_TYPE = "binary";
   static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
   private String applicationLabel;
   private String installerPackageName;
   private final Future kitsFinder;
   private PackageInfo packageInfo;
   private PackageManager packageManager;
   private String packageName;
   private final Collection providedKits;
   private final HttpRequestFactory requestFactory = new DefaultHttpRequestFactory();
   private String targetAndroidSdkVersion;
   private String versionCode;
   private String versionName;

   public Onboarding(Future var1, Collection var2) {
      this.kitsFinder = var1;
      this.providedKits = var2;
   }

   private AppRequestData buildAppRequest(IconRequest var1, Collection var2) {
      Context var5 = this.getContext();
      String var4 = (new ApiKey()).getValue(var5);
      String var6 = CommonUtils.createInstanceIdFrom(new String[]{CommonUtils.resolveBuildId(var5)});
      int var3 = DeliveryMechanism.determineFrom(this.installerPackageName).getId();
      return new AppRequestData(var4, this.getIdManager().getAppIdentifier(), this.versionName, this.versionCode, var6, this.applicationLabel, var3, this.targetAndroidSdkVersion, "0", var1, var2);
   }

   private boolean performAutoConfigure(String var1, AppSettingsData var2, Collection var3) {
      boolean var4 = true;
      if("new".equals(var2.status)) {
         if(!this.performCreateApp(var1, var2, var3)) {
            Fabric.getLogger().e("Fabric", "Failed to create app with Crashlytics service.", (Throwable)null);
            return false;
         }

         var4 = Settings.getInstance().loadSettingsSkippingCache();
      } else {
         if("configured".equals(var2.status)) {
            return Settings.getInstance().loadSettingsSkippingCache();
         }

         if(var2.updateRequired) {
            Fabric.getLogger().d("Fabric", "Server says an update is required - forcing a full App update.");
            this.performUpdateApp(var1, var2, var3);
            return true;
         }
      }

      return var4;
   }

   private boolean performCreateApp(String var1, AppSettingsData var2, Collection var3) {
      AppRequestData var4 = this.buildAppRequest(IconRequest.build(this.getContext(), var1), var3);
      return (new CreateAppSpiCall(this, this.getOverridenSpiEndpoint(), var2.url, this.requestFactory)).invoke(var4);
   }

   private boolean performUpdateApp(AppSettingsData var1, IconRequest var2, Collection var3) {
      AppRequestData var4 = this.buildAppRequest(var2, var3);
      return (new UpdateAppSpiCall(this, this.getOverridenSpiEndpoint(), var1.url, this.requestFactory)).invoke(var4);
   }

   private boolean performUpdateApp(String var1, AppSettingsData var2, Collection var3) {
      return this.performUpdateApp(var2, IconRequest.build(this.getContext(), var1), var3);
   }

   private SettingsData retrieveSettingsData() {
      try {
         Settings.getInstance().initialize(this, this.idManager, this.requestFactory, this.versionCode, this.versionName, this.getOverridenSpiEndpoint()).loadSettingsData();
         SettingsData var1 = Settings.getInstance().awaitSettingsData();
         return var1;
      } catch (Exception var2) {
         Fabric.getLogger().e("Fabric", "Error dealing with settings", var2);
         return null;
      }
   }

   protected Boolean doInBackground() {
      // $FF: Couldn't be decompiled
   }

   public String getIdentifier() {
      return "io.fabric.sdk.android:fabric";
   }

   String getOverridenSpiEndpoint() {
      return CommonUtils.getStringsFileValue(this.getContext(), "com.crashlytics.ApiEndpoint");
   }

   public String getVersion() {
      return "1.3.3.56";
   }

   Map mergeKits(Map var1, Collection var2) {
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         Kit var3 = (Kit)var4.next();
         if(!var1.containsKey(var3.getIdentifier())) {
            var1.put(var3.getIdentifier(), new KitInfo(var3.getIdentifier(), var3.getVersion(), "binary"));
         }
      }

      return var1;
   }

   protected boolean onPreExecute() {
      // $FF: Couldn't be decompiled
   }
}
