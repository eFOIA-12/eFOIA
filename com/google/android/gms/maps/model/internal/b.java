package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.internal.a;

public class b implements Creator {
   static void a(a var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (byte)var0.oh());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Bundle)var0.oi(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.getBitmap(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.dp(var1);
   }

   public a dp(Parcel var1) {
      Bitmap var7 = null;
      byte var2 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      Bundle var6 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var5);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var5);
            break;
         case 4:
            var7 = (Bitmap)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, Bitmap.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new a(var3, var2, var6, var7);
      }
   }

   public a[] fl(int var1) {
      return new a[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fl(var1);
   }
}
