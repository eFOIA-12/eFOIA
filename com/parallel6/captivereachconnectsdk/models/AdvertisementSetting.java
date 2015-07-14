package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;

public class AdvertisementSetting {
   @SerializedName("display_time")
   private int displayTime;
   @SerializedName("transition_time")
   private int transitionTime;

   public int getDisplayTime() {
      return this.displayTime;
   }

   public int getTransitionTime() {
      return this.transitionTime;
   }

   public void setDisplayTime(int var1) {
      this.displayTime = var1;
   }

   public void setTransitionTime(int var1) {
      this.transitionTime = var1;
   }
}
