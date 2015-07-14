package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;

public class b implements Creator {
   static void a(SortOrder var0, Parcel var1, int var2) {
      var2 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1, var0.Sf, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, var0.Sg);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var2);
   }

   public SortOrder aR(Parcel var1) {
      boolean var5 = false;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      ArrayList var6 = null;
      int var2 = 0;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var4, FieldWithSortOrder.CREATOR);
            break;
         case 2:
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
         return new SortOrder(var2, var6, var5);
      }
   }

   public SortOrder[] cg(int var1) {
      return new SortOrder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aR(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.cg(var1);
   }
}
