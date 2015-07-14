package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;

public class ForgotCredentialRequest {
   @SerializedName("old_password")
   private String currentPassword;
   @SerializedName("email")
   private String email;
   @SerializedName("new_password")
   private String password;
   @SerializedName("password_confirmation")
   private String passwordConfirmation;

   public ForgotCredentialRequest() {
   }

   public ForgotCredentialRequest(String var1) {
      this.email = var1;
   }

   public String getCurrentPassword() {
      return this.currentPassword;
   }

   public String getEmail() {
      return this.email;
   }

   public String getPassword() {
      return this.password;
   }

   public String getPasswordConfirmation() {
      return this.passwordConfirmation;
   }

   public void setCurrentPassword(String var1) {
      this.currentPassword = var1;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setPasswordConfirmation(String var1) {
      this.passwordConfirmation = var1;
   }
}
