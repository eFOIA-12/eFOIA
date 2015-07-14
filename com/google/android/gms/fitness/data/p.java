package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.a;

public class p implements Creator {
   static void a(Session var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, var0.jo());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.jp());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.getName(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (String)var0.getIdentifier(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (String)var0.getDescription(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.jm());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, (Parcelable)var0.jx(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public Session bC(Parcel var1) {
      long var6 = 0L;
      int var2 = 0;
      a var10 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      String var11 = null;
      String var12 = null;
      String var13 = null;
      long var8 = 0L;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 2:
            var6 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var5);
            break;
         case 3:
            var13 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 4:
            var12 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 5:
            var11 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var5);
            break;
         case 7:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 8:
            var10 = (a)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, a.CREATOR);
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
         return new Session(var3, var8, var6, var13, var12, var11, var2, var10);
      }
   }

   public Session[] cW(int var1) {
      return new Session[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cW(var1);
   }
}
