package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class t implements Creator {
   static void a(StreetViewPanoramaOrientation var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.tilt);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.bearing);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dl(var1);
   }

   public StreetViewPanoramaOrientation dl(Parcel var1) {
      float var3 = 0.0F;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      float var2 = 0.0F;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var6);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new StreetViewPanoramaOrientation(var4, var2, var3);
      }
   }

   public StreetViewPanoramaOrientation[] fh(int var1) {
      return new StreetViewPanoramaOrientation[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fh(var1);
   }
}
