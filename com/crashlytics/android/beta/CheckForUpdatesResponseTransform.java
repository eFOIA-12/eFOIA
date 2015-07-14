package com.crashlytics.android.beta;

import com.crashlytics.android.beta.CheckForUpdatesResponse;
import java.io.IOException;
import org.json.JSONObject;

class CheckForUpdatesResponseTransform {
   static final String BUILD_VERSION = "build_version";
   static final String DISPLAY_VERSION = "display_version";
   static final String IDENTIFIER = "identifier";
   static final String INSTANCE_IDENTIFIER = "instance_identifier";
   static final String URL = "url";
   static final String VERSION_STRING = "version_string";

   public CheckForUpdatesResponse fromJson(JSONObject var1) throws IOException {
      if(var1 == null) {
         return null;
      } else {
         String var2 = var1.optString("url", (String)null);
         String var3 = var1.optString("version_string", (String)null);
         String var4 = var1.optString("build_version", (String)null);
         return new CheckForUpdatesResponse(var2, var3, var1.optString("display_version", (String)null), var4, var1.optString("identifier", (String)null), var1.optString("instance_identifier", (String)null));
      }
   }
}
