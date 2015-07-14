package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pf;
import java.util.HashSet;
import java.util.Set;

public class pg implements Creator {
   static void a(pf var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      }

      if(var4.contains(Integer.valueOf(2))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.CE, true);
      }

      if(var4.contains(Integer.valueOf(4))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.api, var2, true);
      }

      if(var4.contains(Integer.valueOf(5))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.apa, true);
      }

      if(var4.contains(Integer.valueOf(6))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.apj, var2, true);
      }

      if(var4.contains(Integer.valueOf(7))) {
         com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.vc, true);
      }

      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dy(var1);
   }

   public pf dy(Parcel var1) {
      String var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      HashSet var10 = new HashSet();
      int var2 = 0;
      pd var7 = null;
      String var6 = null;
      pd var9 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var10.add(Integer.valueOf(1));
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var10.add(Integer.valueOf(2));
            break;
         case 3:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            break;
         case 4:
            var9 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, pd.CREATOR);
            var10.add(Integer.valueOf(4));
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var10.add(Integer.valueOf(5));
            break;
         case 6:
            var7 = (pd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, pd.CREATOR);
            var10.add(Integer.valueOf(6));
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            var10.add(Integer.valueOf(7));
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new pf(var10, var2, var8, var9, var6, var7, var5);
      }
   }

   public pf[] fw(int var1) {
      return new pf[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fw(var1);
   }
}
