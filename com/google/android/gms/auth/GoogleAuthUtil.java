package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.auth.UserRecoverableNotifiedException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.r;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public final class GoogleAuthUtil {
   public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
   public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
   public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
   public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
   private static final ComponentName Ek;
   private static final ComponentName El;
   private static final Intent Em;
   private static final Intent En;
   public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
   public static final String KEY_ANDROID_PACKAGE_NAME;
   public static final String KEY_CALLER_UID;
   public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
   @Deprecated
   public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
   public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

   static {
      if(VERSION.SDK_INT >= 11) {
         ;
      }

      KEY_CALLER_UID = "callerUid";
      if(VERSION.SDK_INT >= 14) {
         ;
      }

      KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
      Ek = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      El = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      Em = (new Intent()).setPackage("com.google.android.gms").setComponent(Ek);
      En = (new Intent()).setPackage("com.google.android.gms").setComponent(El);
   }

   private static void C(Context var0) throws GoogleAuthException {
      try {
         GooglePlayServicesUtil.C(var0);
      } catch (GooglePlayServicesRepairableException var1) {
         throw new GooglePlayServicesAvailabilityException(var1.getConnectionStatusCode(), var1.getMessage(), var1.getIntent());
      } catch (GooglePlayServicesNotAvailableException var2) {
         throw new GoogleAuthException(var2.getMessage());
      }
   }

   private static String a(Context var0, String var1, String var2, Bundle var3) throws IOException, GoogleAuthException {
      Bundle var4 = var3;
      if(var3 == null) {
         var4 = new Bundle();
      }

      try {
         var1 = getToken(var0, var1, var2, var4);
         return var1;
      } catch (GooglePlayServicesAvailabilityException var5) {
         GooglePlayServicesUtil.showErrorNotification(var5.getConnectionStatusCode(), var0);
         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      } catch (UserRecoverableAuthException var6) {
         throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
      }
   }

   private static boolean ax(String var0) {
      return "NetworkError".equals(var0) || "ServiceUnavailable".equals(var0) || "Timeout".equals(var0);
   }

   private static boolean ay(String var0) {
      return "BadAuthentication".equals(var0) || "CaptchaRequired".equals(var0) || "DeviceManagementRequiredOrSyncDisabled".equals(var0) || "NeedPermission".equals(var0) || "NeedsBrowser".equals(var0) || "UserCancel".equals(var0) || "AppDownloadRequired".equals(var0) || ii.EI.fO().equals(var0) || ii.EJ.fO().equals(var0) || ii.EK.fO().equals(var0) || ii.EL.fO().equals(var0) || ii.EM.fO().equals(var0) || ii.EN.fO().equals(var0);
   }

   public static void clearToken(Context var0, String var1) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
      Context var2 = var0.getApplicationContext();
      jx.aV("Calling this from your main thread can lead to deadlock");
      C(var2);
      Bundle var3 = new Bundle();
      String var10 = var0.getApplicationInfo().packageName;
      var3.putString("clientPackageName", var10);
      if(!var3.containsKey(KEY_ANDROID_PACKAGE_NAME)) {
         var3.putString(KEY_ANDROID_PACKAGE_NAME, var10);
      }

      a var11 = new a();
      if(!var2.bindService(Em, var11, 1)) {
         throw new IOException("Could not bind to service with the given context.");
      } else {
         try {
            Bundle var12 = r.a.a(var11.gs()).a(var1, var3);
            String var13 = var12.getString(ii.Fk);
            if(!var12.getBoolean("booleanResult")) {
               throw new GoogleAuthException(var13);
            }
         } catch (RemoteException var7) {
            Log.i("GoogleAuthUtil", "GMS remote exception ", var7);
            throw new IOException("remote exception");
         } catch (InterruptedException var8) {
            throw new GoogleAuthException("Interrupted");
         } finally {
            var2.unbindService(var11);
         }

      }
   }

   public static List getAccountChangeEvents(Context var0, int var1, String var2) throws GoogleAuthException, IOException {
      jx.b((String)var2, "accountName must be provided");
      jx.aV("Calling this from your main thread can lead to deadlock");
      var0 = var0.getApplicationContext();
      C(var0);
      a var3 = new a();
      if(var0.bindService(Em, var3, 1)) {
         List var10;
         try {
            var10 = r.a.a(var3.gs()).a((new AccountChangeEventsRequest()).setAccountName(var2).setEventIndex(var1)).getEvents();
         } catch (RemoteException var7) {
            Log.i("GoogleAuthUtil", "GMS remote exception ", var7);
            throw new IOException("remote exception");
         } catch (InterruptedException var8) {
            throw new GoogleAuthException("Interrupted");
         } finally {
            var0.unbindService(var3);
         }

         return var10;
      } else {
         throw new IOException("Could not bind to service with the given context.");
      }
   }

   public static String getAccountId(Context var0, String var1) throws GoogleAuthException, IOException {
      jx.b((String)var1, "accountName must be provided");
      jx.aV("Calling this from your main thread can lead to deadlock");
      C(var0.getApplicationContext());
      return getToken(var0, var1, "^^_account_id_^^", new Bundle());
   }

   public static String getAppCert(Context var0, String var1) {
      return "spatula";
   }

   public static String getToken(Context var0, String var1, String var2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      return getToken(var0, var1, var2, new Bundle());
   }

   public static String getToken(Context param0, String param1, String param2, Bundle param3) throws IOException, UserRecoverableAuthException, GoogleAuthException {
      // $FF: Couldn't be decompiled
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      Bundle var4 = var3;
      if(var3 == null) {
         var4 = new Bundle();
      }

      var4.putBoolean("handle_notification", true);
      return a(var0, var1, var2, var4);
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, Intent var4) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      h(var4);
      Bundle var5 = var3;
      if(var3 == null) {
         var5 = new Bundle();
      }

      var5.putParcelable("callback_intent", var4);
      var5.putBoolean("handle_notification", true);
      return a(var0, var1, var2, var5);
   }

   public static String getTokenWithNotification(Context var0, String var1, String var2, Bundle var3, String var4, Bundle var5) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
      if(TextUtils.isEmpty(var4)) {
         throw new IllegalArgumentException("Authority cannot be empty or null.");
      } else {
         Bundle var6 = var3;
         if(var3 == null) {
            var6 = new Bundle();
         }

         var3 = var5;
         if(var5 == null) {
            var3 = new Bundle();
         }

         ContentResolver.validateSyncExtrasBundle(var3);
         var6.putString("authority", var4);
         var6.putBundle("sync_extras", var3);
         var6.putBoolean("handle_notification", true);
         return a(var0, var1, var2, var6);
      }
   }

   private static void h(Intent var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Callback cannot be null.");
      } else {
         String var2 = var0.toUri(1);

         try {
            Intent.parseUri(var2, 1);
         } catch (URISyntaxException var1) {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
         }
      }
   }

   @Deprecated
   public static void invalidateToken(Context var0, String var1) {
      AccountManager.get(var0).invalidateAuthToken("com.google", var1);
   }
}
