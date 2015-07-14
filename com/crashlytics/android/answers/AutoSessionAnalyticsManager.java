package com.crashlytics.android.answers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy;
import com.crashlytics.android.answers.SessionAnalyticsFilesManager;
import com.crashlytics.android.answers.SessionAnalyticsManager;
import com.crashlytics.android.answers.SessionEventMetadata;
import com.crashlytics.android.answers.SessionEventsHandler;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
class AutoSessionAnalyticsManager extends SessionAnalyticsManager {
   private static final String EXECUTOR_SERVICE = "Crashlytics Trace Manager";
   private final ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
      public void onActivityCreated(Activity var1, Bundle var2) {
         AutoSessionAnalyticsManager.this.onCreate(var1);
      }

      public void onActivityDestroyed(Activity var1) {
         AutoSessionAnalyticsManager.this.onDestroy(var1);
      }

      public void onActivityPaused(Activity var1) {
         AutoSessionAnalyticsManager.this.onPause(var1);
      }

      public void onActivityResumed(Activity var1) {
         AutoSessionAnalyticsManager.this.onResume(var1);
      }

      public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
         AutoSessionAnalyticsManager.this.onSaveInstanceState(var1);
      }

      public void onActivityStarted(Activity var1) {
         AutoSessionAnalyticsManager.this.onStart(var1);
      }

      public void onActivityStopped(Activity var1) {
         AutoSessionAnalyticsManager.this.onStop(var1);
      }
   };
   private final Application application;

   AutoSessionAnalyticsManager(SessionEventMetadata var1, SessionEventsHandler var2, Application var3) {
      super(var1, var2);
      this.application = var3;
      CommonUtils.logControlled(Answers.getInstance().getContext(), "Registering activity lifecycle callbacks for session analytics.");
      var3.registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
   }

   public static AutoSessionAnalyticsManager build(Application var0, SessionEventMetadata var1, SessionAnalyticsFilesManager var2, HttpRequestFactory var3) {
      ScheduledExecutorService var4 = ExecutorUtils.buildSingleThreadScheduledExecutorService("Crashlytics Trace Manager");
      return new AutoSessionAnalyticsManager(var1, new SessionEventsHandler(var0, new EnabledSessionAnalyticsManagerStrategy(var0, var4, var2, var3), var2, var4), var0);
   }

   public void disable() {
      CommonUtils.logControlled(Answers.getInstance().getContext(), "Unregistering activity lifecycle callbacks for session analytics");
      this.application.unregisterActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
      super.disable();
   }
}
