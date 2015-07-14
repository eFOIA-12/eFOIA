package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.kv;

public class ku implements Creator {
   static void a(kv.b var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.fv, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.NZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public kv.b N(Parcel var1) {
      kr.a var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var6 = (kr.a)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, kr.a.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new kv.b(var2, var5, var6);
      }
   }

   public kv.b[] aO(int var1) {
      return new kv.b[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.N(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aO(var1);
   }
}
