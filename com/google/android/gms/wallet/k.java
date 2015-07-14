package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.OfferWalletObject;

public class k implements Creator {
   static void a(MaskedWallet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.auL, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.auM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String[])var0.auR, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.auO, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.auP, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.auQ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (Parcelable[])var0.avw, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable[])var0.avx, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (Parcelable)var0.auS, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable)var0.auT, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, (Parcelable[])var0.auU, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dS(var1);
   }

   public MaskedWallet dS(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var15 = null;
      String var14 = null;
      String[] var13 = null;
      String var12 = null;
      Address var11 = null;
      Address var10 = null;
      LoyaltyWalletObject[] var9 = null;
      OfferWalletObject[] var8 = null;
      UserAddress var7 = null;
      UserAddress var6 = null;
      InstrumentInfo[] var5 = null;

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
            var13 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 5:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var11 = (Address)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Address.CREATOR);
            break;
         case 7:
            var10 = (Address)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Address.CREATOR);
            break;
         case 8:
            var9 = (LoyaltyWalletObject[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, LoyaltyWalletObject.CREATOR);
            break;
         case 9:
            var8 = (OfferWalletObject[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, OfferWalletObject.CREATOR);
            break;
         case 10:
            var7 = (UserAddress)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, UserAddress.CREATOR);
            break;
         case 11:
            var6 = (UserAddress)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, UserAddress.CREATOR);
            break;
         case 12:
            var5 = (InstrumentInfo[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, InstrumentInfo.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new MaskedWallet(var2, var15, var14, var13, var12, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   public MaskedWallet[] fZ(int var1) {
      return new MaskedWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fZ(var1);
   }
}
