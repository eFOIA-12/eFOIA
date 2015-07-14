package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class CRResource extends CRModel {
   @SerializedName("path")
   private CRResource.Path path;
   @SerializedName("resourceable_id")
   private String resourceableId;
   @SerializedName("resourceable_type")
   private String resourceableType;

   public CRResource.Path getPath() {
      return this.path;
   }

   public String getResourceableId() {
      return this.resourceableId;
   }

   public String getResourceableType() {
      return this.resourceableType;
   }

   public void setPath(CRResource.Path var1) {
      this.path = var1;
   }

   public void setResourceableId(String var1) {
      this.resourceableId = var1;
   }

   public void setResourceableType(String var1) {
      this.resourceableType = var1;
   }

   public class Path {
      @SerializedName("url")
      private String url;

      public String getUrl() {
         return this.url;
      }

      public void setUrl(String var1) {
         this.url = var1;
      }
   }
}
