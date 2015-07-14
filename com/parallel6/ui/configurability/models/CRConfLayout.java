package com.parallel6.ui.configurability.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.ui.configurability.models.CRLayoutPropertyModel;

public class CRConfLayout implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRConfLayout createFromParcel(Parcel var1) {
         return null;
      }

      public CRConfLayout[] newArray(int var1) {
         return new CRConfLayout[0];
      }
   };
   @SerializedName("layout_id")
   private String layout_id;
   @SerializedName("properties")
   private CRLayoutPropertyModel propertyModel;

   public int describeContents() {
      return 0;
   }

   public String getLayoutID() {
      return this.layout_id;
   }

   public CRLayoutPropertyModel getPropertyModel() {
      return this.propertyModel;
   }

   public void setLayoutID(String var1) {
      this.layout_id = var1;
   }

   public void setPropertyModel(CRLayoutPropertyModel var1) {
      this.propertyModel = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
