package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.internal.jv;

public final class ConnectionResult {
   public static final int API_UNAVAILABLE = 16;
   public static final int CANCELED = 13;
   public static final int DEVELOPER_ERROR = 10;
   @Deprecated
   public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
   public static final int INTERNAL_ERROR = 8;
   public static final int INTERRUPTED = 15;
   public static final int INVALID_ACCOUNT = 5;
   public static final ConnectionResult Iu = new ConnectionResult(0, (PendingIntent)null);
   public static final int LICENSE_CHECK_FAILED = 11;
   public static final int NETWORK_ERROR = 7;
   public static final int RESOLUTION_REQUIRED = 6;
   public static final int SERVICE_DISABLED = 3;
   public static final int SERVICE_INVALID = 9;
   public static final int SERVICE_MISSING = 1;
   public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
   public static final int SIGN_IN_REQUIRED = 4;
   public static final int SUCCESS = 0;
   public static final int TIMEOUT = 14;
   private final int Iv;
   private final PendingIntent mPendingIntent;

   public ConnectionResult(int var1, PendingIntent var2) {
      this.Iv = var1;
      this.mPendingIntent = var2;
   }

   private String gt() {
      switch(this.Iv) {
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
      case 12:
      default:
         return "unknown status code " + this.Iv;
      case 13:
         return "CANCELED";
      case 14:
         return "TIMEOUT";
      case 15:
         return "INTERRUPTED";
      }
   }

   public int getErrorCode() {
      return this.Iv;
   }

   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public boolean hasResolution() {
      return this.Iv != 0 && this.mPendingIntent != null;
   }

   public boolean isSuccess() {
      return this.Iv == 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return jv.h(this).a("statusCode", this.gt()).a("resolution", this.mPendingIntent).toString();
   }
}
