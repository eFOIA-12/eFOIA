package com.crashlytics.android.beta;

class CheckForUpdatesResponse {
   public final String buildVersion;
   public final String displayVersion;
   public final String instanceId;
   public final String packageName;
   public final String url;
   public final String versionString;

   public CheckForUpdatesResponse(String var1, String var2, String var3, String var4, String var5, String var6) {
      this.url = var1;
      this.versionString = var2;
      this.displayVersion = var3;
      this.buildVersion = var4;
      this.packageName = var5;
      this.instanceId = var6;
   }
}
