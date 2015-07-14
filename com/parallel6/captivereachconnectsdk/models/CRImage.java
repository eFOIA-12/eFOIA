package com.parallel6.captivereachconnectsdk.models;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRImageURL;

public class CRImage implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRImage createFromParcel(Parcel var1) {
         String var2 = var1.readString();
         CRImageURL var3 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImageURL var4 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImageURL var5 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImageURL var6 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImageURL var7 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImageURL var9 = (CRImageURL)var1.readParcelable(CRImageURL.class.getClassLoader());
         CRImage var8 = new CRImage();
         var8.setUrl(var2);
         var8.setMain(var3);
         var8.setSmall(var4);
         var8.setMain_hd(var5);
         var8.setSmall_hd(var6);
         var8.setFullscreen(var7);
         var8.setFullscreen_hd(var9);
         return var8;
      }

      public CRImage[] newArray(int var1) {
         return new CRImage[var1];
      }
   };
   @SerializedName("fullscreen")
   private CRImageURL fullscreen;
   @SerializedName("fullscreen_hd")
   private CRImageURL fullscreen_hd;
   @SerializedName("main")
   private CRImageURL main;
   @SerializedName("main_hd")
   private CRImageURL main_hd;
   @SerializedName("small")
   private CRImageURL small;
   @SerializedName("small_hd")
   private CRImageURL small_hd;
   @SerializedName("url")
   private String url;

   public int describeContents() {
      return 0;
   }

   public boolean equals(CRImage var1) {
      return this.getUrl().equals(var1.getUrl()) && this.getMain().equals(var1.getMain()) && this.getSmall().equals(var1.getSmall());
   }

   public CRImageURL getFullscreen() {
      return this.fullscreen;
   }

   public CRImageURL getFullscreen_hd() {
      return this.fullscreen_hd;
   }

   public String getImageForDensity(CRImage.IMAGE_TYPE param1, Activity param2) {
      // $FF: Couldn't be decompiled
   }

   public CRImageURL getMain() {
      return this.main;
   }

   public CRImageURL getMain_hd() {
      return this.main_hd;
   }

   public CRImageURL getSmall() {
      return this.small;
   }

   public CRImageURL getSmall_hd() {
      return this.small_hd;
   }

   public String getUrl() {
      return this.url;
   }

   public void setFullscreen(CRImageURL var1) {
      this.fullscreen = var1;
   }

   public void setFullscreen_hd(CRImageURL var1) {
      this.fullscreen_hd = var1;
   }

   public void setMain(CRImageURL var1) {
      this.main = var1;
   }

   public void setMain_hd(CRImageURL var1) {
      this.main_hd = var1;
   }

   public void setSmall(CRImageURL var1) {
      this.small = var1;
   }

   public void setSmall_hd(CRImageURL var1) {
      this.small_hd = var1;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.url);
      var1.writeParcelable(this.main, var2);
      var1.writeParcelable(this.small, var2);
      var1.writeParcelable(this.main_hd, var2);
      var1.writeParcelable(this.small_hd, var2);
      var1.writeParcelable(this.small_hd, var2);
   }

   public static enum IMAGE_TYPE {
      FULLSCREEN,
      MAIN,
      SMALL;
   }
}
