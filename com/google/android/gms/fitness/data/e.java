package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Value;

public class e implements Creator {
   static void a(DataPoint var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.getTimestampNanos());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.ju());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable[])var0.jr(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.getOriginalDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.js());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.jt());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataPoint bt(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      DataSource var15 = null;
      long var11 = 0L;
      long var9 = 0L;
      Value[] var14 = null;
      DataSource var13 = null;
      long var7 = 0L;
      long var5 = 0L;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var15 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataSource.CREATOR);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 5:
            var14 = (Value[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var4, Value.CREATOR);
            break;
         case 6:
            var13 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataSource.CREATOR);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new DataPoint(var2, var15, var11, var9, var14, var13, var7, var5);
      }
   }

   public DataPoint[] cM(int var1) {
      return new DataPoint[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bt(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cM(var1);
   }
}
