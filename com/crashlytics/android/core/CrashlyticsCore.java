package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.core.BuildIdValidator;
import com.crashlytics.android.core.CrashTest;
import com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper;
import com.crashlytics.android.core.CrashlyticsListener;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler;
import com.crashlytics.android.core.CreateReportSpiCall;
import com.crashlytics.android.core.DefaultCreateReportSpiCall;
import com.crashlytics.android.core.DialogStringResolver;
import com.crashlytics.android.core.PinningInfoProvider;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.HttpsURLConnection;

@DependsOn({CrashEventDataProvider.class})
public class CrashlyticsCore extends Kit {
   static final float CLS_DEFAULT_PROCESS_DELAY = 1.0F;
   static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
   static final String COLLECT_CUSTOM_LOGS = "com.crashlytics.CollectCustomLogs";
   static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
   static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
   static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
   static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 4;
   private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
   static final int MAX_ATTRIBUTES = 64;
   static final int MAX_ATTRIBUTE_SIZE = 1024;
   private static final String PREF_ALWAYS_SEND_REPORTS_KEY = "always_send_reports_opt_in";
   private static final boolean SHOULD_PROMPT_BEFORE_SENDING_REPORTS_DEFAULT = false;
   public static final String TAG = "Fabric";
   private final ConcurrentHashMap attributes;
   private String buildId;
   private float delay;
   private boolean disabled;
   private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
   private CrashEventDataProvider externalCrashEventDataProvider;
   private CrashlyticsUncaughtExceptionHandler handler;
   private HttpRequestFactory httpRequestFactory;
   private File initializationMarkerFile;
   private String installerPackageName;
   private CrashlyticsListener listener;
   private String packageName;
   private final PinningInfoProvider pinningInfo;
   private final long startTime;
   private String userEmail;
   private String userId;
   private String userName;
   private String versionCode;
   private String versionName;

   public CrashlyticsCore() {
      this(1.0F, (CrashlyticsListener)null, (PinningInfoProvider)null, false);
   }

   CrashlyticsCore(float var1, CrashlyticsListener var2, PinningInfoProvider var3, boolean var4) {
      this(var1, var2, var3, var4, ExecutorUtils.buildSingleThreadExecutorService("Crashlytics Exception Handler"));
   }

   CrashlyticsCore(float var1, CrashlyticsListener var2, PinningInfoProvider var3, boolean var4, ExecutorService var5) {
      this.userId = null;
      this.userEmail = null;
      this.userName = null;
      this.attributes = new ConcurrentHashMap();
      this.startTime = System.currentTimeMillis();
      this.delay = var1;
      this.listener = var2;
      this.pinningInfo = var3;
      this.disabled = var4;
      this.executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(var5);
   }

   private int dipsToPixels(float var1, int var2) {
      return (int)((float)var2 * var1);
   }

   private void doLog(int var1, String var2, String var3) {
      if(!this.disabled && ensureFabricWithCalled("prior to logging messages.")) {
         long var4 = System.currentTimeMillis();
         long var6 = this.startTime;
         this.handler.writeToLog(var4 - var6, formatLogMessage(var1, var2, var3));
      }
   }

   private static boolean ensureFabricWithCalled(String var0) {
      CrashlyticsCore var1 = getInstance();
      if(var1 != null && var1.handler != null) {
         return true;
      } else {
         Fabric.getLogger().e("Fabric", "Crashlytics must be initialized by calling Fabric.with(Context) " + var0, (Throwable)null);
         return false;
      }
   }

