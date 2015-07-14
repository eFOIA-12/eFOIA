package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;

public class ARTarget {
   @SerializedName("extension")
   private String extension;
   @SerializedName("http_video")
   private String httpVideo;
   @SerializedName("image")
   private String imageBase64;
   @SerializedName("extension")
   private String mp4Video;
   @SerializedName("name")
   private String name;
   @SerializedName("page_url")
   private String pageURL;
   @SerializedName("width")
   private int width = 480;

   private String returnValid(String var1) {
      String var2;
      if(var1 != null) {
         var2 = var1;
         if(!var1.equals("null")) {
            return var2;
         }
      }

      var2 = "";
      return var2;
   }

   public String getExtension() {
      return this.returnValid(this.extension);
   }

   public String getHttpVideo() {
      return this.returnValid(this.httpVideo);
   }

   public String getImageBase64() {
      return this.returnValid(this.imageBase64);
   }

   public String getMP4Video() {
      return this.returnValid(this.mp4Video);
   }

   public String getName() {
      return this.returnValid(this.name);
   }

   public String getPageURL() {
      return this.returnValid(this.pageURL);
   }

   public int getWidth() {
      return this.width;
   }

   public void setExtension(String var1) {
      this.extension = var1;
   }

   public void setHttpVideo(String var1) {
      this.httpVideo = var1;
   }

   public void setImageBase64(String var1) {
      this.imageBase64 = var1;
   }

   public void setMP4Video(String var1) {
      this.mp4Video = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void setPageURL(String var1) {
      this.pageURL = var1;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }
}
