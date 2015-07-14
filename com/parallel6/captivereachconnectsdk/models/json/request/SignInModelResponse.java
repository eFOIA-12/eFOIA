package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;

public class SignInModelResponse extends BaseJSon {
   @SerializedName("auth_token")
   protected String auth_token;
   @SerializedName("encryption_key")
   protected String key;
   @SerializedName("is_temporary_password")
   protected boolean temporaryPassword;

   public SignInModelResponse() {
      this.status = "ok";
   }

   public String getAuth_token() {
      return this.auth_token;
   }

   public String getKey() {
      return this.key;
   }

   public boolean isTemporaryPassword() {
      return this.temporaryPassword;
   }

   public void setAuth_token(String var1) {
      this.auth_token = var1;
   }

   public void setKey(String var1) {
      this.key = var1;
   }

   public void setTemporaryPassword(boolean var1) {
      this.temporaryPassword = var1;
   }
}
