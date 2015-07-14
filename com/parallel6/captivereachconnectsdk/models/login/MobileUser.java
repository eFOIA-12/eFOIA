package com.parallel6.captivereachconnectsdk.models.login;

import com.google.gson.annotations.SerializedName;

public class MobileUser {
   @SerializedName("account_name")
   private String account_name;
   @SerializedName("password")
   private String password;

   public MobileUser() {
   }

   public MobileUser(String var1, String var2) {
      this.account_name = var1;
      this.password = var2;
   }

   public String getAccount_name() {
      return this.account_name;
   }

   public String getPassword() {
      return this.password;
   }

   public void setAccount_name(String var1) {
      this.account_name = var1;
   }

   public void setPassword(String var1) {
      this.password = var1;
   }
}
