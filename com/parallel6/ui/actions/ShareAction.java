package com.parallel6.ui.actions;

import com.google.gson.internal.LinkedTreeMap;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public class ShareAction extends CRAction {
   public ShareAction(ControllerState var1) {
      super(var1);
   }

   public void executeAction(Object var1) {
      if(var1 instanceof MobileMenu && ((MobileMenu)var1).getActionObject() instanceof LinkedTreeMap) {
         LinkedTreeMap var2 = (LinkedTreeMap)((MobileMenu)var1).getActionObject();
         this.activity.handleMessage(new CRMessage(-1412628466, new Object[]{var2.get("subject"), var2.get("message")}));
      }

   }
}
