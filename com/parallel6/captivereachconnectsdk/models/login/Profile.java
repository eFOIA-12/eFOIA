package com.parallel6.captivereachconnectsdk.models.login;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.login.Avatar;
import java.util.HashMap;

public class Profile {
   @SerializedName("age")
   protected Integer age;
   @SerializedName("avatar")
   protected Avatar avatar;
   @SerializedName("custom_attributes")
   protected HashMap customAttributes;
   @SerializedName("email")
   protected String email;
   @SerializedName("ethnicity")
   protected String ethnicity;
   @SerializedName("first_name")
   protected String first_name;
   @SerializedName("gender")
   protected String gender;
   @SerializedName("language")
   protected String language;
   @SerializedName("last_name")
   protected String last_name;
   @SerializedName("occupation")
   protected String occupation;
   @SerializedName("phone")
   protected String phone;
   @SerializedName("remove_avatar")
   protected boolean remove_avatar;
   @SerializedName("username")
   protected String username;
   @SerializedName("zip_code")
   protected String zip_code;

   public Integer getAge() {
      return this.age;
   }

   public Avatar getAvatar() {
      return this.avatar;
   }

   public HashMap getCustomAttributes() {
      return this.customAttributes;
   }

   public String getEmail() {
      return this.email;
   }

   public String getEthnicity() {
      return this.ethnicity;
   }

   public String getFirst_name() {
      return this.first_name;
   }

   public String getGender() {
      return this.gender;
   }

   public String getLanguage() {
      return this.language;
   }

   public String getLast_name() {
      return this.last_name;
   }

   public String getOccupation() {
      return this.occupation;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getUsername() {
      return this.username;
   }

   public String getZip_code() {
      return this.zip_code;
   }

   public boolean isRemove_avatar() {
      return this.remove_avatar;
   }

   public void setAge(Integer var1) {
      this.age = var1;
   }

   public void setAvatar(String var1, String var2) {
      if(this.avatar == null) {
         this.avatar = new Avatar();
      }

      this.avatar.setFileName(var1);
      this.avatar.setFileData(var2);
   }

   public void setCustomAttributes(HashMap var1) {
      this.customAttributes = var1;
   }

   public void setEmail(String var1) {
      this.email = var1;
   }

   public void setEthnicity(String var1) {
      this.ethnicity = var1;
   }

   public void setFirst_name(String var1) {
      this.first_name = var1;
   }

   public void setGender(String var1) {
      this.gender = var1;
   }

   public void setLanguage(String var1) {
      this.language = var1;
   }

   public void setLast_name(String var1) {
      this.last_name = var1;
   }

   public void setOccupation(String var1) {
      this.occupation = var1;
   }

   public void setPhone(String var1) {
      this.phone = var1;
   }

   public void setRemove_avatar(boolean var1) {
      this.remove_avatar = var1;
   }

   public void setUsername(String var1) {
      this.username = var1;
   }

   public void setZip_code(String var1) {
      this.zip_code = var1;
   }
}
