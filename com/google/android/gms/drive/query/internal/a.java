package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class a implements Creator {
   static void a(ComparisonFilter var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.Sh, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Si, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public ComparisonFilter aS(Parcel var1) {
      MetadataBundle var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      Operator var6 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var6 = (Operator)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, Operator.CREATOR);
            break;
         case 2:
            var5 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, MetadataBundle.CREATOR);
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
         return new ComparisonFilter(var2, var6, var5);
      }
   }

   public ComparisonFilter[] ch(int var1) {
      return new ComparisonFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ch(var1);
   }
}
