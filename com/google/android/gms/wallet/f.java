package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.identity.intents.model.UserAddress;
import com.google.android.gms.wallet.Address;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.InstrumentInfo;
import com.google.android.gms.wallet.ProxyCard;

public class f implements Creator {
   static void a(FullWallet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.auL, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.auM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.auN, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.auO, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.auP, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.auQ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String[])var0.auR, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.auS, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (Parcelable)var0.auT, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 11, (Parcelable[])var0.auU, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dN(var1);
   }

   public FullWallet dN(Parcel var1) {
      InstrumentInfo[] var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      UserAddress var6 = null;
      UserAddress var7 = null;
      String[] var8 = null;
      Address var9 = null;
      Address var10 = null;
      String var11 = null;
      ProxyCard var12 = null;
      String var13 = null;
      String var14 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var12 = (ProxyCard)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ProxyCard.CREATOR);
            break;
         case 5:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 6:
            var10 = (Address)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Address.CREATOR);
            break;
         case 7:
            var9 = (Address)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Address.CREATOR);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.A(var1, var4);
            break;
         case 9:
            var7 = (UserAddress)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, UserAddress.CREATOR);
            break;
         case 10:
            var6 = (UserAddress)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, UserAddress.CREATOR);
            break;
         case 11:
            var5 = (InstrumentInfo[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, InstrumentInfo.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new FullWallet(var2, var14, var13, var12, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   public FullWallet[] fU(int var1) {
      return new FullWallet[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fU(var1);
   }
}
