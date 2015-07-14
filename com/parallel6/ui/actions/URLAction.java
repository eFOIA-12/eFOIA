package com.parallel6.ui.actions;

import android.content.Context;
import android.widget.Toast;
import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public class URLAction extends CRAction {
   public URLAction(ControllerState var1) {
      super(var1);
   }

   public void executeAction(Object var1) {
      if(var1 instanceof String) {
         if(!StringUtils.isNotEmpty((String)var1)) {
            Toast.makeText((Context)this.activity, "There is no content available", 0).show();
            return;
         }

         this.activity.handleMessage(new CRMessage(-1412628475, new Object[]{(String)var1}));
      } else if(var1 instanceof MobileMenu) {
         MobileMenu var2 = (MobileMenu)var1;
         if(StringUtils.isNotEmpty(var2.getStringActionObject())) {
            this.activity.handleMessage(new CRMessage(-1412628475, new Object[]{var2.getStringActionObject(), var2.getTitle()}));
            return;
         }

         Toast.makeText((Context)this.activity, "There is no content available", 0).show();
         return;
      }

   }
}
