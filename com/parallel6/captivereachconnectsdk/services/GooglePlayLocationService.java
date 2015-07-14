package com.parallel6.captivereachconnectsdk.services;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnClickListener;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.parallel6.captivereachconnectsdk.network.PutLocationTask;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import java.util.Locale;

public class GooglePlayLocationService extends Service implements LocationListener, GooglePlayServicesClient.ConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   public static final String ACTION_STRING_SERVICE = "GooglePlayLocationService_to_service";
   public static final long FASTER_INTERVAL = 60000L;
   public static final int GOOGLE_PLAY_SERVICES_REQUEST_CODE = 666;
   public static final int MIN_DISTANCE = 200;
   public static final long NORMAL_INTERVAL = 120000L;
   public static final int PRIORITY = 102;
   private static final String TAG = "____ ---- GooglePlayLocationService ---- ____";
   private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
      public void onReceive(Context var1, Intent var2) {
         GooglePlayLocationService.this.tryToConnectToLocationClient();
      }
   };
   private GoogleApiClient locClient;
   private LocationRequest locRequest;
   private boolean registerFlag = false;

   private void registerForLocationListener() {
      if(this.locRequest == null && this.locClient != null && this.locClient.isConnected()) {
         this.locRequest = LocationRequest.create();
         this.locRequest.setInterval(120000L).setFastestInterval(60000L).setSmallestDisplacement(200.0F).setPriority(102);
         LocationServices.FusedLocationApi.requestLocationUpdates(this.locClient, this.locRequest, (LocationListener)this);
         Log.i("____ ---- GooglePlayLocationService ---- ____", "registerForLocationListener");
      }

   }

   private boolean tryToConnectToLocationClient() {
      boolean var1;
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var1 && this.locClient == null) {
         this.locClient = (new GoogleApiClient.Builder(this)).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
         this.locClient.connect();
      }

      return var1;
   }

   public static boolean validateGooglePlayServicesAvailability(Activity var0) {
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
      if(var1 == 0) {
         return true;
      } else {
         Dialog var2 = GooglePlayServicesUtil.getErrorDialog(var1, var0, 666);
         if(var2 == null) {
            Builder var3 = new Builder(var0);
            var3.setMessage("Something went wrong. Please make sure that you have the Play Store installed and that you are connected to the internet. Contact developer with details if this persists.");
            var3.setCancelable(true);
            var3.setPositiveButton("OK", (OnClickListener)null);
            var3.create().show();
         } else {
            var2.show();
         }

         return false;
      }
   }

   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onConnected(Bundle var1) {
      this.registerForLocationListener();
   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.locClient = null;
      this.locRequest = null;
   }

   public void onConnectionSuspended(int var1) {
   }

   public void onCreate() {
      super.onCreate();
      if(!this.tryToConnectToLocationClient()) {
         this.registerFlag = true;
         Log.i("____ ---- GooglePlayLocationService ---- ____", "GooglePlayServices Not AVAILABLE");
         IntentFilter var1 = new IntentFilter("GooglePlayLocationService_to_service");
         this.registerReceiver(this.broadcastReceiver, var1);
      }

   }

   public void onDestroy() {
      super.onDestroy();
      if(this.locClient != null) {
         this.locClient.disconnect();
      }

      if(this.registerFlag) {
         this.unregisterReceiver(this.broadcastReceiver);
      }

      this.locClient = null;
      this.locRequest = null;
   }

   public void onDisconnected() {
      this.locClient = null;
      this.locRequest = null;
   }

   public void onLocationChanged(Location var1) {
      Log.i("____ ---- GooglePlayLocationService ---- ____", "onLocationChanged: " + var1);
      SettingsUtils.setLat(this, var1.getLatitude());
      SettingsUtils.setLng(this, var1.getLongitude());
      if(StringUtils.isNotEmpty(SettingsUtils.getRegistrationToken(this))) {
         (new PutLocationTask(this)).execute(new Void[0]);
      }

      Log.d("____ ---- GooglePlayLocationService ---- ____", String.format(Locale.ENGLISH, "Location changed:(%1$10f, %2$10f)", new Object[]{Double.valueOf(var1.getLatitude()), Double.valueOf(var1.getLongitude())}));
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      this.registerForLocationListener();
      return 1;
   }
}
