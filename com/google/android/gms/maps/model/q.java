package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class q implements Creator {
   static void a(StreetViewPanoramaCamera var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.zoom);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.di(var1);
   }

   public StreetViewPanoramaCamera di(Parcel var1) {
      float var4 = 0.0F;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      float var2 = 0.0F;
      int var5 = 0;
      float var3 = 0.0F;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new StreetViewPanoramaCamera(var5, var2, var3, var4);
      }
   }

   public StreetViewPanoramaCamera[] fe(int var1) {
      return new StreetViewPanoramaCamera[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fe(var1);
   }
}
