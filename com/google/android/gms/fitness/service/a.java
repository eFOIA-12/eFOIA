package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public class a implements Creator {
   static void a(FitnessSensorServiceRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.kg(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jI());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.kx());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public FitnessSensorServiceRequest ck(Parcel var1) {
      long var5 = 0L;
      IBinder var9 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      long var7 = 0L;
      DataSource var10 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var10 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataSource.CREATOR);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var4);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 4:
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
         return new FitnessSensorServiceRequest(var2, var10, var9, var7, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ck(var1);
   }

   public FitnessSensorServiceRequest[] dF(int var1) {
      return new FitnessSensorServiceRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dF(var1);
   }
}
