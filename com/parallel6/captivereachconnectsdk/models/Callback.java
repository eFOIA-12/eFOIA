package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Callback implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public Callback createFromParcel(Parcel var1) {
         Callback var2 = new Callback();
         var2.setAction(var1.readString());
         var2.setAction_object(var1.readString());
         var2.setAction_owner_id(Integer.valueOf(var1.readInt()));
         var2.setAction_owner_type(var1.readString());
         var2.setAction_subject_id(Integer.valueOf(var1.readInt()));
         var2.setAction_subject_type(var1.readString());
         var2.setCallback_type(var1.readString());
         var2.setCreated_at(var1.readString());
         var2.setId(Integer.valueOf(var1.readInt()));
         var2.setTrigger(var1.readString());
         var2.setUpdated_at(var1.readString());
         var2.setConditionList(var1.readArrayList(ClassLoader.getSystemClassLoader()));
         return var2;
      }

      public Callback[] newArray(int var1) {
         return new Callback[var1];
      }
   };
   @SerializedName("action")
   protected String action;
   @SerializedName("action_object")
   protected String action_object;
   @SerializedName("action_owner_id")
   protected Integer action_owner_id;
   @SerializedName("action_owner_type")
   protected String action_owner_type;
   @SerializedName("action_subject_id")
   protected Integer action_subject_id;
   @SerializedName("action_subject_type")
   protected String action_subject_type;
   @SerializedName("callback_type")
   protected String callback_type;
   @SerializedName("conditions")
   protected List conditionList;
   @SerializedName("created_at")
   protected String created_at;
   @SerializedName("id")
   protected Integer id;
   @SerializedName("trigger")
   protected String trigger;
   @SerializedName("updated_at")
   protected String updated_at;

   public int describeContents() {
      return 0;
   }

   public String getAction() {
      return this.action;
   }

   public String getAction_object() {
      return this.action_object;
   }

   public Integer getAction_owner_id() {
      return this.action_owner_id;
   }

   public String getAction_owner_type() {
      return this.action_owner_type;
   }

   public Integer getAction_subject_id() {
      return this.action_subject_id;
   }

   public String getAction_subject_type() {
      return this.action_subject_type;
   }

   public String getCallback_type() {
      return this.callback_type;
   }

   public List getConditionList() {
      return this.conditionList;
   }

   public String getCreated_at() {
      return this.created_at;
   }

   public Integer getId() {
      return this.id;
   }

   public String getTrigger() {
      return this.trigger;
   }

   public String getUpdated_at() {
      return this.updated_at;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public void setAction_object(String var1) {
      this.action_object = var1;
   }

   public void setAction_owner_id(Integer var1) {
      this.action_owner_id = var1;
   }

   public void setAction_owner_type(String var1) {
      this.action_owner_type = var1;
   }

   public void setAction_subject_id(Integer var1) {
      this.action_subject_id = var1;
   }

   public void setAction_subject_type(String var1) {
      this.action_subject_type = var1;
   }

   public void setCallback_type(String var1) {
      this.callback_type = var1;
   }

   public void setConditionList(List var1) {
      this.conditionList = var1;
   }

   public void setCreated_at(String var1) {
      this.created_at = var1;
   }

   public void setId(Integer var1) {
      this.id = var1;
   }

   public void setTrigger(String var1) {
      this.trigger = var1;
   }

   public void setUpdated_at(String var1) {
      this.updated_at = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = -1;
      var1.writeString(this.action);
      var1.writeString(this.action_object);
      if(this.action_owner_id == null) {
         var2 = -1;
      } else {
         var2 = this.action_owner_id.intValue();
      }

      var1.writeInt(var2);
      var1.writeString(this.action_owner_type);
      if(this.action_subject_id == null) {
         var2 = -1;
      } else {
         var2 = this.action_subject_id.intValue();
      }

      var1.writeInt(var2);
      var1.writeString(this.action_subject_type);
      var1.writeString(this.callback_type);
      var1.writeString(this.created_at);
      if(this.id == null) {
         var2 = var3;
      } else {
         var2 = this.id.intValue();
      }

      var1.writeInt(var2);
      var1.writeString(this.trigger);
      var1.writeString(this.updated_at);
      var1.writeList(this.conditionList);
   }
}
