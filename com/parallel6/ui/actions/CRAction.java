package com.parallel6.ui.actions;

import android.content.Context;
import com.parallel6.ui.interfaces.ControllerState;

public abstract class CRAction {
   protected ControllerState activity;
   protected Context context;

   protected CRAction(Context var1) {
      this.context = var1;
   }

   protected CRAction(ControllerState var1) {
      this.activity = var1;
   }

   public abstract void executeAction(Object var1);
}
