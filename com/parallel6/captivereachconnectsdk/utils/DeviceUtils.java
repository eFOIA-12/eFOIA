package com.parallel6.captivereachconnectsdk.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.parallel6.captivereachconnectsdk.models.login.Device;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.util.Iterator;
import java.util.UUID;

public class DeviceUtils {
   private static final String DEVICE_INFO;

   static {
      DEVICE_INFO = Build.MANUFACTURER + ' ' + Build.MODEL + ' ' + Build.PRODUCT;
   }

   public static String getAppVersion(Context var0) {
      try {
         String var2 = var0.getPackageManager().getPackageInfo(var0.getPackageName(), 0).versionName;
         return var2;
      } catch (NameNotFoundException var1) {
         var1.printStackTrace();
         return "";
      }
   }

   public static String getCarrierName(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getNetworkOperatorName();
   }

   public static Device getDevice(Context var0) {
      Device var1 = new Device();
      var1.setUdid(getDeviceId(var0));
      var1.setPush_id(SettingsUtils.getPushId(var0));
      var1.setTechnology("android");
      var1.setApp_version(getAppVersion(var0));
      return var1;
   }

   public static String getDeviceId(Context var0) {
      String var1 = ((TelephonyManager)var0.getSystemService("phone")).getDeviceId();
      String var2 = var1;
      if(StringUtils.isEmpty(var1)) {
         var2 = UUID.randomUUID().toString();
      }

      return var2;
   }

   public static String getDeviceInfo() {
      return DEVICE_INFO;
   }

   public static String getGPSLog(Context var0) {
      String var1;
      if(isLocationEnabled(var0)) {
         var1 = "enabled";
         GpsStatus var2 = ((LocationManager)var0.getSystemService("location")).getGpsStatus((GpsStatus)null);
         if(var2 != null) {
            String var3 = "enabled" + ", max satellites: " + var2.getMaxSatellites();
            Iterator var5 = var2.getSatellites().iterator();

            while(true) {
               var1 = var3;
               if(!var5.hasNext()) {
                  break;
               }

               GpsSatellite var4 = (GpsSatellite)var5.next();
               var3 = var3 + ", satellite[ azimuth: " + var4.getAzimuth() + ", elevation: " + var4.getElevation() + ", prn: " + var4.getPrn() + ", snr: " + var4.getSnr();
            }
         }
      } else {
         var1 = "disabled";
      }

      return var1;
   }

   public static boolean hasLocation(Context var0) {
      boolean var2 = true;
      boolean var1;
      if(!StringUtils.isEmpty(SettingsUtils.getLng(var0))) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(StringUtils.isEmpty(SettingsUtils.getLng(var0))) {
         var2 = false;
      }

      return var1 & var2;
   }

   public static boolean haveNetworkConnection(Context var0) {
      boolean var4 = false;
      boolean var2 = false;
      NetworkInfo[] var7 = ((ConnectivityManager)var0.getSystemService("connectivity")).getAllNetworkInfo();
      int var5 = var7.length;

      boolean var3;
      for(int var1 = 0; var1 < var5; var4 = var3) {
         NetworkInfo var6 = var7[var1];
         var3 = var4;
         if(var6.getTypeName().equalsIgnoreCase("WIFI")) {
            var3 = var4;
            if(var6.isConnected()) {
               var3 = true;
            }
         }

         var4 = var2;
         if(var6.getTypeName().equalsIgnoreCase("MOBILE")) {
            var4 = var2;
            if(var6.isConnected()) {
               var4 = true;
            }
         }

         ++var1;
         var2 = var4;
      }

      if(!var4 && !var2) {
         return false;
      } else {
         return true;
      }
   }

   public static boolean isLocationEnabled(Context var0) {
      return ((LocationManager)var0.getSystemService("location")).isProviderEnabled("gps");
   }
}
