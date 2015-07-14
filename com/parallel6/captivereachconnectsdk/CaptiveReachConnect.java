package com.parallel6.captivereachconnectsdk;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.androidquery.callback.BitmapAjaxCallback;
import com.parallel6.captivereachconnectsdk.cache.CRDynamicContentDao;
import com.parallel6.captivereachconnectsdk.cache.CacheService;
import com.parallel6.captivereachconnectsdk.gcm.GcmListener;
import com.parallel6.captivereachconnectsdk.gcm.GcmRegister;
import com.parallel6.captivereachconnectsdk.models.Tracker;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelRequest;
import com.parallel6.captivereachconnectsdk.models.json.request.SignInModelResponse;
import com.parallel6.captivereachconnectsdk.models.json.request.SignUpModelRequest;
import com.parallel6.captivereachconnectsdk.models.login.MobileUser;
import com.parallel6.captivereachconnectsdk.models.login.Profile;
import com.parallel6.captivereachconnectsdk.network.PostDeviceRegistration;
import com.parallel6.captivereachconnectsdk.network.PostInsightTask;
import com.parallel6.captivereachconnectsdk.network.PutDeviceTask;
import com.parallel6.captivereachconnectsdk.network.http.CRUrl;
import com.parallel6.captivereachconnectsdk.network.login.GuestSignInTask;
import com.parallel6.captivereachconnectsdk.network.login.SignInTask;
import com.parallel6.captivereachconnectsdk.network.login.SignOutTask;
import com.parallel6.captivereachconnectsdk.network.login.SignUpTask;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.AsyncTask;
import com.parallel6.captivereachconnectsdk.utils.ConnectionUtils;
import com.parallel6.captivereachconnectsdk.utils.DeviceUtils;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class CaptiveReachConnect {
   private static final String LOG_TAG = CaptiveReachConnect.class.getSimpleName();
   private static CaptiveReachConnect connector;
   private static GcmListener gcmListener;
   private static TaskListener localRegisterListener;
   private CRUrl[] cacheUrls;
   private Context mContext;
   private TaskListener tokenListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
         if(CaptiveReachConnect.localRegisterListener != null) {
            CaptiveReachConnect.localRegisterListener.onTaskFailure(var1);
         }

         Log.e(CaptiveReachConnect.LOG_TAG, "Something went wrong try again later");
      }

      public void onTaskSuccess(SignInModelResponse var1) {
         if(var1.getStatus().equals("ok")) {
            Log.i(CaptiveReachConnect.LOG_TAG, "TOKEN " + var1.getAuth_token());
            SettingsUtils.setRegistrationToken(CaptiveReachConnect.this.mContext, var1.getAuth_token());
            if(CaptiveReachConnect.localRegisterListener != null) {
               CaptiveReachConnect.localRegisterListener.onTaskSuccess(var1);
            }

         } else {
            Log.i(CaptiveReachConnect.LOG_TAG, "Unable to retrieve token try again later " + var1.getMessage());
         }
      }

      public void onTaskTimeOut() {
         if(CaptiveReachConnect.localRegisterListener != null) {
            CaptiveReachConnect.localRegisterListener.onTaskTimeOut();
         }

         Log.e(CaptiveReachConnect.LOG_TAG, "Get token timeout");
      }
   };
   private boolean trackingEnabled;

   private CaptiveReachConnect() {
   }

   private CaptiveReachConnect(Context var1, String var2, String var3) {
      this.mContext = var1;
      SettingsUtils.setBaseUrl(var1, var2);
      SettingsUtils.setBaseRestUrl(var1, var2 + "api/");
      SettingsUtils.setGcmSenderId(var1, var3);
   }

   public static GcmListener getGcmListener() {
      return gcmListener;
   }

   public static CaptiveReachConnect getInstance() {
      if(connector == null) {
         connector = new CaptiveReachConnect();
      }

      return connector;
   }

   private static void initRegisterListener(TaskListener var0) {
      localRegisterListener = var0;
   }

   public static CaptiveReachConnect newInstance(Context var0, String var1, String var2, TaskListener var3) {
      initRegisterListener(var3);
      connector = new CaptiveReachConnect(var0, var1, var2);
      return connector;
   }

   @Deprecated
   public static void register(String var0, String var1, Context var2) {
      register(var0, var1, var2, (TaskListener)null);
   }

   @Deprecated
   public static void register(String var0, String var1, Context var2, TaskListener var3) {
      register(var0, var1, var2, var3, (GcmListener)null);
   }

   @Deprecated
   public static void register(String var0, String var1, Context var2, TaskListener var3, GcmListener var4) {
      gcmListener = var4;
      initRegisterListener(var3);
      connector = new CaptiveReachConnect(var2, var0, var1);
      connector.getGCMToken(var2);
      connector.getCRToken(var2, false);
   }

   public static void setGcmListener(GcmListener var0) {
      gcmListener = var0;
   }

   public void clearCache(Context var1) {
      this.mContext = var1;
      if(this.mContext != null) {
         (new CRDynamicContentDao(this.mContext)).clearDatabase();
         BitmapAjaxCallback.clearCache();
      }

   }

   public void getCRToken(Context var1) {
      this.mContext = var1;
      this.getCRToken(var1, true);
   }

   public void getCRToken(Context var1, boolean var2) {
      if(StringUtils.isNotEmpty(SettingsUtils.getRegistrationToken(var1))) {
         if(localRegisterListener != null) {
            SignInModelResponse var3 = new SignInModelResponse();
            var3.setStatus("ok");
            var3.setAuth_token(SettingsUtils.getRegistrationToken(var1));
            localRegisterListener.onTaskSuccess(new SignInModelResponse());
         }

         localRegisterListener = null;
      }

      if(var2) {
         (new GuestSignInTask(var1, this.tokenListener)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } else {
         (new PostDeviceRegistration(var1, new TaskListener() {
            public void onTaskCancelled() {
               CaptiveReachConnect.this.tokenListener.onTaskCancelled();
            }

            public void onTaskFailure(Exception var1) {
               CaptiveReachConnect.this.tokenListener.onTaskFailure(var1);
            }

            public void onTaskSuccess(String var1) {
               SignInModelResponse var2 = new SignInModelResponse();
               var2.setStatus("ok");
               var2.setAuth_token(var1);
               CaptiveReachConnect.this.tokenListener.onTaskSuccess(var2);
            }

            public void onTaskTimeOut() {
               CaptiveReachConnect.this.tokenListener.onTaskTimeOut();
            }
         })).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
   }

   public void getGCMToken(Context var1) {
      this.mContext = var1;
      if(StringUtils.isNotEmpty(SettingsUtils.getGcmSenderId(this.mContext))) {
         (new GcmRegister(var1, new TaskListener() {
            public void onTaskCancelled() {
            }

            public void onTaskFailure(Exception var1) {
               Log.e(CaptiveReachConnect.LOG_TAG, "GCMToken: Error retrieving gcm token: " + var1.getMessage());
            }

            public void onTaskSuccess(String var1) {
               if(StringUtils.isNotEmpty(SettingsUtils.getRegistrationToken(CaptiveReachConnect.this.mContext))) {
                  (new PutDeviceTask(CaptiveReachConnect.this.mContext)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
               }

            }

            public void onTaskTimeOut() {
               Log.e(CaptiveReachConnect.LOG_TAG, "GCMToken: GCM Token timeout");
            }
         })).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }

   }

   public boolean isTrackingEnabled() {
      return this.trackingEnabled;
   }

   public void login(Context var1) {
      this.login(var1, (TaskListener)null);
   }

   public void login(Context var1, TaskListener var2) {
      this.login(var1, (String)null, (String)null, var2);
   }

   public void login(Context var1, String var2, String var3, TaskListener var4) {
      this.mContext = var1;
      initRegisterListener(var4);
      if(var2 != null && var3 != null) {
         SignInModelRequest var5 = new SignInModelRequest();
         var5.setDevice(DeviceUtils.getDevice(this.mContext));
         var5.setMobile_user(new MobileUser(var2, var3));
         (new SignInTask(this.mContext, "", new TaskListener() {
            public void onTaskCancelled() {
               if(CaptiveReachConnect.localRegisterListener != null) {
                  CaptiveReachConnect.localRegisterListener.onTaskCancelled();
               }

            }

            public void onTaskFailure(Exception var1) {
               if(CaptiveReachConnect.localRegisterListener != null) {
                  CaptiveReachConnect.localRegisterListener.onTaskFailure(var1);
               }

            }

            public void onTaskSuccess(SignInModelResponse var1) {
               if(var1.getStatus().equals("ok")) {
                  SettingsUtils.setRegistrationToken(CaptiveReachConnect.this.mContext, var1.getAuth_token());
                  if(CaptiveReachConnect.localRegisterListener != null) {
                     CaptiveReachConnect.localRegisterListener.onTaskSuccess(var1);
                  }
               } else if(CaptiveReachConnect.localRegisterListener != null) {
                  CaptiveReachConnect.localRegisterListener.onTaskFailure(new Exception(var1.getMessage()));
                  return;
               }

            }

            public void onTaskTimeOut() {
               if(CaptiveReachConnect.localRegisterListener != null) {
                  CaptiveReachConnect.localRegisterListener.onTaskTimeOut();
               }

            }
         }, var5)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      } else {
         this.getCRToken(var1);
      }
   }

   public void logout(Context var1) {
      this.logout(var1, (TaskListener)null);
   }

   public void logout(Context var1, final TaskListener var2) {
      new SignOutTask(var1, (String)null, new TaskListener() {
         public void onTaskCancelled() {
            if(var2 != null) {
               var2.onTaskCancelled();
            }

         }

         public void onTaskFailure(Exception var1) {
            if(var2 != null) {
               var2.onTaskFailure(var1);
            }

         }

         public void onTaskSuccess(String var1) {
            if(var2 != null) {
               var2.onTaskSuccess(var1);
            }

         }

         public void onTaskTimeOut() {
            if(var2 != null) {
               var2.onTaskTimeOut();
            }

         }
      });
   }

   public void setCacheExpiration(int var1) {
      SettingsUtils.getSettingsEditor(this.mContext).putString("1", String.valueOf(var1));
   }

   public void setTrackingEnabled(boolean var1) {
      this.trackingEnabled = var1;
   }

   public void setWebCacheEnabled(boolean var1) {
      SettingsUtils.setWebCacheEnable(this.mContext, Boolean.valueOf(var1));
   }

   public void signup(Context var1, String var2, String var3, Profile var4, final TaskListener var5) {
      this.mContext = var1;
      SignUpModelRequest var6 = new SignUpModelRequest();
      var6.setDevice(DeviceUtils.getDevice(this.mContext));
      var6.setProfile(var4);
      if(var2 != null && var3 != null) {
         var6.setMobile_user(new MobileUser(var2, var3));
      }

      (new SignUpTask(this.mContext, "", new TaskListener() {
         public void onTaskCancelled() {
            if(var5 != null) {
               var5.onTaskCancelled();
            }

         }

         public void onTaskFailure(Exception var1) {
            if(var5 != null) {
               var5.onTaskFailure(var1);
            }

         }

         public void onTaskSuccess(SignInModelResponse var1) {
            if(var1.getStatus().equals("ok")) {
               SettingsUtils.setRegistrationToken(CaptiveReachConnect.this.mContext, var1.getAuth_token());
               if(var5 != null) {
                  var5.onTaskSuccess(var1);
               }
            } else if(var5 != null) {
               var5.onTaskFailure(new Exception(var1.getMessage()));
               return;
            }

         }

         public void onTaskTimeOut() {
            if(var5 != null) {
               var5.onTaskTimeOut();
            }

         }
      }, var6)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
   }

   public void startCache(Context var1) {
      this.startCache(var1, this.cacheUrls);
   }

   public void startCache(Context var1, CRUrl[] var2) {
      this.mContext = var1;
      if(this.mContext != null) {
         SettingsUtils.setCacheEnable(this.mContext, Boolean.valueOf(true));
         if(ConnectionUtils.isNetworkActive(this.mContext) && !SettingsUtils.isCacheRunning(this.mContext).booleanValue()) {
            SettingsUtils.setCacheRunning(this.mContext, Boolean.valueOf(true));
            this.cacheUrls = var2;
            Intent var3 = new Intent(this.mContext, CacheService.class);
            var3.putExtra("permanent_links", var2);
            this.mContext.startService(var3);
         }
      }

   }

   public void stopCache(Context var1) {
      this.mContext = var1;
      if(this.mContext != null) {
         Intent var2 = new Intent(this.mContext, CacheService.class);
         this.mContext.stopService(var2);
      }

   }

   @Deprecated
   public void trackActionV2(Context var1, String var2, String var3, Map var4) {
      this.mContext = var1;
      Tracker var5 = new Tracker();
      var5.setSection(var2);
      var5.setAction(var3);
      var5.setLatitude(SettingsUtils.getLat(this.mContext));
      var5.setLongitude(SettingsUtils.getLng(this.mContext));
      var5.setTriggered_at((new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)).format(new Date()));
      if(var4 != null) {
         var5.setOptions(var4);
      }

      (new PostInsightTask(this.mContext, var5)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
   }

   public void trackInsightV2(Context var1, String var2, String var3, String var4, String var5) {
      this.trackInsightV2(var1, var2, var3, var4, (String)null, var5);
   }

   public void trackInsightV2(Context var1, String var2, String var3, String var4, String var5, String var6) {
      this.mContext = var1;
      if(this.isTrackingEnabled()) {
         Tracker var7 = new Tracker();
         var7.setValue(var4);
         var7.setSection(var2);
         var7.setBrandId(var5);
         var7.setAction(var3);
         var7.setTriggered_at((new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)).format(new Date()));
         var7.setLatitude(SettingsUtils.getLat(this.mContext));
         var7.setLongitude(SettingsUtils.getLng(this.mContext));
         var7.setLabel(var6);
         (new PostInsightTask(this.mContext, var7)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }

   }
}
