package com.parallel6.captivereachconnectsdk.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CacheUrl implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public CacheUrl createFromParcel(Parcel var1) {
         int var2 = var1.readInt();
         String var3 = var1.readString();
         String var4 = var1.readString();
         String var6 = var1.readString();
         CacheUrl var5 = new CacheUrl();
         var5.setId(var2);
         var5.setPath(var3);
         var5.setJson(var4);
         var5.setHttpMethod(var6);
         return var5;
      }

      public CacheUrl[] newArray(int var1) {
         return new CacheUrl[var1];
      }
   };
   private String httpMethod;
   private int id;
   private String json;
   private String path;

   public CacheUrl() {
   }

   public CacheUrl(int var1, String var2, String var3, String var4) {
      this.id = var1;
      this.path = var2;
      this.json = var3;
      this.httpMethod = var4;
   }

   public CacheUrl(String var1, String var2) {
      this.path = var1;
      this.json = var2;
   }

   public int describeContents() {
      return 0;
   }

   public String getHttpMethod() {
      return this.httpMethod;
   }

   public int getId() {
      return this.id;
   }

   public String getJson() {
      return this.json;
   }

   public String getPath() {
      return this.path;
   }

   public void setHttpMethod(String var1) {
      this.httpMethod = var1;
   }

   public void setId(int var1) {
      this.id = var1;
   }

   public void setJson(String var1) {
      this.json = var1;
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeInt(this.id);
      var1.writeString(this.path);
      var1.writeString(this.json);
      var1.writeString(this.httpMethod);
   }
}
