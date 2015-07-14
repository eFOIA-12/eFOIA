package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.gs;
import java.util.ArrayList;

public class fi implements Creator {
   static void a(fh var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Bundle)var0.tK, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.tL, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.lS, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.lL, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.applicationInfo, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.tM, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.tN, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.tO, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (String)var0.tP, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable)var0.lO, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (Bundle)var0.tQ, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 13, var0.tR);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 14, var0.mc, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (Bundle)var0.tS, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 16, var0.tT);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.h(var1);
   }

   public fh h(Parcel var1) {
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      Bundle var19 = null;
      av var18 = null;
      ay var17 = null;
      String var16 = null;
      ApplicationInfo var15 = null;
      PackageInfo var14 = null;
      String var13 = null;
      String var12 = null;
      String var11 = null;
      gs var10 = null;
      Bundle var9 = null;
      int var2 = 0;
      ArrayList var8 = null;
      Bundle var7 = null;
      boolean var6 = false;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var19 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 3:
            var18 = (av)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, av.CREATOR);
            break;
         case 4:
            var17 = (ay)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, ay.CREATOR);
            break;
         case 5:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 6:
            var15 = (ApplicationInfo)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, ApplicationInfo.CREATOR);
            break;
         case 7:
            var14 = (PackageInfo)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, PackageInfo.CREATOR);
            break;
         case 8:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 9:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 10:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 11:
            var10 = (gs)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, gs.CREATOR);
            break;
         case 12:
            var9 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 13:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 14:
            var8 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var5);
            break;
         case 15:
            var7 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 16:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new fh(var3, var19, var18, var17, var16, var15, var14, var13, var12, var11, var10, var9, var2, var8, var7, var6);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.q(var1);
   }

   public fh[] q(int var1) {
      return new fh[var1];
   }
}
