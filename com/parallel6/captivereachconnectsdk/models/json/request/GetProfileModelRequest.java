package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.login.Profile;

public class GetProfileModelRequest {
   @SerializedName("content")
   private Profile profile;

   public Profile getProfile() {
      return this.profile;
   }

   public void setProfile(Profile var1) {
      this.profile = var1;
   }
}
