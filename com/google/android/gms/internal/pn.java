package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class pn implements Creator {
   static void a(pi.b var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var3 = var0.aon;
      if(var3.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var3.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.lj);
      }

      if(var3.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.vf, true);
      }

      if(var3.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.li);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dD(var1);
   }

   public pi.b dD(Parcel var1) {
      int var2 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var8 = new HashSet();
      String var7 = null;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var8.add(Integer.valueOf(1));
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var8.add(Integer.valueOf(2));
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            var8.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var8.add(Integer.valueOf(4));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new pi.b(var8, var4, var3, var7, var2);
      }
   }

   public pi.b[] fB(int var1) {
      return new pi.b[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fB(var1);
   }
}
