package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;

public class jw implements Creator {
   static void a(jg.a var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getAccountName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 2, var0.ho(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.hn());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.hq(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public jg.a E(Parcel var1) {
      int var2 = 0;
      String var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var7 = null;
      String var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var5);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
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
         return new jg.a(var3, var8, var7, var2, var6);
      }
   }

   public jg.a[] aG(int var1) {
      return new jg.a[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.E(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aG(var1);
   }
}
