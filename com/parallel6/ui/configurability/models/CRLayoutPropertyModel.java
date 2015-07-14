package com.parallel6.ui.configurability.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class CRLayoutPropertyModel implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRLayoutPropertyModel createFromParcel(Parcel var1) {
         return null;
      }

      public CRLayoutPropertyModel[] newArray(int var1) {
         return new CRLayoutPropertyModel[0];
      }
   };
   @SerializedName("background_color")
   private String background_color;

   public int describeContents() {
      return 0;
   }

   public String getBackgroundColor() {
      return this.background_color;
   }

   public void setBackgroundColor(String var1) {
      this.background_color = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
