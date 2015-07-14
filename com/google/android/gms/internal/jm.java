package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;

public final class jm {
   private final jm.b MX;
   private final ArrayList MY = new ArrayList();
   final ArrayList MZ = new ArrayList();
   private boolean Na = false;
   private final ArrayList Nb = new ArrayList();
   private final Handler mHandler;

   public jm(Context var1, Looper var2, jm.b var3) {
      this.MX = var3;
      this.mHandler = new jm.a(var2);
   }

   // $FF: synthetic method
   static ArrayList a(jm var0) {
      return var0.MY;
   }

   // $FF: synthetic method
   static jm.b b(jm var0) {
      return var0.MX;
   }

   public void aE(int param1) {
      // $FF: Couldn't be decompiled
   }

   public void b(ConnectionResult param1) {
      // $FF: Couldn't be decompiled
   }

   protected void dU() {
      // $FF: Couldn't be decompiled
   }

   public void f(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks param1) {
      // $FF: Couldn't be decompiled
   }

   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener param1) {
      // $FF: Couldn't be decompiled
   }

   final class a extends Handler {
      public a(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message param1) {
         // $FF: Couldn't be decompiled
      }
   }

   public interface b {
      Bundle fX();

      boolean gN();

      boolean isConnected();
   }
}
