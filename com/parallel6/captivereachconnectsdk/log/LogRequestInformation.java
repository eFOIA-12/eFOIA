package com.parallel6.captivereachconnectsdk.log;

import com.google.gson.annotations.SerializedName;

public class LogRequestInformation {
   @SerializedName("method")
   protected String method;
   @SerializedName("params")
   protected String params;
   @SerializedName("status_code")
   protected String status_code;
   @SerializedName("url")
   protected String url;

   public String getMethod() {
      return this.method;
   }

   public String getParams() {
      return this.params;
   }

   public String getStatus_code() {
      return this.status_code;
   }

   public String getUrl() {
      return this.url;
   }

   public void setMethod(String var1) {
      this.method = var1;
   }

   public void setParams(String var1) {
      this.params = var1;
   }

   public void setStatus_code(String var1) {
      this.status_code = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }
}
