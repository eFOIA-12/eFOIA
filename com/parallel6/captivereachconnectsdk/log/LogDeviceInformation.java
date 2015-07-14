package com.parallel6.captivereachconnectsdk.log;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.utils.ConnectionUtils;
import com.parallel6.captivereachconnectsdk.utils.DeviceUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;

public class LogDeviceInformation {
   @SerializedName("app_version")
   protected String app_version;
   @SerializedName("brand")
   protected String brand;
   @SerializedName("carrier")
   protected String carrier;
   @SerializedName("gps_status")
   protected String gps_status;
   @SerializedName("latitude")
   protected String latitude;
   @SerializedName("longitude")
   protected String longitude;
   @SerializedName("manufacturer")
   protected String manufacturer;
   @SerializedName("network_status")
   protected String network_status;
   @SerializedName("os_version")
   protected String os_version;
   @SerializedName("push_id")
   protected String push_id;
   @SerializedName("token")
   protected String token;
   @SerializedName("udid")
   protected String udid;

   public LogDeviceInformation(Context var1) {
      this.udid = DeviceUtils.getDeviceId(var1);
      this.token = SettingsUtils.getRegistrationToken(var1);
      this.push_id = SettingsUtils.getPushId(var1);
      this.app_version = DeviceUtils.getAppVersion(var1);
      this.os_version = VERSION.RELEASE;
      this.network_status = ConnectionUtils.getNetworkLog(var1);
      this.gps_status = DeviceUtils.getGPSLog(var1);
      this.latitude = SettingsUtils.getLat(var1);
      this.longitude = SettingsUtils.getLng(var1);
      this.brand = Build.MODEL;
      this.manufacturer = Build.MANUFACTURER;
      this.carrier = DeviceUtils.getCarrierName(var1);
   }

   public String getApp_version() {
      return this.app_version;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getCarrier() {
      return this.carrier;
   }

   public String getGps_status() {
      return this.gps_status;
   }

   public String getLatitude() {
      return this.latitude;
   }

   public String getLongitude() {
      return this.longitude;
   }

   public String getManufacturer() {
      return this.manufacturer;
   }

   public String getNetwork_status() {
      return this.network_status;
   }

   public String getOs_version() {
      return this.os_version;
   }

   public String getPush_id() {
      return this.push_id;
   }

   public String getToken() {
      return this.token;
   }

   public String getUdid() {
      return this.udid;
   }

   public void setApp_version(String var1) {
      this.app_version = var1;
   }

   public void setBrand(String var1) {
      this.brand = var1;
   }

   public void setCarrier(String var1) {
      this.carrier = var1;
   }

   public void setGps_status(String var1) {
      this.gps_status = var1;
   }

   public void setLatitude(String var1) {
      this.latitude = var1;
   }

   public void setLongitude(String var1) {
      this.longitude = var1;
   }

   public void setManufacturer(String var1) {
      this.manufacturer = var1;
   }

   public void setNetwork_status(String var1) {
      this.network_status = var1;
   }

   public void setOs_version(String var1) {
      this.os_version = var1;
   }

   public void setPush_id(String var1) {
      this.push_id = var1;
   }

   public void setToken(String var1) {
      this.token = var1;
   }

   public void setUdid(String var1) {
      this.udid = var1;
   }
}
