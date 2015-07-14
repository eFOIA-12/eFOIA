package com.parallel6.captivereachconnectsdk.models.json.response;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import java.util.List;

public class ModulesResponse extends BaseJSon {
   @SerializedName("modules")
   private List modules;

   public List getModules() {
      return this.modules;
   }

   public void setModules(List var1) {
      this.modules = var1;
   }
}
