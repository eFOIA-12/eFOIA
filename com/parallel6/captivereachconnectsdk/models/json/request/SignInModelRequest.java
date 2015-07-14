package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.login.Device;
import com.parallel6.captivereachconnectsdk.models.login.MobileUser;

public class SignInModelRequest {
   @SerializedName("device")
   protected Device device;
   @SerializedName("mobile_user")
   protected MobileUser mobile_user;

   public Device getDevice() {
      return this.device;
   }

   public MobileUser getMobile_user() {
      return this.mobile_user;
   }

   public void setDevice(Device var1) {
      this.device = var1;
   }

   public void setMobile_user(MobileUser var1) {
      this.mobile_user = var1;
   }
}
