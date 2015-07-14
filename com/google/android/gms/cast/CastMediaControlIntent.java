package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

public final class CastMediaControlIntent {
   public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
   @Deprecated
   public static final String CATEGORY_CAST = "com.google.android.gms.cast.CATEGORY_CAST";
   public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
   public static final int ERROR_CODE_REQUEST_FAILED = 1;
   public static final int ERROR_CODE_SESSION_START_FAILED = 2;
   public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
   public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
   public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
   public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
   public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
   public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
   public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
   public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

   private static String a(String var0, String var1, Collection var2) throws IllegalArgumentException {
      StringBuffer var5 = new StringBuffer(var0);
      if(var1 != null) {
         String var3 = var1.toUpperCase();
         if(!var3.matches("[A-F0-9]+")) {
            throw new IllegalArgumentException("Invalid application ID: " + var1);
         }

         var5.append("/").append(var3);
      }

      if(var2 != null) {
         if(var2.isEmpty()) {
            throw new IllegalArgumentException("Must specify at least one namespace");
         }

         Iterator var6 = var2.iterator();

         while(true) {
            if(var6.hasNext()) {
               String var4 = (String)var6.next();
               if(!TextUtils.isEmpty(var4) && !var4.trim().equals("")) {
                  continue;
               }

               throw new IllegalArgumentException("Namespaces must not be null or empty");
            }

            if(var1 == null) {
               var5.append("/");
            }

            var5.append("/").append(TextUtils.join(",", var2));
            break;
         }
      }

      return var5.toString();
   }

   public static String categoryForCast(String var0) throws IllegalArgumentException {
      if(var0 == null) {
         throw new IllegalArgumentException("applicationId cannot be null");
      } else {
         return a("com.google.android.gms.cast.CATEGORY_CAST", var0, (Collection)null);
      }
   }

   public static String categoryForCast(String var0, Collection var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("applicationId cannot be null");
      } else if(var1 == null) {
         throw new IllegalArgumentException("namespaces cannot be null");
      } else {
         return a("com.google.android.gms.cast.CATEGORY_CAST", var0, var1);
      }
   }

   public static String categoryForCast(Collection var0) throws IllegalArgumentException {
      if(var0 == null) {
         throw new IllegalArgumentException("namespaces cannot be null");
      } else {
         return a("com.google.android.gms.cast.CATEGORY_CAST", (String)null, var0);
      }
   }

   public static String categoryForRemotePlayback() {
      return a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", (String)null, (Collection)null);
   }

   public static String categoryForRemotePlayback(String var0) throws IllegalArgumentException {
      if(TextUtils.isEmpty(var0)) {
         throw new IllegalArgumentException("applicationId cannot be null or empty");
      } else {
         return a("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", var0, (Collection)null);
      }
   }

   public static String languageTagForLocale(Locale var0) {
      return in.b(var0);
   }
}
