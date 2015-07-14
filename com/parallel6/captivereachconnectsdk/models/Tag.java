package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class Tag implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Tag createFromParcel(Parcel var1) {
         return null;
      }

      public Tag[] newArray(int var1) {
         return new Tag[var1];
      }
   };
   @SerializedName("id")
   private int id;
   @SerializedName("name")
   private String name;

   public int describeContents() {
      return 0;
   }

   public int getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public void setName(String var1) {
      this.name = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.id);
      var1.writeString(this.name);
   }
}
