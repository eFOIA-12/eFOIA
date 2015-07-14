package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;

public class Member {
   @SerializedName("age")
   private String age;
   @SerializedName("city")
   private String city;
   @SerializedName("email")
   private String email;
   @SerializedName("first_name")
   private String firstName;
   @SerializedName("last_name")
   private String lastName;
   @SerializedName("state")
   private String state;

   public String getAge() {
      return this.age;
   }

   public String getCity() {
      return this.city;
   }

   public String getEmail() {
      return this.email;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getState() {
      return this.state;
   }

   public void setAge(String var1) {
      this.age = var1;
   }

   public void setCity(String var1) {
      this.city = var1;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setFirstName(String var1) {
      this.firstName = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setState(String var1) {
      this.state = var1;
   }
}
