package com.parallel6.captivereachconnectsdk.models.json.response;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.json.BaseJSon;
import java.util.List;

public class MobileMenuResponse extends BaseJSon {
   @SerializedName("mobile_menus")
   private List mobile_menu;

   public List getMobileMenus() {
      return this.mobile_menu;
   }

   public void setMobileMenu(List var1) {
      this.mobile_menu = var1;
   }
}
