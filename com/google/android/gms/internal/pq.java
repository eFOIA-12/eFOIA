package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class pq implements Creator {
   static void a(pi.f var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var3 = var0.aon;
      if(var3.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var3.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.apP, true);
      }

      if(var3.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.UO, true);
      }

      if(var3.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.aoK, true);
      }

      if(var3.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.apQ, true);
      }

      if(var3.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.mName, true);
      }

      if(var3.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.apR);
      }

      if(var3.contains(Integer.valueOf(8))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.apa, true);
      }

      if(var3.contains(Integer.valueOf(9))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.OH, true);
      }

      if(var3.contains(Integer.valueOf(10))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.Gt);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dG(var1);
   }

   public pi.f dG(Parcel var1) {
      int var2 = 0;
      String var7 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var14 = new HashSet();
      String var8 = null;
      boolean var6 = false;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      String var13 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            var14.add(Integer.valueOf(1));
            break;
         case 2:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(2));
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(3));
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(4));
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(5));
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(6));
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            var14.add(Integer.valueOf(7));
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(8));
            break;
         case 9:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            var14.add(Integer.valueOf(9));
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            var14.add(Integer.valueOf(10));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new pi.f(var14, var3, var13, var12, var11, var10, var9, var6, var8, var7, var2);
      }
   }

   public pi.f[] fE(int var1) {
      return new pi.f[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fE(var1);
   }
}
