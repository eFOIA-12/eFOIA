package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.filters.CRFilter;

public class CRLocationRadiusFilter extends CRFilter {
   @SerializedName("exact_lat")
   private double originLat;
   @SerializedName("exact_lng")
   private double originLng;
   @SerializedName("radius")
   private double radius;

   public CRLocationRadiusFilter(String var1) {
      super(var1);
   }

   public CRLocationRadiusFilter(String var1, double var2, double var4, double var6) {
      super(var1);
      this.originLat = var2;
      this.originLng = var4;
      this.radius = var6;
   }

   public double getOriginLat() {
      return this.originLat;
   }

   public double getOriginLng() {
      return this.originLng;
   }

   public double getRadius() {
      return this.radius;
   }

   public void setOriginLat(double var1) {
      this.originLat = var1;
   }

   public void setOriginLng(double var1) {
      this.originLng = var1;
   }

   public void setRadius(double var1) {
      this.radius = var1;
   }
}
