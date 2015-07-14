package com.parallel6.captivereachconnectsdk.models.json.response;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import java.util.List;

public class AdvertisementResponse extends BaseJSon {
   @SerializedName("advertisements")
   private List advertisements;

   public List getAdvertisements() {
      return this.advertisements;
   }

   public void setAdvertisements(List var1) {
      this.advertisements = var1;
   }
}
