package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.settings.IconRequest;
import java.util.Collection;

public class AppRequestData {
   public final String apiKey;
   public final String appId;
   public final String buildVersion;
   public final String builtSdkVersion;
   public final String displayVersion;
   public final IconRequest icon;
   public final String instanceIdentifier;
   public final String minSdkVersion;
   public final String name;
   public final Collection sdkKits;
   public final int source;

   public AppRequestData(String var1, String var2, String var3, String var4, String var5, String var6, int var7, String var8, String var9, IconRequest var10, Collection var11) {
      this.apiKey = var1;
      this.appId = var2;
      this.displayVersion = var3;
      this.buildVersion = var4;
      this.instanceIdentifier = var5;
      this.name = var6;
      this.source = var7;
      this.minSdkVersion = var8;
      this.builtSdkVersion = var9;
      this.icon = var10;
      this.sdkKits = var11;
   }
}
