package com.crashlytics.android.core;

import com.crashlytics.android.core.Report;

class CreateReportRequest {
   public final String apiKey;
   public final Report report;

   public CreateReportRequest(String var1, Report var2) {
      this.apiKey = var1;
      this.report = var2;
   }
}
