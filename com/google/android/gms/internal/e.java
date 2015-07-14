package com.google.android.gms.internal;

import android.util.Base64;
import com.google.android.gms.internal.m;

class e implements m {
   public String a(byte[] var1, boolean var2) {
      byte var3;
      if(var2) {
         var3 = 11;
      } else {
         var3 = 2;
      }

      return Base64.encodeToString(var1, var3);
   }

   public byte[] a(String var1, boolean var2) throws IllegalArgumentException {
      byte var3;
      if(var2) {
         var3 = 11;
      } else {
         var3 = 2;
      }

      return Base64.decode(var1, var3);
   }
}
