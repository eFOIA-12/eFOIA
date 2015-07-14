package gov.dhs.mobile.efoia.datastructures;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Submission implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public Submission createFromParcel(Parcel var1) {
         boolean var3 = true;
         Submission var4 = new Submission();
         var4.setComponent(var1.readString());
         var4.setTitle(var1.readString());
         var4.setFirstName(var1.readString());
         var4.setMiddleInitial(var1.readString());
         var4.setLastName(var1.readString());
         var4.setSuffix(var1.readString());
         var4.setEmailAddress(var1.readString());
         var4.setCountry(var1.readString());
         var4.setAddressLine1(var1.readString());
         var4.setAddressLine2(var1.readString());
         var4.setState(var1.readString());
         var4.setCity(var1.readString());
         var4.setZipCode(var1.readString());
         var4.setTelephone(var1.readString());
         var4.setFax(var1.readString());
         boolean var2;
         if(var1.readByte() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4.setRecordsForSelf(var2);
         if(var1.readByte() != 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         var4.setDeclaration(var2);
         var4.setInitials(var1.readString());
         var4.setRecordsDescription(var1.readString());
         var4.setPayAmount(var1.readString());
         var4.setRequestCategory(var1.readString());
         if(var1.readByte() != 0) {
            var2 = var3;
         } else {
            var2 = false;
         }

         var4.setRequestFeeWaiver(var2);
         var4.setFeeWaiverDescription(var1.readString());
         var4.setExpediteRequested(var1.readString());
         var4.setExpediteRequested(var1.readString());
         var4.setDrupalFormID(var1.readString());
         return var4;
      }

      public Submission[] newArray(int var1) {
         return new Submission[var1];
      }
   };
   private String addressLine1 = "";
   private String addressLine2 = "";
   private String city = "";
   private String component = "";
   private String country = "";
   private Boolean declaration = Boolean.valueOf(false);
   private String drupalFormID = "";
   private String emailAddress = "";
   private String expediteRequested = "";
   private String expediteRequestedDescription = "";
   private String fax = "";
   private String feeWaiverDescription = "";
   private String firstName = "";
   private String initials = "";
   private String lastName = "";
   private String middleInitial = "";
   private String payAmount = "";
   private String recordsDescription = "";
   private Boolean recordsForSelf = Boolean.valueOf(false);
   private String requestCategory = "";
   private Boolean requestFeeWaiver = Boolean.valueOf(false);
   private String state = "";
   private String suffix = "";
   private String telephone = "";
   private String title = "";
   private String zipCode = "";

   public int describeContents() {
      return 8675309;
   }

   public String getAddressLine1() {
      return this.addressLine1;
   }

   public String getAddressLine2() {
      return this.addressLine2;
   }

   public String getCity() {
      return this.city;
   }

   public String getComponent() {
      return this.component;
   }

   public String getCountry() {
      return this.country;
   }

   public boolean getDeclaration() {
      return this.declaration.booleanValue();
   }

   public String getDrupalFormID() {
      return this.drupalFormID;
   }

   public String getEmailAddress() {
      return this.emailAddress;
   }

   public String getExpediteRequested() {
      return this.expediteRequested;
   }

   public String getExpediteRequestedDescription() {
      return this.expediteRequestedDescription;
   }

   public String getFax() {
      return this.fax;
   }

   public String getFeeWaiverDescription() {
      return this.feeWaiverDescription;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public String getInitials() {
      return this.initials;
   }

   public String getLastName() {
      return this.lastName;
   }

   public String getMiddleInitial() {
      return this.middleInitial;
   }

   public String getPayAmount() {
      return this.payAmount;
   }

   public String getRecordsDescription() {
      return this.recordsDescription;
   }

   public boolean getRecordsForSelf() {
      return this.recordsForSelf.booleanValue();
   }

   public String getRequestCategory() {
      return this.requestCategory;
   }

   public boolean getRequestFeeWaiver() {
      return this.requestFeeWaiver.booleanValue();
   }

   public String getState() {
      return this.state;
   }

   public String getSuffix() {
      return this.suffix;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public String getTitle() {
      return this.title;
   }

   public String getZipCode() {
      return this.zipCode;
   }

   public String serializeSubmission(String var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[dhs_component]\"\r\n\r\n" + this.component);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[title]\"\r\n\r\n" + this.title);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[first_name]\"\r\n\r\n" + this.firstName);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[middle_initial]\"\r\n\r\n" + this.middleInitial);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[last_name]\"\r\n\r\n" + this.lastName);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[suffix]\"\r\n\r\n" + this.suffix);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[email_address]\"\r\n\r\n" + this.emailAddress);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[country]\"\r\n\r\n" + this.country);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[address_1]\"\r\n\r\n" + this.addressLine1);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[address_2]\"\r\n\r\n" + this.addressLine2);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[city]\"\r\n\r\n" + this.city);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[state]\"\r\n\r\n" + this.state);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[zip_code]\"\r\n\r\n" + this.zipCode);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[telephone_number]\"\r\n\r\n" + this.telephone);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[fax_number]\"\r\n\r\n" + this.fax);
      var3.append("\r\n--" + var1 + "\r\n");
      String var2 = "No ";
      if(this.recordsForSelf.booleanValue()) {
         var2 = "Yes ";
      }

      var3.append("Content-Disposition: form-data; name=\"submitted[records_request_self]\"\r\n\r\n" + var2);
      var3.append("\r\n--" + var1 + "\r\n");
      var2 = "";
      if(this.declaration.booleanValue()) {
         var2 = "Yes ";
      }

      var3.append("Content-Disposition: form-data; name=\"submitted[perjury_statement]\"\r\n\r\n" + var2);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[electronic_signature]\"\r\n\r\n" + this.initials);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[amount_willing_to_pay]\"\r\n\r\n" + this.payAmount);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[requester_category]\"\r\n\r\n" + this.requestCategory);
      var3.append("\r\n--" + var1 + "\r\n");
      var2 = "";
      if(this.declaration.booleanValue()) {
         var2 = "fee waiver request ";
      }

      var3.append("Content-Disposition: form-data; name=\"submitted[fee_waiver_request]\"\r\n\r\n" + var2);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[fee_waiver_explanation]\"\r\n\r\n" + this.feeWaiverDescription);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[expedite_selection]\"\r\n\r\n" + this.expediteRequested);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"submitted[additional_expedite_information]\"\r\n\r\n" + this.expediteRequestedDescription);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"details[sid]\"");
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"details[page_num]\"\r\n\r\n1");
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"details[page_count]\"\r\n\r\n1");
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"details[finished]\"\r\n\r\n0");
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"form_build_id\"\r\n\r\n" + this.drupalFormID);
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"form_id\"\r\n\r\nwebform_client_form_11359");
      var3.append("\r\n--" + var1 + "\r\n");
      var3.append("Content-Disposition: form-data; name=\"op\"\r\n\r\nSubmit FOIA Request");
      var3.append("\r\n--" + var1 + "\r\n");
      return var3.toString();
   }

   public void setAddressLine1(String var1) {
      this.addressLine1 = var1;
   }

   public void setAddressLine2(String var1) {
      this.addressLine2 = var1;
   }

   public void setCity(String var1) {
      this.city = var1;
   }

   public void setComponent(String var1) {
      this.component = var1;
   }

   public void setCountry(String var1) {
      this.country = var1;
   }

   public void setDeclaration(boolean var1) {
      this.declaration = Boolean.valueOf(var1);
   }

   public void setDrupalFormID(String var1) {
      this.drupalFormID = var1;
   }

   public void setEmailAddress(String var1) {
      this.emailAddress = var1;
   }

   public void setExpediteRequested(String var1) {
      this.expediteRequested = var1;
   }

   public void setExpediteRequestedDescription(String var1) {
      this.expediteRequestedDescription = var1;
   }

   public void setFax(String var1) {
      this.fax = var1;
   }

   public void setFeeWaiverDescription(String var1) {
      this.feeWaiverDescription = var1;
   }

   public void setFirstName(String var1) {
      this.firstName = var1;
   }

   public void setInitials(String var1) {
      this.initials = var1;
   }

   public void setLastName(String var1) {
      this.lastName = var1;
   }

   public void setMiddleInitial(String var1) {
      this.middleInitial = var1;
   }

   public void setPayAmount(String var1) {
      this.payAmount = var1;
   }

   public void setRecordsDescription(String var1) {
      this.recordsDescription = var1;
   }

   public void setRecordsForSelf(boolean var1) {
      this.recordsForSelf = Boolean.valueOf(var1);
   }

   public void setRequestCategory(String var1) {
      this.requestCategory = var1;
   }

   public void setRequestFeeWaiver(boolean var1) {
      this.requestFeeWaiver = Boolean.valueOf(var1);
   }

   public void setState(String var1) {
      this.state = var1;
   }

   public void setSuffix(String var1) {
      this.suffix = var1;
   }

   public void setTelephone(String var1) {
      this.telephone = var1;
   }

   public void setTitle(String var1) {
      this.title = var1;
   }

   public void setZipCode(String var1) {
      this.zipCode = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      var1.writeString(this.component);
      var1.writeString(this.title);
      var1.writeString(this.firstName);
      var1.writeString(this.middleInitial);
      var1.writeString(this.lastName);
      var1.writeString(this.suffix);
      var1.writeString(this.emailAddress);
      var1.writeString(this.country);
      var1.writeString(this.addressLine1);
      var1.writeString(this.addressLine2);
      var1.writeString(this.state);
      var1.writeString(this.city);
      var1.writeString(this.zipCode);
      var1.writeString(this.telephone);
      var1.writeString(this.fax);
      byte var4;
      if(this.recordsForSelf.booleanValue()) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeByte((byte)var4);
      if(this.declaration.booleanValue()) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      var1.writeByte((byte)var4);
      var1.writeString(this.initials);
      var1.writeString(this.recordsDescription);
      var1.writeString(this.payAmount);
      var1.writeString(this.requestCategory);
      if(this.requestFeeWaiver.booleanValue()) {
         var4 = var3;
      } else {
         var4 = 0;
      }

      var1.writeByte((byte)var4);
      var1.writeString(this.feeWaiverDescription);
      var1.writeString(this.expediteRequested);
      var1.writeString(this.expediteRequestedDescription);
      var1.writeString(this.drupalFormID);
   }
}
