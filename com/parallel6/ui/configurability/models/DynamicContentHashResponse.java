package com.parallel6.ui.configurability.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import java.util.List;

public class DynamicContentHashResponse extends BaseJSon {
   @SerializedName("content")
   private List content;
   @SerializedName("total_pages")
   private int totalPages;

   public List getContent() {
      return this.content;
   }

   public int getTotalPages() {
      return this.totalPages;
   }

   public void setContent(List var1) {
      this.content = var1;
   }

   public void setTotalPages(int var1) {
      this.totalPages = var1;
   }
}
