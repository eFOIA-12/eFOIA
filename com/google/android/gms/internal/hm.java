package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hl;

public class hm implements Creator {
   static void a(hl.a var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.Dc, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hl.a[] N(int var1) {
      return new hl.a[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.p(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.N(var1);
   }

   public hl.a p(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Account var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var5 = (Account)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Account.CREATOR);
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
         return new hl.a(var2, var5);
      }
   }
}
