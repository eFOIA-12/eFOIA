package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;

public class ResetCredentialRequest {
   @SerializedName("old_password")
   private String currentPassword;
   @SerializedName("new_password")
   private String password;
   @SerializedName("new_password_confirmation")
   private String passwordConfirmation;

   public String getCurrentPassword() {
      return this.currentPassword;
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

   public void setPassword(String var1) {
      this.password = var1;
   }

   public void setPasswordConfirmation(String var1) {
      this.passwordConfirmation = var1;
   }
}
