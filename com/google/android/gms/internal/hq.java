package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hj;
import com.google.android.gms.internal.hp;

public class hq implements Creator {
   static void a(hp var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.Dh, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.Di);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.weight);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.Dj);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.Dk, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable[])var0.Dl, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (int[])var0.Dm, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (String)var0.Dn, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hp[] R(int var1) {
      return new hp[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.r(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.R(var1);
   }

   public hp r(Parcel var1) {
      boolean var6 = false;
      String var8 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 1;
      int[] var9 = null;
      hj[] var10 = null;
      String var11 = null;
      boolean var7 = false;
      String var12 = null;
      String var13 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 6:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var10 = (hj[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var5, hj.CREATOR);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.u(var1, var5);
            break;
         case 11:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
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
         return new hp(var3, var13, var12, var7, var2, var6, var11, var10, var9, var8);
      }
   }
}
