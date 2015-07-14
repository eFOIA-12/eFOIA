package com.parallel6.ui.interfaces;

import com.parallel6.ui.enums.ScreenOrientation;
import com.parallel6.ui.interfaces.CRMessage;

public interface FragmentState {
   ScreenOrientation getScreenOrientation();

   boolean goToHome();

   boolean handleMessage(int var1);

   boolean handleMessage(CRMessage var1);

   boolean hasActionBar();

   void initTopActionBar();

   boolean onBack();

   void onRefresh();
}
