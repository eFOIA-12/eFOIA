package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {
   Api.a a(Api.c var1);

   BaseImplementation.a a(BaseImplementation.a var1);

   boolean a(Scope var1);

   BaseImplementation.a b(BaseImplementation.a var1);

   ConnectionResult blockingConnect();

   ConnectionResult blockingConnect(long var1, TimeUnit var3);

   PendingResult clearDefaultAccountAndReconnect();

   void connect();

   d d(Object var1);

   void disconnect();

   Looper getLooper();

   boolean isConnected();

   boolean isConnecting();

   boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1);

   boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1);

   void reconnect();

   void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   void stopAutoManage(FragmentActivity var1);

   void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1);

   void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1);

   public static final class Builder {
      private String DZ;
      private Looper JF;
      private final Set JH;
      private int JI;
      private View JJ;
      private String JK;
      private final Map JL;
      private FragmentActivity JM;
      private int JN;
      private GoogleApiClient.OnConnectionFailedListener JO;
      private final Set JP;
      private final Set JQ;
      private final Context mContext;

      public Builder(Context var1) {
         this.JH = new HashSet();
         this.JL = new HashMap();
         this.JN = -1;
         this.JP = new HashSet();
         this.JQ = new HashSet();
         this.mContext = var1;
         this.JF = var1.getMainLooper();
         this.JK = var1.getPackageName();
      }

      public Builder(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3) {
         this(var1);
         jx.b((Object)var2, "Must provide a connected listener");
         this.JP.add(var2);
         jx.b((Object)var3, "Must provide a connection failed listener");
         this.JQ.add(var3);
      }

      private GoogleApiClient gI() {
         g var3 = g.a(this.JM);
         GoogleApiClient var2 = var3.an(this.JN);
         Object var1 = var2;
         if(var2 == null) {
            var1 = new c(this.mContext.getApplicationContext(), this.JF, this.gH(), this.JL, this.JP, this.JQ, this.JN);
         }

         var3.a(this.JN, (GoogleApiClient)var1, this.JO);
         return (GoogleApiClient)var1;
      }

      public GoogleApiClient.Builder addApi(Api var1) {
         this.JL.put(var1, (Object)null);
         List var4 = var1.gy();
         int var3 = var4.size();

         for(int var2 = 0; var2 < var3; ++var2) {
            this.JH.add(((Scope)var4.get(var2)).gO());
         }

         return this;
      }

      public GoogleApiClient.Builder addApi(Api var1, Api.HasOptions var2) {
         jx.b((Object)var2, "Null options are not permitted for this Api");
         this.JL.put(var1, var2);
         List var5 = var1.gy();
         int var4 = var5.size();

         for(int var3 = 0; var3 < var4; ++var3) {
            this.JH.add(((Scope)var5.get(var3)).gO());
         }

         return this;
      }

      public GoogleApiClient.Builder addConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
         this.JP.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addOnConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
         this.JQ.add(var1);
         return this;
      }

      public GoogleApiClient.Builder addScope(Scope var1) {
         this.JH.add(var1.gO());
         return this;
      }

      public GoogleApiClient build() {
         boolean var1;
         if(!this.JL.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "must call addApi() to add at least one API");
         return (GoogleApiClient)(this.JN >= 0?this.gI():new c(this.mContext, this.JF, this.gH(), this.JL, this.JP, this.JQ, -1));
      }

      public GoogleApiClient.Builder enableAutoManage(FragmentActivity var1, int var2, GoogleApiClient.OnConnectionFailedListener var3) {
         boolean var4;
         if(var2 >= 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.b(var4, "clientId must be non-negative");
         this.JN = var2;
         this.JM = (FragmentActivity)jx.b((Object)var1, "Null activity is not permitted.");
         this.JO = var3;
         return this;
      }

      public jg gH() {
         return new jg(this.DZ, this.JH, this.JI, this.JJ, this.JK);
      }

      public GoogleApiClient.Builder setAccountName(String var1) {
         this.DZ = var1;
         return this;
      }

      public GoogleApiClient.Builder setGravityForPopups(int var1) {
         this.JI = var1;
         return this;
      }

      public GoogleApiClient.Builder setHandler(Handler var1) {
         jx.b((Object)var1, "Handler must not be null");
         this.JF = var1.getLooper();
         return this;
      }

      public GoogleApiClient.Builder setViewForPopups(View var1) {
         this.JJ = var1;
         return this;
      }

      public GoogleApiClient.Builder useDefaultAccount() {
         return this.setAccountName("<<default account>>");
      }
   }

   public interface ConnectionCallbacks {
      int CAUSE_NETWORK_LOST = 2;
      int CAUSE_SERVICE_DISCONNECTED = 1;

      void onConnected(Bundle var1);

      void onConnectionSuspended(int var1);
   }

   public interface OnConnectionFailedListener extends GooglePlayServicesClient.OnConnectionFailedListener {
      void onConnectionFailed(ConnectionResult var1);
   }
}
