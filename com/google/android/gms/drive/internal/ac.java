package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;

public class ac implements Creator {
   static void a(GetDriveIdFromUniqueIdentifierRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.QC, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.QD);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public GetDriveIdFromUniqueIdentifierRequest am(Parcel var1) {
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
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
         return new GetDriveIdFromUniqueIdentifierRequest(var2, var6, var5);
      }
   }

   public GetDriveIdFromUniqueIdentifierRequest[] bB(int var1) {
      return new GetDriveIdFromUniqueIdentifierRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.am(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.bB(var1);
   }
}
