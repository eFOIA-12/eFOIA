package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class s implements Creator {
   static void a(StreetViewPanoramaLocation var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable[])var0.links, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.position, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.panoId, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dk(var1);
   }

   public StreetViewPanoramaLocation dk(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      LatLng var7 = null;

      StreetViewPanoramaLink[] var6;
      StreetViewPanoramaLink[] var8;
      for(var6 = null; var1.dataPosition() < var3; var6 = var8) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         LatLng var9;
         StreetViewPanoramaLink[] var10;
         LatLng var11;
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var8 = var6;
            var9 = var7;
            var10 = var8;
            break;
         case 2:
            var8 = (StreetViewPanoramaLink[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, StreetViewPanoramaLink.CREATOR);
            var9 = var7;
            var10 = var8;
            break;
         case 3:
            var11 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LatLng.CREATOR);
            var10 = var6;
            var9 = var11;
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var8 = var6;
            var9 = var7;
            var10 = var8;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            var11 = var7;
            var10 = var6;
            var9 = var11;
         }

         var8 = var10;
         var7 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new StreetViewPanoramaLocation(var2, var6, var7, var5);
      }
   }

   public StreetViewPanoramaLocation[] fg(int var1) {
      return new StreetViewPanoramaLocation[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fg(var1);
   }
}
