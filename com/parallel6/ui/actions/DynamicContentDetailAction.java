package com.parallel6.ui.actions;

import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public class DynamicContentDetailAction extends CRAction {
   private String detailStyle;

   public DynamicContentDetailAction(ControllerState var1) {
      super(var1);
   }

   public DynamicContentDetailAction(ControllerState var1, String var2) {
      super(var1);
      this.detailStyle = var2;
   }

   public void executeAction(Object var1) {
      this.activity.handleMessage(new CRMessage(-1412628472, new Object[]{var1, this.detailStyle}));
   }
}
