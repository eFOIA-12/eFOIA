package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;

public class r implements Creator {
   static void a(q var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getSession(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.jH(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public q bD(Parcel var1) {
      DataSet var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Session var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var6 = (Session)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Session.CREATOR);
            break;
         case 2:
            var5 = (DataSet)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, DataSet.CREATOR);
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
         return new q(var2, var6, var5);
      }
   }

   public q[] cX(int var1) {
      return new q[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cX(var1);
   }
}
