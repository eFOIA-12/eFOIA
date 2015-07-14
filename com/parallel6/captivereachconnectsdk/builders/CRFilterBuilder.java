package com.parallel6.captivereachconnectsdk.builders;

import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;
import com.parallel6.captivereachconnectsdk.models.filters.CRKeywordFilter;
import com.parallel6.captivereachconnectsdk.models.filters.CRLocationBoxFilter;
import com.parallel6.captivereachconnectsdk.models.filters.CRLocationRadiusFilter;
import com.parallel6.captivereachconnectsdk.models.filters.CRRangeFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRFilterBuilder {
   private List filterList = new ArrayList();

   public List build() {
      return this.filterList;
   }

   public CRFilterBuilder withBoundsFilter(String var1) {
      this.filterList.add(new CRLocationBoxFilter(var1));
      return this;
   }

   public CRFilterBuilder withBoundsFilter(String var1, double var2, double var4, double var6, double var8) {
      this.filterList.add(new CRLocationBoxFilter(var1, var2, var4, var6, var8));
      return this;
   }

   public CRFilterBuilder withCompoundFilter(CRFilter... var1) {
      ArrayList var2 = new ArrayList();
      var2.addAll(Arrays.asList(var1));
      this.filterList.add(var2);
      return this;
   }

   public CRFilterBuilder withFilter(String var1) {
      CRFilter var2 = new CRFilter(var1, new ArrayList());
      this.filterList.add(var2);
      return this;
   }

   public CRFilterBuilder withFilter(String var1, String... var2) {
      CRFilter var6 = new CRFilter(var1, new ArrayList());
      int var4 = var2.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String var5 = var2[var3];
         var6.getFilterValues().add(var5);
      }

      this.filterList.add(var6);
      return this;
   }

   public CRFilterBuilder withKeywordFilter(String var1, String var2) {
      ArrayList var3 = new ArrayList();
      var3.addAll(Arrays.asList(var2.split(" ")));
      CRKeywordFilter var4 = new CRKeywordFilter(var1, var3);
      this.filterList.add(var4);
      return this;
   }

   public CRFilterBuilder withKeywordFilter(String var1, String var2, boolean var3) {
      ArrayList var4 = new ArrayList();
      var4.addAll(Arrays.asList(var2.split(" ")));
      CRKeywordFilter var5 = new CRKeywordFilter(var1, var4, var3);
      this.filterList.add(var5);
      return this;
   }

   public CRFilterBuilder withRadiusFilter(String var1) {
      this.filterList.add(new CRLocationRadiusFilter(var1));
      return this;
   }

   public CRFilterBuilder withRadiusFilter(String var1, double var2, double var4, float var6) {
      this.filterList.add(new CRLocationRadiusFilter(var1, var2, var4, (double)var6));
      return this;
   }

   public CRFilterBuilder withRangeFilter(String var1) {
      this.filterList.add(new CRRangeFilter(var1));
      return this;
   }

   public CRFilterBuilder withRangeFilter(String var1, String var2) {
      this.filterList.add(new CRRangeFilter(var1, var2));
      return this;
   }

   public CRFilterBuilder withRangeFilter(String var1, String var2, String var3) {
      this.filterList.add(new CRRangeFilter(var1, var2, var3));
      return this;
   }

   public CRFilterBuilder withRangeFilter(String var1, String var2, String var3, String var4) {
      this.filterList.add(new CRRangeFilter(var1, var2, var3, var4));
      return this;
   }
}
