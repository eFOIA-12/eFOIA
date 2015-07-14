package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.SessionReadRequest;
import java.util.ArrayList;

public class t implements Creator {
   static void a(SessionReadRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (String)var0.getSessionName(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (String)var0.getSessionId(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jo());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, var0.jp());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.kj());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 8, var0.jV());
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 9, var0.getExcludedPackages(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public SessionReadRequest bT(Parcel var1) {
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      String var15 = null;
      String var14 = null;
      long var7 = 0L;
      long var5 = 0L;
      ArrayList var13 = null;
      ArrayList var12 = null;
      boolean var10 = false;
      boolean var9 = false;
      ArrayList var11 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var15 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 2:
            var14 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 5:
            var13 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataType.CREATOR);
            break;
         case 6:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataSource.CREATOR);
            break;
         case 7:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 8:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 9:
            var11 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionReadRequest(var2, var15, var14, var7, var5, var13, var12, var10, var9, var11);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bT(var1);
   }

   public SessionReadRequest[] do(int var1) {
      return new SessionReadRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.do(var1);
   }
}
