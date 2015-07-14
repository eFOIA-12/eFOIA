package com.parallel6.ui.utils;

import com.parallel6.captivereachconnectsdk.models.MobileMenu;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.interfaces.ControllerState;
import com.parallel6.ui.models.NotificationTriggerResponse;

public class NotificationUtils {
   public static void executeNotificationTriggerExtras(ControllerState var0, NotificationTriggerResponse var1, CRActionFactory var2) {
      Action var3;
      try {
         var3 = Action.valueOf(var1.getNotificationCallback().getAction().toUpperCase());
      } catch (Exception var4) {
         var3 = Action.NO_ACTION;
      }

      if(var3 == Action.DYNAMIC_CONTENTS) {
         if(var1.getNotificationCallback().getAction_subject_id() != null && var1.getNotificationCallback().getAction_subject_id().intValue() != -1) {
            var2.executeAction(Action.DYNAMIC_CONTENT_DETAIL, var1.getNotificationCallback().getAction_subject_id(), var0, (String)var1.getNotificationCallback().getAction_object().toUpperCase());
         } else {
            MobileMenu var5 = new MobileMenu();
            var5.setAction(Action.DYNAMIC_CONTENTS.toString());
            var5.setActionObject(var1.getNotificationCallback().getAction_object());
            var2.executeAction(Action.DYNAMIC_CONTENTS, var5, var0);
         }
      } else {
         var2.executeAction(var3, var1.getNotificationCallback().getAction_object(), var0);
      }
   }
}
