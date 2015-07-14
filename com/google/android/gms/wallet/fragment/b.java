package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public class b implements Creator {
   static void a(WalletFragmentOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getEnvironment());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getTheme());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.getFragmentStyle(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getMode());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ea(var1);
   }

   public WalletFragmentOptions ea(Parcel var1) {
      int var2 = 1;
      int var3 = 0;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      WalletFragmentStyle var8 = null;
      int var4 = 1;
      int var5 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 4:
            var8 = (WalletFragmentStyle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, WalletFragmentStyle.CREATOR);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new WalletFragmentOptions(var5, var4, var3, var8, var2);
      }
   }

   public WalletFragmentOptions[] gi(int var1) {
      return new WalletFragmentOptions[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gi(var1);
   }
}
