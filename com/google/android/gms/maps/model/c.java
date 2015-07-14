package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class c implements Creator {
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

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.db(var1);
   }

   public CircleOptions db(Parcel var1) {
      float var4 = 0.0F;
      boolean var11 = false;
      int var9 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      LatLng var12 = null;
      double var2 = 0.0D;
      int var6 = 0;
      int var7 = 0;
      float var5 = 0.0F;
      int var8 = 0;

      while(var1.dataPosition() < var9) {
         int var10 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var10);
            break;
         case 2:
            var12 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var10);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var10);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var10);
            break;
         case 7:
            var4 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var10);
         }
      }

      if(var1.dataPosition() != var9) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var9, var1);
      } else {
         return new CircleOptions(var8, var12, var2, var5, var7, var6, var4, var11);
      }
   }

   public CircleOptions[] eX(int var1) {
      return new CircleOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eX(var1);
   }
}
