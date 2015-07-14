package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;

public class Distance {
   @SerializedName("latitude")
   private double latitude;
   @SerializedName("longitude")
   private double longitude;

   public double getLatitude() {
      return this.latitude;
   }

   public double getLongitude() {
      return this.longitude;
   }

   public void setLatitude(double var1) {
      this.latitude = var1;
   }

   public void setLongitude(double var1) {
      this.longitude = var1;
   }
}
