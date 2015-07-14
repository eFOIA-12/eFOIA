package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.RawDataSet;
import java.util.ArrayList;

public class o implements Creator {
   static void a(RawDataSet var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.UJ);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.UL);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.UM, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.Uc);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public RawDataSet bB(Parcel var1) {
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var8 = null;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, RawDataPoint.CREATOR);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new RawDataSet(var4, var3, var2, var8, var7);
      }
   }

   public RawDataSet[] cU(int var1) {
      return new RawDataSet[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cU(var1);
   }
}
