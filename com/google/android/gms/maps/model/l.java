package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.MarkerOptions;

public class l {
   static void a(MarkerOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getPosition(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getTitle(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.getSnippet(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (IBinder)var0.oe(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.getAnchorU());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getAnchorV());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.isDraggable());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }
}
