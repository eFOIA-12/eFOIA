package com.parallel6.captivereachconnectsdk.models.filters;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.filters.Distance;

public class CRSort {
   public static final String DIRECTION_ASC = "asc";
   public static final String DIRECTION_DESC = "desc";
   @SerializedName("column")
   private String column;
   @SerializedName("direction")
   private String direction;
   @SerializedName("distance")
   private Distance distance;
   @SerializedName("dynamic_attribute")
   private boolean dynamic_attribute;
   @SerializedName("random")
   private boolean random;
   @SerializedName("seed")
   private long seed;

   public CRSort() {
   }

   public CRSort(String var1, String var2) {
      this.column = var1;
      this.direction = var2;
   }

   public String getColumn() {
      return this.column;
   }

   public String getDirection() {
      return this.direction;
   }

   public Distance getDistance() {
      return this.distance;
   }

   public boolean getRandom() {
      return this.random;
   }

   public long getSeed() {
      return this.seed;
   }

   public boolean isDynamic_attribute() {
      return this.dynamic_attribute;
   }

   public void setColumn(String var1) {
      this.column = var1;
   }

   public void setDirection(String var1) {
      this.direction = var1;
   }

   public void setDistance(Distance var1) {
      this.distance = var1;
   }

   public void setDynamic_attribute(boolean var1) {
      this.dynamic_attribute = var1;
   }

   public void setRandom(boolean var1) {
      this.random = var1;
   }

   public void setSeed(long var1) {
      this.seed = var1;
   }
}
