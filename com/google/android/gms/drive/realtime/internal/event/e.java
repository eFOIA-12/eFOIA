package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;

public class e implements Creator {
   static void a(TextDeletedDetails var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.Ti);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public TextDeletedDetails bk(Parcel var1) {
      int var4 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new TextDeletedDetails(var2, var3, var4);
      }
   }

   public TextDeletedDetails[] cA(int var1) {
      return new TextDeletedDetails[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bk(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cA(var1);
   }
}
