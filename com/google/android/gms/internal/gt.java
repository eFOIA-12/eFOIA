package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.gs;

public class gt implements Creator {
   static void a(gs var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.wS, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.wT);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.wU);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.wV);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.j(var1);
   }

   public gs j(Parcel var1) {
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var8 = null;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new gs(var4, var8, var3, var2, var7);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.w(var1);
   }

   public gs[] w(int var1) {
      return new gs[var1];
   }
}
