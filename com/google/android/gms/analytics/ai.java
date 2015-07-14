package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;
import com.google.android.gms.analytics.q;

class ai implements q {
   private static ai Cc;
   private static Object xO = new Object();
   private final Context mContext;

   protected ai(Context var1) {
      this.mContext = var1;
   }

   public static ai fl() {
      // $FF: Couldn't be decompiled
   }

   public static void y(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean ac(String var1) {
      return "&sr".equals(var1);
   }

   protected String fm() {
      DisplayMetrics var1 = this.mContext.getResources().getDisplayMetrics();
      return var1.widthPixels + "x" + var1.heightPixels;
   }

   public String getValue(String var1) {
      return var1 != null && var1.equals("&sr")?this.fm():null;
   }
}
