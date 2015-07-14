package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public class a implements Creator {
   static void a(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (byte)var0.nD());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (byte)var0.nE());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getMapType());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.getCamera(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (byte)var0.nF());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (byte)var0.nG());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (byte)var0.nH());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (byte)var0.nI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (byte)var0.nJ());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (byte)var0.nK());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (byte)var0.nL());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (byte)var0.nM());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public GoogleMapOptions cX(Parcel var1) {
      int var14 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var13 = 0;
      byte var11 = 0;
      byte var10 = 0;
      int var12 = 0;
      CameraPosition var16 = null;
      byte var9 = 0;
      byte var8 = 0;
      byte var7 = 0;
      byte var6 = 0;
      byte var5 = 0;
      byte var4 = 0;
      byte var3 = 0;
      byte var2 = 0;

      while(var1.dataPosition() < var14) {
         int var15 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var15)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 4:
            var12 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 5:
            var16 = (CameraPosition)com.google.android.gms.common.internal.safeparcel.a.a(var1, var15, CameraPosition.CREATOR);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 7:
            var8 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 8:
            var7 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 9:
            var6 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 10:
            var5 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 11:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 12:
            var3 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 13:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var15);
            break;
         case 14:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
         }
      }

      if(var1.dataPosition() != var14) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var14, var1);
      } else {
         return new GoogleMapOptions(var13, var11, var10, var12, var16, var9, var8, var7, var6, var5, var4, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cX(var1);
   }

   public GoogleMapOptions[] eT(int var1) {
      return new GoogleMapOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eT(var1);
   }
}
