package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;

public class CRRangeFilter extends CRFilter {
   @SerializedName("equal")
   private String exactString;
   @SerializedName("max")
   private String maxString;
   @SerializedName("min")
   private String minString;

   public CRRangeFilter() {
      this((String)null, (String)null, (String)null, (String)null);
   }

   public CRRangeFilter(String var1) {
      this(var1, (String)null, (String)null, (String)null);
   }

   public CRRangeFilter(String var1, String var2) {
      this(var1, var2, (String)null, (String)null);
   }

   public CRRangeFilter(String var1, String var2, String var3) {
      this(var1, var2, var3, (String)null);
   }

   public CRRangeFilter(String var1, String var2, String var3, String var4) {
      super(var1);
      this.minString = var2;
      this.maxString = var3;
      this.exactString = var4;
   }

   public String getExactString() {
      return this.exactString;
   }

   public String getMaxString() {
      return this.maxString;
   }

   public String getMinString() {
      return this.minString;
   }

   public void setExactString(String var1) {
      this.exactString = var1;
   }

   public void setMaxString(String var1) {
      this.maxString = var1;
   }

   public void setMinString(String var1) {
      this.minString = var1;
   }
}
