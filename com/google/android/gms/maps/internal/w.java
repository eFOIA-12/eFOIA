package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class w {
   public static void a(Bundle var0, String var1, Parcelable var2) {
      var0.setClassLoader(w.class.getClassLoader());
      Bundle var4 = var0.getBundle("map_state");
      Bundle var3 = var4;
      if(var4 == null) {
         var3 = new Bundle();
      }

      var3.setClassLoader(w.class.getClassLoader());
      var3.putParcelable(var1, var2);
      var0.putBundle("map_state", var3);
   }
}
