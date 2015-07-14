package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class CRLocation implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public CRLocation createFromParcel(Parcel var1) {
         return null;
      }

      public CRLocation[] newArray(int var1) {
         return new CRLocation[var1];
      }
   };
   @SerializedName("address")
   private String mAddress;
   @SerializedName("latitude")
   private double mLatitude;
   @SerializedName("longitude")
   private double mLongitude;

   public CRLocation() {
   }

   public CRLocation(double var1, double var3) {
      this(var1, var3, "");
   }

   public CRLocation(double var1, double var3, String var5) {
      this.mLatitude = var1;
      this.mLongitude = var3;
      this.mAddress = var5;
   }

   public CRLocation(Parcel var1) {
      this.readFromParcel(var1);
   }

   public int describeContents() {
      return 0;
   }

   public String getAddress() {
      return this.mAddress;
   }

   public double getLat() {
      return this.mLatitude;
   }

   public double getLon() {
      return this.mLongitude;
   }

   public void readFromParcel(Parcel var1) {
      this.mLongitude = var1.readDouble();
      this.mLatitude = var1.readDouble();
      this.mAddress = var1.readString();
   }

   public void setAddress(String var1) {
      this.mAddress = var1;
   }

   public void setLat(double var1) {
      this.mLatitude = var1;
   }

   public void setLon(double var1) {
      this.mLongitude = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeDouble(this.mLongitude);
      var1.writeDouble(this.mLatitude);
      var1.writeString(this.mAddress);
   }
}
