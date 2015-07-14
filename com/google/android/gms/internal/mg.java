package com.google.android.gms.internal;

import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.internal.lk;

public class mg {
   private static final ThreadLocal UV = new ThreadLocal();

   public static String bw(String var0) {
      return r(var0, (String)UV.get());
   }

   public static DataSource c(DataSource var0) {
      if(var0.jz()) {
         String var1 = (String)UV.get();
         if(!jN() && !var1.equals(var0.getAppPackageName())) {
            return var0.jA();
         }
      }

      return var0;
   }

   public static boolean jN() {
      String var0 = (String)UV.get();
      return var0 == null || var0.startsWith("com.google");
   }

   private static String r(String var0, String var1) {
      if(var0 != null && var1 != null) {
         byte[] var2 = new byte[var0.length() + var1.length()];
         System.arraycopy(var0.getBytes(), 0, var2, 0, var0.length());
         System.arraycopy(var1.getBytes(), 0, var2, var0.length(), var1.length());
         return Integer.toHexString(lk.a(var2, 0, var2.length, 0));
      } else {
         return var0;
      }
   }
}
