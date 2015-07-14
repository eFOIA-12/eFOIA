package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.fj;
import java.util.ArrayList;

public class fk implements Creator {
   static void a(fj var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.sg, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.tU, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 4, var0.qw, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.errorCode);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 6, var0.qx, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.tV);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.tW);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.tX);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 10, var0.tY, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.qA);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 12, var0.orientation);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, (String)var0.tZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, var0.ua);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (String)var0.ub, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 19, (String)var0.ud, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 18, var0.uc);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 21, (String)var0.ue, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 23, var0.ug);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 22, var0.uf);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 25, var0.uh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 24, var0.tT);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.i(var1);
   }

   public fj i(Parcel var1) {
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      String var29 = null;
      String var28 = null;
      ArrayList var27 = null;
      int var3 = 0;
      ArrayList var26 = null;
      long var13 = 0L;
      boolean var20 = false;
      long var11 = 0L;
      ArrayList var25 = null;
      long var9 = 0L;
      int var2 = 0;
      String var24 = null;
      long var7 = 0L;
      String var23 = null;
      boolean var19 = false;
      String var22 = null;
      String var21 = null;
      boolean var18 = false;
      boolean var17 = false;
      boolean var16 = false;
      boolean var15 = false;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var29 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var28 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 4:
            var27 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var6);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 6:
            var26 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var6);
            break;
         case 7:
            var13 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 8:
            var20 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 10:
            var25 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var6);
            break;
         case 11:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 12:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 13:
            var24 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 14:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 15:
            var23 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 16:
         case 17:
         case 20:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
            break;
         case 18:
            var19 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 19:
            var22 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 21:
            var21 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 22:
            var18 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 23:
            var17 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 24:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 25:
            var15 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new fj(var4, var29, var28, var27, var3, var26, var13, var20, var11, var25, var9, var2, var24, var7, var23, var19, var22, var21, var18, var17, var16, var15);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.r(var1);
   }

   public fj[] r(int var1) {
      return new fj[var1];
   }
}
