package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.t;

public class u implements Creator {
   static void a(t var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.statusCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable[])var0.axK, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.et(var1);
   }

   public t et(Parcel var1) {
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      com.google.android.gms.wearable.c[] var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 3:
            var6 = (com.google.android.gms.wearable.c[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var5, com.google.android.gms.wearable.c.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new t(var2, var3, var6);
      }
   }

   public t[] gC(int var1) {
      return new t[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gC(var1);
   }
}
