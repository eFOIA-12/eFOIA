package com.parallel6.captivereachconnectsdk.network.http;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.parallel6.captivereachconnectsdk.network.http.CRUrl;

public class CRHttpRequest implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRHttpRequest createFromParcel(Parcel var1) {
         var1.readInt();
         var1.readString();
         var1.readString();
         var1.readString();
         return new CRHttpRequest();
      }

      public CRHttpRequest[] newArray(int var1) {
         return new CRHttpRequest[var1];
      }
   };
   private CRUrl url;

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
