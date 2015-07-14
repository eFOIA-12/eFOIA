package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitInfo;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AppRequestData;
import io.fabric.sdk.android.services.settings.AppSpiCall;
import java.util.Locale;

abstract class AbstractAppSpiCall extends AbstractSpiCall implements AppSpiCall {
   public static final String APP_BUILD_VERSION_PARAM = "app[build_version]";
   public static final String APP_BUILT_SDK_VERSION_PARAM = "app[built_sdk_version]";
   public static final String APP_DISPLAY_VERSION_PARAM = "app[display_version]";
   public static final String APP_ICON_DATA_PARAM = "app[icon][data]";
   public static final String APP_ICON_HASH_PARAM = "app[icon][hash]";
   public static final String APP_ICON_HEIGHT_PARAM = "app[icon][height]";
   public static final String APP_ICON_PRERENDERED_PARAM = "app[icon][prerendered]";
   public static final String APP_ICON_WIDTH_PARAM = "app[icon][width]";
   public static final String APP_IDENTIFIER_PARAM = "app[identifier]";
   public static final String APP_INSTANCE_IDENTIFIER_PARAM = "app[instance_identifier]";
   public static final String APP_MIN_SDK_VERSION_PARAM = "app[minimum_sdk_version]";
   public static final String APP_NAME_PARAM = "app[name]";
   public static final String APP_SDK_MODULES_PARAM_BUILD_TYPE = "app[build][libraries][%s][type]";
   public static final String APP_SDK_MODULES_PARAM_PREFIX = "app[build][libraries][%s]";
   public static final String APP_SDK_MODULES_PARAM_VERSION = "app[build][libraries][%s][version]";
   public static final String APP_SOURCE_PARAM = "app[source]";
   static final String ICON_CONTENT_TYPE = "application/octet-stream";
   static final String ICON_FILE_NAME = "icon.png";

   public AbstractAppSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      super(var1, var2, var3, var4, var5);
   }

   private HttpRequest applyHeadersTo(HttpRequest var1, AppRequestData var2) {
      return var1.header("X-CRASHLYTICS-API-KEY", var2.apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion());
   }

   private HttpRequest applyMultipartDataTo(HttpRequest param1, AppRequestData param2) {
      // $FF: Couldn't be decompiled
   }

   String getKitBuildTypeKey(KitInfo var1) {
      return String.format(Locale.US, "app[build][libraries][%s][type]", new Object[]{var1.getIdentifier()});
   }

   String getKitVersionKey(KitInfo var1) {
      return String.format(Locale.US, "app[build][libraries][%s][version]", new Object[]{var1.getIdentifier()});
   }

   public boolean invoke(AppRequestData var1) {
      HttpRequest var3 = this.applyMultipartDataTo(this.applyHeadersTo(this.getHttpRequest(), var1), var1);
      Fabric.getLogger().d("Fabric", "Sending app info to " + this.getUrl());
      if(var1.icon != null) {
         Fabric.getLogger().d("Fabric", "App icon hash is " + var1.icon.hash);
         Fabric.getLogger().d("Fabric", "App icon size is " + var1.icon.width + "x" + var1.icon.height);
      }

      int var2 = var3.code();
      String var4;
      if("POST".equals(var3.method())) {
         var4 = "Create";
      } else {
         var4 = "Update";
      }

      Fabric.getLogger().d("Fabric", var4 + " app request ID: " + var3.header("X-REQUEST-ID"));
      Fabric.getLogger().d("Fabric", "Result was " + var2);
      return ResponseParser.parse(var2) == 0;
   }
}
