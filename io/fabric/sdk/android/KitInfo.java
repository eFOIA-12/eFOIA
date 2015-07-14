package io.fabric.sdk.android;

public class KitInfo {
   private final String buildType;
   private final String identifier;
   private final String version;

   public KitInfo(String var1, String var2, String var3) {
      this.identifier = var1;
      this.version = var2;
      this.buildType = var3;
   }

   public String getBuildType() {
      return this.buildType;
   }

   public String getIdentifier() {
      return this.identifier;
   }

   public String getVersion() {
      return this.version;
   }
}
