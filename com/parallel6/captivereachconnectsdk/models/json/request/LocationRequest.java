package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRLocation;

public class LocationRequest {
   @SerializedName("location")
   protected CRLocation location;

   public CRLocation getLocation() {
      return this.location;
   }

   public void setLocation(CRLocation var1) {
      this.location = var1;
   }
}
