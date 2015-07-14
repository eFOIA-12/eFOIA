package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.maps.model.Tile;

public class v {
   static void a(Tile var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.width);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.height);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (byte[])var0.data, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }
}
