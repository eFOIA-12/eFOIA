package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class d implements Creator {
   static void a(Bucket var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, var0.jo());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.jp());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.getSession(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 4, var0.jm());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 5, var0.getDataSets(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 6, var0.getBucketType());
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, var0.jn());
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public Bucket bs(Parcel var1) {
      long var7 = 0L;
      ArrayList var12 = null;
      boolean var11 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      int var3 = 0;
      Session var13 = null;
      long var9 = 0L;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var6)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var6);
            break;
         case 3:
            var13 = (Session)com.google.android.gms.common.internal.safeparcel.a.a(var1, var6, Session.CREATOR);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 5:
            var12 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6, DataSet.CREATOR);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         case 7:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var5, var1);
      } else {
         return new Bucket(var4, var9, var7, var13, var3, var12, var2, var11);
      }
   }

   public Bucket[] cK(int var1) {
      return new Bucket[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bs(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cK(var1);
   }
}
