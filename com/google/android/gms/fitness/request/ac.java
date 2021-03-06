package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import java.util.ArrayList;

public class ac implements Creator {
   static void a(StartBleScanRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (IBinder)var0.km(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getTimeoutSecs());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public StartBleScanRequest bY(Parcel var1) {
      IBinder var7 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, DataType.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var5);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new StartBleScanRequest(var2, var6, var7, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bY(var1);
   }

   public StartBleScanRequest[] dt(int var1) {
      return new StartBleScanRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dt(var1);
   }
}
