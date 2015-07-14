package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;

public class s implements Creator {
   static void a(Subscription var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jI());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getAccuracyMode());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public Subscription bE(Parcel var1) {
      DataType var8 = null;
      int var2 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      long var6 = 0L;
      DataSource var9 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var9 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DataSource.CREATOR);
            break;
         case 2:
            var8 = (DataType)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DataType.CREATOR);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new Subscription(var3, var9, var8, var6, var2);
      }
   }

   public Subscription[] cY(int var1) {
      return new Subscription[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cY(var1);
   }
}
