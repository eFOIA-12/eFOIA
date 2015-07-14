package com.parallel6.captivereachconnectsdk.services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.parallel6.captivereachconnectsdk.network.PutLocationTask;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.util.Locale;

public class LocationService extends Service implements LocationListener {
   private static final int DISTANCE = 200;
   private static final String PROVIDER = "network";
   public static final String TAG = "LocationService";
   private static final int TIME = 120000;
   private LocationManager locationManager;

   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      super.onCreate();
      Log.d("LocationService", "onCreate()");
      this.locationManager = (LocationManager)this.getSystemService("location");
      Log.d("LocationService", "Registering updates...");
      if(this.locationManager.getAllProviders().contains("network")) {
         this.locationManager.requestLocationUpdates("network", 120000L, 200.0F, this);
      }

      if(this.locationManager.getAllProviders().contains("gps")) {
         this.locationManager.requestLocationUpdates("gps", 120000L, 200.0F, this);
      }

   }

   public void onDestroy() {
      super.onDestroy();
      Log.d("LocationService", "onDestroy()");
      if(this.locationManager != null) {
         Log.d("LocationService", "Removing updates...");
         this.locationManager.removeUpdates(this);
      }

   }

   public void onLocationChanged(Location var1) {
      Log.i("LocationService", "onLocationChanged: " + var1);
      SettingsUtils.setLat(this, var1.getLatitude());
      SettingsUtils.setLng(this, var1.getLongitude());
      if(StringUtils.isNotEmpty(SettingsUtils.getRegistrationToken(this))) {
         (new PutLocationTask(this)).execute(new Void[0]);
      }

      Log.d("LocationService", String.format(Locale.ENGLISH, "Location changed:(%1$10f, %2$10f)", new Object[]{Double.valueOf(var1.getLatitude()), Double.valueOf(var1.getLongitude())}));
   }

   public void onProviderDisabled(String var1) {
      Log.d("LocationService", String.format("%1$s disabled...", new Object[]{var1}));
   }

   public void onProviderEnabled(String var1) {
      Log.d("LocationService", String.format("%1$s enabled...", new Object[]{var1}));
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      Log.d("LocationService", "onStartCommand()");
      return 1;
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
}
