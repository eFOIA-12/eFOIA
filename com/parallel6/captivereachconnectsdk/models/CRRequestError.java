package com.parallel6.captivereachconnectsdk.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;

public class CRRequestError extends BaseJSon {
   @SerializedName("error_message")
   private String errorMessage;
   @SerializedName("friendly_error")
   private String friendlyError;
   @SerializedName("internal_code")
   private String internalCode;
   @SerializedName("more_info")
   private String moreInfo;

   public String getErrorMessage() {
      return this.errorMessage;
   }

   public String getFriendlyError() {
      return this.friendlyError;
   }

   public String getInternalCode() {
      return this.internalCode;
   }

   public String getMoreInfo() {
      return this.moreInfo;
   }

   public void setErrorMessage(String var1) {
      this.errorMessage = var1;
   }

   public void setFriendlyError(String var1) {
      this.friendlyError = var1;
   }

   public void setInternalCode(String var1) {
      this.internalCode = var1;
   }

   public void setMoreInfo(String var1) {
      this.moreInfo = var1;
   }
}
