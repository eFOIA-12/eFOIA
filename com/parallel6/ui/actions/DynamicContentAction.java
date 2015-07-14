package com.parallel6.ui.actions;

import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.configurability.CaptiveReachUserInterfaceSDK;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public class DynamicContentAction extends CRAction {
   public DynamicContentAction(ControllerState var1) {
      super(var1);
   }

   public void executeAction(Object var1) {
      if(var1 instanceof MobileMenu) {
         MobileMenu var2 = (MobileMenu)var1;
         if(!CaptiveReachUserInterfaceSDK.getInstance().isUsingConfigurability()) {
            this.activity.handleMessage(new CRMessage(-1412628473, new Object[]{var2.getStringActionObject(), var2.getTitle()}));
            return;
         }

         this.activity.handleMessage(new CRMessage(-1412628462, new Object[]{CRActionFactory.getSafeAction(var2.getAction()), String.valueOf(var2.getId())}));
      }

   }
}
