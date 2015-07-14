package com.parallel6.captivereachconnectsdk.models.json.response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRImage;

public class ImageResponse implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public ImageResponse createFromParcel(Parcel var1) {
         CRImage var3 = (CRImage)var1.readParcelable(CRImage.class.getClassLoader());
         ImageResponse var2 = new ImageResponse();
         var2.setCRImage(var3);
         return var2;
      }

      public ImageResponse[] newArray(int var1) {
         return new ImageResponse[var1];
      }
   };
   @SerializedName("image")
   private CRImage CRImage;

   public int describeContents() {
      return 0;
   }

   public boolean equals(ImageResponse var1) {
      return this.getCRImage().equals(var1.getCRImage());
   }

   public CRImage getCRImage() {
      return this.CRImage;
   }

   public void setCRImage(CRImage var1) {
      this.CRImage = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeParcelable(this.CRImage, var2);
   }
}
