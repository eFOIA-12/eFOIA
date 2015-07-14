package com.parallel6.ui.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRLocation;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Place extends CRModel {
   private String googleMarkerId;
   @SerializedName("location")
   private CRLocation location;

   public String getGoogleMarkerId() {
      return this.googleMarkerId;
   }

   public CRLocation getLocation() {
      return this.location;
   }

   public void setGoogleMarkerId(String var1) {
      this.googleMarkerId = var1;
   }

   public void setLocation(CRLocation var1) {
      this.location = var1;
   }
}
