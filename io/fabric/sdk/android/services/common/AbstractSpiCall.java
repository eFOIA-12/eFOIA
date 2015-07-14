package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class AbstractSpiCall {
   public static final String ACCEPT_JSON_VALUE = "application/json";
   public static final String ANDROID_CLIENT_TYPE = "android";
   public static final String CLS_ANDROID_SDK_DEVELOPER_TOKEN = "470fa2b4ae81cd56ecbcda9735803434cec591fa";
   public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
   public static final int DEFAULT_TIMEOUT = 10000;
   public static final String HEADER_ACCEPT = "Accept";
   public static final String HEADER_API_KEY = "X-CRASHLYTICS-API-KEY";
   public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
   public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
   public static final String HEADER_D = "X-CRASHLYTICS-D";
   public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
   public static final String HEADER_DEVICE_STATE = "X-CRASHLYTICS-DEVICE-STATE";
   public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
   public static final String HEADER_USER_AGENT = "User-Agent";
   private static final Pattern PROTOCOL_AND_HOST_PATTERN = Pattern.compile("http(s?)://[^\\/]+", 2);
   protected final Kit kit;
   private final HttpMethod method;
   private final String protocolAndHostOverride;
   private final HttpRequestFactory requestFactory;
   private final String url;

   public AbstractSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      if(var3 == null) {
         throw new IllegalArgumentException("url must not be null.");
      } else if(var4 == null) {
         throw new IllegalArgumentException("requestFactory must not be null.");
      } else {
         this.kit = var1;
         this.protocolAndHostOverride = var2;
         this.url = this.overrideProtocolAndHost(var3);
         this.requestFactory = var4;
         this.method = var5;
      }
   }

   private String overrideProtocolAndHost(String var1) {
      String var2 = var1;
      if(!CommonUtils.isNullOrEmpty(this.protocolAndHostOverride)) {
         var2 = PROTOCOL_AND_HOST_PATTERN.matcher(var1).replaceFirst(this.protocolAndHostOverride);
      }

      return var2;
   }

   protected HttpRequest getHttpRequest() {
      return this.getHttpRequest(Collections.emptyMap());
   }

   protected HttpRequest getHttpRequest(Map var1) {
      return this.requestFactory.buildHttpRequest(this.method, this.getUrl(), var1).useCaches(false).connectTimeout(10000).header("User-Agent", "Crashlytics Android SDK/" + this.kit.getVersion()).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
   }

   protected String getUrl() {
      return this.url;
   }
}
