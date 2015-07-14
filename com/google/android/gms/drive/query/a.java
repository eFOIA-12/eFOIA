package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

public class a implements Creator {
   static void a(Query var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.RY, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (String)var0.RZ, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.Sa, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.b(var1, 5, var0.Sb, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public Query aQ(Parcel var1) {
      ArrayList var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      SortOrder var6 = null;
      String var7 = null;
      LogicalFilter var8 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var8 = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LogicalFilter.CREATOR);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.a.o(var1, var4);
            break;
         case 4:
            var6 = (SortOrder)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, SortOrder.CREATOR);
            break;
         case 5:
            var5 = com.google.android.gms.common.internal.safeparcel.a.C(var1, var4);
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
         return new Query(var2, var8, var7, var6, var5);
      }
   }

   public Query[] cf(int var1) {
      return new Query[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aQ(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cf(var1);
   }
}
