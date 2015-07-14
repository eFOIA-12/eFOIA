package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.ey;

@ey
public class am implements ActivityLifecycleCallbacks {
   private Context mContext;
   private final Object mH = new Object();
   private Activity nB;

   public am(Application var1, Activity var2) {
      var1.registerActivityLifecycleCallbacks(this);
      this.setActivity(var2);
      this.mContext = var1.getApplicationContext();
   }

   private void setActivity(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   public Activity getActivity() {
      return this.nB;
   }

   public Context getContext() {
      return this.mContext;
   }

   public void onActivityCreated(Activity var1, Bundle var2) {
   }

   public void onActivityDestroyed(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   public void onActivityPaused(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivityResumed(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
   }

   public void onActivityStarted(Activity var1) {
      this.setActivity(var1);
   }

   public void onActivityStopped(Activity var1) {
   }
}
