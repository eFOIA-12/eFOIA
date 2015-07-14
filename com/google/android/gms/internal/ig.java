package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.if;

public class ig implements Creator {
   static void a(if var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.responseCode);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Bundle)var0.Ep, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (byte[])var0.Eq, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public if[] U(int var1) {
      return new if[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.t(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.U(var1);
   }

   public if t(Parcel var1) {
      byte[] var7 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      Bundle var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var5);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new if(var2, var3, var6, var7);
      }
   }
}
