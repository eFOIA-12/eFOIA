package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.io;

public class ip implements Creator {
   static void a(io var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.fZ());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.gi());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.gj());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.getApplicationMetadata(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.gk());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public io[] ai(int var1) {
      return new io[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.y(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ai(var1);
   }

   public io y(Parcel var1) {
      int var4 = 0;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      double var2 = 0.0D;
      ApplicationMetadata var10 = null;
      int var5 = 0;
      boolean var9 = false;
      int var6 = 0;

      while(var1.dataPosition() < var7) {
         int var8 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var8)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.m(var1, var8);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var8);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         case 5:
            var10 = (ApplicationMetadata)com.google.android.gms.common.internal.safeparcel.a.a(var1, var8, ApplicationMetadata.CREATOR);
            break;
         case 6:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var7, var1);
      } else {
         return new io(var6, var2, var9, var5, var10, var4);
      }
   }
}
