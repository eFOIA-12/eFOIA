package io.fabric.sdk.android.services.common;

import android.content.Context;
import android.text.TextUtils;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;

public class ApiKey {
   static final String CRASHLYTICS_API_KEY = "com.crashlytics.ApiKey";
   static final String FABRIC_API_KEY = "io.fabric.ApiKey";

   @Deprecated
   public static String getApiKey(Context var0) {
      Fabric.getLogger().w("Fabric", "getApiKey(context) is deprecated, please upgrade kit(s) to the latest version.");
      return (new ApiKey()).getValue(var0);
   }

   @Deprecated
   public static String getApiKey(Context var0, boolean var1) {
      Fabric.getLogger().w("Fabric", "getApiKey(context, debug) is deprecated, please upgrade kit(s) to the latest version.");
      return (new ApiKey()).getValue(var0);
   }

   protected String buildApiKeyInstructions() {
      return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
   }

   protected String getApiKeyFromManifest(Context param1) {
      // $FF: Couldn't be decompiled
   }

   protected String getApiKeyFromStrings(Context var1) {
      String var4 = null;
      int var3 = CommonUtils.getResourcesIdentifier(var1, "io.fabric.ApiKey", "string");
      int var2 = var3;
      if(var3 == 0) {
         Fabric.getLogger().d("Fabric", "Falling back to Crashlytics key lookup from Strings");
         var2 = CommonUtils.getResourcesIdentifier(var1, "com.crashlytics.ApiKey", "string");
      }

      if(var2 != 0) {
         var4 = var1.getResources().getString(var2);
      }

      return var4;
   }

   public String getValue(Context var1) {
      String var3 = this.getApiKeyFromManifest(var1);
      String var2 = var3;
      if(TextUtils.isEmpty(var3)) {
         var2 = this.getApiKeyFromStrings(var1);
      }

      if(TextUtils.isEmpty(var2)) {
         this.logErrorOrThrowException(var1);
      }

      return var2;
   }

   protected void logErrorOrThrowException(Context var1) {
      if(!Fabric.isDebuggable() && !CommonUtils.isAppDebuggable(var1)) {
         Fabric.getLogger().e("Fabric", this.buildApiKeyInstructions());
      } else {
         throw new IllegalArgumentException(this.buildApiKeyInstructions());
      }
   }
}
