package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
   public static Filter and(Filter var0, Filter... var1) {
      return new LogicalFilter(Operator.SB, var0, var1);
   }

   public static Filter and(Iterable var0) {
      return new LogicalFilter(Operator.SB, var0);
   }

   public static Filter contains(SearchableMetadataField var0, String var1) {
      return new ComparisonFilter(Operator.SE, var0, var1);
   }

   public static Filter eq(CustomPropertyKey var0, String var1) {
      return new HasFilter(SearchableField.Se, (new AppVisibleCustomProperties.a()).a(var0, var1).iW());
   }

   public static Filter eq(SearchableMetadataField var0, Object var1) {
      return new ComparisonFilter(Operator.Sw, var0, var1);
   }

   public static Filter greaterThan(SearchableOrderedMetadataField var0, Comparable var1) {
      return new ComparisonFilter(Operator.Sz, var0, var1);
   }

   public static Filter greaterThanEquals(SearchableOrderedMetadataField var0, Comparable var1) {
      return new ComparisonFilter(Operator.SA, var0, var1);
   }

   public static Filter in(SearchableCollectionMetadataField var0, Object var1) {
      return new InFilter(var0, var1);
   }

   public static Filter lessThan(SearchableOrderedMetadataField var0, Comparable var1) {
      return new ComparisonFilter(Operator.Sx, var0, var1);
   }

   public static Filter lessThanEquals(SearchableOrderedMetadataField var0, Comparable var1) {
      return new ComparisonFilter(Operator.Sy, var0, var1);
   }

   public static Filter not(Filter var0) {
      return new NotFilter(var0);
   }

   public static Filter openedByMe() {
      return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
   }

   public static Filter or(Filter var0, Filter... var1) {
      return new LogicalFilter(Operator.SC, var0, var1);
   }

   public static Filter or(Iterable var0) {
      return new LogicalFilter(Operator.SC, var0);
   }

   public static Filter sharedWithMe() {
      return new FieldOnlyFilter(SearchableField.Sd);
   }
}
