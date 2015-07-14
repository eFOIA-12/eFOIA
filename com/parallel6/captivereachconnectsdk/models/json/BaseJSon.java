package com.parallel6.captivereachconnectsdk.models.json;

import com.google.gson.annotations.SerializedName;

public class BaseJSon {
   @SerializedName("message")
   protected String message;
   @SerializedName("status")
   protected String status;

   public String getMessage() {
      return this.message;
   }

   public String getStatus() {
      return this.status;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void setStatus(String var1) {
      this.status = var1;
   }
}
