package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jx;

public class lm {
   public static Scope[] d(String[] var0) {
      jx.b((Object)var0, "scopeStrings can\'t be null.");
      Scope[] var2 = new Scope[var0.length];

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2[var1] = new Scope(var0[var1]);
      }

      return var2;
   }
}
