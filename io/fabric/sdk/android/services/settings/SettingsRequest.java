package io.fabric.sdk.android.services.settings;

public class SettingsRequest {
   public final String apiKey;
   public final String buildVersion;
   public final String deviceId;
   public final String displayVersion;
   public final String iconHash;
   public final String instanceId;
   public final int source;

   public SettingsRequest(String var1, String var2, String var3, String var4, String var5, int var6, String var7) {
      this.apiKey = var1;
      this.deviceId = var2;
      this.instanceId = var3;
      this.displayVersion = var4;
      this.buildVersion = var5;
      this.source = var6;
      this.iconHash = var7;
   }
}
