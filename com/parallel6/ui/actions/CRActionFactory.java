package com.parallel6.ui.actions;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import com.parallel6.ui.actions.CRAction;
import com.parallel6.ui.actions.CalendarAction;
import com.parallel6.ui.actions.DynamicContentAction;
import com.parallel6.ui.actions.DynamicContentDetailAction;
import com.parallel6.ui.actions.HomeAction;
import com.parallel6.ui.actions.InAppAlertsAction;
import com.parallel6.ui.actions.ProfileAction;
import com.parallel6.ui.actions.ShareAction;
import com.parallel6.ui.actions.SubcategoryAction;
import com.parallel6.ui.actions.SurveysAction;
import com.parallel6.ui.actions.URLAction;
import com.parallel6.ui.actions.UndefinedAction;
import com.parallel6.ui.configurability.CaptiveReachUserInterfaceSDK;
import com.parallel6.ui.configurability.fragments.undefined.CRUndefinedFragment;
import com.parallel6.ui.enums.Action;
import com.parallel6.ui.interfaces.ControllerState;
import com.parallel6.ui.interfaces.FragmentState;

public class CRActionFactory {
   protected static CRActionFactory factory;

   public static FragmentState getContentFragment(Context var0, Action var1, String var2, Bundle var3) {
      Class var6 = CaptiveReachUserInterfaceSDK.getInstance().getActionPermanentLinkClass(var1, var2);
      if(var6 == null) {
         return (FragmentState)Fragment.instantiate(var0, CRUndefinedFragment.class.getName(), var3);
      } else {
         try {
            FragmentState var5 = (FragmentState)Fragment.instantiate(var0, var6.getName(), var3);
            return var5;
         } catch (Exception var4) {
            throw new RuntimeException("Fragment must implement FragmentState interface");
         }
      }
   }

   public static CRActionFactory getInstance() {
      if(factory == null) {
         factory = new CRActionFactory();
      }

      return factory;
   }

   public static Action getSafeAction(String var0) {
      try {
         Action var2 = Action.valueOf(var0.toUpperCase().replace(" ", "_"));
         return var2;
      } catch (Exception var1) {
         return Action.NO_ACTION;
      }
   }

   public void executeAction(Action var1, Object var2, ControllerState var3) {
      this.executeAction(var1, var2, var3, (Context)null, (String)null);
   }

   public void executeAction(Action var1, Object var2, ControllerState var3, Context var4) {
      this.executeAction(var1, var2, var3, var4, (String)null);
   }

   public void executeAction(Action var1, Object var2, ControllerState var3, Context var4, String var5) {
      Object var6;
      switch(null.$SwitchMap$com$parallel6$ui$enums$Action[var1.ordinal()]) {
      case 1:
         var6 = new HomeAction(var3);
         break;
      case 2:
         var6 = new ProfileAction(var3);
         break;
      case 3:
         var6 = new SubcategoryAction(var3);
         break;
      case 4:
         var6 = new URLAction(var3);
         break;
      case 5:
      case 6:
         var6 = new DynamicContentAction(var3);
         break;
      case 7:
         var6 = new DynamicContentDetailAction(var3, var5);
         break;
      case 8:
         var6 = new CalendarAction(var3);
         break;
      case 9:
         var6 = new SurveysAction(var3);
         break;
      case 10:
         var6 = new InAppAlertsAction(var3);
         break;
      case 11:
         var6 = new ShareAction(var3);
         break;
      case 12:
         return;
      default:
         var6 = new UndefinedAction(var3);
      }

      ((CRAction)var6).executeAction(var2);
   }

   public void executeAction(Action var1, Object var2, ControllerState var3, String var4) {
      this.executeAction(var1, var2, var3, (Context)null, var4);
   }
}
