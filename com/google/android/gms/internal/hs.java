package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.hd;
import com.google.android.gms.internal.hf;
import com.google.android.gms.internal.hr;

public class hs implements Creator {
   static void a(hr var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.Dw, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.Dx);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.Dy);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.pc, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.Dz, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public hr[] S(int var1) {
      return new hr[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.s(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.S(var1);
   }

   public hr s(Parcel var1) {
      int var2 = 0;
      hd var8 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      long var6 = 0L;
      String var9 = null;
      hf var10 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var10 = (hf)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, hf.CREATOR);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var8 = (hd)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, hd.CREATOR);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new hr(var3, var10, var6, var2, var9, var8);
      }
   }
}
