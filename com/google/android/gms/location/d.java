package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;

public class d implements Creator {
   static void a(LocationRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.mPriority);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.agr);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.ags);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.Wg);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.age);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.agt);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.agu);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.agv);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public LocationRequest cJ(Parcel var1) {
      int var6 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var5 = 0;
      int var4 = 102;
      long var14 = 3600000L;
      long var12 = 600000L;
      boolean var16 = false;
      long var10 = Long.MAX_VALUE;
      int var3 = Integer.MAX_VALUE;
      float var2 = 0.0F;
      long var8 = 0L;

      while(var1.dataPosition() < var6) {
         int var7 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var7)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 2:
            var14 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 4:
            var16 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var7);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.l(var1, var7);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var7);
            break;
         case 1000:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var6, var1);
      } else {
         return new LocationRequest(var5, var4, var14, var12, var16, var10, var3, var2, var8);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.cJ(var1);
   }

   public LocationRequest[] eA(int var1) {
      return new LocationRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.eA(var1);
   }
}
