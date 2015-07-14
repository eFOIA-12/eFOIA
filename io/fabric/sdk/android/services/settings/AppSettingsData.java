package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.settings.AppIconSettingsData;

public class AppSettingsData {
   public static final String STATUS_ACTIVATED = "activated";
   public static final String STATUS_CONFIGURED = "configured";
   public static final String STATUS_NEW = "new";
   public final AppIconSettingsData icon;
   public final String identifier;
   public final String reportsUrl;
   public final String status;
   public final boolean updateRequired;
   public final String url;

   public AppSettingsData(String var1, String var2, String var3, String var4, boolean var5, AppIconSettingsData var6) {
      this.identifier = var1;
      this.status = var2;
      this.url = var3;
      this.reportsUrl = var4;
      this.updateRequired = var5;
      this.icon = var6;
   }
}
