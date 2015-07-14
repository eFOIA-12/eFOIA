package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.response.ImageResponse;

@Deprecated
public class CRModelV1 implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public CRModelV1 createFromParcel(Parcel var1) {
         return null;
      }

      public CRModelV1[] newArray(int var1) {
         return new CRModelV1[var1];
      }
   };
   @SerializedName("content_type")
   protected String content_type;
   @SerializedName("description")
   protected String description;
   @SerializedName("id")
   protected long id;
   @SerializedName("image")
   protected ImageResponse image;
   @SerializedName("title")
   protected String title;

   public CRModelV1() {
   }

   public CRModelV1(long var1, String var3, String var4, ImageResponse var5) {
      this.id = var1;
      this.title = var3;
      this.description = var4;
      this.image = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getContent_type() {
      return this.content_type;
   }

   public String getDescription() {
      return this.description;
   }

   public long getId() {
      return this.id;
   }

   public ImageResponse getImage() {
      return this.image;
   }

   public String getTitle() {
      return this.title;
   }

   public void setContent_type(String var1) {
      this.content_type = var1;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public void setId(long var1) {
      this.id = var1;
   }

   public void setImage(ImageResponse var1) {
      this.image = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
