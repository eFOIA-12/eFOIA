package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;

public class i implements Creator {
   static void a(LatLng var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.latitude);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.longitude);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.de(var1);
   }

   public LatLng de(Parcel var1) {
      double var2 = 0.0D;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var6 = 0;
      double var4 = 0.0D;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new LatLng(var6, var4, var2);
      }
   }

   public LatLng[] fa(int var1) {
      return new LatLng[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fa(var1);
   }
}
