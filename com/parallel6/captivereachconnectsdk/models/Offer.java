package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRLocation;
import com.parallel6.captivereachconnectsdk.models.CRModelV1;
import java.util.List;

public class Offer extends CRModelV1 implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public Offer createFromParcel(Parcel var1) {
         return null;
      }

      public Offer[] newArray(int var1) {
         return new Offer[var1];
      }
   };
   private static final String TAG = Offer.class.getSimpleName();
   @SerializedName("action")
   private int action;
   @SerializedName("action_object")
   private String actionObject;
   @SerializedName("created_at")
   private String createdAt;
   private boolean deleted;
   @SerializedName("gallery")
   private List gallery;
   @SerializedName("location")
   private CRLocation location;
   private boolean read;

   public int describeContents() {
      return 0;
   }

   public int getAction() {
      return this.action;
   }

   public String getActionObject() {
      return this.actionObject;
   }

   public String getCreatedAt() {
      return this.createdAt;
   }

   public List getGallery() {
      return this.gallery;
   }

   public CRLocation getLocation() {
      return this.location;
   }

   public boolean isDeleted() {
      return this.deleted;
   }

   public boolean isRead() {
      return this.read;
   }

   public void setAction(int var1) {
      this.action = var1;
   }

   public void setActionObject(String var1) {
      this.actionObject = var1;
   }

   public void setCreatedAt(String var1) {
      this.createdAt = var1;
   }

   public void setDeleted(boolean var1) {
      this.deleted = var1;
   }

   public void setGallery(List var1) {
      this.gallery = var1;
   }

   public void setLocation(CRLocation var1) {
      this.location = var1;
   }

   public void setRead(boolean var1) {
      this.read = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.createdAt);
      var1.writeList(this.gallery);
      var1.writeInt(this.action);
      var1.writeString(this.actionObject);
      var1.writeParcelable(this.location, var2);
   }
}
