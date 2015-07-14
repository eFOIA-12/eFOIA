package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ns;
import com.google.android.gms.internal.nu;

public class nt implements Creator {
   static void a(ns var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.np());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.ns());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.nt(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ns cP(Parcel var1) {
      int var3 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = -1;
      nu var7 = null;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 3:
            var7 = (nu)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, nu.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new ns(var2, var3, var4, var7);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cP(var1);
   }

   public ns[] eL(int var1) {
      return new ns[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eL(var1);
   }
}
