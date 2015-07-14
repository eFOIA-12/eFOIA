package com.parallel6.ui.configurability.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.ui.configurability.models.CRConfLayout;
import java.util.List;

public class CRConfLayoutModule implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRConfLayoutModule createFromParcel(Parcel var1) {
         return null;
      }

      public CRConfLayoutModule[] newArray(int var1) {
         return new CRConfLayoutModule[0];
      }
   };
   @SerializedName("layout")
   private CRConfLayout layout;
   @SerializedName("slots")
   private List layoutSlots;
   @SerializedName("permanent_link")
   private String permanentLink;

   public int describeContents() {
      return 0;
   }

   public CRConfLayout getLayout() {
      return this.layout;
   }

   public List getLayoutSlots() {
      return this.layoutSlots;
   }

   public String getPermanentLink() {
      return this.permanentLink;
   }

   public void setLayout(CRConfLayout var1) {
      this.layout = var1;
   }

   public void setLayoutSlots(List var1) {
      this.layoutSlots = var1;
   }

   public void setPermanentLink(String var1) {
      this.permanentLink = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
