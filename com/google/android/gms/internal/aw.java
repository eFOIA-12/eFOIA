package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.bj;
import java.util.ArrayList;

public class aw implements Creator {
   static void a(av var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.od);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Bundle)var0.extras, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.oe);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 5, var0.of, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.og);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.oh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.oi);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.oj, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (Parcelable)var0.ok, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable)var0.ol, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (String)var0.om, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, (Bundle)var0.on, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public av b(Parcel var1) {
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      long var7 = 0L;
      Bundle var17 = null;
      int var3 = 0;
      ArrayList var16 = null;
      boolean var10 = false;
      int var2 = 0;
      boolean var9 = false;
      String var15 = null;
      bj var14 = null;
      Location var13 = null;
      String var12 = null;
      Bundle var11 = null;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 3:
            var17 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var6);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var16 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var6);
            break;
         case 6:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 9:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 10:
            var14 = (bj)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, bj.CREATOR);
            break;
         case 11:
            var13 = (Location)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, Location.CREATOR);
            break;
         case 12:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 13:
            var11 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new av(var4, var7, var17, var3, var16, var10, var2, var9, var15, var14, var13, var12, var11);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.b(var1);
   }

   public av[] f(int var1) {
      return new av[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.f(var1);
   }
}
