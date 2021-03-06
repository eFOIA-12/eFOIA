package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public final class AccountPicker {
   public static Intent a(Account var0, ArrayList var1, String[] var2, boolean var3, String var4, String var5, String[] var6, Bundle var7, boolean var8) {
      return a(var0, var1, var2, var3, var4, var5, var6, var7, var8, 0, 0);
   }

   public static Intent a(Account var0, ArrayList var1, String[] var2, boolean var3, String var4, String var5, String[] var6, Bundle var7, boolean var8, int var9, int var10) {
      Intent var11 = new Intent();
      var11.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
      var11.setPackage("com.google.android.gms");
      var11.putExtra("allowableAccounts", var1);
      var11.putExtra("allowableAccountTypes", var2);
      var11.putExtra("addAccountOptions", var7);
      var11.putExtra("selectedAccount", var0);
      var11.putExtra("alwaysPromptForAccount", var3);
      var11.putExtra("descriptionTextOverride", var4);
      var11.putExtra("authTokenType", var5);
      var11.putExtra("addAccountRequiredFeatures", var6);
      var11.putExtra("setGmsCoreAccount", var8);
      var11.putExtra("overrideTheme", var9);
      var11.putExtra("overrideCustomTheme", var10);
      return var11;
   }

   public static Intent newChooseAccountIntent(Account var0, ArrayList var1, String[] var2, boolean var3, String var4, String var5, String[] var6, Bundle var7) {
      return a(var0, var1, var2, var3, var4, var5, var6, var7, false);
   }
}
