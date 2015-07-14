package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class pe implements Creator {
   static void a(pd var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.aoo, var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.b(var1, 3, var0.aop, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.aoq, var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.aor, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.aos, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.aot, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 8, var0.aou, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 9, var0.aov);
      }

      if(var4.contains(Integer.valueOf(10))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.aow, true);
      }

      if(var4.contains(Integer.valueOf(11))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable)var0.aox, var2, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 12, var0.aoy, true);
      }

      if(var4.contains(Integer.valueOf(13))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, (String)var0.aoz, true);
      }

      if(var4.contains(Integer.valueOf(14))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (String)var0.aoA, true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (Parcelable)var0.aoB, var2, true);
      }

      if(var4.contains(Integer.valueOf(17))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 17, (String)var0.aoD, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 16, (String)var0.aoC, true);
      }

      if(var4.contains(Integer.valueOf(19))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 19, var0.aoE, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 18, (String)var0.ov, true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 21, (String)var0.aoG, true);
      }

      if(var4.contains(Integer.valueOf(20))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 20, (String)var0.aoF, true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 23, (String)var0.UO, true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 22, (String)var0.aoH, true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 25, (String)var0.aoJ, true);
      }

      if(var4.contains(Integer.valueOf(24))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 24, (String)var0.aoI, true);
      }

      if(var4.contains(Integer.valueOf(27))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 27, (String)var0.aoL, true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 26, (String)var0.aoK, true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 29, (Parcelable)var0.aoN, var2, true);
      }

      if(var4.contains(Integer.valueOf(28))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 28, (String)var0.aoM, true);
      }

      if(var4.contains(Integer.valueOf(31))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 31, (String)var0.aoP, true);
      }

      if(var4.contains(Integer.valueOf(30))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 30, (String)var0.aoO, true);
      }

      if(var4.contains(Integer.valueOf(34))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 34, (Parcelable)var0.aoR, var2, true);
      }

      if(var4.contains(Integer.valueOf(32))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 32, (String)var0.CE, true);
      }

      if(var4.contains(Integer.valueOf(33))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 33, (String)var0.aoQ, true);
      }

      if(var4.contains(Integer.valueOf(38))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 38, var0.agh);
      }

      if(var4.contains(Integer.valueOf(39))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 39, (String)var0.mName, true);
      }

      if(var4.contains(Integer.valueOf(36))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 36, var0.agg);
      }

      if(var4.contains(Integer.valueOf(37))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 37, (Parcelable)var0.aoS, var2, true);
      }

      if(var4.contains(Integer.valueOf(42))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 42, (String)var0.aoV, true);
      }

      if(var4.contains(Integer.valueOf(43))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 43, (String)var0.aoW, true);
      }

      if(var4.contains(Integer.valueOf(40))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 40, (Parcelable)var0.aoT, var2, true);
      }

      if(var4.contains(Integer.valueOf(41))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 41, var0.aoU, true);
      }

      if(var4.contains(Integer.valueOf(46))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 46, (Parcelable)var0.aoZ, var2, true);
      }

      if(var4.contains(Integer.valueOf(47))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 47, (String)var0.apa, true);
      }

      if(var4.contains(Integer.valueOf(44))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 44, (String)var0.aoX, true);
      }

      if(var4.contains(Integer.valueOf(45))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 45, (String)var0.aoY, true);
      }

      if(var4.contains(Integer.valueOf(51))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 51, (String)var0.ape, true);
      }

      if(var4.contains(Integer.valueOf(50))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 50, (Parcelable)var0.apd, var2, true);
      }

      if(var4.contains(Integer.valueOf(49))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 49, (String)var0.apc, true);
      }

      if(var4.contains(Integer.valueOf(48))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 48, (String)var0.apb, true);
      }

      if(var4.contains(Integer.valueOf(55))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 55, (String)var0.apg, true);
      }

      if(var4.contains(Integer.valueOf(54))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 54, (String)var0.vf, true);
      }

      if(var4.contains(Integer.valueOf(53))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 53, (String)var0.vc, true);
      }

      if(var4.contains(Integer.valueOf(52))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 52, (String)var0.apf, true);
      }

      if(var4.contains(Integer.valueOf(56))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 56, (String)var0.aph, true);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dx(var1);
   }

   public pd dx(Parcel var1) {
      int var8 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var61 = new HashSet();
      int var7 = 0;
      pd var60 = null;
      ArrayList var58 = null;
      pd var59 = null;
      String var57 = null;
      String var56 = null;
      String var55 = null;
      ArrayList var54 = null;
      int var6 = 0;
      ArrayList var52 = null;
      pd var53 = null;
      ArrayList var51 = null;
      String var50 = null;
      String var48 = null;
      pd var49 = null;
      String var47 = null;
      String var46 = null;
      String var45 = null;
      ArrayList var44 = null;
      String var43 = null;
      String var42 = null;
      String var41 = null;
      String var40 = null;
      String var39 = null;
      String var38 = null;
      String var37 = null;
      String var36 = null;
      String var34 = null;
      pd var35 = null;
      String var33 = null;
      String var32 = null;
      String var31 = null;
      String var29 = null;
      pd var30 = null;
      double var4 = 0.0D;
      pd var28 = null;
      double var2 = 0.0D;
      String var26 = null;
      pd var27 = null;
      ArrayList var25 = null;
      String var24 = null;
      String var23 = null;
      String var22 = null;
      String var20 = null;
      pd var21 = null;
      String var19 = null;
      String var18 = null;
      String var16 = null;
      pd var17 = null;
      String var15 = null;
      String var14 = null;
      String var13 = null;
      String var12 = null;
      String var11 = null;
      String var10 = null;

      while(var1.dataPosition() < var8) {
         int var9 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var61.add(Integer.valueOf(1));
            break;
         case 2:
            var60 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(2));
            break;
         case 3:
            var58 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var9);
            var61.add(Integer.valueOf(3));
            break;
         case 4:
            var59 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(4));
            break;
         case 5:
            var57 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(5));
            break;
         case 6:
            var56 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(6));
            break;
         case 7:
            var55 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(7));
            break;
         case 8:
            var54 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(8));
            break;
         case 9:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var61.add(Integer.valueOf(9));
            break;
         case 10:
            var52 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(10));
            break;
         case 11:
            var53 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(11));
            break;
         case 12:
            var51 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(12));
            break;
         case 13:
            var50 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(13));
            break;
         case 14:
            var48 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(14));
            break;
         case 15:
            var49 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(15));
            break;
         case 16:
            var47 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(16));
            break;
         case 17:
            var46 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(17));
            break;
         case 18:
            var45 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(18));
            break;
         case 19:
            var44 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(19));
            break;
         case 20:
            var43 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(20));
            break;
         case 21:
            var42 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(21));
            break;
         case 22:
            var41 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(22));
            break;
         case 23:
            var40 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(23));
            break;
         case 24:
            var39 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(24));
            break;
         case 25:
            var38 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(25));
            break;
         case 26:
            var37 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(26));
            break;
         case 27:
            var36 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(27));
            break;
         case 28:
            var34 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(28));
            break;
         case 29:
            var35 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(29));
            break;
         case 30:
            var33 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(30));
            break;
         case 31:
            var32 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(31));
            break;
         case 32:
            var31 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(32));
            break;
         case 33:
            var29 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(33));
            break;
         case 34:
            var30 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(34));
            break;
         case 35:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var9);
            break;
         case 36:
            var4 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var9);
            var61.add(Integer.valueOf(36));
            break;
         case 37:
            var28 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(37));
            break;
         case 38:
            var2 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var9);
            var61.add(Integer.valueOf(38));
            break;
         case 39:
            var26 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(39));
            break;
         case 40:
            var27 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(40));
            break;
         case 41:
            var25 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(41));
            break;
         case 42:
            var24 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(42));
            break;
         case 43:
            var23 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(43));
            break;
         case 44:
            var22 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(44));
            break;
         case 45:
            var20 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(45));
            break;
         case 46:
            var21 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(46));
            break;
         case 47:
            var19 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(47));
            break;
         case 48:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(48));
            break;
         case 49:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(49));
            break;
         case 50:
            var17 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pd.CREATOR);
            var61.add(Integer.valueOf(50));
            break;
         case 51:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(51));
            break;
         case 52:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(52));
            break;
         case 53:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(53));
            break;
         case 54:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(54));
            break;
         case 55:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(55));
            break;
         case 56:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var61.add(Integer.valueOf(56));
         }
      }

      if(var1.dataPosition() != var8) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var8, var1);
      } else {
         return new pd(var61, var7, var60, var58, var59, var57, var56, var55, var54, var6, var52, var53, var51, var50, var48, var49, var47, var46, var45, var44, var43, var42, var41, var40, var39, var38, var37, var36, var34, var35, var33, var32, var31, var29, var30, var4, var28, var2, var26, var27, var25, var24, var23, var22, var20, var21, var19, var18, var16, var17, var15, var14, var13, var12, var11, var10);
      }
   }

   public pd[] fv(int var1) {
      return new pd[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fv(var1);
   }
}
