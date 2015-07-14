package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.km;
import com.google.android.gms.internal.kr;

public class kt implements Creator {
   static void a(kr.a var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.hI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.hO());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.hJ());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.hP());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.hQ(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.hR());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.hT(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.hV(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public kr.a M(Parcel var1) {
      km var10 = null;
      int var2 = 0;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var11 = null;
      String var12 = null;
      boolean var8 = false;
      int var3 = 0;
      boolean var9 = false;
      int var4 = 0;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 5:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7);
            break;
         case 6:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 8:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var7);
            break;
         case 9:
            var10 = (km)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, km.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new kr.a(var5, var4, var9, var3, var8, var12, var2, var11, var10);
      }
   }

   public kr.a[] aN(int var1) {
      return new kr.a[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.M(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aN(var1);
   }
}
