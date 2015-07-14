package com.parallel6.captivereachconnectsdk.gps;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaptiveReachLocationManager implements LocationListener {
   private static final int DISTANCE = 50;
   private static final String PROVIDER = "network";
   public static final String TAG = "LocationService";
   private static final int TIME = 120000;
   private List listeners;
   private LocationManager locationManager;
   private Context mContext;
   private long mLastUpdatedTime = 0L;
   private boolean mLocationRequestStarted;

   public CaptiveReachLocationManager(Context var1) {
      this.locationManager = (LocationManager)var1.getSystemService("location");
      this.mContext = var1;
      this.listeners = new ArrayList();
   }

   public static boolean isLocationEnabled(Context var0) {
      return ((LocationManager)var0.getSystemService("location")).isProviderEnabled("gps");
   }

   public void onLocationChanged(Location var1) {
      Log.i("LocationService", "onLocationChanged: " + var1);
      this.mLastUpdatedTime = System.currentTimeMillis();
      SettingsUtils.setLat(this.mContext, var1.getLatitude());
      SettingsUtils.setLng(this.mContext, var1.getLongitude());
      if(this.listeners.size() > 0) {
         Iterator var2 = this.listeners.iterator();

         while(var2.hasNext()) {
            ((CaptiveReachLocationManager.CaptiveReachLocationChangedListener)var2.next()).onLocationChanged(var1);
            var2.remove();
         }
      } else {
         this.stop();
      }

   }

   public void onProviderDisabled(String var1) {
      Log.d("LocationService", String.format("%1$s disabled...", new Object[]{var1}));
   }

   public void onProviderEnabled(String var1) {
      Log.d("LocationService", String.format("%1$s enabled...", new Object[]{var1}));
   }

   public void onStatusChanged(String var1, int var2, Bundle var3) {
      switch(var2) {
      case 0:
         var1 = String.format("%1$s is \"Out of service\"", new Object[]{var1});
         break;
      case 1:
         var1 = String.format("%1$s is \"Temporary unavailable\"", new Object[]{var1});
         break;
      case 2:
         var1 = String.format("%1$s is \"Available\"", new Object[]{var1});
         break;
      default:
         var1 = String.format("%1$s status unknown...", new Object[]{var1});
      }

      Log.d("LocationService", var1);
   }

   public void start(CaptiveReachLocationManager.CaptiveReachLocationChangedListener var1) {
      if(System.currentTimeMillis() - this.mLastUpdatedTime > 120000L && !this.mLocationRequestStarted) {
         this.listeners.add(var1);
         if(this.locationManager.getAllProviders().contains("network")) {
            this.locationManager.requestLocationUpdates("network", 120000L, 50.0F, this);
            this.mLocationRequestStarted = true;
         }

         if(this.locationManager.getAllProviders().contains("gps")) {
            this.locationManager.requestLocationUpdates("gps", 120000L, 50.0F, this);
            this.mLocationRequestStarted = true;
         }

      } else {
         var1.onLocationChanged(this.locationManager.getLastKnownLocation("location"));
      }
   }

   public void stop() {
      if(this.locationManager != null && this.listeners.size() == 0) {
         this.locationManager.removeUpdates(this);
      }

      this.mLocationRequestStarted = false;
   }

   public interface CaptiveReachLocationChangedListener {
      void onLocationChanged(Location var1);
   }
}
