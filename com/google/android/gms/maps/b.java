package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.GoogleMapOptions;

public class b {
   static void a(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (byte)var0.nD());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (byte)var0.nE());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getMapType());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.getCamera(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (byte)var0.nF());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (byte)var0.nG());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (byte)var0.nH());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (byte)var0.nI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (byte)var0.nJ());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (byte)var0.nK());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
