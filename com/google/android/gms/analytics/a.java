package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.an;
import com.google.android.gms.analytics.q;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

class a implements q {
   private static Object xO = new Object();
   private static a xP;
   private Context mContext;
   private AdvertisingIdClient.Info xQ;
   private long xR;
   private String xS;
   private boolean xT = false;
   private Object xU = new Object();

   a(Context var1) {
      this.mContext = var1.getApplicationContext();
   }

   private boolean a(AdvertisingIdClient.Info param1, AdvertisingIdClient.Info param2) {
      // $FF: Couldn't be decompiled
   }

   static String aa(String var0) {
      MessageDigest var1 = an.ap("MD5");
      return var1 == null?null:String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, var1.digest(var0.getBytes()))});
   }

   private boolean ab(String var1) {
      try {
         var1 = aa(var1);
         ae.V("Storing hashed adid.");
         FileOutputStream var2 = this.mContext.openFileOutput("gaClientIdData", 0);
         var2.write(var1.getBytes());
         var2.close();
         this.xS = var1;
         return true;
      } catch (FileNotFoundException var3) {
         ae.T("Error creating hash file.");
         return false;
      } catch (IOException var4) {
         ae.T("Error writing to hash file.");
         return false;
      }
   }

   public static q w(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static String x(Context param0) {
      // $FF: Couldn't be decompiled
   }

   AdvertisingIdClient.Info dP() {
      try {
         AdvertisingIdClient.Info var1 = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
         return var1;
      } catch (IllegalStateException var2) {
         ae.W("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added \'<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />\' to your application manifest file. See http://goo.gl/naFqQk for details.");
         return null;
      } catch (GooglePlayServicesRepairableException var3) {
         ae.W("GooglePlayServicesRepairableException getting Ad Id Info");
         return null;
      } catch (IOException var4) {
         ae.W("IOException getting Ad Id Info");
         return null;
      } catch (GooglePlayServicesNotAvailableException var5) {
         ae.W("GooglePlayServicesNotAvailableException getting Ad Id Info");
         return null;
      } catch (Throwable var6) {
         ae.W("Unknown exception. Could not get the ad Id.");
         return null;
      }
   }

   public String getValue(String var1) {
      long var2 = System.currentTimeMillis();
      if(var2 - this.xR > 1000L) {
         AdvertisingIdClient.Info var4 = this.dP();
         if(this.a(this.xQ, var4)) {
            this.xQ = var4;
         } else {
            this.xQ = new AdvertisingIdClient.Info("", false);
         }

         this.xR = var2;
      }

      if(this.xQ != null) {
         if("&adid".equals(var1)) {
            return this.xQ.getId();
         }

         if("&ate".equals(var1)) {
            if(this.xQ.isLimitAdTrackingEnabled()) {
               return "0";
            }

            return "1";
         }
      }

      return null;
   }
}
