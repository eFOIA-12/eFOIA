package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.LineItem;

public class i implements Creator {
   static void a(LineItem var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.description, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.auZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.ava, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.auF, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.avb);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.auG, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dQ(var1);
   }

   public LineItem dQ(Parcel var1) {
      int var2 = 0;
      String var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new LineItem(var3, var10, var9, var8, var7, var2, var6);
      }
   }

   public LineItem[] fX(int var1) {
      return new LineItem[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fX(var1);
   }
}
