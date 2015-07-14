package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.a;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query implements SafeParcelable {
   public static final Creator CREATOR = new a();
   final int CK;
   final LogicalFilter RY;
   final String RZ;
   final SortOrder Sa;
   final List Sb;

   Query(int var1, LogicalFilter var2, String var3, SortOrder var4, List var5) {
      this.CK = var1;
      this.RY = var2;
      this.RZ = var3;
      this.Sa = var4;
      this.Sb = var5;
   }

   Query(LogicalFilter var1, String var2, SortOrder var3, List var4) {
      this(1, var1, var2, var3, var4);
   }

   public int describeContents() {
      return 0;
   }

   public Filter getFilter() {
      return this.RY;
   }

   public String getPageToken() {
      return this.RZ;
   }

   public SortOrder getSortOrder() {
      return this.Sa;
   }

   public List jb() {
      return this.Sb;
   }

   public String toString() {
      return String.format(Locale.US, "Query[%s,%s,PageToken=%s]", new Object[]{this.RY, this.Sa, this.RZ});
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }

   public static class Builder {
      private String RZ;
      private SortOrder Sa;
      private List Sb;
      private final List Sc = new ArrayList();

      public Builder() {
      }

      public Builder(Query var1) {
         this.Sc.add(var1.getFilter());
         this.RZ = var1.getPageToken();
         this.Sa = var1.getSortOrder();
         this.Sb = var1.jb();
      }

      public Query.Builder addFilter(Filter var1) {
         if(!(var1 instanceof MatchAllFilter)) {
            this.Sc.add(var1);
         }

         return this;
      }

      public Query build() {
         return new Query(new LogicalFilter(Operator.SB, this.Sc), this.RZ, this.Sa, this.Sb);
      }

      public Query.Builder setPageToken(String var1) {
         this.RZ = var1;
         return this;
      }

      public Query.Builder setSortOrder(SortOrder var1) {
         this.Sa = var1;
         return this;
      }
   }
}
