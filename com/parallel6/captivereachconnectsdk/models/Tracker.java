package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class Tracker {
   @SerializedName("action")
   private String action;
   @SerializedName("brand_id")
   private String brandId;
   @SerializedName("label")
   private String label;
   @SerializedName("lat")
   private String latitude;
   @SerializedName("lng")
   private String longitude;
   @SerializedName("options")
   private Map options;
   @SerializedName("section")
   private String section;
   @SerializedName("triggered_at")
   private String triggered_at;
   @SerializedName("value")
   private String value;

   public String getAction() {
      return this.action;
   }

   public String getBrandId() {
      return this.brandId;
   }

   public String getLabel() {
      return this.label;
   }

   public String getLatitude() {
      return this.latitude;
   }

   public String getLongitude() {
      return this.longitude;
   }

   public Map getOptions() {
      return this.options;
   }

   public String getSection() {
      return this.section;
   }

   public String getTriggered_at() {
      return this.triggered_at;
   }

   public String getValue() {
      return this.value;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public void setBrandId(String var1) {
      this.brandId = var1;
   }

   public void setLabel(String var1) {
      this.label = var1;
   }

   public void setLatitude(String var1) {
      this.latitude = var1;
   }

   public void setLongitude(String var1) {
      this.longitude = var1;
   }

   public void setOptions(Map var1) {
      this.options = var1;
   }

   public void setSection(String var1) {
      this.section = var1;
   }

   public void setTriggered_at(String var1) {
      this.triggered_at = var1;
   }

   public void setValue(String var1) {
      this.value = var1;
   }
}
