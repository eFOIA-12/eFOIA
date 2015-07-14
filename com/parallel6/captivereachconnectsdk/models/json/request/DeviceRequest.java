package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.login.Device;

public class DeviceRequest {
   @SerializedName("device")
   private Device device;

   public DeviceRequest(Device var1) {
      this.device = var1;
   }

   public DeviceRequest(String var1, String var2, String var3, String var4) {
      this.device = new Device(var1, var2, var3, var4);
   }

   public Device getDevice() {
      return this.device;
   }

   public void setDevice(Device var1) {
      this.device = var1;
   }
}
