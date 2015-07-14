package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.or;

public class ot implements Creator {
   static void a(or var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.amW);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.tag, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (byte[])var0.amX, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Bundle)var0.amY, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dt(var1);
   }

   public or dt(Parcel var1) {
      Bundle var7 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      long var5 = 0L;
      byte[] var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var4);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new or(var2, var5, var9, var8, var7);
      }
   }

   public or[] fq(int var1) {
      return new or[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fq(var1);
   }
}
