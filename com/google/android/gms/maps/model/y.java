package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;

public class y implements Creator {
   static void a(VisibleRegion var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.nearLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.nearRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.farLeft, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.farRight, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.latLngBounds, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.do(var1);
   }

   public VisibleRegion do(Parcel var1) {
      LatLngBounds var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      LatLng var6 = null;
      LatLng var7 = null;
      LatLng var8 = null;
      LatLng var9 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var9 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            break;
         case 3:
            var8 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            break;
         case 4:
            var7 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            break;
         case 5:
            var6 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            break;
         case 6:
            var5 = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLngBounds.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new VisibleRegion(var2, var9, var8, var7, var6, var5);
      }
   }

   public VisibleRegion[] fk(int var1) {
      return new VisibleRegion[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fk(var1);
   }
}
