package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;

public class d implements Creator {
   static void a(FilterHolder var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.b.H(var1);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 1, (Parcelable)var0.Sl, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.c(var1, 1000, var0.CK);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 2, (Parcelable)var0.Sm, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 3, (Parcelable)var0.Sn, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 4, (Parcelable)var0.So, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 5, (Parcelable)var0.Sp, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 6, (Parcelable)var0.Sq, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.a(var1, 7, (Parcelable)var0.Sr, var2, false);
      com.google.android.gms.common.internal.safeparcel.b.H(var1, var3);
   }

   public FilterHolder aV(Parcel var1) {
      HasFilter var5 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.a.G(var1);
      int var2 = 0;
      MatchAllFilter var6 = null;
      InFilter var7 = null;
      NotFilter var8 = null;
      LogicalFilter var9 = null;
      FieldOnlyFilter var10 = null;
      ComparisonFilter var11 = null;

      while(var1.dataPosition() < var3) {
         int var4 = com.google.android.gms.common.internal.safeparcel.a.F(var1);
         switch(com.google.android.gms.common.internal.safeparcel.a.aH(var4)) {
         case 1:
            var11 = (ComparisonFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, ComparisonFilter.CREATOR);
            break;
         case 2:
            var10 = (FieldOnlyFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, FieldOnlyFilter.CREATOR);
            break;
         case 3:
            var9 = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, LogicalFilter.CREATOR);
            break;
         case 4:
            var8 = (NotFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, NotFilter.CREATOR);
            break;
         case 5:
            var7 = (InFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, InFilter.CREATOR);
            break;
         case 6:
            var6 = (MatchAllFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, MatchAllFilter.CREATOR);
            break;
         case 7:
            var5 = (HasFilter)com.google.android.gms.common.internal.safeparcel.a.a(var1, var4, HasFilter.CREATOR);
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
         return new FilterHolder(var2, var11, var10, var9, var8, var7, var6, var5);
      }
   }

   public FilterHolder[] ck(int var1) {
      return new FilterHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.aV(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.ck(var1);
   }
}
