package com.parallel6.ui.actions;

import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public class SubcategoryAction extends CRAction {
   public SubcategoryAction(ControllerState var1) {
      super(var1);
   }

   public void executeAction(Object var1) {
      this.activity.handleMessage(new CRMessage(-1412628469, new Object[]{var1}));
   }
}
