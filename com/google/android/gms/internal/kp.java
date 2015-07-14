package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ko;
import java.util.ArrayList;

public class kp implements Creator {
   static void a(ko var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.hH(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ko K(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, ko.a.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ko(var2, var5);
      }
   }

   public ko[] aL(int var1) {
      return new ko[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.K(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aL(var1);
   }
}
