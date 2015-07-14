package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.StorageStats;

public class g implements Creator {
   static void a(StorageStats var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.OM);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.ON);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.OO);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.OP);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.OQ);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public StorageStats V(Parcel var1) {
      int var2 = 0;
      long var6 = 0L;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      long var8 = 0L;
      long var10 = 0L;
      long var12 = 0L;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new StorageStats(var3, var12, var10, var8, var6, var2);
      }
   }

   public StorageStats[] bd(int var1) {
      return new StorageStats[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.V(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bd(var1);
   }
}
