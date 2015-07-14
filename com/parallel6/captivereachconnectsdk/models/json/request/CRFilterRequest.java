package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class CRFilterRequest {
   @SerializedName("brand_relative")
   protected boolean brand_relative;
   @SerializedName("filters")
   protected List filters;
   @SerializedName("minimal")
   protected boolean minimal;
   @SerializedName("order_by")
   protected List order_by;
   @SerializedName("reference_module")
   protected boolean reference_module;

   public CRFilterRequest() {
      this.filters = new ArrayList();
      this.order_by = new ArrayList();
      this.minimal = false;
      this.brand_relative = false;
      this.reference_module = false;
   }

   public CRFilterRequest(List var1) {
      this.filters = var1;
      this.order_by = new ArrayList();
      this.minimal = false;
      this.brand_relative = false;
      this.reference_module = false;
   }

   public List getFilters() {
      return this.filters;
   }

   public List getOrder_by() {
      return this.order_by;
   }

   public boolean isBrand_relative() {
      return this.brand_relative;
   }

   public boolean isMinimal() {
      return this.minimal;
   }

   public boolean isReference_module() {
      return this.reference_module;
   }

   public void setBrand_relative(boolean var1) {
      this.brand_relative = var1;
   }

   public void setFilters(List var1) {
      this.filters = var1;
   }

   public void setMinimal(boolean var1) {
      this.minimal = var1;
   }

   public void setOrder_by(List var1) {
      this.order_by = var1;
   }

   public void setReference_module(boolean var1) {
      this.reference_module = var1;
   }
}
