package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;

public class PointRecord {
   @SerializedName("points_record")
   private PointRecord.PointableRecord points_record;

   public PointRecord(int var1, String var2) {
      this.points_record = new PointRecord.PointableRecord(var1, var2);
   }

   public PointRecord.PointableRecord getPoints_record() {
      return this.points_record;
   }

   public void setPoints_record(PointRecord.PointableRecord var1) {
      this.points_record = var1;
   }

   public class PointableRecord {
      @SerializedName("pointable_id")
      private String pointable_id;
      @SerializedName("pointable_type")
      private String pointable_type;

      public PointableRecord(int var2, String var3) {
         this.pointable_id = String.valueOf(var2);
         this.pointable_type = var3;
      }

      public String getPointable_id() {
         return this.pointable_id;
      }

      public String getPointable_type() {
         return this.pointable_type;
      }

      public void setPointable_id(String var1) {
         this.pointable_id = var1;
      }

      public void setPointable_type(String var1) {
         this.pointable_type = var1;
      }
   }
}
