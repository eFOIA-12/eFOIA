package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;

public class jo {
   private static final Uri No = Uri.parse("http://plus.google.com/");
   private static final Uri Np;

   static {
      Np = No.buildUpon().appendPath("circles").appendPath("find").build();
   }

   public static Intent aY(String var0) {
      Uri var2 = Uri.fromParts("package", var0, (String)null);
      Intent var1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      var1.setData(var2);
      return var1;
   }

   private static Uri aZ(String var0) {
      return Uri.parse("market://details").buildUpon().appendQueryParameter("id", var0).build();
   }

   public static Intent ba(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(aZ(var0));
      var1.setPackage("com.android.vending");
      var1.addFlags(524288);
      return var1;
   }

   public static Intent hE() {
      Intent var0 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
      var0.setPackage("com.google.android.wearable.app");
      return var0;
   }
}
