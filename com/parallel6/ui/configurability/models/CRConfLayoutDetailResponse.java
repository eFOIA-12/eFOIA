package com.parallel6.ui.configurability.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CRConfLayoutDetailResponse {
   @SerializedName("modules")
   private List layoutModelList;

   public List getLayoutModelList() {
      return this.layoutModelList;
   }

   public void setLayoutModelList(List var1) {
      this.layoutModelList = var1;
   }
}
