package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.nn;

public class no implements Creator {
   static void a(nn var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getRequestId(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.getExpirationTime());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (short)var0.nn());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.getLatitude());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.getLongitude());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.no());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.np());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.getNotificationResponsiveness());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 9, var0.nq());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public nn cN(Parcel var1) {
      int var12 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var11 = 0;
      String var16 = null;
      int var10 = 0;
      short var2 = 0;
      double var5 = 0.0D;
      double var3 = 0.0D;
      float var7 = 0.0F;
      long var14 = 0L;
      int var9 = 0;
      int var8 = -1;

      while(var1.dataPosition() < var12) {
         int var13 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var13)) {
         case 1:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var13);
            break;
         case 2:
            var14 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var13);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.f(var1, var13);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var13);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var13);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var13);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var13);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var13);
            break;
         case 9:
            var8 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var13);
            break;
         case 1000:
            var11 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var13);
         }
      }

      if(var1.dataPosition() != var12) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var12, var1);
      } else {
         return new nn(var11, var16, var10, var2, var5, var3, var7, var14, var9, var8);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cN(var1);
   }

   public nn[] eJ(int var1) {
      return new nn[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eJ(var1);
   }
}
