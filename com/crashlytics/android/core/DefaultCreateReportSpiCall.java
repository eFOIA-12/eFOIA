package com.crashlytics.android.core;

import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CreateReportRequest;
import com.crashlytics.android.core.CreateReportSpiCall;
import com.crashlytics.android.core.Report;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.common.ResponseParser;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.Iterator;
import java.util.Map.Entry;

class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
   static final String FILE_CONTENT_TYPE = "application/octet-stream";
   static final String FILE_PARAM = "report[file]";
   static final String IDENTIFIER_PARAM = "report[identifier]";

   public DefaultCreateReportSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4) {
      super(var1, var2, var3, var4, HttpMethod.POST);
   }

   DefaultCreateReportSpiCall(Kit var1, String var2, String var3, HttpRequestFactory var4, HttpMethod var5) {
      super(var1, var2, var3, var4, var5);
   }

   private HttpRequest applyHeadersTo(HttpRequest var1, CreateReportRequest var2) {
      var1 = var1.header("X-CRASHLYTICS-API-KEY", var2.apiKey).header("X-CRASHLYTICS-API-CLIENT-TYPE", "android").header("X-CRASHLYTICS-API-CLIENT-VERSION", CrashlyticsCore.getInstance().getVersion());

      for(Iterator var3 = var2.report.getCustomHeaders().entrySet().iterator(); var3.hasNext(); var1 = var1.header((Entry)var3.next())) {
         ;
      }

      return var1;
   }

   private HttpRequest applyMultipartDataTo(HttpRequest var1, CreateReportRequest var2) {
      Report var3 = var2.report;
      return var1.part("report[file]", var3.getFileName(), "application/octet-stream", var3.getFile()).part("report[identifier]", var3.getIdentifier());
   }

   public boolean invoke(CreateReportRequest var1) {
      HttpRequest var3 = this.applyMultipartDataTo(this.applyHeadersTo(this.getHttpRequest(), var1), var1);
      Fabric.getLogger().d("Fabric", "Sending report to: " + this.getUrl());
      int var2 = var3.code();
      Fabric.getLogger().d("Fabric", "Create report request ID: " + var3.header("X-REQUEST-ID"));
      Fabric.getLogger().d("Fabric", "Result was: " + var2);
      return ResponseParser.parse(var2) == 0;
   }
}
