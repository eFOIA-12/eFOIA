package com.parallel6.ui.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.parallel6.ui.enums.CalendarEventTone;

public class CalendarEvent implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CalendarEvent createFromParcel(Parcel var1) {
         return null;
      }

      public CalendarEvent[] newArray(int var1) {
         return new CalendarEvent[var1];
      }
   };
   @SerializedName("appointment_date")
   private String appointmentDate;
   private String dateString;
   private CalendarEventTone eventTone;
   @SerializedName("id")
   private long id = -1L;
   private long index = -1L;
   @SerializedName("location")
   private String location;
   @SerializedName("millis")
   protected long millis;
   @SerializedName("notes")
   private String notes;
   @SerializedName("reminder_index")
   private int reminderInxex;
   @SerializedName("time")
   private String time;
   @SerializedName("type")
   private String type;

   public int describeContents() {
      return 0;
   }

   public CalendarEvent encryptModel() {
      return this;
   }

   public String getAppointmentDate() {
      return this.appointmentDate;
   }

   public CalendarEventTone getEventTone() {
      return this.eventTone;
   }

   public long getId() {
      return this.id;
   }

   public long getIndex() {
      return this.index;
   }

   public String getLocation() {
      return this.location;
   }

   public long getMillis() {
      return this.millis;
   }

   public String getNotes() {
      return this.notes;
   }

   public int getReminderIndex() {
      return this.reminderInxex;
   }

   public String getTime() {
      return this.time;
   }

   public String getType() {
      return this.type;
   }

   public void setAppointmentDate(String var1) {
      this.appointmentDate = var1;
   }

   public void setEventTone(CalendarEventTone var1) {
      this.eventTone = var1;
   }

   public void setId(long var1) {
      this.id = var1;
   }

   public void setInxex(long var1) {
      this.index = var1;
   }

   public void setLocation(String var1) {
      this.location = var1;
   }

   public void setMillis(long var1) {
      this.millis = var1;
   }

   public void setNotes(String var1) {
      this.notes = var1;
   }

   public void setReminderIndex(int var1) {
      this.reminderInxex = var1;
   }

   public void setTime(String var1) {
      this.time = var1;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
   }
}