   private void finishInitSynchronously() {
      PriorityCallable var1 = new PriorityCallable() {
         public Void call() throws Exception {
            return CrashlyticsCore.this.doInBackground();
         }

         public Priority getPriority() {
            return Priority.IMMEDIATE;
         }
      };
      Iterator var2 = this.getDependencies().iterator();

      while(var2.hasNext()) {
         var1.addDependency((Task)var2.next());
      }

      Future var6 = this.getFabric().getExecutorService().submit(var1);
      Fabric.getLogger().d("Fabric", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");

      try {
         var6.get(4L, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         Fabric.getLogger().e("Fabric", "Crashlytics was interrupted during initialization.", var3);
      } catch (ExecutionException var4) {
         Fabric.getLogger().e("Fabric", "Problem encountered during Crashlytics initialization.", var4);
      } catch (TimeoutException var5) {
         Fabric.getLogger().e("Fabric", "Crashlytics timed out during initialization.", var5);
      }
   }

   private static String formatLogMessage(int var0, String var1, String var2) {
      return CommonUtils.logPriorityToString(var0) + "/" + var1 + " " + var2;
   }

   public static CrashlyticsCore getInstance() {
      return (CrashlyticsCore)Fabric.getKit(CrashlyticsCore.class);
   }

   private boolean getSendDecisionFromUser(final Activity var1, final PromptSettingsData var2) {
      final DialogStringResolver var3 = new DialogStringResolver(var1, var2);
      final CrashlyticsCore.OptInLatch var4 = new CrashlyticsCore.OptInLatch(null);
      var1.runOnUiThread(new Runnable() {
         public void run() {
            android.app.AlertDialog.Builder var3x = new android.app.AlertDialog.Builder(var1);
            OnClickListener var4x = new OnClickListener() {
               public void onClick(DialogInterface var1x, int var2x) {
                  var4.setOptIn(true);
                  var1x.dismiss();
               }
            };
            float var1x = var1.getResources().getDisplayMetrics().density;
            int var2x = CrashlyticsCore.this.dipsToPixels(var1x, 5);
            TextView var5 = new TextView(var1);
            var5.setAutoLinkMask(15);
            var5.setText(var3.getMessage());
            var5.setTextAppearance(var1, 16973892);
            var5.setPadding(var2x, var2x, var2x, var2x);
            var5.setFocusable(false);
            ScrollView var6 = new ScrollView(var1);
            var6.setPadding(CrashlyticsCore.this.dipsToPixels(var1x, 14), CrashlyticsCore.this.dipsToPixels(var1x, 2), CrashlyticsCore.this.dipsToPixels(var1x, 10), CrashlyticsCore.this.dipsToPixels(var1x, 12));
            var6.addView(var5);
            var3x.setView(var6).setTitle(var3.getTitle()).setCancelable(false).setNeutralButton(var3.getSendButtonTitle(), var4x);
            if(var2.showCancelButton) {
               var4x = new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     var4.setOptIn(false);
                     var1x.dismiss();
                  }
               };
               var3x.setNegativeButton(var3.getCancelButtonTitle(), var4x);
            }

            if(var2.showAlwaysSendButton) {
               var4x = new OnClickListener() {
                  public void onClick(DialogInterface var1x, int var2x) {
                     CrashlyticsCore.this.setShouldSendUserReportsWithoutPrompting(true);
                     var4.setOptIn(true);
                     var1x.dismiss();
                  }
               };
               var3x.setPositiveButton(var3.getAlwaysSendButtonTitle(), var4x);
            }

            var3x.show();
         }
      });
      Fabric.getLogger().d("Fabric", "Waiting for user opt-in.");
      var4.await();
      return var4.getOptIn();
   }

   private boolean isRequiringBuildId(Context var1) {
      return CommonUtils.getBooleanResourceValue(var1, "com.crashlytics.RequireBuildId", true);
   }

   static void recordFatalExceptionEvent(String var0) {
      Answers var1 = (Answers)Fabric.getKit(Answers.class);
      if(var1 != null) {
         var1.onException(new Crash.FatalException(var0));
      }

   }

   static void recordLoggedExceptionEvent(String var0) {
      Answers var1 = (Answers)Fabric.getKit(Answers.class);
      if(var1 != null) {
         var1.onException(new Crash.LoggedException(var0));
      }

   }

   private static String sanitizeAttribute(String var0) {
      String var1 = var0;
      if(var0 != null) {
         var0 = var0.trim();
         var1 = var0;
         if(var0.length() > 1024) {
            var1 = var0.substring(0, 1024);
         }
      }

      return var1;
   }

