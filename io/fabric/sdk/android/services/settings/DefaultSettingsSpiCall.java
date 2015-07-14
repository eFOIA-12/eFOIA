package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.SettingsRequest;
import io.fabric.sdk.android.services.settings.SettingsSpiCall;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {
   static final String BUILD_VERSION_PARAM = "build_version";
   static final String DISPLAY_VERSION_PARAM = "display_version";
   static final String ICON_HASH = "icon_hash";
   static final String INSTANCE_PARAM = "instance";
   static final String SOURCE_PARAM = "source";

   public DefaultSettingsSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4) {
      this(var1, var2, var3, var4, HttpMethod.GET);
   }

   DefaultSettingsSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      super(var1, var2, var3, var4, var5);
   }

   private HttpRequest applyHeadersTo(HttpRequest var1, SettingsRequest var2) {
      return var1.header("X-CRASHLYTICS-API-KEY", var2.apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-D", var2.deviceId).header("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion()).header("Accept", "application/json");
   }

   private JSONObject getJsonObjectFrom(String var1) {
      try {
         JSONObject var2 = new JSONObject(var1);
         return var2;
      } catch (Exception var3) {
         Fabric.getLogger().d("Fabric", "Failed to parse settings JSON from " + this.getUrl(), var3);
         Fabric.getLogger().d("Fabric", "Settings response " + var1);
         return null;
      }
   }

   private Map getQueryParamsFor(SettingsRequest var1) {
      HashMap var2 = new HashMap();
      var2.put("build_version", var1.buildVersion);
      var2.put("display_version", var1.displayVersion);
      var2.put("source", Integer.toString(var1.source));
      if(var1.iconHash != null) {
         var2.put("icon_hash", var1.iconHash);
      }

      String var3 = var1.instanceId;
      if(!CommonUtils.isNullOrEmpty(var3)) {
         var2.put("instance", var3);
      }

      return var2;
   }

   JSONObject handleResponse(HttpRequest var1) {
      int var2 = var1.code();
      Fabric.getLogger().d("Fabric", "Settings result was: " + var2);
      if(this.requestWasSuccessful(var2)) {
         return this.getJsonObjectFrom(var1.body());
      } else {
         Fabric.getLogger().e("Fabric", "Failed to retrieve settings from " + this.getUrl());
         return null;
      }
   }

   public JSONObject invoke(SettingsRequest param1) {
      // $FF: Couldn't be decompiled
   }

   boolean requestWasSuccessful(int var1) {
      return var1 == 200 || var1 == 201 || var1 == 202 || var1 == 203;
   }
}
