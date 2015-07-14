package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class x {
   static void a(TileOverlayOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.og(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }
}
