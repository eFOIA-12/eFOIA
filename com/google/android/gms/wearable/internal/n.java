package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.internal.m;

public class n implements Creator {
   static void a(m var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getUri(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Bundle)var0.rk(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (byte[])var0.getData(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.eq(var1);
   }

   public m eq(Parcel var1) {
      byte[] var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Bundle var7 = null;

      Uri var6;
      Uri var8;
      for(var6 = null; var1.dataPosition() < var3; var6 = var8) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         Bundle var9;
         Uri var10;
         Bundle var11;
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var8 = var6;
            var9 = var7;
            var10 = var8;
            break;
         case 2:
            var8 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Uri.CREATOR);
            var9 = var7;
            var10 = var8;
            break;
         case 3:
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            var11 = var7;
            var10 = var6;
            var9 = var11;
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var4);
            var10 = var6;
            var9 = var11;
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.a.r(var1, var4);
            var8 = var6;
            var9 = var7;
            var10 = var8;
         }

         var8 = var10;
         var7 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new m(var2, var6, var7, var5);
      }
   }

   public m[] gz(int var1) {
      return new m[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.gz(var1);
   }
}
