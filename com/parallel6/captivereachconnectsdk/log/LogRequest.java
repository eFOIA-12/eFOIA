package com.parallel6.captivereachconnectsdk.log;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.log.LogDeviceInformation;
import com.parallel6.captivereachconnectsdk.log.LogEntry;
import com.parallel6.captivereachconnectsdk.log.LogRequestInformation;

public class LogRequest {
   @SerializedName("device_information")
   protected LogDeviceInformation device_information;
   @SerializedName("entry")
   protected LogEntry entry;
   @SerializedName("request_information")
   protected LogRequestInformation request_information;

   public LogDeviceInformation getDevice_information() {
      return this.device_information;
   }

   public LogEntry getEntry() {
      return this.entry;
   }

   public LogRequestInformation getRequest_information() {
      return this.request_information;
   }

   public void setDevice_information(LogDeviceInformation var1) {
      this.device_information = var1;
   }

   public void setEntry(LogEntry var1) {
      this.entry = var1;
   }

   public void setRequest_information(LogRequestInformation var1) {
      this.request_information = var1;
   }
}
