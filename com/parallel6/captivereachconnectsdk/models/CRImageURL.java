package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class CRImageURL implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRImageURL createFromParcel(Parcel var1) {
         String var3 = var1.readString();
         CRImageURL var2 = new CRImageURL();
         var2.setUrl(var3);
         return var2;
      }

      public CRImageURL[] newArray(int var1) {
         return new CRImageURL[var1];
      }
   };
   @SerializedName("url")
   private String url;

   public int describeContents() {
      return 0;
   }

   public boolean equals(CRImageURL var1) {
      return this.getUrl().equals(var1.getUrl());
   }

   public String getUrl() {
      return this.url;
   }

   public void setUrl(String var1) {
      this.url = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.url);
   }
}
