package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;

public class j implements Creator {
   static void a(ValuesSetDetails var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.SO);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.SP);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ValuesSetDetails bp(Parcel var1) {
      int var5 = 0;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new ValuesSetDetails(var2, var3, var4, var5);
      }
   }

   public ValuesSetDetails[] cF(int var1) {
      return new ValuesSetDetails[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bp(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cF(var1);
   }
}
