package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hh;

public class he implements Creator {
   static void a(hd var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable[])var0.CL, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.CM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.CN);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.account, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hd[] J(int var1) {
      return new hd[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.l(var1);
   }

   public hd l(Parcel var1) {
      boolean var5 = false;
      Account var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var7 = null;
      hh[] var8 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var8 = (hh[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, hh.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 4:
            var6 = (Account)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Account.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new hd(var2, var8, var7, var5, var6);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.J(var1);
   }
}
