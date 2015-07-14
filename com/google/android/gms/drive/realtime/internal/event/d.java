package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;

public class d implements Creator {
   static void a(ReferenceShiftedDetails var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.Te, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.Tf, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.Tg);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.Th);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public ReferenceShiftedDetails bj(Parcel var1) {
      String var7 = null;
      int var2 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      String var8 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new ReferenceShiftedDetails(var4, var8, var7, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bj(var1);
   }

   public ReferenceShiftedDetails[] cz(int var1) {
      return new ReferenceShiftedDetails[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cz(var1);
   }
}
