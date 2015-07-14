package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;

public class i implements Creator {
   static void a(ValuesRemovedDetails var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.SO);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.SP);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.Tm, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.Tn);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ValuesRemovedDetails bo(Parcel var1) {
      int var2 = 0;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var9 = null;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var8);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new ValuesRemovedDetails(var6, var5, var4, var3, var9, var2);
      }
   }

   public ValuesRemovedDetails[] cE(int var1) {
      return new ValuesRemovedDetails[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bo(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cE(var1);
   }
}
