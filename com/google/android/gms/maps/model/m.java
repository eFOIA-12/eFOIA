package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import java.util.ArrayList;

public class m implements Creator {
   static void a(PolygonOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getPoints(), false);
      com.google.android.gms.common.internal.safeparcel.b.d(var1, 3, var0.of(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getStrokeWidth());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getStrokeColor());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getFillColor());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.isGeodesic());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dg(var1);
   }

   public PolygonOptions dg(Parcel var1) {
      float var2 = 0.0F;
      boolean var9 = false;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var11 = null;
      ArrayList var12 = new ArrayList();
      boolean var10 = false;
      int var4 = 0;
      int var5 = 0;
      float var3 = 0.0F;
      int var6 = 0;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var8, LatLng.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.a.a(var1, var8, var12, this.getClass().getClassLoader());
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var8);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 6:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var8);
            break;
         case 8:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var8);
            break;
         case 9:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new PolygonOptions(var6, var11, var12, var3, var5, var4, var2, var10, var9);
      }
   }

   public PolygonOptions[] fc(int var1) {
      return new PolygonOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fc(var1);
   }
}
