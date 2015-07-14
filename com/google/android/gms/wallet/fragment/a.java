package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;

public class a implements Creator {
   static void a(WalletFragmentInitParams var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getAccountName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.getMaskedWalletRequest(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getMaskedWalletRequestCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.getMaskedWallet(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dZ(var1);
   }

   public WalletFragmentInitParams dZ(Parcel var1) {
      MaskedWallet var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      int var2 = -1;
      MaskedWalletRequest var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var7 = (MaskedWalletRequest)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, MaskedWalletRequest.CREATOR);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 5:
            var6 = (MaskedWallet)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, MaskedWallet.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new WalletFragmentInitParams(var3, var8, var7, var2, var6);
      }
   }

   public WalletFragmentInitParams[] gh(int var1) {
      return new WalletFragmentInitParams[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gh(var1);
   }
}
