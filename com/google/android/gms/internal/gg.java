package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.internal.ey;

@ey
public final class gg {
   public static void a(Context var0, boolean var1) {
      Editor var2 = n(var0).edit();
      var2.putBoolean("use_https", var1);
      var2.commit();
   }

   private static SharedPreferences n(Context var0) {
      return var0.getSharedPreferences("admob", 0);
   }

   public static boolean o(Context var0) {
      return n(var0).getBoolean("use_https", true);
   }
}
