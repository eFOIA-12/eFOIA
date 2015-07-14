package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;

public class CallbackCondition {
   @SerializedName("callback_id")
   protected Integer callbackId;
   @SerializedName("created_at")
   protected String created_at;
   @SerializedName("criteria")
   protected String criteria;
   @SerializedName("id")
   protected Integer id;
   @SerializedName("operator")
   protected String operator;
   @SerializedName("unit")
   protected String unit;
   @SerializedName("updated_at")
   protected String updated_at;
   @SerializedName("value")
   protected Integer value;

   public Integer getCallbackId() {
      return this.callbackId;
   }

   public String getCreated_at() {
      return this.created_at;
   }

   public String getCriteria() {
      return this.criteria;
   }

   public Integer getId() {
      return this.id;
   }

   public String getOperator() {
      return this.operator;
   }

   public String getUnit() {
      return this.unit;
   }

   public String getUpdated_at() {
      return this.updated_at;
   }

   public Integer getValue() {
      return this.value;
   }

   public void setCallbackId(Integer var1) {
      this.callbackId = var1;
   }

   public void setCreated_at(String var1) {
      this.created_at = var1;
   }

   public void setCriteria(String var1) {
      this.criteria = var1;
   }

   public void setId(Integer var1) {
      this.id = var1;
   }

   public void setOperator(String var1) {
      this.operator = var1;
   }

   public void setUnit(String var1) {
      this.unit = var1;
   }

   public void setUpdated_at(String var1) {
      this.updated_at = var1;
   }

   public void setValue(Integer var1) {
      this.value = var1;
   }
}
