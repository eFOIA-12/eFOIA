package com.crashlytics.android.answers;

import com.crashlytics.android.answers.Answers;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.io.File;
import java.util.Iterator;
import java.util.List;

class SessionAnalyticsFilesSender extends AbstractSpiCall implements FilesSender {
   static final String FILE_CONTENT_TYPE = "application/vnd.crashlytics.android.events";
   static final String FILE_PARAM_NAME = "session_analytics_file_";
   private final String apiKey;

   public SessionAnalyticsFilesSender(Kit var1, String var2, String var3, HttpRequestFactory var4, String var5) {
      super(var1, var2, var3, var4, HttpMethod.POST);
      this.apiKey = var5;
   }

   private HttpRequest applyHeadersTo(HttpRequest var1, String var2) {
      return var1.header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", Answers.getInstance().getVersion()).header("X-CRASHLYTICS-API-KEY", var2);
   }

   private HttpRequest applyMultipartDataTo(HttpRequest var1, List var2) {
      int var3 = 0;

      for(Iterator var5 = var2.iterator(); var5.hasNext(); ++var3) {
         File var4 = (File)var5.next();
         CommonUtils.logControlled(Answers.getInstance().getContext(), "Adding analytics session file " + var4.getName() + " to multipart POST");
         var1.part("session_analytics_file_" + var3, var4.getName(), "application/vnd.crashlytics.android.events", var4);
      }

      return var1;
   }

   public boolean send(List var1) {
      HttpRequest var3 = this.applyMultipartDataTo(this.applyHeadersTo(this.getHttpRequest(), this.apiKey), var1);
      CommonUtils.logControlled(Answers.getInstance().getContext(), "Sending " + var1.size() + " analytics files to " + this.getUrl());
      int var2 = var3.code();
      CommonUtils.logControlled(Answers.getInstance().getContext(), "Response code for analytics file send is " + var2);
      return ResponseParser.parse(var2) == 0;
   }
}
