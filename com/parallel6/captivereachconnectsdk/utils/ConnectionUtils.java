package com.parallel6.captivereachconnectsdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ConnectionUtils {
   @TargetApi(17)
   public static String getNetworkLog(Context var0) {
      NetworkInfo var3 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      String var2 = "";
      String var4;
      if(var3 == null) {
         var4 = "offline";
      } else {
         String var1;
         if(var3.getType() == 1) {
            var1 = String.valueOf(((WifiManager)var0.getSystemService("wifi")).getConnectionInfo().getRssi());
         } else {
            var1 = var2;
            if(var3.getType() == 0) {
               var1 = var2;
               if(VERSION.SDK_INT >= 17) {
                  TelephonyManager var5 = (TelephonyManager)var0.getSystemService("phone");
                  var1 = var2;
                  if(var5 != null) {
                     var1 = var2;
                     if(var5.getAllCellInfo() != null) {
                        if(var5.getAllCellInfo().get(0) instanceof CellInfoGsm) {
                           var1 = String.valueOf(((CellInfoGsm)var5.getAllCellInfo().get(0)).getCellSignalStrength().getAsuLevel() * 2 - 113);
                        } else if(var5.getAllCellInfo().get(0) instanceof CellInfoLte) {
                           var1 = String.valueOf(((CellInfoLte)var5.getAllCellInfo().get(0)).getCellSignalStrength().getAsuLevel() * 2 - 113);
                        } else {
                           var1 = var2;
                           if(var5.getAllCellInfo().get(0) instanceof CellInfoCdma) {
                              var1 = String.valueOf(((CellInfoCdma)var5.getAllCellInfo().get(0)).getCellSignalStrength().getAsuLevel() * 2 - 113);
                           }
                        }
                     }
                  }
               }
            }
         }

         var4 = "name= " + var3.getState().name() + ", type: " + var3.getTypeName() + ", subtype: " + var3.getSubtypeName() + ", extrainfo: " + var3.getExtraInfo() + ", detailed state: " + var3.getDetailedState().toString() + ", network_strength: " + var1;
      }

      Log.d(ConnectionUtils.class.getName(), var4);
      return var4;
   }

   public static ConnectionUtils.NetworkState getNewNetworkState(Context var0) {
      return ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo() == null?ConnectionUtils.NetworkState.OFFLINE:ConnectionUtils.NetworkState.ONLINE;
   }

   public static boolean isMobileNetworkActive(Context var0) {
      return isNetworkActive(var0, 0);
   }

   public static boolean isNetworkActive(Context var0) {
      return isWifiNetworkActive(var0) || isMobileNetworkActive(var0);
   }

   private static boolean isNetworkActive(Context var0, int var1) {
      NetworkInfo var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getNetworkInfo(var1);
      return var2 != null && var2.isConnected();
   }

   public static boolean isWifiNetworkActive(Context var0) {
      return isNetworkActive(var0, 1);
   }

   public static enum NetworkState {
      OFFLINE,
      ONLINE;
   }
}
