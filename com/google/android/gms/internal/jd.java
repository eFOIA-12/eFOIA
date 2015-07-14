package com.google.android.gms.internal;

import android.accounts.Account;
import android.text.TextUtils;
import com.google.android.gms.internal.jq;

public class jd extends jq.a {
   private Account CR;

   public jd(Account var1) {
      this.CR = var1;
   }

   public static jd aT(String var0) {
      Account var1;
      if(TextUtils.isEmpty(var0)) {
         var1 = null;
      } else {
         var1 = new Account(var0, "com.google");
      }

      return new jd(var1);
   }

   public Account hk() {
      return this.CR;
   }
}
