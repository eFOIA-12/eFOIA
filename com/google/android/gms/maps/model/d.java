package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CircleOptions;

public class d {
   static void a(CircleOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getCenter(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.getRadius());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getStrokeWidth());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getStrokeColor());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getFillColor());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
