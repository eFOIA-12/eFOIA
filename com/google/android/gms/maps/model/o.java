package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;

public class o implements Creator {
   static void a(PolylineOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getPoints(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getColor());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.isGeodesic());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dh(var1);
   }

   public PolylineOptions dh(Parcel var1) {
      float var2 = 0.0F;
      boolean var8 = false;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var10 = null;
      boolean var9 = false;
      int var4 = 0;
      float var3 = 0.0F;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7, LatLng.CREATOR);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7);
            break;
         case 7:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new PolylineOptions(var5, var10, var3, var4, var2, var9, var8);
      }
   }

   public PolylineOptions[] fd(int var1) {
      return new PolylineOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fd(var1);
   }
}
