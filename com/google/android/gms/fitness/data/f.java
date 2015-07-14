package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class f implements Creator {
   static void a(DataSet var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getDataSource(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getDataType(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.d(var1, 3, var0.jv(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.jw(), false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, var0.jn());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataSet bu(Parcel var1) {
      boolean var5 = false;
      ArrayList var6 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var9 = new ArrayList();
      DataType var7 = null;
      DataSource var8 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var8 = (DataSource)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataSource.CREATOR);
            break;
         case 2:
            var7 = (DataType)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataType.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, var9, this.getClass().getClassLoader());
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataSource.CREATOR);
            break;
         case 5:
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
         return new DataSet(var2, var8, var7, var9, var6, var5);
      }
   }

   public DataSet[] cN(int var1) {
      return new DataSet[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cN(var1);
   }
}
