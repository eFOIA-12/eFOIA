package com.parallel6.captivereachconnectsdk.network.login;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.login.Profile;

public class ProfileRequest {
   @SerializedName("profile")
   private Profile profile;

   public Profile getProfile() {
      return this.profile;
   }

   public void setProfile(Profile var1) {
      this.profile = var1;
   }
}
