package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.q;

class g implements q {
   private static Object xO = new Object();
   private static g ye;
   protected String ya;
   protected String yb;
   protected String yc;
   protected String yd;

   protected g() {
   }

   private g(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public static g dZ() {
      return ye;
   }

   public static void y(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean ac(String var1) {
      return "&an".equals(var1) || "&av".equals(var1) || "&aid".equals(var1) || "&aiid".equals(var1);
   }

   public String getValue(String var1) {
      if(var1 != null) {
         if(var1.equals("&an")) {
            return this.ya;
         }

         if(var1.equals("&av")) {
            return this.yb;
         }

         if(var1.equals("&aid")) {
            return this.yc;
         }

         if(var1.equals("&aiid")) {
            return this.yd;
         }
      }

      return null;
   }
}
