package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;

public class VerifyAccountRequest {
   @SerializedName("verification_code")
   protected String verification_code;

   public String getVerification_code() {
      return this.verification_code;
   }

   public void setVerification_code(String var1) {
      this.verification_code = var1;
   }
}
