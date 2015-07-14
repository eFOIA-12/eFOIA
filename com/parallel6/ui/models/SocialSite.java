package com.parallel6.ui.models;

import com.google.gson.annotations.SerializedName;
import com.parallel6.captivereachconnectsdk.models.CRModel;

public class SocialSite extends CRModel {
   @SerializedName("action")
   private SocialSite.ActionModel actionModel;

   public SocialSite.ActionModel getActionModel() {
      return this.actionModel;
   }

   public void setActionModel(SocialSite.ActionModel var1) {
      this.actionModel = var1;
   }

   public class ActionModel {
      @SerializedName("action")
      private String action;
      @SerializedName("action_object")
      private String actionObject;

      public String getAction() {
         return this.action;
      }

      public String getActionObject() {
         return this.actionObject;
      }

      public void setAction(String var1) {
         this.action = var1;
      }

      public void setActionObject(String var1) {
         this.actionObject = var1;
      }
   }
}
