package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ov;

public class ow implements Creator {
   static void a(ov var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.packageName, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.ang);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.anh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.ani, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (String)var0.anj, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.ank);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (String)var0.anl, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.du(var1);
   }

   public ov du(Parcel var1) {
      int var2 = 0;
      String var8 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      boolean var7 = true;
      String var9 = null;
      String var10 = null;
      int var3 = 0;
      String var11 = null;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 6:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 8:
            var8 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new ov(var4, var11, var3, var2, var10, var9, var7, var8);
      }
   }

   public ov[] fr(int var1) {
      return new ov[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.fr(var1);
   }
}
