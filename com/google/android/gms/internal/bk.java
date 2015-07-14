package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.bj;

public class bk implements Creator {
   static void a(bj var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.oQ);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.backgroundColor);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.oR);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.oS);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.oT);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.oU);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.oV);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 9, var0.oW);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (String)var0.oX, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 11, var0.oY);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (String)var0.oZ, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 13, var0.pa);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 14, var0.pb);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (String)var0.pc, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.d(var1);
   }

   public bj d(Parcel var1) {
      int var14 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var13 = 0;
      int var12 = 0;
      int var11 = 0;
      int var10 = 0;
      int var9 = 0;
      int var8 = 0;
      int var7 = 0;
      int var6 = 0;
      int var5 = 0;
      String var18 = null;
      int var4 = 0;
      String var17 = null;
      int var3 = 0;
      int var2 = 0;
      String var16 = null;

      while(var1.dataPosition() < var14) {
         int var15 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var15)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 9:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 10:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var15);
            break;
         case 11:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 12:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var15);
            break;
         case 13:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 14:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var15);
            break;
         case 15:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var15);
         }
      }

      if(var1.dataPosition() != var14) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var14, var1);
      } else {
         return new bj(var13, var12, var11, var10, var9, var8, var7, var6, var5, var18, var4, var17, var3, var2, var16);
      }
   }

   public bj[] i(int var1) {
      return new bj[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.i(var1);
   }
}
