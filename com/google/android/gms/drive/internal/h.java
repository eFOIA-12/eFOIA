package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.internal.CreateContentsRequest;

public class h implements Creator {
   static void a(CreateContentsRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.Oi);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public CreateContentsRequest af(Parcel var1) {
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      int var3 = 536870912;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateContentsRequest(var2, var3);
      }
   }

   public CreateContentsRequest[] bp(int var1) {
      return new CreateContentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.af(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bp(var1);
   }
}
