package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import java.math.BigInteger;
import java.util.Locale;

@ey
public final class ge {
   private static final Object ut = new Object();
   private static String wt;

   public static String a(Context param0, String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private static void b(Context var0, String var1, String var2) {
      Class var4;
      ClassLoader var9;
      try {
         var9 = var0.createPackageContext(var2, 3).getClassLoader();
         var4 = Class.forName("com.google.ads.mediation.MediationAdapter", false, var9);
      } catch (Throwable var6) {
         wt = "err";
         return;
      }

      BigInteger var7 = new BigInteger(new byte[1]);
      String[] var5 = var1.split(",");

      BigInteger var8;
      for(int var3 = 0; var3 < var5.length; var7 = var8) {
         var8 = var7;
         if(gi.a(var9, var4, var5[var3])) {
            var8 = var7.setBit(var3);
         }

         ++var3;
      }

      wt = String.format(Locale.US, "%X", new Object[]{var7});
   }

   public static String dr() {
      // $FF: Couldn't be decompiled
   }
}
