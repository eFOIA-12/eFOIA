package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;
import com.parallel6.captivereachconnectsdk.models.json.response.ImageResponse;

public class New implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public CRModel createFromParcel(Parcel var1) {
         return null;
      }

      public CRModel[] newArray(int var1) {
         return new CRModel[var1];
      }
   };
   @SerializedName("action")
   private String action;
   @SerializedName("action_object")
   private String actionObject;
   @SerializedName("content_id")
   private String content_id;
   @SerializedName("description")
   protected String description;
   @SerializedName("id")
   protected long id;
   @SerializedName("image")
   protected ImageResponse image;
   @SerializedName("title")
   protected String title;

   public New() {
   }

   public New(long var1, String var3, String var4, ImageResponse var5) {
      this.id = var1;
      this.title = var3;
      this.description = var4;
      this.image = var5;
   }

   public New(String var1, String var2) {
      this.title = var1;
      this.description = var2;
   }

   public int describeContents() {
      return 0;
   }

   public String getAction() {
      return this.action;
   }

   public String getActionObject() {
      return this.actionObject;
   }

   public String getContent_id() {
      return this.content_id;
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

   public void setAction(String var1) {
      this.action = var1;
   }

   public void setActionObject(String var1) {
      this.actionObject = var1;
   }

   public void setContent_id(String var1) {
      this.content_id = var1;
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
      var1.writeLong(this.id);
      var1.writeString(this.title);
      var1.writeParcelable(this.image, var2);
   }
}
