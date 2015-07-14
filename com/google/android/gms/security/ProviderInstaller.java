package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import java.lang.reflect.Method;

public class ProviderInstaller {
   public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
   private static Method apU = null;
   private static final Object ut = new Object();

   private static void V(Context var0) throws ClassNotFoundException, NoSuchMethodException {
      apU = var0.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
   }

   public static void installIfNeeded(Context param0) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
      // $FF: Couldn't be decompiled
   }

   public static void installIfNeededAsync(final Context var0, final ProviderInstaller.ProviderInstallListener var1) {
      jx.b((Object)var0, "Context must not be null");
      jx.b((Object)var1, "Listener must not be null");
      jx.aU("Must be called on the UI thread");
      (new AsyncTask() {
         protected Integer c(Void... var1x) {
            try {
               ProviderInstaller.installIfNeeded(var0);
            } catch (GooglePlayServicesRepairableException var2) {
               return Integer.valueOf(var2.getConnectionStatusCode());
            } catch (GooglePlayServicesNotAvailableException var3) {
               return Integer.valueOf(var3.errorCode);
            }

            return Integer.valueOf(0);
         }

         protected void d(Integer var1x) {
            if(var1x.intValue() == 0) {
               var1.onProviderInstalled();
            } else {
               Intent var2 = GooglePlayServicesUtil.aj(var1x.intValue());
               var1.onProviderInstallFailed(var1x.intValue(), var2);
            }
         }

         // $FF: synthetic method
         protected Object doInBackground(Object[] var1x) {
            return this.c((Void[])var1x);
         }

         // $FF: synthetic method
         protected void onPostExecute(Object var1x) {
            this.d((Integer)var1x);
         }
      }).execute(new Void[0]);
   }

   public interface ProviderInstallListener {
      void onProviderInstallFailed(int var1, Intent var2);

      void onProviderInstalled();
   }
}
