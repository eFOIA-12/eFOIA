package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ha implements Parcelable {
   @Deprecated
   public static final Creator CREATOR = new Creator() {
      @Deprecated
      public ha[] I(int var1) {
         return new ha[var1];
      }

      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.k(var1);
      }

      @Deprecated
      public ha k(Parcel var1) {
         return new ha(var1);
      }

      // $FF: synthetic method
      public Object[] newArray(int var1) {
         return this.I(var1);
      }
   };
   private String CE;
   private String CF;
   private String mValue;

   @Deprecated
   public ha() {
   }

   @Deprecated
   ha(Parcel var1) {
      this.readFromParcel(var1);
   }

   public ha(String var1, String var2, String var3) {
      this.CE = var1;
      this.CF = var2;
      this.mValue = var3;
   }

   @Deprecated
   private void readFromParcel(Parcel var1) {
      this.CE = var1.readString();
      this.CF = var1.readString();
      this.mValue = var1.readString();
   }

   @Deprecated
   public int describeContents() {
      return 0;
   }

   public String getId() {
      return this.CE;
   }

   public String getValue() {
      return this.mValue;
   }

   @Deprecated
   public void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.CE);
      var1.writeString(this.CF);
      var1.writeString(this.mValue);
   }
}
