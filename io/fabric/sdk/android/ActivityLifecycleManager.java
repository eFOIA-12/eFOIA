package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Build.VERSION;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ActivityLifecycleManager {
   private final Application application;
   private ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper callbacksWrapper;

   public ActivityLifecycleManager(Context var1) {
      this.application = (Application)var1.getApplicationContext();
      if(VERSION.SDK_INT >= 14) {
         this.callbacksWrapper = new ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper(this.application);
      }

   }

   public boolean registerCallbacks(ActivityLifecycleManager.Callbacks var1) {
      return this.callbacksWrapper != null && this.callbacksWrapper.registerLifecycleCallbacks(var1);
   }

   public void resetCallbacks() {
      if(this.callbacksWrapper != null) {
         this.callbacksWrapper.clearCallbacks();
      }

   }

   private static class ActivityLifecycleCallbacksWrapper {
      private final Application application;
      private final Set registeredCallbacks = new HashSet();

      ActivityLifecycleCallbacksWrapper(Application var1) {
         this.application = var1;
      }

      @TargetApi(14)
      private void clearCallbacks() {
         Iterator var1 = this.registeredCallbacks.iterator();

         while(var1.hasNext()) {
            ActivityLifecycleCallbacks var2 = (ActivityLifecycleCallbacks)var1.next();
            this.application.unregisterActivityLifecycleCallbacks(var2);
         }

      }

      @TargetApi(14)
      private boolean registerLifecycleCallbacks(final ActivityLifecycleManager.Callbacks var1) {
         if(this.application != null) {
            ActivityLifecycleCallbacks var2 = new ActivityLifecycleCallbacks() {
               public void onActivityCreated(Activity var1x, Bundle var2) {
                  var1.onActivityCreated(var1x, var2);
               }

               public void onActivityDestroyed(Activity var1x) {
                  var1.onActivityDestroyed(var1x);
               }

               public void onActivityPaused(Activity var1x) {
                  var1.onActivityPaused(var1x);
               }

               public void onActivityResumed(Activity var1x) {
                  var1.onActivityResumed(var1x);
               }

               public void onActivitySaveInstanceState(Activity var1x, Bundle var2) {
                  var1.onActivitySaveInstanceState(var1x, var2);
               }

               public void onActivityStarted(Activity var1x) {
                  var1.onActivityStarted(var1x);
               }

               public void onActivityStopped(Activity var1x) {
                  var1.onActivityStopped(var1x);
               }
            };
            this.application.registerActivityLifecycleCallbacks(var2);
            this.registeredCallbacks.add(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   public abstract static class Callbacks {
      public void onActivityCreated(Activity var1, Bundle var2) {
      }

      public void onActivityDestroyed(Activity var1) {
      }

      public void onActivityPaused(Activity var1) {
      }

      public void onActivityResumed(Activity var1) {
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
      }

      public void onActivityStarted(Activity var1) {
      }

      public void onActivityStopped(Activity var1) {
      }
   }
}
