package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.RawDataPoint;
import com.google.android.gms.fitness.data.Value;

public class n implements Creator {
   static void a(RawDataPoint var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, var0.Ud);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.Ue);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable[])var0.Uf, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.UJ);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.UK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.Uh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.Ui);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public RawDataPoint bA(Parcel var1) {
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      long var13 = 0L;
      long var11 = 0L;
      Value[] var15 = null;
      int var3 = 0;
      int var2 = 0;
      long var9 = 0L;
      long var7 = 0L;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 3:
            var15 = (Value[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var6, Value.CREATOR);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
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
         return new RawDataPoint(var4, var13, var11, var15, var3, var2, var9, var7);
      }
   }

   public RawDataPoint[] cT(int var1) {
      return new RawDataPoint[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cT(var1);
   }
}
