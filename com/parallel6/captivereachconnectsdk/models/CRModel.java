package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import java.util.List;

public class CRModel implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public CRModel createFromParcel(Parcel var1) {
         CRModel var2 = new CRModel();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         return var2;
      }

      public CRModel[] newArray(int var1) {
         return new CRModel[var1];
      }
   };
   @SerializedName("brand")
   protected Brand brand;
   @SerializedName("content_type")
   protected String content_type;
   @SerializedName("description")
   protected String description;
   @SerializedName("distance")
   protected double distance;
   @SerializedName("id")
   protected long id;
   @SerializedName("image")
   protected CRImage image;
   @SerializedName("tags")
   protected List tagList;
   @SerializedName("title")
   protected String title;

   public CRModel() {
   }

   public CRModel(long var1, String var3, String var4, CRImage var5) {
      this.id = var1;
      this.title = var3;
      this.description = var4;
      this.image = var5;
   }

   public int describeContents() {
      return 0;
   }

   public Brand getBrand() {
      return this.brand;
   }

   public String getContent_type() {
      return this.content_type;
   }

   public String getDescription() {
      return this.description;
   }

   public double getDistance() {
      return this.distance;
   }

   public long getId() {
      return this.id;
   }

   public CRImage getImage() {
      return this.image;
   }

   public List getTagList() {
      return this.tagList;
   }

   public String getTitle() {
      return this.title;
   }

   public void setBrand(Brand var1) {
      this.brand = var1;
   }

   public void setContent_type(String var1) {
      this.content_type = var1;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public void setDistance(double var1) {
      this.distance = var1;
   }

   public void setId(long var1) {
      this.id = var1;
   }

   public void setImage(CRImage var1) {
      this.image = var1;
   }

   public void setTagList(List var1) {
      this.tagList = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeLong(this.id);
      var1.writeString(this.title);
      var1.writeString(this.description);
      var1.writeString(this.content_type);
      var1.writeParcelable(this.image, var2);
      var1.writeParcelable(this.brand, var2);
   }
}
