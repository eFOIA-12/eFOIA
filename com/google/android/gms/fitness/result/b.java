package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.ArrayList;

public class b implements Creator {
   static void a(DataReadResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.d(var1, 1, var0.kt(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.d(var1, 3, var0.ks(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.kr());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.jw(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 7, var0.ku(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public DataReadResult ce(Parcel var1) {
      int var2 = 0;
      ArrayList var6 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var9 = new ArrayList();
      ArrayList var10 = new ArrayList();
      ArrayList var7 = null;
      Status var8 = null;
      int var3 = 0;

      while(var1.dataPosition() < var4) {
         int var5 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var5)) {
         case 1:
            com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, var9, this.getClass().getClassLoader());
            break;
         case 2:
            var8 = (Status)com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, Status.CREATOR);
            break;
         case 3:
            com.google.android.gms.common.internal.safeparcel.a.a(var1, var5, var10, this.getClass().getClassLoader());
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var5);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, DataSource.CREATOR);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var5, DataType.CREATOR);
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
         return new DataReadResult(var3, var9, var8, var10, var2, var7, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.ce(var1);
   }

   public DataReadResult[] dz(int var1) {
      return new DataReadResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dz(var1);
   }
}
