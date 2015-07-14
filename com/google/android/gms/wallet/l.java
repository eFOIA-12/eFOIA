package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.CountrySpecification;
import com.google.android.gms.wallet.MaskedWalletRequest;
import java.util.ArrayList;

public class l implements Creator {
   static void a(MaskedWalletRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.auM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.avz);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.avA);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.avB);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.avC, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.auG, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.avD, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.auV, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, var0.avE);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, var0.avF);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (Parcelable[])var0.avG, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, var0.avH);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, var0.avI);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 15, var0.avJ, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dT(var1);
   }

   public MaskedWalletRequest dT(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var18 = null;
      boolean var11 = false;
      boolean var10 = false;
      boolean var9 = false;
      String var17 = null;
      String var16 = null;
      String var15 = null;
      Cart var14 = null;
      boolean var8 = false;
      boolean var7 = false;
      CountrySpecification[] var13 = null;
      boolean var6 = true;
      boolean var5 = true;
      ArrayList var12 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var18 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 6:
            var17 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 7:
            var16 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 8:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 9:
            var14 = (Cart)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Cart.CREATOR);
            break;
         case 10:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 11:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 12:
            var13 = (CountrySpecification[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, CountrySpecification.CREATOR);
            break;
         case 13:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 14:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 15:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new MaskedWalletRequest(var2, var18, var11, var10, var9, var17, var16, var15, var14, var8, var7, var13, var6, var5, var12);
      }
   }

   public MaskedWalletRequest[] ga(int var1) {
      return new MaskedWalletRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ga(var1);
   }
}
