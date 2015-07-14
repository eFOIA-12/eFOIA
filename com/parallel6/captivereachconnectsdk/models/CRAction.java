package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;

public class CRAction implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public CRAction createFromParcel(Parcel var1) {
         return null;
      }

      public CRAction[] newArray(int var1) {
         return new CRAction[var1];
      }
   };
   @SerializedName("action")
   private String action;
   @SerializedName("action_object")
   private String action_object;

   public int describeContents() {
      return 0;
   }

   public String getAction() {
      return this.action;
   }

   public String getAction_object() {
      return this.action_object;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public void setAction_object(String var1) {
      this.action_object = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.action);
      var1.writeString(this.action_object);
   }
}
