package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.VisibleRegion;

public class z {
   static void a(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.nearLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.nearRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.farLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.farRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.latLngBounds, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
