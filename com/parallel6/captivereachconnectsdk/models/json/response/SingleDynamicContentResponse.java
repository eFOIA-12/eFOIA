package com.parallel6.captivereachconnectsdk.models.json.response;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;

public class SingleDynamicContentResponse extends BaseJSon {
   @SerializedName("content")
   Object content;

   public Object getContent() {
      return this.content;
   }

   public void setContent(Object var1) {
      this.content = var1;
   }
}
