package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;

public class c implements Creator {
   static void a(DriveId var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.Ot, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.Ou);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.Ov);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public DriveId S(Parcel var1) {
      long var5 = 0L;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var9 = null;
      long var7 = 0L;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new DriveId(var2, var9, var7, var5);
      }
   }

   public DriveId[] aY(int var1) {
      return new DriveId[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.S(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aY(var1);
   }
}
