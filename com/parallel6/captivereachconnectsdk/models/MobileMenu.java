package com.parallel6.captivereachconnectsdk.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModelV1;
import com.parallel6.captivereachconnectsdk.models.json.response.ImageResponse;
import com.parallel6.ui.configurability.models.CRConfLayout;
import java.util.List;

public class MobileMenu extends CRModelV1 implements Parcelable {
   private static final Creator CREATOR = new Creator() {
      public MobileMenu createFromParcel(Parcel var1) {
         return null;
      }

      public MobileMenu[] newArray(int var1) {
         return new MobileMenu[var1];
      }
   };
   @SerializedName("action")
   private String action;
   @SerializedName("action_object")
   private Object actionObject;
   @SerializedName("featured")
   private boolean featured;
   @SerializedName("layout")
   private CRConfLayout layout;
   @SerializedName("subcategories")
   private List mobile_menu;
   @SerializedName("position")
   private int position;
   @SerializedName("slots")
   private List slotList;
   @SerializedName("tags")
   private List tags;

   public int describeContents() {
      return 0;
   }

   public boolean equals(MobileMenu var1) {
      return this.getTitle() != null && this.getDescription() != null && this.getAction() != null && this.getStringActionObject() != null && this.getImage() != null && this.getContent_type() != null && this.getId() == var1.getId() && this.getTitle().equals(var1.getTitle()) && this.getDescription().equals(var1.getDescription()) && this.getAction().equals(var1.getAction()) && this.getStringActionObject().equals(var1.getStringActionObject()) && this.getImage().equals(var1.getImage()) && this.getContent_type().equals(var1.getContent_type());
   }

   public String getAction() {
      return this.action;
   }

   public Object getActionObject() {
      return this.actionObject;
   }

   public String getDescription() {
      return this.description;
   }

   public long getId() {
      return this.id;
   }

   public ImageResponse getImage() {
      return this.image;
   }

   public CRConfLayout getLayout() {
      return this.layout;
   }

   public int getPosition() {
      return this.position;
   }

   public List getSlotList() {
      return this.slotList;
   }

   public String getStringActionObject() {
      return (String)this.actionObject;
   }

   public List getSubcategories() {
      return this.mobile_menu;
   }

   public List getTags() {
      return this.tags;
   }

   public String getTitle() {
      return this.title;
   }

   public boolean hasSubcategories() {
      return this.getSubcategories() != null && this.getSubcategories().size() > 0;
   }

   public boolean isFeatured() {
      return this.featured;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public void setActionObject(String var1) {
      this.actionObject = var1;
   }

   public void setDescription(String var1) {
      this.description = var1;
   }

   public void setFeatured(boolean var1) {
      this.featured = var1;
   }

   public void setId(long var1) {
      this.id = var1;
   }

   public void setImage(ImageResponse var1) {
      this.image = var1;
   }

   public void setLayoutId(CRConfLayout var1) {
      this.layout = var1;
   }

   public void setPosition(int var1) {
      this.position = var1;
   }

   public void setSlotList(List var1) {
      this.slotList = var1;
   }

   public void setSubcategories(List var1) {
      this.mobile_menu = var1;
   }

   public void setTags(List var1) {
      this.tags = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
   }
}
