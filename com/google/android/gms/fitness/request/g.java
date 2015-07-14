package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;

public class g implements Creator {
   static void a(DataReadRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jo());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.jp());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getAggregatedDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getAggregatedDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.getBucketType());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.jX());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (Parcelable)var0.getActivityDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.getLimit());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, var0.jW());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, var0.jV());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataReadRequest bL(Parcel var1) {
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      ArrayList var19 = null;
      ArrayList var18 = null;
      long var11 = 0L;
      long var9 = 0L;
      ArrayList var17 = null;
      ArrayList var16 = null;
      int var3 = 0;
      long var7 = 0L;
      DataSource var15 = null;
      int var2 = 0;
      boolean var14 = false;
      boolean var13 = false;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var19 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, DataType.CREATOR);
            break;
         case 2:
            var18 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, DataSource.CREATOR);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 5:
            var17 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, DataType.CREATOR);
            break;
         case 6:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, DataSource.CREATOR);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 8:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 9:
            var15 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, DataSource.CREATOR);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 12:
            var14 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 13:
            var13 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
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
         return new DataReadRequest(var4, var19, var18, var11, var9, var17, var16, var3, var7, var15, var2, var14, var13);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bL(var1);
   }

   public DataReadRequest[] df(int var1) {
      return new DataReadRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.df(var1);
   }
}
