package com.parallel6.captivereachconnectsdk.models.surveys;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class SurveyItem extends CRModel {
   @SerializedName("created_at")
   private String createdAt;
   @SerializedName("position")
   private int position;
   @SerializedName("updated_at")
   private String updatedAt;

   public SurveyItem(long var1, String var3) {
      super(var1, var3, (String)null, (CRImage)null);
   }

   public String getCreatedAt() {
      return this.createdAt;
   }

   public int getPosition() {
      return this.position;
   }

   public String getUpdatedAt() {
      return this.updatedAt;
   }

   public void setCreatedAt(String var1) {
      this.createdAt = var1;
   }

   public void setPosition(int var1) {
      this.position = var1;
   }

   public void setUpdatedAt(String var1) {
      this.updatedAt = var1;
   }
}
