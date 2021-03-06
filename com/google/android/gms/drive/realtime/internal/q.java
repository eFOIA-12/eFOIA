package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

public class q implements Creator {
   static void a(ParcelableIndexReference var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.SM, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.SN);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ParcelableIndexReference bf(Parcel var1) {
      boolean var6 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var7 = null;
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new ParcelableIndexReference(var2, var7, var3, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bf(var1);
   }

   public ParcelableIndexReference[] cv(int var1) {
      return new ParcelableIndexReference[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cv(var1);
   }
}
