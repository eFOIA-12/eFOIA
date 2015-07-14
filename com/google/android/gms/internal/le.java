package com.google.android.gms.internal;

import android.database.CharArrayBuffer;

public final class le {
   public static void b(String var0, CharArrayBuffer var1) {
      if(var1.data != null && var1.data.length >= var0.length()) {
         var0.getChars(0, var0.length(), var1.data, 0);
      } else {
         var1.data = var0.toCharArray();
      }

      var1.sizeCopied = var0.length();
   }
}
