package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Build.VERSION;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class x {
   private static Context alI;
   private static c alJ;

   public static c S(Context var0) throws GooglePlayServicesNotAvailableException {
      jx.i(var0);
      if(alJ != null) {
         return alJ;
      } else {
         T(var0);
         alJ = U(var0);

         try {
            alJ.a(com.google.android.gms.dynamic.e.k(getRemoteContext(var0).getResources()), 6587000);
         } catch (RemoteException var1) {
            throw new RuntimeRemoteException(var1);
         }

         return alJ;
      }
   }

   private static void T(Context var0) throws GooglePlayServicesNotAvailableException {
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      switch(var1) {
      case 0:
         return;
      default:
         throw new GooglePlayServicesNotAvailableException(var1);
      }
   }

   private static c U(Context var0) {
      if(nY()) {
         Log.i(x.class.getSimpleName(), "Making Creator statically");
         return (c)c(nZ());
      } else {
         Log.i(x.class.getSimpleName(), "Making Creator dynamically");
         return c.a.aS((IBinder)a(getRemoteContext(var0).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
      }
   }

   private static Object a(ClassLoader var0, String var1) {
      try {
         Object var3 = c(((ClassLoader)jx.i(var0)).loadClass(var1));
         return var3;
      } catch (ClassNotFoundException var2) {
         throw new IllegalStateException("Unable to find dynamic class " + var1);
      }
   }

   private static Object c(Class var0) {
      try {
         Object var1 = var0.newInstance();
         return var1;
      } catch (InstantiationException var2) {
         throw new IllegalStateException("Unable to instantiate the dynamic class " + var0.getName());
      } catch (IllegalAccessException var3) {
         throw new IllegalStateException("Unable to call the default constructor of " + var0.getName());
      }
   }

   private static Context getRemoteContext(Context var0) {
      if(alI == null) {
         if(nY()) {
            alI = var0.getApplicationContext();
         } else {
            alI = GooglePlayServicesUtil.getRemoteContext(var0);
         }
      }

      return alI;
   }

   public static boolean nY() {
      return false;
   }

   private static Class nZ() {
      try {
         if(VERSION.SDK_INT < 15) {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6");
         } else {
            Class var0 = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
            return var0;
         }
      } catch (ClassNotFoundException var1) {
         throw new RuntimeException(var1);
      }
   }
}
