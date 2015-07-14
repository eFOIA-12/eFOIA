package com.parallel6.ui.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.parallel6.ui.enums.ScreenOrientation;
import com.parallel6.ui.interfaces.CRMessage;
import com.parallel6.ui.interfaces.ControllerState;

public abstract class CRActivity extends Activity implements ControllerState {
   public abstract boolean handleMessage(int var1);

   public abstract boolean handleMessage(CRMessage var1);

   public void hideKeyboard() {
      if(this.getCurrentFocus() != null) {
         ((InputMethodManager)this.getSystemService("input_method")).hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   public void setScreenOrientationForActivity(ScreenOrientation var1) {
      byte var2;
      switch(null.$SwitchMap$com$parallel6$ui$enums$ScreenOrientation[var1.ordinal()]) {
      case 1:
         var2 = 1;
         break;
      case 2:
         var2 = 0;
         break;
      case 3:
         var2 = -1;
         break;
      default:
         var2 = 1;
      }

      this.setRequestedOrientation(var2);
   }

   public void showKeyboard(final EditText var1) {
      if(var1 != null) {
         var1.requestFocus();
         if(var1.hasFocus()) {
            var1.postDelayed(new Runnable() {
               public void run() {
                  ((InputMethodManager)CRActivity.this.getSystemService("input_method")).showSoftInput(var1, 0);
               }
            }, 200L);
            return;
         }
      }

   }
}
