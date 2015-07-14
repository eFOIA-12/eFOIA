package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.ay;

public class az implements Creator {
   static void a(ay var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.op, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.height);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.heightPixels);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.oq);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.width);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.widthPixels);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (Parcelable[])var0.or, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ay c(Parcel var1) {
      ay[] var10 = null;
      int var2 = 0;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var3 = 0;
      boolean var9 = false;
      int var4 = 0;
      int var5 = 0;
      String var11 = null;
      int var6 = 0;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var8);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var8);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 8:
            var10 = (ay[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var8, ay.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new ay(var6, var11, var5, var4, var9, var3, var2, var10);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.c(var1);
   }

   public ay[] g(int var1) {
      return new ay[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.g(var1);
   }
}
