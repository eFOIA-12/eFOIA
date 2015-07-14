package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Value;

public class u implements Creator {
   static void a(Value var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getFormat());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.isSet());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jL());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public Value bF(Parcel var1) {
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      float var2 = 0.0F;
      int var4 = 0;
      int var3 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var6);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new Value(var3, var4, var7, var2);
      }
   }

   public Value[] cZ(int var1) {
      return new Value[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bF(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cZ(var1);
   }
}
