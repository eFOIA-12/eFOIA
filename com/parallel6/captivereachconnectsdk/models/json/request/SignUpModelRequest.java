package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelRequest;
import com.parallel6.captivereachconnectsdk.models.login.Profile;

public class SignUpModelRequest extends SignInModelRequest {
   @SerializedName("profile")
   protected Profile profile;

   public Profile getProfile() {
      return this.profile;
   }

   public void setProfile(Profile var1) {
      this.profile = var1;
   }
}
