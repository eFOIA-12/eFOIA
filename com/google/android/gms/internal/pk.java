package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class pk implements Creator {
   static void a(pi.a var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var3 = var0.aon;
      if(var3.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var3.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.apE);
      }

      if(var3.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.apF);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dA(var1);
   }

   public pi.a dA(Parcel var1) {
      int var4 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var7 = new HashSet();
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var7.add(Integer.valueOf(1));
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var7.add(Integer.valueOf(2));
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            var7.add(Integer.valueOf(3));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new pi.a(var7, var2, var3, var4);
      }
   }

   public pi.a[] fy(int var1) {
      return new pi.a[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fy(var1);
   }
}
