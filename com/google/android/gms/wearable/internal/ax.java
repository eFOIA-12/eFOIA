package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.aw;
import java.util.ArrayList;

public class ax implements Creator {
   static void a(aw var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.statusCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.ayc);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.aye, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.eE(var1);
   }

   public aw eE(Parcel var1) {
      int var2 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      long var6 = 0L;
      ArrayList var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, an.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new aw(var3, var2, var6, var8);
      }
   }

   public aw[] gO(int var1) {
      return new aw[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gO(var1);
   }
}
