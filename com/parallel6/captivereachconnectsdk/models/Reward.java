package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class Reward extends CRModel {
   @SerializedName("redemption_points")
   private int redemptionPoints;

   public int getRedemptionPoints() {
      return this.redemptionPoints;
   }

   public void setRedemptionPoints(int var1) {
      this.redemptionPoints = var1;
   }
}
