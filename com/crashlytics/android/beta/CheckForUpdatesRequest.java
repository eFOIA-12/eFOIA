package com.crashlytics.android.beta;

import com.crashlytics.android.beta.BuildProperties;
import com.crashlytics.android.beta.CheckForUpdatesResponse;
import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.HashMap;
import java.util.Map;

class CheckForUpdatesRequest extends AbstractSpiCall {
   static final String BETA_SOURCE = "3";
   static final String BUILD_VERSION = "build_version";
   static final String DISPLAY_VERSION = "display_version";
   static final String INSTANCE = "instance";
   static final String SOURCE = "source";
   private final CheckForUpdatesResponseTransform responseTransform;

   public CheckForUpdatesRequest(Kit var1, String var2, String var3, HttpRequestFactory var4, CheckForUpdatesResponseTransform var5) {
      super(var1, var2, var3, var4, HttpMethod.GET);
      this.responseTransform = var5;
   }

   private HttpRequest applyHeadersTo(HttpRequest var1, String var2, String var3) {
      return var1.header("Accept", "application/json").header("User-Agent", "Crashlytics Android SDK/" + this.kit.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "bca6990fc3c15a8105800c0673517a4b579634a1").header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", this.kit.getVersion()).header("X-CRASHLYTICS-API-KEY", var2).header("X-CRASHLYTICS-D", var3);
   }

   private Map getQueryParamsFor(BuildProperties var1) {
      HashMap var2 = new HashMap();
      var2.put("build_version", var1.versionCode);
      var2.put("display_version", var1.versionName);
      var2.put("instance", var1.buildId);
      var2.put("source", "3");
      return var2;
   }

   public CheckForUpdatesResponse invoke(String param1, String param2, BuildProperties param3) {
      // $FF: Couldn't be decompiled
   }
}
