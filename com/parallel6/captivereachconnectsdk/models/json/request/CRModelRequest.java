package com.parallel6.captivereachconnectsdk.models.json.request;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class CRModelRequest {
   @SerializedName("content")
   private CRModel content;

   public CRModel getContent() {
      return this.content;
   }

   public void setContent(CRModel var1) {
      this.content = var1;
   }
}
