package com.parallel6.ui.interfaces;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import com.parallel6.ui.actions.CRActionFactory;
import com.parallel6.ui.interfaces.CRMessage;

public interface ControllerState {
   CRActionFactory getActionFactory();

   View getBaseBackActionbarView(Context var1);

   boolean handleMessage(int var1);

   boolean handleMessage(CRMessage var1);

   void hideKeyboard();

   void showKeyboard(EditText var1);
}
