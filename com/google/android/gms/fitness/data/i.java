package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Device;

public class i implements Creator {
   static void a(Device var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getManufacturer(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getModel(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getVersion(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.jF(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getType());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.jC());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public Device bx(Parcel var1) {
      int var2 = 0;
      String var7 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 5:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new Device(var4, var10, var9, var8, var7, var3, var2);
      }
   }

   public Device[] cQ(int var1) {
      return new Device[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bx(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cQ(var1);
   }
}
