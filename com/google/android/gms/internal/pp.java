package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class pp implements Creator {
   static void a(pi.d var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var3 = var0.aon;
      if(var3.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var3.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.aoL, true);
      }

      if(var3.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.apL, true);
      }

      if(var3.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.aoO, true);
      }

      if(var3.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.apM, true);
      }

      if(var3.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.apN, true);
      }

      if(var3.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.apO, true);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dF(var1);
   }

   public pi.d dF(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var11 = new HashSet();
      int var2 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var11.add(Integer.valueOf(1));
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(2));
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(3));
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(4));
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(5));
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(6));
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var11.add(Integer.valueOf(7));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new pi.d(var11, var2, var10, var9, var8, var7, var6, var5);
      }
   }

   public pi.d[] fD(int var1) {
      return new pi.d[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fD(var1);
   }
}
