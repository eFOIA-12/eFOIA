package com.parallel6.ui.configurability.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.ui.configurability.models.CRConfLayoutStyle;

public class CRConfLayoutSlot implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CRConfLayoutSlot createFromParcel(Parcel var1) {
         return null;
      }

      public CRConfLayoutSlot[] newArray(int var1) {
         return new CRConfLayoutSlot[0];
      }
   };
   @SerializedName("attribute_id")
   private String attributeKey;
   @SerializedName("default_value")
   private String defaultValue;
   @SerializedName("display_name")
   private String displayName;
   @SerializedName("slot_id")
   private String slotId;
   @SerializedName("style")
   private CRConfLayoutStyle style;

   public int describeContents() {
      return 0;
   }

   public String getAttributeKey() {
      return this.attributeKey;
   }

   public String getDefaultValue() {
      return this.defaultValue;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public String getSlotId() {
      return this.slotId;
   }

   public CRConfLayoutStyle getStyle() {
      return this.style;
   }

   public void setAttributeKey(String var1) {
      this.attributeKey = var1;
   }

   public void setDefaultValue(String var1) {
      this.defaultValue = var1;
   }

   public void setDisplayName(String var1) {
      this.displayName = var1;
   }

   public void setSlotId(String var1) {
      this.slotId = var1;
   }

   public void setStyle(CRConfLayoutStyle var1) {
      this.style = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
