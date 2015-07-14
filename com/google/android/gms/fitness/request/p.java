package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

public class p implements Creator {
   static void a(o var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (IBinder)var0.kg(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.VX);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.VY);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.jI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.kd());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (Parcelable)var0.kb(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, var0.kc());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 10, var0.getAccuracyMode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 11, var0.ke(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 12, var0.kf());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public o bQ(Parcel var1) {
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var5 = 0;
      DataSource var20 = null;
      DataType var19 = null;
      IBinder var18 = null;
      int var4 = 0;
      int var3 = 0;
      long var14 = 0L;
      long var12 = 0L;
      PendingIntent var17 = null;
      long var10 = 0L;
      int var2 = 0;
      ArrayList var16 = null;
      long var8 = 0L;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var20 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, DataSource.CREATOR);
            break;
         case 2:
            var19 = (DataType)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, DataType.CREATOR);
            break;
         case 3:
            var18 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var7);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 6:
            var14 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 7:
            var12 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 8:
            var17 = (PendingIntent)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, PendingIntent.CREATOR);
            break;
         case 9:
            var10 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 11:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7, LocationRequest.CREATOR);
            break;
         case 12:
            var8 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 1000:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new o(var5, var20, var19, var18, var4, var3, var14, var12, var17, var10, var2, var16, var8);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bQ(var1);
   }

   public o[] dk(int var1) {
      return new o[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dk(var1);
   }
}
