package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Tracker;

public class TrackerRequest {
   @SerializedName("tracker")
   private Tracker tracker;

   public Tracker getTracker() {
      return this.tracker;
   }

   public void setTracker(Tracker var1) {
      this.tracker = var1;
   }
}
