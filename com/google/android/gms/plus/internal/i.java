package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.h;

public class i implements Creator {
   static void a(h var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getAccountName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String[])var0.oz(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String[])var0.oA(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String[])var0.oB(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.oC(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.oD(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.oE(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.oF(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.oG(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dw(var1);
   }

   public h dw(Parcel var1) {
      PlusCommonExtras var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String[] var10 = null;
      String[] var11 = null;
      String[] var12 = null;
      String var13 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 9:
            var5 = (PlusCommonExtras)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, PlusCommonExtras.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new h(var2, var13, var12, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   public h[] fu(int var1) {
      return new h[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fu(var1);
   }
}
