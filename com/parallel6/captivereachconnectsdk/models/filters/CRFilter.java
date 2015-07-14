package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRFilter {
   public static final String SEARCH_METHOD_ENDS_WITH = "ends_with";
   public static final String SEARCH_METHOD_IS = "is";
   public static final String SEARCH_METHOD_LIKE = "like";
   public static final String SEARCH_METHOD_STARTS_WITH = "starts_with";
   @SerializedName("attribute")
   private String attributeName;
   @SerializedName("values")
   private List filterValues;
   @SerializedName("search_method")
   private String search_method;

   public CRFilter() {
   }

   public CRFilter(String var1) {
      this.attributeName = var1;
   }

   public CRFilter(String var1, String var2, String var3) {
      ArrayList var4 = new ArrayList();
      var4.addAll(Arrays.asList(var2.split(" ")));
      this.attributeName = var1;
      this.filterValues = var4;
      this.search_method = var3;
   }

   public CRFilter(String var1, List var2) {
      this.attributeName = var1;
      this.filterValues = var2;
   }

   public CRFilter(String var1, List var2, String var3) {
      this.attributeName = var1;
      this.filterValues = var2;
      this.search_method = var3;
   }

   public String getAttributeName() {
      return this.attributeName;
   }

   public List getFilterValues() {
      return this.filterValues;
   }

   public String getSearch_method() {
      return this.search_method;
   }

   public void setAttributeName(String var1) {
      this.attributeName = var1;
   }

   public void setFilterValues(List var1) {
      this.filterValues = var1;
   }

   public void setSearch_method(String var1) {
      this.search_method = var1;
   }
}
