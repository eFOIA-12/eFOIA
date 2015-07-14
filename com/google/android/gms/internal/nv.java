package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.oa;
import com.google.android.gms.internal.oe;
import java.util.ArrayList;

public class nv implements Creator {
   static void a(nu var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.ahn, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.nu(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.nv());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.aht, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 6, var0.ahu, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public nu cQ(Parcel var1) {
      boolean var5 = false;
      ArrayList var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var7 = null;
      String var8 = null;
      ArrayList var9 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, oa.CREATOR);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, oe.CREATOR);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
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
         return new nu(var2, var9, var8, var5, var7, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cQ(var1);
   }

   public nu[] eM(int var1) {
      return new nu[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eM(var1);
   }
}
