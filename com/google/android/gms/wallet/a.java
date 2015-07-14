package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.Address;

public class a implements Creator {
   static void a(Address var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.afK, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.afL, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.afM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.vk, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.auD, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.auE, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.afR, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (String)var0.afT, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.afU);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (String)var0.afV, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dJ(var1);
   }

   public Address dJ(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var15 = null;
      String var14 = null;
      String var13 = null;
      String var12 = null;
      String var11 = null;
      String var10 = null;
      String var9 = null;
      String var8 = null;
      String var7 = null;
      boolean var5 = false;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 5:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 9:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 10:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 11:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 12:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new Address(var2, var15, var14, var13, var12, var11, var10, var9, var8, var7, var5, var6);
      }
   }

   public Address[] fQ(int var1) {
      return new Address[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fQ(var1);
   }
}
