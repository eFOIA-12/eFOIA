package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRImage;

public class Brand implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public Brand createFromParcel(Parcel var1) {
         Brand var2 = new Brand();
         var2.setId(var1.readInt());
         var2.setName(var1.readString());
         var2.setDescription(var1.readString());
         var2.setCreated_at(var1.readString());
         var2.setLogo((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         return null;
      }

      public Brand[] newArray(int var1) {
         return new Brand[var1];
      }
   };
   @SerializedName("created_at")
   protected String created_at;
   @SerializedName("description")
   protected String description;
   @SerializedName("id")
   protected int id;
   @SerializedName("logo")
   protected CRImage logo;
   @SerializedName("name")
   protected String name;

   public int describeContents() {
      return 0;
   }

   public String getCreated_at() {
      return this.created_at;
   }

   public String getDescription() {
      return this.description;
   }

   public int getId() {
      return this.id;
   }

   public CRImage getLogo() {
      return this.logo;
   }

   public String getName() {
      return this.name;
   }

   public void setCreated_at(String var1) {
      this.created_at = var1;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public void setLogo(CRImage var1) {
      this.logo = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.id);
      var1.writeString(this.name);
      var1.writeString(this.description);
      var1.writeString(this.created_at);
      var1.writeParcelable(this.logo, var2);
   }
}
