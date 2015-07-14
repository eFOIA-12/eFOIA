package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class k implements Creator {
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
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, var0.isFlat());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.getRotation());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, var0.getInfoWindowAnchorU());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, var0.getInfoWindowAnchorV());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, var0.getAlpha());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.df(var1);
   }

   public MarkerOptions df(Parcel var1) {
      int var9 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var8 = 0;
      LatLng var17 = null;
      String var16 = null;
      String var15 = null;
      IBinder var14 = null;
      float var7 = 0.0F;
      float var6 = 0.0F;
      boolean var13 = false;
      boolean var12 = false;
      boolean var11 = false;
      float var5 = 0.0F;
      float var4 = 0.5F;
      float var3 = 0.0F;
      float var2 = 1.0F;

      while(var1.dataPosition() < var9) {
         int var10 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var10)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var10);
            break;
         case 2:
            var17 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var10);
            break;
         case 4:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var10);
            break;
         case 5:
            var14 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var10);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 8:
            var13 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var10);
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var10);
            break;
         case 10:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var10);
            break;
         case 11:
            var5 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 12:
            var4 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 13:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         case 14:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var10);
         }
      }

      if(var1.dataPosition() != var9) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var9, var1);
      } else {
         return new MarkerOptions(var8, var17, var16, var15, var14, var7, var6, var13, var12, var11, var5, var4, var3, var2);
      }
   }

   public MarkerOptions[] fb(int var1) {
      return new MarkerOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fb(var1);
   }
}
