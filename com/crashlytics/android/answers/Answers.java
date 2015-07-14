package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import com.crashlytics.android.answers.EventAttributes;
import com.crashlytics.android.answers.SessionAnalyticsManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import java.io.File;

public class Answers extends Kit {
   static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
   static final long FIRST_LAUNCH_INTERVAL_IN_MS = 3600000L;
   static final String PREFKEY_ANALYTICS_LAUNCHED = "analytics_launched";
   static final String SESSION_ANALYTICS_FILE_EXTENSION = ".tap";
   static final String SESSION_ANALYTICS_FILE_NAME = "session_analytics.tap";
   private static final String SESSION_ANALYTICS_TO_SEND_DIR = "session_analytics_to_send";
   public static final String TAG = "Answers";
   private long installedAt;
   private PreferenceStore preferenceStore;
   SessionAnalyticsManager sessionAnalyticsManager;
   private String versionCode;
   private String versionName;

   public static Answers getInstance() {
      return (Answers)Fabric.getKit(Answers.class);
   }

   @SuppressLint({"CommitPrefEdits"})
   @TargetApi(14)
   private void initializeSessionAnalytics(Context param1) {
      // $FF: Couldn't be decompiled
   }

   protected Boolean doInBackground() {
      // $FF: Couldn't be decompiled
   }

   boolean getAnalyticsLaunched() {
      return this.preferenceStore.get().getBoolean("analytics_launched", false);
   }

   public String getIdentifier() {
      return "com.crashlytics.sdk.android:answers";
   }

   String getOverridenSpiEndpoint() {
      return CommonUtils.getStringsFileValue(this.getContext(), "com.crashlytics.ApiEndpoint");
   }

   File getSdkDirectory() {
      return (new FileStoreImpl(this)).getFilesDir();
   }

   public String getVersion() {
      return "1.2.2.56";
   }

   boolean installedRecently(long var1) {
      return System.currentTimeMillis() - var1 < 3600000L;
   }

   boolean isFirstLaunch(long var1) {
      return !this.getAnalyticsLaunched() && this.installedRecently(var1);
   }

   public void logEvent(String var1) {
      this.logEvent(var1, new EventAttributes());
   }

   public void logEvent(String var1, EventAttributes var2) {
      if(var1 == null) {
         throw new NullPointerException("eventName must not be null");
      } else if(var2 == null) {
         throw new NullPointerException("attributes must not be null");
      } else {
         if(this.sessionAnalyticsManager != null) {
            this.sessionAnalyticsManager.onCustom(var1, var2.attributes);
         }

      }
   }

   public void onException(Crash.FatalException var1) {
      if(this.sessionAnalyticsManager != null) {
         this.sessionAnalyticsManager.onCrash(var1.getSessionId());
      }

   }

   public void onException(Crash.LoggedException var1) {
      if(this.sessionAnalyticsManager != null) {
         this.sessionAnalyticsManager.onError(var1.getSessionId());
      }

   }

   @SuppressLint({"NewApi"})
   protected boolean onPreExecute() {
      // $FF: Couldn't be decompiled
   }
}
