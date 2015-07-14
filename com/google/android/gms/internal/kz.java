package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.kv;
import com.google.android.gms.internal.ky;

public class kz implements Creator {
   static void a(ky var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcel)var0.ic(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.id(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ky Q(Parcel var1) {
      kv var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Parcel var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.D(var1, var4);
            break;
         case 3:
            var6 = (kv)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, kv.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new ky(var2, var5, var6);
      }
   }

   public ky[] aR(int var1) {
      return new ky[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.Q(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aR(var1);
   }
}
