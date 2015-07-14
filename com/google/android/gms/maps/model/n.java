package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.maps.model.PolygonOptions;

public class n {
   static void a(PolygonOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getPoints(), false);
      com.google.android.gms.common.internal.safeparcel.b.d(var1, 3, var0.of(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getStrokeWidth());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getStrokeColor());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getFillColor());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.isGeodesic());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }
}
