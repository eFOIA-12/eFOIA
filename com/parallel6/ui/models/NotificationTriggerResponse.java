package com.parallel6.ui.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Callback;

public class NotificationTriggerResponse implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public NotificationTriggerResponse createFromParcel(Parcel var1) {
         return new NotificationTriggerResponse(var1);
      }

      public NotificationTriggerResponse[] newArray(int var1) {
         return new NotificationTriggerResponse[var1];
      }
   };
   @SerializedName("message")
   private String message;
   @SerializedName("callback")
   private Callback notificationCallback;
   @SerializedName("type")
   private String notificationType;
   @SerializedName("title")
   private String title;

   public NotificationTriggerResponse() {
   }

   public NotificationTriggerResponse(Parcel var1) {
      this.message = var1.readString();
      this.title = var1.readString();
      this.notificationType = var1.readString();
      this.notificationCallback = (Callback)var1.readParcelable(Callback.class.getClassLoader());
   }

   public int describeContents() {
      return 0;
   }

   public String getMessage() {
      return this.message;
   }

   public Callback getNotificationCallback() {
      return this.notificationCallback;
   }

   public String getNotificationType() {
      return this.notificationType;
   }

   public String getTitle() {
      return this.title;
   }

   public void setMessage(String var1) {
      this.message = var1;
   }

   public void setNotificationCallback(Callback var1) {
      this.notificationCallback = var1;
   }

   public void setNotificationType(String var1) {
      this.notificationType = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.message);
      var1.writeString(this.title);
      var1.writeString(this.notificationType);
      var1.writeParcelable(this.notificationCallback, var2);
   }
}
