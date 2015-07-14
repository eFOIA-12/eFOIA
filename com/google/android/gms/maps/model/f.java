package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class f {
   static void a(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.od(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.getLocation(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.getHeight());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.getBounds(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getBearing());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, var0.getTransparency());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.getAnchorU());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, var0.getAnchorV());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
