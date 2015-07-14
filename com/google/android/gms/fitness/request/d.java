package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import java.util.ArrayList;

public class d implements Creator {
   static void a(DataDeleteRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, var0.jo());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.jp());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getDataSources(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getSessions(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, var0.jR());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.jS());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public DataDeleteRequest bJ(Parcel var1) {
      long var5 = 0L;
      ArrayList var11 = null;
      boolean var9 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      boolean var10 = false;
      ArrayList var12 = null;
      ArrayList var13 = null;
      long var7 = 0L;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var4);
            break;
         case 3:
            var13 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataSource.CREATOR);
            break;
         case 4:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataType.CREATOR);
            break;
         case 5:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, Session.CREATOR);
            break;
         case 6:
            var10 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
            break;
         case 7:
            var9 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
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
         return new DataDeleteRequest(var2, var7, var5, var13, var12, var11, var10, var9);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bJ(var1);
   }

   public DataDeleteRequest[] dd(int var1) {
      return new DataDeleteRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dd(var1);
   }
}
