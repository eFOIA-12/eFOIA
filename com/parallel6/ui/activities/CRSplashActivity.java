package com.parallel6.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelResponse;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.ui.activities.CRMainActivity;

public class CRSplashActivity extends Activity {
   protected static final long SPLASH_TIMEOUT = 2000L;
   public static Class mMainClass;
   protected ProgressBar mProgressBar;
   protected Handler mTimeoutHandler = new Handler();
   protected Runnable mTimerRunnable = new Runnable() {
      public void run() {
         CRSplashActivity.this.timerTask();
      }
   };
   private TaskListener signInListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         if(CRSplashActivity.this.mProgressBar != null) {
            CRSplashActivity.this.mProgressBar.setVisibility(8);
         }

      }

      public void onTaskSuccess(SignInModelResponse var1) {
         CRSplashActivity.this.timerTask();
      }

      public void onTaskTimeOut() {
         if(CRSplashActivity.this.mProgressBar != null) {
            CRSplashActivity.this.mProgressBar.setVisibility(8);
         }

      }
   };
   protected long startTime;

   protected String getGCMKey() {
      return "500243347037";
   }

   protected int getHeroScreenResource() {
      return R.drawable.hero_cr;
   }

   protected Class getMainClassActivity() {
      return CRMainActivity.class;
   }

   protected String getServerUrl() {
      return "http://sixappeal.captivereach.com/";
   }

   protected int getSplashLayoutResource() {
      return R.layout.activity_splash_screen;
   }

   protected void initApp() {
      if(this.mProgressBar != null) {
         this.mProgressBar.setVisibility(8);
      }

      CaptiveReachConnect.getInstance().trackInsightV2(this, "application", "open", (String)null, (String)null);
      this.startActivity(new Intent(this, mMainClass));
      this.finish();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.setContentView(this.getSplashLayoutResource());
      this.findViewById(R.id.activity_splash_iv_hero).setBackgroundResource(this.getHeroScreenResource());
      this.startTime = System.currentTimeMillis();
      mMainClass = this.getMainClassActivity();
      this.mProgressBar = (ProgressBar)this.findViewById(R.id.activity_splash_pb_loading);
      this.setupRequest();
   }

   protected void onPause() {
      super.onPause();
      this.mTimeoutHandler.removeCallbacks(this.mTimerRunnable);
   }

   protected void setupRequest() {
      CaptiveReachConnect.newInstance(this, this.getServerUrl(), this.getGCMKey(), (TaskListener)null).login(this, this.signInListener);
      CaptiveReachConnect.getInstance().getGCMToken(this);
      CaptiveReachConnect.getInstance().setTrackingEnabled(this.trackingEnabled());
   }

   protected void timerTask() {
      long var1 = System.currentTimeMillis() - this.startTime;
      if(var1 > 2000L) {
         this.initApp();
      } else {
         long var3 = 2000L - var1;
         var1 = var3;
         if(var3 < 0L) {
            var1 = 0L;
         }

         this.mTimeoutHandler.postDelayed(this.mTimerRunnable, var1);
      }
   }

   protected boolean trackingEnabled() {
      return true;
   }
}
