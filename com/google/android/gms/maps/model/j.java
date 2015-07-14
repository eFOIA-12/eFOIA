package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

public class j {
   static void a(LatLng var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.latitude);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.longitude);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }
}
