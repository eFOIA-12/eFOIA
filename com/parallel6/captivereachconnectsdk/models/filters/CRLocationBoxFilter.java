package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;

public class CRLocationBoxFilter extends CRFilter {
   @SerializedName("ne_lat")
   private double neLat;
   @SerializedName("ne_lng")
   private double neLng;
   @SerializedName("sw_lat")
   private double swLat;
   @SerializedName("sw_lng")
   private double swLng;

   public CRLocationBoxFilter(String var1) {
      super(var1);
   }

   public CRLocationBoxFilter(String var1, double var2, double var4, double var6, double var8) {
      super(var1);
      this.swLat = var2;
      this.swLng = var4;
      this.neLat = var6;
      this.neLng = var8;
   }

   public double getNeLat() {
      return this.neLat;
   }

   public double getNeLng() {
      return this.neLng;
   }

   public double getSwLat() {
      return this.swLat;
   }

   public double getSwLng() {
      return this.swLng;
   }

   public void setNeLat(double var1) {
      this.neLat = var1;
   }

   public void setNeLng(double var1) {
      this.neLng = var1;
   }

   public void setSwLat(double var1) {
      this.swLat = var1;
   }

   public void setSwLng(double var1) {
      this.swLng = var1;
   }
}
