package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.do;

public class dn implements Creator {
   static void a(do var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.rG, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.rH, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.mimeType, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.packageName, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.rI, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.rJ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.rK, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.e(var1);
   }

   public do e(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new do(var2, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   public do[] m(int var1) {
      return new do[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.m(var1);
   }
}
