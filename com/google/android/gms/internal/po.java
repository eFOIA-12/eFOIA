package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pi;
import java.util.HashSet;
import java.util.Set;

public class po implements Creator {
   static void a(pi.c var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var3 = var0.aon;
      if(var3.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var3.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.vf, true);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dE(var1);
   }

   public pi.c dE(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var6 = new HashSet();
      int var2 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var6.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var6.add(Integer.valueOf(2));
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new pi.c(var6, var2, var5);
      }
   }

   public pi.c[] fC(int var1) {
      return new pi.c[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fC(var1);
   }
}
