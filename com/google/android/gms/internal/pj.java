package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class pj implements Creator {
   static void a(pi var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.apl, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.apm, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.apn, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.apo, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.app);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.apq, var2, true);
      }

      if(var4.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.apr, true);
      }

      if(var4.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.OS, true);
      }

      if(var4.contains(Integer.valueOf(12))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 12, var0.ow);
      }

      if(var4.contains(Integer.valueOf(14))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (String)var0.CE, true);
      }

      if(var4.contains(Integer.valueOf(15))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (Parcelable)var0.aps, var2, true);
      }

      if(var4.contains(Integer.valueOf(16))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 16, var0.apt);
      }

      if(var4.contains(Integer.valueOf(19))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 19, (Parcelable)var0.apu, var2, true);
      }

      if(var4.contains(Integer.valueOf(18))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 18, (String)var0.FR, true);
      }

      if(var4.contains(Integer.valueOf(21))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 21, var0.apw);
      }

      if(var4.contains(Integer.valueOf(20))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 20, (String)var0.apv, true);
      }

      if(var4.contains(Integer.valueOf(23))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 23, var0.apy, true);
      }

      if(var4.contains(Integer.valueOf(22))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 22, var0.apx, true);
      }

      if(var4.contains(Integer.valueOf(25))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 25, var0.apA);
      }

      if(var4.contains(Integer.valueOf(24))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 24, var0.apz);
      }

      if(var4.contains(Integer.valueOf(27))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 27, (String)var0.vf, true);
      }

      if(var4.contains(Integer.valueOf(26))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 26, (String)var0.apB, true);
      }

      if(var4.contains(Integer.valueOf(29))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 29, var0.apD);
      }

      if(var4.contains(Integer.valueOf(28))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 28, var0.apC, true);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dz(var1);
   }

   public pi dz(Parcel var1) {
      int var8 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var29 = new HashSet();
      int var7 = 0;
      String var27 = null;
      pi.a var28 = null;
      String var26 = null;
      String var24 = null;
      int var6 = 0;
      pi.b var25 = null;
      String var23 = null;
      String var22 = null;
      int var5 = 0;
      String var20 = null;
      pi.c var21 = null;
      boolean var11 = false;
      String var18 = null;
      pi.d var19 = null;
      String var17 = null;
      int var4 = 0;
      ArrayList var16 = null;
      ArrayList var15 = null;
      int var3 = 0;
      int var2 = 0;
      String var14 = null;
      String var13 = null;
      ArrayList var12 = null;
      boolean var10 = false;

      while(var1.dataPosition() < var8) {
         int var9 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var9)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(1));
            break;
         case 2:
            var27 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(2));
            break;
         case 3:
            var28 = (pi.a)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pi.a.CREATOR);
            var29.add(Integer.valueOf(3));
            break;
         case 4:
            var26 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(4));
            break;
         case 5:
            var24 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(6));
            break;
         case 7:
            var25 = (pi.b)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pi.b.CREATOR);
            var29.add(Integer.valueOf(7));
            break;
         case 8:
            var23 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(8));
            break;
         case 9:
            var22 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(9));
            break;
         case 10:
         case 11:
         case 13:
         case 17:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var9);
            break;
         case 12:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(12));
            break;
         case 14:
            var20 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(14));
            break;
         case 15:
            var21 = (pi.c)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pi.c.CREATOR);
            var29.add(Integer.valueOf(15));
            break;
         case 16:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9);
            var29.add(Integer.valueOf(16));
            break;
         case 18:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(18));
            break;
         case 19:
            var19 = (pi.d)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, pi.d.CREATOR);
            var29.add(Integer.valueOf(19));
            break;
         case 20:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(20));
            break;
         case 21:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(21));
            break;
         case 22:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pi.f.CREATOR);
            var29.add(Integer.valueOf(22));
            break;
         case 23:
            var15 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pi.g.CREATOR);
            var29.add(Integer.valueOf(23));
            break;
         case 24:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(24));
            break;
         case 25:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var9);
            var29.add(Integer.valueOf(25));
            break;
         case 26:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(26));
            break;
         case 27:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var9);
            var29.add(Integer.valueOf(27));
            break;
         case 28:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9, pi.h.CREATOR);
            var29.add(Integer.valueOf(28));
            break;
         case 29:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var9);
            var29.add(Integer.valueOf(29));
         }
      }

      if(var1.dataPosition() != var8) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var8, var1);
      } else {
         return new pi(var29, var7, var27, var28, var26, var24, var6, var25, var23, var22, var5, var20, var21, var11, var18, var19, var17, var4, var16, var15, var3, var2, var14, var13, var12, var10);
      }
   }

   public pi[] fx(int var1) {
      return new pi[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fx(var1);
   }
}
