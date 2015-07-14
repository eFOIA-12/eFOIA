package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.nu;
import com.google.android.gms.internal.ny;

public class nz implements Creator {
   static void a(ny var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.nt(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.getInterval());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getPriority());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ny cS(Parcel var1) {
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      nu var8 = null;
      long var6 = ny.ahz;
      int var2 = 102;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 2:
            var8 = (nu)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, nu.CREATOR);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
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
         return new ny(var3, var8, var6, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cS(var1);
   }

   public ny[] eO(int var1) {
      return new ny[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eO(var1);
   }
}
