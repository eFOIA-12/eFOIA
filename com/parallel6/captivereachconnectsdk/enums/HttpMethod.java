package com.parallel6.captivereachconnectsdk.enums;

public enum HttpMethod {
   DELETE("DELETE"),
   GET("GET"),
   POST("POST"),
   PUT("PUT");

   String methodName;

   private HttpMethod(String var3) {
      this.methodName = var3;
   }

   public String getValue() {
      return this.methodName;
   }
}
