package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class c implements Creator {
   static void a(BleDevice var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getAddress(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 3, var0.getSupportedProfiles(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public BleDevice br(Parcel var1) {
      ArrayList var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataType.CREATOR);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new BleDevice(var2, var8, var7, var6, var5);
      }
   }

   public BleDevice[] cI(int var1) {
      return new BleDevice[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.br(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cI(var1);
   }
}
