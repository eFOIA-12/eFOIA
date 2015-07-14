package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.app.Notification.BigTextStyle;
import android.content.Context;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.R;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.b;
import com.google.android.gms.internal.jf;
import com.google.android.gms.internal.jh;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lc;
import com.google.android.gms.internal.ll;
import java.util.Arrays;
import java.util.Set;

public final class GooglePlayServicesUtil {
   public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
   public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
   public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 6587000;
   public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
   public static boolean Jg = false;
   public static boolean Jh = false;
   private static int Ji = -1;
   private static final Object Jj = new Object();

   public static void C(Context var0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
      int var1 = isGooglePlayServicesAvailable(var0);
      if(var1 != 0) {
         Intent var2 = aj(var1);
         Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + var1);
         if(var2 == null) {
            throw new GooglePlayServicesNotAvailableException(var1);
         } else {
            throw new GooglePlayServicesRepairableException(var1, "Google Play Services not available", var2);
         }
      }
   }

   private static void D(Context var0) {
      Object var2 = null;

      ApplicationInfo var4;
      try {
         var4 = var0.getPackageManager().getApplicationInfo(var0.getPackageName(), 128);
      } catch (NameNotFoundException var3) {
         Log.wtf("GooglePlayServicesUtil", "This should never happen.", var3);
         var4 = (ApplicationInfo)var2;
      }

      Bundle var5 = var4.metaData;
      if(var5 != null) {
         int var1 = var5.getInt("com.google.android.gms.version");
         if(var1 != 6587000) {
            throw new IllegalStateException("The meta-data tag in your app\'s AndroidManifest.xml does not have the right value.  Expected 6587000 but found " + var1 + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
         }
      } else {
         throw new IllegalStateException("A required meta-data tag in your app\'s AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
      }
   }

   private static void E(Context var0) {
      GooglePlayServicesUtil.a var1 = new GooglePlayServicesUtil.a(var0);
      var1.sendMessageDelayed(var1.obtainMessage(1), 120000L);
   }

   private static String F(Context var0) {
      String var2 = var0.getApplicationInfo().name;
      String var1 = var2;
      if(TextUtils.isEmpty(var2)) {
         var1 = var0.getPackageName();
         PackageManager var5 = var0.getApplicationContext().getPackageManager();

         ApplicationInfo var4;
         try {
            var4 = var5.getApplicationInfo(var0.getPackageName(), 0);
         } catch (NameNotFoundException var3) {
            var4 = null;
         }

         if(var4 != null) {
            var1 = var5.getApplicationLabel(var4).toString();
         }
      }

      return var1;
   }

   private static Dialog a(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      int var5 = var0;
      if(lc.K(var1)) {
         var5 = var0;
         if(var0 == 2) {
            var5 = 42;
         }
      }

      Builder var11;
      label48: {
         if(ll.ij()) {
            TypedValue var6 = new TypedValue();
            var1.getTheme().resolveAttribute(16843529, var6, true);
            if("Theme.Dialog.Alert".equals(var1.getResources().getResourceEntryName(var6.resourceId))) {
               var11 = new Builder(var1, 5);
               break label48;
            }
         }

         var11 = null;
      }

      Builder var7 = var11;
      if(var11 == null) {
         var7 = new Builder(var1);
      }

      var7.setMessage(b(var1, var5));
      if(var4 != null) {
         var7.setOnCancelListener(var4);
      }

      Intent var10 = aj(var5);
      jh var9;
      if(var2 == null) {
         var9 = new jh(var1, var10, var3);
      } else {
         var9 = new jh(var2, var10, var3);
      }

      String var8 = c(var1, var5);
      if(var8 != null) {
         var7.setPositiveButton(var8, var9);
      }

      switch(var5) {
      case 0:
         return null;
      case 1:
         return var7.setTitle(R.string.common_google_play_services_install_title).create();
      case 2:
         return var7.setTitle(R.string.common_google_play_services_update_title).create();
      case 3:
         return var7.setTitle(R.string.common_google_play_services_enable_title).create();
      case 4:
      case 6:
         return var7.create();
      case 5:
         Log.e("GooglePlayServicesUtil", "An invalid account was specified when connecting. Please provide a valid account.");
         return var7.setTitle(R.string.common_google_play_services_invalid_account_title).create();
      case 7:
         Log.e("GooglePlayServicesUtil", "Network error occurred. Please retry request later.");
         return var7.setTitle(R.string.common_google_play_services_network_error_title).create();
      case 8:
         Log.e("GooglePlayServicesUtil", "Internal error occurred. Please see logs for detailed information");
         return var7.create();
      case 9:
         Log.e("GooglePlayServicesUtil", "Google Play services is invalid. Cannot recover.");
         return var7.setTitle(R.string.common_google_play_services_unsupported_title).create();
      case 10:
         Log.e("GooglePlayServicesUtil", "Developer error occurred. Please see logs for detailed information");
         return var7.create();
      case 11:
         Log.e("GooglePlayServicesUtil", "The application is not licensed to the user.");
         return var7.create();
      case 42:
         return var7.setTitle(R.string.common_android_wear_update_title).create();
      default:
         Log.e("GooglePlayServicesUtil", "Unexpected error code " + var5);
         return var7.create();
      }
   }

   private static void a(int var0, Context var1) {
      Resources var2 = var1.getResources();
      String var3 = d(var1, var0);
      String var4 = var2.getString(R.string.common_google_play_services_error_notification_requested_by_msg, new Object[]{F(var1)});
      PendingIntent var5 = getErrorPendingIntent(var0, var1, 0);
      Notification var6;
      if(lc.K(var1)) {
         jx.K(ll.ik());
         var6 = (new android.app.Notification.Builder(var1)).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle((new BigTextStyle()).bigText(var3 + " " + var4)).addAction(R.drawable.common_full_open_on_phone, var2.getString(R.string.common_open_on_phone), var5).build();
      } else {
         var6 = new Notification(17301642, var2.getString(R.string.common_google_play_services_notification_ticker), System.currentTimeMillis());
         var6.flags |= 16;
         var6.setLatestEventInfo(var1, var3, var4, var5);
      }

      ((NotificationManager)var1.getSystemService("notification")).notify(ak(var0), var6);
   }

   public static boolean a(PackageManager var0, PackageInfo var1) {
      boolean var2 = true;
      boolean var4 = false;
      boolean var3 = false;
      if(var1 != null) {
         if(c(var0)) {
            if(a(var1, true) == null) {
               var2 = false;
            }

            return var2;
         }

         var2 = var4;
         if(a(var1, false) != null) {
            var2 = true;
         }

         var3 = var2;
         if(!var2) {
            var3 = var2;
            if(a(var1, true) != null) {
               Log.w("GooglePlayServicesUtil", "Test-keys aren\'t accepted on this build.");
               return var2;
            }
         }
      }

      return var3;
   }

   public static boolean a(Resources var0) {
      if(var0 != null) {
         boolean var1;
         if((var0.getConfiguration().screenLayout & 15) > 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(ll.ig() && var1 || b(var0)) {
            return true;
         }
      }

      return false;
   }

   private static byte[] a(PackageInfo var0, boolean var1) {
      if(var0.signatures.length != 1) {
         Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
         return null;
      } else {
         byte[] var2 = var0.signatures[0].toByteArray();
         Set var3;
         if(var1) {
            var3 = b.gu();
         } else {
            var3 = b.gv();
         }

         if(var3.contains(var2)) {
            return var2;
         } else {
            if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
               Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var2, 0));
            }

            return null;
         }
      }
   }

   private static byte[] a(PackageInfo var0, byte[]... var1) {
      if(var0.signatures.length != 1) {
         Log.w("GooglePlayServicesUtil", "Package has more than one signature.");
         return null;
      } else {
         byte[] var4 = var0.signatures[0].toByteArray();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            byte[] var3 = var1[var2];
            if(Arrays.equals(var3, var4)) {
               return var3;
            }
         }

         if(Log.isLoggable("GooglePlayServicesUtil", 2)) {
            Log.v("GooglePlayServicesUtil", "Signature not valid.  Found: \n" + Base64.encodeToString(var4, 0));
         }

         return null;
      }
   }

   public static Intent aj(int var0) {
      switch(var0) {
      case 1:
      case 2:
         return jo.ba("com.google.android.gms");
      case 3:
         return jo.aY("com.google.android.gms");
      case 42:
         return jo.hE();
      default:
         return null;
      }
   }

   private static int ak(int var0) {
      switch(var0) {
      case 1:
      case 3:
         return 10436;
      case 2:
      default:
         return '魭';
      }
   }

   public static String b(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         if(a(var0.getResources())) {
            return var2.getString(R.string.common_google_play_services_install_text_tablet);
         }

         return var2.getString(R.string.common_google_play_services_install_text_phone);
      case 2:
         return var2.getString(R.string.common_google_play_services_update_text);
      case 3:
         return var2.getString(R.string.common_google_play_services_enable_text);
      case 5:
         return var2.getString(R.string.common_google_play_services_invalid_account_text);
      case 7:
         return var2.getString(R.string.common_google_play_services_network_error_text);
      case 9:
         return var2.getString(R.string.common_google_play_services_unsupported_text);
      case 42:
         return var2.getString(R.string.common_android_wear_update_text);
      default:
         return var2.getString(R.string.common_google_play_services_unknown_issue);
      }
   }

   public static boolean b(PackageManager param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean b(PackageManager var0, String var1) {
      PackageInfo var2;
      try {
         var2 = var0.getPackageInfo(var1, 64);
      } catch (NameNotFoundException var3) {
         if(Log.isLoggable("GooglePlayServicesUtil", 3)) {
            Log.d("GooglePlayServicesUtil", "Package manager can\'t find package " + var1 + ", defaulting to false");
         }

         return false;
      }

      return a(var0, var2);
   }

   private static boolean b(Resources var0) {
      boolean var2 = false;
      Configuration var3 = var0.getConfiguration();
      boolean var1 = var2;
      if(ll.ii()) {
         var1 = var2;
         if((var3.screenLayout & 15) <= 3) {
            var1 = var2;
            if(var3.smallestScreenWidthDp >= 600) {
               var1 = true;
            }
         }
      }

      return var1;
   }

   public static String c(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(R.string.common_google_play_services_install_button);
      case 2:
      case 42:
         return var2.getString(R.string.common_google_play_services_update_button);
      case 3:
         return var2.getString(R.string.common_google_play_services_enable_button);
      default:
         return var2.getString(17039370);
      }
   }

   public static boolean c(PackageManager var0) {
      return b(var0) || !gw();
   }

   public static String d(Context var0, int var1) {
      Resources var2 = var0.getResources();
      switch(var1) {
      case 1:
         return var2.getString(R.string.common_google_play_services_notification_needs_installation_title);
      case 2:
         return var2.getString(R.string.common_google_play_services_notification_needs_update_title);
      case 3:
         return var2.getString(R.string.common_google_play_services_needs_enabling_title);
      case 5:
         return var2.getString(R.string.common_google_play_services_invalid_account_text);
      case 7:
         return var2.getString(R.string.common_google_play_services_network_error_text);
      case 9:
         return var2.getString(R.string.common_google_play_services_unsupported_text);
      case 42:
         return var2.getString(R.string.common_android_wear_notification_needs_update_text);
      default:
         return var2.getString(R.string.common_google_play_services_unknown_issue);
      }
   }

   public static boolean e(Context var0, int var1) {
      if(var1 == 1) {
         PackageManager var4 = var0.getPackageManager();

         boolean var2;
         try {
            var2 = var4.getApplicationInfo("com.google.android.gms", 8192).enabled;
         } catch (NameNotFoundException var3) {
            return false;
         }

         if(var2) {
            return true;
         }
      }

      return false;
   }

   public static Dialog getErrorDialog(int var0, Activity var1, int var2) {
      return getErrorDialog(var0, var1, var2, (OnCancelListener)null);
   }

   public static Dialog getErrorDialog(int var0, Activity var1, int var2, OnCancelListener var3) {
      return a(var0, var1, (Fragment)null, var2, var3);
   }

   public static PendingIntent getErrorPendingIntent(int var0, Context var1, int var2) {
      Intent var3 = aj(var0);
      return var3 == null?null:PendingIntent.getActivity(var1, var2, var3, 268435456);
   }

   public static String getErrorString(int var0) {
      switch(var0) {
      case 0:
         return "SUCCESS";
      case 1:
         return "SERVICE_MISSING";
      case 2:
         return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 3:
         return "SERVICE_DISABLED";
      case 4:
         return "SIGN_IN_REQUIRED";
      case 5:
         return "INVALID_ACCOUNT";
      case 6:
         return "RESOLUTION_REQUIRED";
      case 7:
         return "NETWORK_ERROR";
      case 8:
         return "INTERNAL_ERROR";
      case 9:
         return "SERVICE_INVALID";
      case 10:
         return "DEVELOPER_ERROR";
      case 11:
         return "LICENSE_CHECK_FAILED";
      default:
         return "UNKNOWN_ERROR_CODE";
      }
   }

   public static String getOpenSourceSoftwareLicenseInfo(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Context getRemoteContext(Context var0) {
      try {
         var0 = var0.createPackageContext("com.google.android.gms", 3);
         return var0;
      } catch (NameNotFoundException var1) {
         return null;
      }
   }

   public static Resources getRemoteResource(Context var0) {
      try {
         Resources var2 = var0.getPackageManager().getResourcesForApplication("com.google.android.gms");
         return var2;
      } catch (NameNotFoundException var1) {
         return null;
      }
   }

   public static boolean gw() {
      return Jg?Jh:"user".equals(Build.TYPE);
   }

   public static int isGooglePlayServicesAvailable(Context var0) {
      PackageManager var2 = var0.getPackageManager();
      if(!jf.Mv) {
         try {
            var0.getResources().getString(R.string.common_google_play_services_unknown_issue);
         } catch (Throwable var9) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
         }
      }

      if(!jf.Mv) {
         D(var0);
      }

      PackageInfo var3;
      try {
         var3 = var2.getPackageInfo("com.google.android.gms", 64);
      } catch (NameNotFoundException var8) {
         Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
         return 1;
      }

      if(lc.aU(var3.versionCode)) {
         byte var1;
         if(gw()) {
            var1 = 0;
         } else {
            var1 = 1;
         }

         if(a(var3, new byte[][]{b.Ix[var1], b.IE[var1], b.IC[var1]}) == null) {
            Log.w("GooglePlayServicesUtil", "Google Play Services signature invalid on Glass.");
            return 9;
         }

         String var10 = var0.getPackageName();

         try {
            PackageInfo var4 = var2.getPackageInfo(var10, 64);
            if(!a(var2, var4)) {
               Log.w("GooglePlayServicesUtil", "Calling package " + var4.packageName + " signature invalid on Glass.");
               return 9;
            }
         } catch (NameNotFoundException var7) {
            Log.w("GooglePlayServicesUtil", "Could not get info for calling package: " + var10);
            return 9;
         }
      } else if(lc.K(var0)) {
         if(a(var3, b.Ix) == null) {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return 9;
         }
      } else {
         PackageInfo var11;
         try {
            var11 = var2.getPackageInfo("com.android.vending", 64);
         } catch (NameNotFoundException var6) {
            Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
            return 9;
         }

         byte[] var12 = a(var11, b.Ix);
         if(var12 == null) {
            Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
            return 9;
         }

         if(a(var3, new byte[][]{var12}) == null) {
            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
            return 9;
         }
      }

      int var14 = lc.aS(6587000);
      if(lc.aS(var3.versionCode) < var14) {
         Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires 6587000 but found " + var3.versionCode);
         return 2;
      } else {
         ApplicationInfo var13;
         try {
            var13 = var2.getApplicationInfo("com.google.android.gms", 0);
         } catch (NameNotFoundException var5) {
            Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
            var5.printStackTrace();
            return 1;
         }

         return !var13.enabled?3:0;
      }
   }

   public static boolean isGoogleSignedUid(PackageManager var0, int var1) {
      if(var0 == null) {
         throw new SecurityException("Unknown error: invalid Package Manager");
      } else {
         String[] var2 = var0.getPackagesForUid(var1);
         if(var2.length != 0 && b(var0, var2[0])) {
            return true;
         } else {
            throw new SecurityException("Uid is not Google Signed");
         }
      }
   }

   public static boolean isUserRecoverableError(int var0) {
      switch(var0) {
      case 1:
      case 2:
      case 3:
      case 9:
         return true;
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      default:
         return false;
      }
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2) {
      return showErrorDialogFragment(var0, var1, var2, (OnCancelListener)null);
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, int var2, OnCancelListener var3) {
      return showErrorDialogFragment(var0, var1, (Fragment)null, var2, var3);
   }

   public static boolean showErrorDialogFragment(int var0, Activity var1, Fragment var2, int var3, OnCancelListener var4) {
      boolean var5 = false;
      Dialog var11 = a(var0, var1, var2, var3, var4);
      if(var11 == null) {
         return false;
      } else {
         label23: {
            boolean var6;
            try {
               var6 = var1 instanceof FragmentActivity;
            } catch (NoClassDefFoundError var8) {
               break label23;
            }

            var5 = var6;
         }

         if(var5) {
            FragmentManager var9 = ((FragmentActivity)var1).getSupportFragmentManager();
            SupportErrorDialogFragment.newInstance(var11, var4).show(var9, "GooglePlayServicesErrorDialog");
         } else {
            if(!ll.ig()) {
               throw new RuntimeException("This Activity does not support Fragments.");
            }

            android.app.FragmentManager var10 = var1.getFragmentManager();
            ErrorDialogFragment.newInstance(var11, var4).show(var10, "GooglePlayServicesErrorDialog");
         }

         return true;
      }
   }

   public static void showErrorNotification(int var0, Context var1) {
      int var2 = var0;
      if(lc.K(var1)) {
         var2 = var0;
         if(var0 == 2) {
            var2 = 42;
         }
      }

      if(e(var1, var2)) {
         E(var1);
      } else {
         a(var2, var1);
      }
   }

   private static class a extends Handler {
      private final Context mO;

      a(Context var1) {
         Looper var2;
         if(Looper.myLooper() == null) {
            var2 = Looper.getMainLooper();
         } else {
            var2 = Looper.myLooper();
         }

         super(var2);
         this.mO = var1.getApplicationContext();
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            int var2 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mO);
            if(GooglePlayServicesUtil.isUserRecoverableError(var2)) {
               GooglePlayServicesUtil.a(var2, this.mO);
               return;
            }
            break;
         default:
            Log.w("GooglePlayServicesUtil", "Don\'t know how to handle this message: " + var1.what);
         }

      }
   }
}
