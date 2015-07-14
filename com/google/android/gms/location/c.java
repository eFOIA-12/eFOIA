package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.nk;

@Deprecated
public class c implements GooglePlayServicesClient {
   private final nk agq;

   public void connect() {
      this.agq.connect();
   }

   public void disconnect() {
      this.agq.disconnect();
   }

   public boolean isConnected() {
      return this.agq.isConnected();
   }

   public boolean isConnecting() {
      return this.agq.isConnecting();
   }

   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.agq.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.agq.isConnectionFailedListenerRegistered(var1);
   }

   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.agq.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.agq.registerConnectionFailedListener(var1);
   }

   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.agq.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.agq.unregisterConnectionFailedListener(var1);
   }

   public interface a {
      void a(int var1, String[] var2);
   }

   public interface b {
      void a(int var1, PendingIntent var2);

      void b(int var1, String[] var2);
   }
}
