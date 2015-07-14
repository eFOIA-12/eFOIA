package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import java.util.ArrayList;

public class b implements Creator {
   static void a(CastDevice var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getDeviceId(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.FH, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.getFriendlyName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.getModelName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.getDeviceVersion(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.getServicePort());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.getIcons(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 9, var0.getCapabilities());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.getStatus());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public CastDevice[] Z(int var1) {
      return new CastDevice[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.v(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.Z(var1);
   }

   public CastDevice v(Parcel var1) {
      int var2 = 0;
      ArrayList var8 = null;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      int var4 = 0;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      String var13 = null;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 7:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7, WebImage.CREATOR);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new CastDevice(var5, var13, var12, var11, var10, var9, var4, var8, var3, var2);
      }
   }
}
