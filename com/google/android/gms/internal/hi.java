package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hp;

public class hi implements Creator {
   static void a(hh var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.CX, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.CY, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.CZ);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (byte[])var0.Da, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hh[] L(int var1) {
      return new hh[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.n(var1);
   }

   public hh n(Parcel var1) {
      byte[] var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      int var2 = -1;
      hp var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var7 = (hp)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, hp.CREATOR);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var5);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new hh(var3, var8, var7, var2, var6);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.L(var1);
   }
}
