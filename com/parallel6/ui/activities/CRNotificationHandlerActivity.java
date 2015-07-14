package com.parallel6.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.parallel6.ui.activities.CRMainActivity;
import com.parallel6.ui.activities.CRSplashActivity;

public class CRNotificationHandlerActivity extends Activity {
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(!CRMainActivity.isIsActive()) {
         this.startActivity(new Intent(this, CRSplashActivity.mMainClass));
      }

      this.finish();
   }
}
