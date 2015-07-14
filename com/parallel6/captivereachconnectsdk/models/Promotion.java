package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import java.util.List;

public class Promotion extends CRModel {
   private static final String TAG = Promotion.class.getSimpleName();
   @SerializedName("encoded_data")
   private String encodedData;
   @SerializedName("gallery")
   private List gallery;
   @SerializedName("limit")
   private int limit;
   @SerializedName("points")
   private int points;

   public String getEncodedData() {
      return this.encodedData;
   }

   public List getGallery() {
      return this.gallery;
   }

   public int getLimit() {
      return this.limit;
   }

   public int getPoints() {
      return this.points;
   }

   public void setEncodedData(String var1) {
      this.encodedData = var1;
   }

   public void setGallery(List var1) {
      this.gallery = var1;
   }

   public void setLimit(int var1) {
      this.limit = var1;
   }

   public void setPoints(int var1) {
      this.points = var1;
   }
}
