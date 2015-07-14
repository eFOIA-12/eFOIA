package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import java.util.ArrayList;
import java.util.List;

public class h implements Creator {
   static void a(DataSourcesRequest var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.getDataTypes(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (List)var0.jZ(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, var0.jY());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public DataSourcesRequest bM(Parcel var1) {
      ArrayList var7 = null;
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataType.CREATOR);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.B(var1, var4);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4);
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
         return new DataSourcesRequest(var2, var6, var7, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bM(var1);
   }

   public DataSourcesRequest[] dg(int var1) {
      return new DataSourcesRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dg(var1);
   }
}
