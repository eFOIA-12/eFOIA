package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.d;

public class FilterHolder implements SafeParcelable {
   public static final Creator CREATOR = new d();
   final int CK;
   final ComparisonFilter Sl;
   final FieldOnlyFilter Sm;
   final LogicalFilter Sn;
   final NotFilter So;
   final InFilter Sp;
   final MatchAllFilter Sq;
   final HasFilter Sr;
   private final Filter Ss;

   FilterHolder(int var1, ComparisonFilter var2, FieldOnlyFilter var3, LogicalFilter var4, NotFilter var5, InFilter var6, MatchAllFilter var7, HasFilter var8) {
      this.CK = var1;
      this.Sl = var2;
      this.Sm = var3;
      this.Sn = var4;
      this.So = var5;
      this.Sp = var6;
      this.Sq = var7;
      this.Sr = var8;
      if(this.Sl != null) {
         this.Ss = this.Sl;
      } else if(this.Sm != null) {
         this.Ss = this.Sm;
      } else if(this.Sn != null) {
         this.Ss = this.Sn;
      } else if(this.So != null) {
         this.Ss = this.So;
      } else if(this.Sp != null) {
         this.Ss = this.Sp;
      } else if(this.Sq != null) {
         this.Ss = this.Sq;
      } else if(this.Sr != null) {
         this.Ss = this.Sr;
      } else {
         throw new IllegalArgumentException("At least one filter must be set.");
      }
   }

   public FilterHolder(Filter var1) {
      this.CK = 2;
      ComparisonFilter var2;
      if(var1 instanceof ComparisonFilter) {
         var2 = (ComparisonFilter)var1;
      } else {
         var2 = null;
      }

      this.Sl = var2;
      FieldOnlyFilter var3;
      if(var1 instanceof FieldOnlyFilter) {
         var3 = (FieldOnlyFilter)var1;
      } else {
         var3 = null;
      }

      this.Sm = var3;
      LogicalFilter var4;
      if(var1 instanceof LogicalFilter) {
         var4 = (LogicalFilter)var1;
      } else {
         var4 = null;
      }

      this.Sn = var4;
      NotFilter var5;
      if(var1 instanceof NotFilter) {
         var5 = (NotFilter)var1;
      } else {
         var5 = null;
      }

      this.So = var5;
      InFilter var6;
      if(var1 instanceof InFilter) {
         var6 = (InFilter)var1;
      } else {
         var6 = null;
      }

      this.Sp = var6;
      MatchAllFilter var7;
      if(var1 instanceof MatchAllFilter) {
         var7 = (MatchAllFilter)var1;
      } else {
         var7 = null;
      }

      this.Sq = var7;
      HasFilter var8;
      if(var1 instanceof HasFilter) {
         var8 = (HasFilter)var1;
      } else {
         var8 = null;
      }

      this.Sr = var8;
      if(this.Sl == null && this.Sm == null && this.Sn == null && this.So == null && this.Sp == null && this.Sq == null && this.Sr == null) {
         throw new IllegalArgumentException("Invalid filter type or null filter.");
      } else {
         this.Ss = var1;
      }
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.Ss;
   }

   public String toString() {
      return String.format("FilterHolder[%s]", new Object[]{this.Ss});
   }

   public void writeToParcel(Parcel var1, int var2) {
      d.a(this, var1, var2);
   }
}
