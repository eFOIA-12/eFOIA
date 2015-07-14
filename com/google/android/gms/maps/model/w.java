package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class w implements Creator {
   static void a(TileOverlayOptions var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.og(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.isVisible());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getZIndex());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.getFadeIn());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dn(var1);
   }

   public TileOverlayOptions dn(Parcel var1) {
      boolean var7 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      IBinder var8 = null;
      float var2 = 0.0F;
      boolean var6 = true;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var5);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var5);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new TileOverlayOptions(var3, var8, var7, var2, var6);
      }
   }

   public TileOverlayOptions[] fj(int var1) {
      return new TileOverlayOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fj(var1);
   }
}
