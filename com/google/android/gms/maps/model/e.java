package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class e implements Creator {
   static void a(GroundOverlayOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.od(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.getLocation(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getWidth());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.getHeight());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.getBounds(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.getBearing());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, var0.getTransparency());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.getAnchorU());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, var0.getAnchorV());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dc(var1);
   }

   public GroundOverlayOptions dc(Parcel var1) {
      int var10 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var9 = 0;
      IBinder var15 = null;
      LatLng var14 = null;
      float var8 = 0.0F;
      float var7 = 0.0F;
      LatLngBounds var13 = null;
      float var6 = 0.0F;
      float var5 = 0.0F;
      boolean var12 = false;
      float var4 = 0.0F;
      float var3 = 0.0F;
      float var2 = 0.0F;

      while(var1.dataPosition() < var10) {
         int var11 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var11)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var11);
            break;
         case 2:
            var15 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var11);
            break;
         case 3:
            var14 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var11, LatLng.CREATOR);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 6:
            var13 = (LatLngBounds)com.google.android.gms.common.internal.safeparcel.a.a(var1, var11, LatLngBounds.CREATOR);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var11);
            break;
         case 10:
            var4 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         case 12:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var11);
         }
      }

      if(var1.dataPosition() != var10) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var10, var1);
      } else {
         return new GroundOverlayOptions(var9, var15, var14, var8, var7, var13, var6, var5, var12, var4, var3, var2);
      }
   }

   public GroundOverlayOptions[] eY(int var1) {
      return new GroundOverlayOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eY(var1);
   }
}
