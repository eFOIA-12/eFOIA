package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import java.util.ArrayList;

public class s implements Creator {
   static void a(SessionInsertRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.getSession(), var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 2, var0.getDataSets(), false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 3, var0.getAggregateDataPoints(), false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public SessionInsertRequest bS(Parcel var1) {
      ArrayList var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      ArrayList var7 = null;

      Session var6;
      Session var8;
      for(var6 = null; var1.dataPosition() < var3; var6 = var8) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         ArrayList var9;
         Session var10;
         ArrayList var11;
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var8 = (Session)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Session.CREATOR);
            var9 = var7;
            var10 = var8;
            break;
         case 2:
            var11 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataSet.CREATOR);
            var10 = var6;
            var9 = var11;
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, DataPoint.CREATOR);
            var8 = var6;
            var9 = var7;
            var10 = var8;
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var4);
            var8 = var6;
            var9 = var7;
            var10 = var8;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var4);
            var11 = var7;
            var10 = var6;
            var9 = var11;
         }

         var8 = var10;
         var7 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.a("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionInsertRequest(var2, var6, var7, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.bS(var1);
   }

   public SessionInsertRequest[] dn(int var1) {
      return new SessionInsertRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.dn(var1);
   }
}
