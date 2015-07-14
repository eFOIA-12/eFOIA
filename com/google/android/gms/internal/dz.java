package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ea;

public class dz implements Creator {
   static void a(ea var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (IBinder)var0.cu(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (IBinder)var0.cv(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (IBinder)var0.cw(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (IBinder)var0.ct(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.g(var1);
   }

   public ea g(Parcel var1) {
      IBinder var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      IBinder var6 = null;
      IBinder var7 = null;
      IBinder var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ea(var2, var8, var7, var6, var5);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.o(var1);
   }

   public ea[] o(int var1) {
      return new ea[var1];
   }
}