   private void setAndValidateKitProperties(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   boolean canSendWithUserApproval() {
      return ((Boolean)Settings.getInstance().withSettings(new Settings.SettingsAccess() {
         public Boolean usingSettings(SettingsData var1) {
            boolean var3 = true;
            Activity var4 = CrashlyticsCore.this.getFabric().getCurrentActivity();
            boolean var2 = var3;
            if(var4 != null) {
               var2 = var3;
               if(!var4.isFinishing()) {
                  var2 = var3;
                  if(CrashlyticsCore.this.shouldPromptUserBeforeSendingCrashReports()) {
                     var2 = CrashlyticsCore.this.getSendDecisionFromUser(var4, var1.promptData);
                  }
               }
            }

            return Boolean.valueOf(var2);
         }
      }, Boolean.valueOf(true))).booleanValue();
   }

   public void crash() {
      (new CrashTest()).indexOutOfBounds();
   }

   boolean didPreviousInitializationComplete() {
      return ((Boolean)this.executorServiceWrapper.executeSyncLoggingException(new Callable() {
         public Boolean call() throws Exception {
            return Boolean.valueOf(CrashlyticsCore.this.initializationMarkerFile.exists());
         }
      })).booleanValue();
   }

   protected Void doInBackground() {
      // $FF: Couldn't be decompiled
   }

   Map getAttributes() {
      return Collections.unmodifiableMap(this.attributes);
   }

   String getBuildId() {
      return this.buildId;
   }

   BuildIdValidator getBuildIdValidator(String var1, boolean var2) {
      return new BuildIdValidator(var1, var2);
   }

   CreateReportSpiCall getCreateReportSpiCall(SettingsData var1) {
      return var1 != null?new DefaultCreateReportSpiCall(this, this.getOverridenSpiEndpoint(), var1.appData.reportsUrl, this.httpRequestFactory):null;
   }

   SessionEventData getExternalCrashEventData() {
      SessionEventData var1 = null;
      if(this.externalCrashEventDataProvider != null) {
         var1 = this.externalCrashEventDataProvider.getCrashEventData();
      }

      return var1;
   }

   CrashlyticsUncaughtExceptionHandler getHandler() {
      return this.handler;
   }

   public String getIdentifier() {
      return "com.crashlytics.sdk.android.crashlytics-core";
   }

   String getInstallerPackageName() {
      return this.installerPackageName;
   }

   String getOverridenSpiEndpoint() {
      return CommonUtils.getStringsFileValue(this.getContext(), "com.crashlytics.ApiEndpoint");
   }

   String getPackageName() {
      return this.packageName;
   }

   public PinningInfoProvider getPinningInfoProvider() {
      return !this.disabled?this.pinningInfo:null;
   }

   File getSdkDirectory() {
      return (new FileStoreImpl(this)).getFilesDir();
   }

   SessionSettingsData getSessionSettingsData() {
      SettingsData var1 = Settings.getInstance().awaitSettingsData();
      return var1 == null?null:var1.sessionData;
   }

   String getUserEmail() {
      return this.getIdManager().canCollectUserIds()?this.userEmail:null;
   }

   String getUserIdentifier() {
      return this.getIdManager().canCollectUserIds()?this.userId:null;
   }

   String getUserName() {
      return this.getIdManager().canCollectUserIds()?this.userName:null;
   }

   public String getVersion() {
      return "2.3.2.56";
   }

   String getVersionCode() {
      return this.versionCode;
   }

   String getVersionName() {
      return this.versionName;
   }

   boolean internalVerifyPinning(URL var1) {
      boolean var2 = false;
      if(this.getPinningInfoProvider() != null) {
         HttpRequest var3 = this.httpRequestFactory.buildHttpRequest(HttpMethod.GET, var1.toString());
         ((HttpsURLConnection)var3.getConnection()).setInstanceFollowRedirects(false);
         var3.code();
         var2 = true;
      }

      return var2;
   }

   public void log(int var1, String var2, String var3) {
      this.doLog(var1, var2, var3);
      Fabric.getLogger().log(var1, "" + var2, "" + var3, true);
   }

   public void log(String var1) {
      this.doLog(3, "Fabric", var1);
   }

   public void logException(Throwable var1) {
      if(!this.disabled && ensureFabricWithCalled("prior to logging exceptions.")) {
         if(var1 == null) {
            Fabric.getLogger().log(5, "Fabric", "Crashlytics is ignoring a request to log a null exception.");
         } else {
            this.handler.writeNonFatalException(Thread.currentThread(), var1);
         }
      }
   }

   void markInitializationComplete() {
      this.executorServiceWrapper.executeAsync(new Callable() {
         public Boolean call() throws Exception {
            boolean var1;
            try {
               var1 = CrashlyticsCore.this.initializationMarkerFile.delete();
               Fabric.getLogger().d("Fabric", "Initialization marker file removed: " + var1);
            } catch (Exception var3) {
               Fabric.getLogger().e("Fabric", "Problem encountered deleting Crashlytics initialization marker.", var3);
               return Boolean.valueOf(false);
            }

            return Boolean.valueOf(var1);
         }
      });
   }

   void markInitializationStarted() {
      this.executorServiceWrapper.executeSyncLoggingException(new Callable() {
         public Void call() throws Exception {
            CrashlyticsCore.this.initializationMarkerFile.createNewFile();
            Fabric.getLogger().d("Fabric", "Initialization marker file created.");
            return null;
         }
      });
   }

   protected boolean onPreExecute() {
      return this.onPreExecute(super.getContext());
   }

   boolean onPreExecute(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public void setBool(String var1, boolean var2) {
      this.setString(var1, Boolean.toString(var2));
   }

   public void setDouble(String var1, double var2) {
      this.setString(var1, Double.toString(var2));
   }

   void setExternalCrashEventDataProvider(CrashEventDataProvider var1) {
      this.externalCrashEventDataProvider = var1;
   }

   public void setFloat(String var1, float var2) {
      this.setString(var1, Float.toString(var2));
   }

   public void setInt(String var1, int var2) {
      this.setString(var1, Integer.toString(var2));
   }

   @Deprecated
   public void setListener(CrashlyticsListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void setLong(String var1, long var2) {
      this.setString(var1, Long.toString(var2));
   }

   @SuppressLint({"CommitPrefEdits"})
   void setShouldSendUserReportsWithoutPrompting(boolean var1) {
      PreferenceStoreImpl var2 = new PreferenceStoreImpl(this);
      var2.save(var2.edit().putBoolean("always_send_reports_opt_in", var1));
   }

   public void setString(String var1, String var2) {
      if(!this.disabled) {
         if(var1 == null) {
            if(this.getContext() != null && CommonUtils.isAppDebuggable(this.getContext())) {
               throw new IllegalArgumentException("Custom attribute key must not be null.");
            } else {
               Fabric.getLogger().e("Fabric", "Attempting to set custom attribute with null key, ignoring.", (Throwable)null);
            }
         } else {
            String var3 = sanitizeAttribute(var1);
            if(this.attributes.size() >= 64 && !this.attributes.containsKey(var3)) {
               Fabric.getLogger().d("Fabric", "Exceeded maximum number of custom attributes (64)");
            } else {
               if(var2 == null) {
                  var1 = "";
               } else {
                  var1 = sanitizeAttribute(var2);
               }

               this.attributes.put(var3, var1);
            }
         }
      }
   }

   public void setUserEmail(String var1) {
      if(!this.disabled) {
         this.userEmail = sanitizeAttribute(var1);
      }
   }

   public void setUserIdentifier(String var1) {
      if(!this.disabled) {
         this.userId = sanitizeAttribute(var1);
      }
   }

   public void setUserName(String var1) {
      if(!this.disabled) {
         this.userName = sanitizeAttribute(var1);
      }
   }

   boolean shouldPromptUserBeforeSendingCrashReports() {
      return ((Boolean)Settings.getInstance().withSettings(new Settings.SettingsAccess() {
         public Boolean usingSettings(SettingsData var1) {
            boolean var2 = false;
            if(var1.featuresData.promptEnabled) {
               if(!CrashlyticsCore.this.shouldSendReportsWithoutPrompting()) {
                  var2 = true;
               }

               return Boolean.valueOf(var2);
            } else {
               return Boolean.valueOf(false);
            }
         }
      }, Boolean.valueOf(false))).booleanValue();
   }

   boolean shouldSendReportsWithoutPrompting() {
      return (new PreferenceStoreImpl(this)).get().getBoolean("always_send_reports_opt_in", false);
   }

   public boolean verifyPinning(URL var1) {
      try {
         boolean var2 = this.internalVerifyPinning(var1);
         return var2;
      } catch (Exception var3) {
         Fabric.getLogger().e("Fabric", "Could not verify SSL pinning", var3);
         return false;
      }
   }

   public static class Builder {
      private float delay = -1.0F;
      private boolean disabled = false;
      private CrashlyticsListener listener;
      private PinningInfoProvider pinningInfoProvider;

      public CrashlyticsCore build() {
         if(this.delay < 0.0F) {
            this.delay = 1.0F;
         }

         return new CrashlyticsCore(this.delay, this.listener, this.pinningInfoProvider, this.disabled);
      }

      public CrashlyticsCore.Builder delay(float var1) {
         if(var1 <= 0.0F) {
            throw new IllegalArgumentException("delay must be greater than 0");
         } else if(this.delay > 0.0F) {
            throw new IllegalStateException("delay already set.");
         } else {
            this.delay = var1;
            return this;
         }
      }

      public CrashlyticsCore.Builder disabled(boolean var1) {
         this.disabled = var1;
         return this;
      }

      public CrashlyticsCore.Builder listener(CrashlyticsListener var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("listener must not be null.");
         } else if(this.listener != null) {
            throw new IllegalStateException("listener already set.");
         } else {
            this.listener = var1;
            return this;
         }
      }

      @Deprecated
      public CrashlyticsCore.Builder pinningInfo(PinningInfoProvider var1) {
         if(var1 == null) {
            throw new IllegalArgumentException("pinningInfoProvider must not be null.");
         } else if(this.pinningInfoProvider != null) {
            throw new IllegalStateException("pinningInfoProvider already set.");
         } else {
            this.pinningInfoProvider = var1;
            return this;
         }
      }
   }

   private class OptInLatch {
      private final CountDownLatch latch;
      private boolean send;

      private OptInLatch() {
         this.send = false;
         this.latch = new CountDownLatch(1);
      }

      // $FF: synthetic method
      OptInLatch(Object var2) {
         this();
      }

      void await() {
         try {
            this.latch.await();
         } catch (InterruptedException var2) {
            ;
         }
      }

      boolean getOptIn() {
         return this.send;
      }

      void setOptIn(boolean var1) {
         this.send = var1;
         this.latch.countDown();
      }
   }
}
