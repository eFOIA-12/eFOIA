package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.CameraPosition;

public class b {
   static void a(CameraPosition var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.target, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.zoom);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
