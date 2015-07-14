package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.a;

public class g implements Creator {
   static void a(DataSource var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getType());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.getDevice(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.jx(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.getStreamName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.jz());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataSource bv(Parcel var1) {
      boolean var6 = false;
      String var7 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      a var8 = null;
      Device var9 = null;
      int var2 = 0;
      String var10 = null;
      DataType var11 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var11 = (DataType)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, DataType.CREATOR);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 4:
            var9 = (Device)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, Device.CREATOR);
            break;
         case 5:
            var8 = (a)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, a.CREATOR);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5);
            break;
         case 1000:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new DataSource(var3, var11, var10, var2, var9, var8, var7, var6);
      }
   }

   public DataSource[] cO(int var1) {
      return new DataSource[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bv(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cO(var1);
   }
}
