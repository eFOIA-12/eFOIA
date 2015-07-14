package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.LoadRealtimeRequest;

public class aj implements Creator {
   static void a(LoadRealtimeRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Oj, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.QF);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public LoadRealtimeRequest ap(Parcel var1) {
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      DriveId var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var6 = (DriveId)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DriveId.CREATOR);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new LoadRealtimeRequest(var2, var6, var5);
      }
   }

   public LoadRealtimeRequest[] bE(int var1) {
      return new LoadRealtimeRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ap(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bE(var1);
   }
}
