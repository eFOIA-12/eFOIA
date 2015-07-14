package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PromotionList {
   @SerializedName("promotions")
   private List promotions;

   public List getPromotions() {
      return this.promotions;
   }

   public void setPromotions(List var1) {
      this.promotions = var1;
   }
}
