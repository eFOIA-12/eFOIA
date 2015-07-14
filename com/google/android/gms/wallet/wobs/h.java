package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.wobs.g;

public class h implements Creator {
   static void a(g var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.awN);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.awO, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.awP);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.awQ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.awR);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.awS);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ef(var1);
   }

   public g ef(Parcel var1) {
      String var11 = null;
      int var5 = 0;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      double var2 = 0.0D;
      long var9 = 0L;
      int var4 = -1;
      String var12 = null;
      int var6 = 0;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var8);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var8);
            break;
         case 5:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var8);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var8);
            break;
         case 7:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new g(var6, var5, var12, var2, var11, var9, var4);
      }
   }

   public g[] go(int var1) {
      return new g[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.go(var1);
   }
}
