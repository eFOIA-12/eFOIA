package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.ai;

public class aj implements Creator {
   static void a(ai var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getRequestId());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getPath(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (byte[])var0.getData(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.getSourceNodeId(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ey(var1);
   }

   public ai ey(Parcel var1) {
      int var2 = 0;
      String var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      byte[] var7 = null;
      String var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var7 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var5);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var5);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var4, var1);
      } else {
         return new ai(var3, var2, var8, var7, var6);
      }
   }

   public ai[] gH(int var1) {
      return new ai[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gH(var1);
   }
}
