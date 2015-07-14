package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy;
import com.crashlytics.android.answers.SessionAnalyticsFilesManager;
import com.crashlytics.android.answers.SessionEvent;
import com.crashlytics.android.answers.SessionEventMetadata;
import com.crashlytics.android.answers.SessionEventsHandler;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager {
   private static final String EXECUTOR_SERVICE = "Crashlytics SAM";
   static final String ON_CRASH_ERROR_MSG = "onCrash called from main thread!!!";
   boolean customEventsEnabled = true;
   final SessionEventsHandler eventsHandler;
   final SessionEventMetadata metadata;

   SessionAnalyticsManager(SessionEventMetadata var1, SessionEventsHandler var2) {
      this.metadata = var1;
      this.eventsHandler = var2;
   }

   public static SessionAnalyticsManager build(Context var0, SessionEventMetadata var1, SessionAnalyticsFilesManager var2, HttpRequestFactory var3) {
      ScheduledExecutorService var4 = ExecutorUtils.buildSingleThreadScheduledExecutorService("Crashlytics SAM");
      return new SessionAnalyticsManager(var1, new SessionEventsHandler(var0, new EnabledSessionAnalyticsManagerStrategy(var0, var4, var2, var3), var2, var4));
   }

   public void disable() {
      this.eventsHandler.disable();
   }

   public void onCrash(String var1) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("onCrash called from main thread!!!");
      } else {
         this.eventsHandler.recordEventSync(SessionEvent.buildCrashEvent(this.metadata, var1));
      }
   }

   public void onCreate(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.CREATE, var1), false);
   }

   public void onCustom(String var1, Map var2) {
      if(this.customEventsEnabled) {
         this.eventsHandler.recordEventAsync(SessionEvent.buildCustomEvent(this.metadata, var1, var2), false);
      }

   }

   public void onDestroy(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.DESTROY, var1), false);
   }

   public void onError(String var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildErrorEvent(this.metadata, var1), false);
   }

   public void onInstall() {
      this.eventsHandler.recordEventAsync(SessionEvent.buildInstallEvent(this.metadata), true);
   }

   public void onPause(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.PAUSE, var1), false);
   }

   public void onResume(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.RESUME, var1), false);
   }

   public void onSaveInstanceState(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.SAVE_INSTANCE_STATE, var1), false);
   }

   public void onStart(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.START, var1), false);
   }

   public void onStop(Activity var1) {
      this.eventsHandler.recordEventAsync(SessionEvent.buildActivityLifecycleEvent(this.metadata, SessionEvent.Type.STOP, var1), false);
   }

   public void setAnalyticsSettingsData(AnalyticsSettingsData var1, String var2) {
      this.customEventsEnabled = var1.trackCustomEvents;
      this.eventsHandler.setAnalyticsSettingsData(var1, var2);
   }
}
