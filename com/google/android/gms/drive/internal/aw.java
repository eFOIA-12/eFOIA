package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.StorageStats;
import com.google.android.gms.drive.internal.OnStorageStatsResponse;

public class aw implements Creator {
   static void a(OnStorageStatsResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.QS, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public OnStorageStatsResponse aB(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      StorageStats var5 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var5 = (StorageStats)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, StorageStats.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new OnStorageStatsResponse(var2, var5);
      }
   }

   public OnStorageStatsResponse[] bQ(int var1) {
      return new OnStorageStatsResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bQ(var1);
   }
}
