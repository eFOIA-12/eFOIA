package com.crashlytics.android.answers;

final class SessionEventMetadata {
   public final String advertisingId;
   public final String androidId;
   public final String appBundleId;
   public final String appVersionCode;
   public final String appVersionName;
   public final String betaDeviceToken;
   public final String buildId;
   public final String deviceModel;
   public final String executionId;
   public final String installationId;
   public final String osVersion;
   private String stringRepresentation;

   public SessionEventMetadata(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11) {
      this.appBundleId = var1;
      this.executionId = var2;
      this.installationId = var3;
      this.androidId = var4;
      this.advertisingId = var5;
      this.betaDeviceToken = var6;
      this.buildId = var7;
      this.osVersion = var8;
      this.deviceModel = var9;
      this.appVersionCode = var10;
      this.appVersionName = var11;
   }

   public String toString() {
      if(this.stringRepresentation == null) {
         this.stringRepresentation = "appBundleId=" + this.appBundleId + ", executionId=" + this.executionId + ", installationId=" + this.installationId + ", androidId=" + this.androidId + ", advertisingId=" + this.advertisingId + ", betaDeviceToken=" + this.betaDeviceToken + ", buildId=" + this.buildId + ", osVersion=" + this.osVersion + ", deviceModel=" + this.deviceModel + ", appVersionCode=" + this.appVersionCode + ", appVersionName=" + this.appVersionName;
      }

      return this.stringRepresentation;
   }
}
