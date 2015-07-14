package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEventMetadata;
import io.fabric.sdk.android.services.events.EventTransform;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

class SessionEventTransform implements EventTransform {
   static final String ADVERTISING_ID_KEY = "advertisingId";
   static final String ANDROID_ID_KEY = "androidId";
   static final String APP_BUNDLE_ID_KEY = "appBundleId";
   static final String APP_VERSION_CODE_KEY = "appVersionCode";
   static final String APP_VERSION_NAME_KEY = "appVersionName";
   static final String BETA_DEVICE_TOKEN_KEY = "betaDeviceToken";
   static final String BUILD_ID_KEY = "buildId";
   static final String CUSTOM_ATTRIBUTES = "customAttributes";
   static final String CUSTOM_TYPE = "customType";
   static final String DETAILS_KEY = "details";
   static final String DEVICE_MODEL_KEY = "deviceModel";
   static final String EXECUTION_ID_KEY = "executionId";
   static final String INSTALLATION_ID_KEY = "installationId";
   static final String OS_VERSION_KEY = "osVersion";
   static final String TIMESTAMP_KEY = "timestamp";
   static final String TYPE_KEY = "type";

   @TargetApi(9)
   public JSONObject buildJsonForEvent(SessionEvent var1) throws IOException {
      try {
         JSONObject var2 = new JSONObject();
         SessionEventMetadata var3 = var1.sessionEventMetadata;
         var2.put("appBundleId", var3.appBundleId);
         var2.put("executionId", var3.executionId);
         var2.put("installationId", var3.installationId);
         var2.put("androidId", var3.androidId);
         var2.put("advertisingId", var3.advertisingId);
         var2.put("betaDeviceToken", var3.betaDeviceToken);
         var2.put("buildId", var3.buildId);
         var2.put("osVersion", var3.osVersion);
         var2.put("deviceModel", var3.deviceModel);
         var2.put("appVersionCode", var3.appVersionCode);
         var2.put("appVersionName", var3.appVersionName);
         var2.put("timestamp", var1.timestamp);
         var2.put("type", var1.type.toString());
         var2.put("details", new JSONObject(var1.details));
         var2.put("customType", var1.customType);
         var2.put("customAttributes", new JSONObject(var1.customAttributes));
         return var2;
      } catch (JSONException var4) {
         if(VERSION.SDK_INT >= 9) {
            throw new IOException(var4.getMessage(), var4);
         } else {
            throw new IOException(var4.getMessage());
         }
      }
   }

   public byte[] toBytes(SessionEvent var1) throws IOException {
      return this.buildJsonForEvent(var1).toString().getBytes("UTF-8");
   }
}
