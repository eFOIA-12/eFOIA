package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class pl implements Creator {
   static void a(pi.b var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.apG, var2, true);
      }

      if(var4.contains(Integer.valueOf(3))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.apH, var2, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.apI);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dB(var1);
   }

   public pi.b dB(Parcel var1) {
      pi.b var6 = null;
      int var2 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var8 = new HashSet();
      pi.a var7 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            var8.add(Integer.valueOf(1));
            break;
         case 2:
            var7 = (pi.a)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, pi.a.CREATOR);
            var8.add(Integer.valueOf(2));
            break;
         case 3:
            var6 = (pi.b)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, pi.b.CREATOR);
            var8.add(Integer.valueOf(3));
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            var8.add(Integer.valueOf(4));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new pi.b(var8, var3, var7, var6, var2);
      }
   }

   public pi.b[] fz(int var1) {
      return new pi.b[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fz(var1);
   }
}
