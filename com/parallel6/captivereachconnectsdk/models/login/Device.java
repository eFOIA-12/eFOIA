package com.parallel6.captivereachconnectsdk.models.login;

import com.google.gson.annotations.SerializedName;

public class Device {
   @SerializedName("app_version")
   private String app_version;
   @SerializedName("push_id")
   private String push_id;
   @SerializedName("technology")
   private String technology;
   @SerializedName("udid")
   private String udid;

   public Device() {
   }

   public Device(String var1, String var2, String var3, String var4) {
      this.udid = var1;
      this.technology = var2;
      this.push_id = var3;
      this.app_version = var4;
   }

   public String getApp_version() {
      return this.app_version;
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

   public void setApp_version(String var1) {
      this.app_version = var1;
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
