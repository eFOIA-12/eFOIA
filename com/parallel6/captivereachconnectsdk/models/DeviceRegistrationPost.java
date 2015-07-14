package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRLocation;
import java.util.ArrayList;
import java.util.List;

public class DeviceRegistrationPost {
   @SerializedName("device")
   private DeviceRegistrationPost.DevicePostRequest device;

   public DeviceRegistrationPost(String var1, String var2, String var3, String var4, String var5) {
      this.device = new DeviceRegistrationPost.DevicePostRequest(var1, var2, var3, var4, var5);
   }

   public DeviceRegistrationPost.DevicePostRequest getDevice() {
      return this.device;
   }

   public void setDevice(DeviceRegistrationPost.DevicePostRequest var1) {
      this.device = var1;
   }

   public class DevicePostRequest {
      @SerializedName("locations_attributes")
      private List locations_attributes;
      @SerializedName("push_id")
      private String push_id;
      @SerializedName("technology")
      private String technology;
      @SerializedName("udid")
      private String udid;

      public DevicePostRequest(String var2, String var3, String var4, String var5, String var6) {
         this.udid = var2;
         this.push_id = var3;
         this.technology = var4;
         this.locations_attributes = new ArrayList();
         this.locations_attributes.add(new CRLocation(Double.parseDouble(var5), Double.parseDouble(var6)));
      }

      public List getLocations_attributes() {
         return this.locations_attributes;
      }

      public String getPush_id() {
         return this.push_id;
      }

      public String getTechnology() {
         return this.technology;
      }

      public String getUdid() {
         return this.udid;
      }

      public void setLocations_attributes(List var1) {
         this.locations_attributes = var1;
      }

      public void setPush_id(String var1) {
         this.push_id = var1;
      }

      public void setTechnology(String var1) {
         this.technology = var1;
      }

      public void setUdid(String var1) {
         this.udid = var1;
      }
   }
}
