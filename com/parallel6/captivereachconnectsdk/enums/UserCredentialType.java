package com.parallel6.captivereachconnectsdk.enums;

public enum UserCredentialType {
   PASSWORD("forgot_password"),
   UNDEFINED(""),
   USER_ID("forgot_account_name");

   private String value;

   private UserCredentialType(String var3) {
      this.value = var3;
   }

   public String getValue() {
      return this.value;
   }

   public void setValue(String var1) {
      this.value = var1;
   }
}
