package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.y;

public class dq implements Creator {
   static void a(dr var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.sb, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (IBinder)var0.ck(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (IBinder)var0.cl(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (IBinder)var0.cm(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (IBinder)var0.cn(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (String)var0.sg, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.sh);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 9, (String)var0.si, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 10, (IBinder)var0.cp(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 11, var0.orientation);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 12, var0.sk);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 13, (String)var0.rH, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 14, (Parcelable)var0.lO, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 15, (IBinder)var0.co(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 17, (Parcelable)var0.sn, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 16, (String)var0.sm, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.f(var1);
   }

   public dr f(Parcel var1) {
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var4 = 0;
      do var20 = null;
      IBinder var19 = null;
      IBinder var18 = null;
      IBinder var17 = null;
      IBinder var16 = null;
      String var15 = null;
      boolean var7 = false;
      String var14 = null;
      IBinder var13 = null;
      int var3 = 0;
      int var2 = 0;
      String var12 = null;
      gs var11 = null;
      IBinder var10 = null;
      String var9 = null;
      y var8 = null;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var20 = (do)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, do.CREATOR);
            break;
         case 3:
            var19 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 4:
            var18 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 5:
            var17 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 6:
            var16 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 7:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 8:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 9:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 10:
            var13 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 12:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 13:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 14:
            var11 = (gs)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, gs.CREATOR);
            break;
         case 15:
            var10 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 16:
            var9 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 17:
            var8 = (y)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, y.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new dr(var4, var20, var19, var18, var17, var16, var15, var7, var14, var13, var3, var2, var12, var11, var10, var9, var8);
      }
   }

   public dr[] n(int var1) {
      return new dr[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.n(var1);
   }
}
