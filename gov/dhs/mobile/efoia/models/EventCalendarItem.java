package gov.dhs.mobile.efoia.models;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.Brand;
import com.parallel6.captivereachconnectsdk.models.CRImage;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class EventCalendarItem extends CRModel {
   public static final Creator CREATOR = new Creator() {
      public EventCalendarItem createFromParcel(Parcel var1) {
         EventCalendarItem var2 = new EventCalendarItem();
         var2.setId(var1.readLong());
         var2.setTitle(var1.readString());
         var2.setDescription(var1.readString());
         var2.setContent_type(var1.readString());
         var2.setImage((CRImage)var1.readParcelable(CRImage.class.getClassLoader()));
         var2.setBrand((Brand)var1.readParcelable(Brand.class.getClassLoader()));
         var2.setEvent_date(var1.readString());
         var2.setLocation(var1.readString());
         var2.setDetails(var1.readString());
         return var2;
      }

      public EventCalendarItem[] newArray(int var1) {
         return new EventCalendarItem[var1];
      }
   };
   @SerializedName("details")
   private String details;
   @SerializedName("event_date")
   private String event_date;
   @SerializedName("location")
   private String location;

   public EventCalendarItem() {
   }

   public EventCalendarItem(long var1, String var3, String var4, CRImage var5, String var6, String var7) {
      super(var1, var3, var4, var5);
      this.event_date = var6;
      this.location = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String getDetails() {
      return this.details;
   }

   public String getEvent_date() {
      return this.event_date;
   }

   public String getLocation() {
      return this.location;
   }

   public void setDetails(String var1) {
      this.details = var1;
   }

   public void setEvent_date(String var1) {
      this.event_date = var1;
   }

   public void setLocation(String var1) {
      this.location = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.event_date);
      var1.writeString(this.location);
      var1.writeString(this.details);
   }
}
