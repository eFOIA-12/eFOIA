package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class c implements Creator {
   static void a(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getStreetViewPanoramaCamera(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getPanoramaId(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.getPosition(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Integer)var0.getRadius(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (byte)var0.nS());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (byte)var0.nI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (byte)var0.nT());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (byte)var0.nU());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (byte)var0.nE());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public StreetViewPanoramaOptions cY(Parcel var1) {
      Integer var10 = null;
      byte var2 = 0;
      int var8 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      byte var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      byte var6 = 0;
      LatLng var11 = null;
      String var12 = null;
      StreetViewPanoramaCamera var13 = null;
      int var7 = 0;

      while(var1.dataPosition() < var8) {
         int var9 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            break;
         case 2:
            var13 = (StreetViewPanoramaCamera)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, StreetViewPanoramaCamera.CREATOR);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            break;
         case 4:
            var11 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, LatLng.CREATOR);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var9);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         case 8:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var9);
         }
      }

      if(var1.dataPosition() != var8) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var8, var1);
      } else {
         return new StreetViewPanoramaOptions(var7, var13, var12, var11, var10, var6, var5, var4, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cY(var1);
   }

   public StreetViewPanoramaOptions[] eU(int var1) {
      return new StreetViewPanoramaOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eU(var1);
   }
}
