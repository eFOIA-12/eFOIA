package com.parallel6.captivereachconnectsdk.log;

import com.google.gson.annotations.SerializedName;

public class LogEntry {
   @SerializedName("message")
   protected String message;
   @SerializedName("tag")
   protected String tag;

   public String getMessage() {
      return this.message;
   }

   public String getTag() {
      return this.tag;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void setTag(String var1) {
      this.tag = var1;
   }
}
