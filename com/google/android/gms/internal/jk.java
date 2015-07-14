package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.jj;

public class jk implements Creator {
   static void a(jj var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.version);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.MD);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.ME);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.MF, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (IBinder)var0.MG, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable[])var0.MH, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Bundle)var0.MI, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public jj D(Parcel var1) {
      int var2 = 0;
      Bundle var7 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      Scope[] var8 = null;
      IBinder var9 = null;
      String var10 = null;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 2:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var6);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.p(var1, var6);
            break;
         case 6:
            var8 = (Scope[])com.google.android.gms.common.internal.safeparcel.a.b(var1, var6, Scope.CREATOR);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.q(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new jj(var4, var3, var2, var10, var9, var8, var7);
      }
   }

   public jj[] aC(int var1) {
      return new jj[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.D(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.aC(var1);
   }
}
