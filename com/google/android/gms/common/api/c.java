package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.kc;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c implements GoogleApiClient {
   private final Looper JF;
   private final Condition JR;
   private final jm JS;
   private final int JT;
   final Queue JU;
   private ConnectionResult JV;
   private int JW;
   private volatile int JX;
   private volatile boolean JY;
   private boolean JZ;
   private final c.b Jy;
   private int Ka;
   private long Kb;
   private long Kc;
   final Handler Kd;
   BroadcastReceiver Ke;
   private final Bundle Kf;
   private final Map Kg;
   private final List Kh;
   private boolean Ki;
   private final Set Kj;
   final Set Kk;
   private final GoogleApiClient.ConnectionCallbacks Kl;
   private final jm.b Km;
   private final Context mContext;
   private final Lock zO = new ReentrantLock();

   public c(Context var1, Looper var2, jg var3, Map var4, Set var5, Set var6, int var7) {
      this.JR = this.zO.newCondition();
      this.JU = new LinkedList();
      this.JX = 4;
      this.JZ = false;
      this.Kb = 120000L;
      this.Kc = 5000L;
      this.Kf = new Bundle();
      this.Kg = new HashMap();
      this.Kj = Collections.newSetFromMap(new WeakHashMap());
      this.Kk = Collections.newSetFromMap(new ConcurrentHashMap());
      this.Jy = new c.b() {
         public void b(c.d var1) {
            c.this.Kk.remove(var1);
         }
      };
      this.Kl = new GoogleApiClient.ConnectionCallbacks() {
         public void onConnected(Bundle param1) {
            // $FF: Couldn't be decompiled
         }

         public void onConnectionSuspended(int param1) {
            // $FF: Couldn't be decompiled
         }
      };
      this.Km = new jm.b() {
         public Bundle fX() {
            return null;
         }

         public boolean gN() {
            return c.this.Ki;
         }

         public boolean isConnected() {
            return c.this.isConnected();
         }
      };
      this.mContext = var1;
      this.JS = new jm(var1, var2, this.Km);
      this.JF = var2;
      this.Kd = new c.c(var2);
      this.JT = var7;
      Iterator var10 = var5.iterator();

      while(var10.hasNext()) {
         GoogleApiClient.ConnectionCallbacks var8 = (GoogleApiClient.ConnectionCallbacks)var10.next();
         this.JS.registerConnectionCallbacks(var8);
      }

      var10 = var6.iterator();

      while(var10.hasNext()) {
         GoogleApiClient.OnConnectionFailedListener var11 = (GoogleApiClient.OnConnectionFailedListener)var10.next();
         this.JS.registerConnectionFailedListener(var11);
      }

      var10 = var4.keySet().iterator();

      while(var10.hasNext()) {
         Api var12 = (Api)var10.next();
         final Api.b var13 = var12.gx();
         Object var9 = var4.get(var12);
         this.Kg.put(var12.gz(), a(var13, var9, var1, var2, var3, this.Kl, new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult var1) {
               c.this.zO.lock();

               try {
                  if(c.this.JV == null || var13.getPriority() < c.this.JW) {
                     c.this.JV = var1;
                     c.this.JW = var13.getPriority();
                  }

                  c.this.gJ();
               } finally {
                  c.this.zO.unlock();
               }

            }
         }));
      }

      this.Kh = Collections.unmodifiableList(var3.ho());
   }

   private static Api.a a(Api.b var0, Object var1, Context var2, Looper var3, jg var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
      return var0.a(var2, var3, var4, var1, var5, var6);
   }

   private void a(final GoogleApiClient var1, final f var2, final boolean var3) {
      kc.Nu.c(var1).setResultCallback(new ResultCallback() {
         public void j(Status var1x) {
            if(var1x.isSuccess() && c.this.isConnected()) {
               c.this.reconnect();
            }

            var2.b(var1x);
            if(var3) {
               var1.disconnect();
            }

         }

         // $FF: synthetic method
         public void onResult(Result var1x) {
            this.j((Status)var1x);
         }
      });
   }

   private void a(c.d param1) throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(c var0, int var1) {
      var0.al(var1);
   }

   // $FF: synthetic method
   static boolean a(c var0, boolean var1) {
      var0.JY = var1;
      return var1;
   }

   private void al(int param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static int b(c var0) {
      return var0.JX;
   }

   // $FF: synthetic method
   static Bundle c(c var0) {
      return var0.Kf;
   }

   // $FF: synthetic method
   static Context e(c var0) {
      return var0.mContext;
   }

   // $FF: synthetic method
   static long f(c var0) {
      return var0.Kb;
   }

   // $FF: synthetic method
   static long g(c var0) {
      return var0.Kc;
   }

   private void gJ() {
      --this.Ka;
      if(this.Ka == 0) {
         if(this.JV == null) {
            this.JX = 2;
            this.gM();
            this.JR.signalAll();
            this.gK();
            if(this.JZ) {
               this.JZ = false;
               this.al(-1);
               return;
            }

            Bundle var1;
            if(this.Kf.isEmpty()) {
               var1 = null;
            } else {
               var1 = this.Kf;
            }

            this.JS.f(var1);
            return;
         }

         this.JZ = false;
         this.al(3);
         if(!this.gL() || !GooglePlayServicesUtil.e(this.mContext, this.JV.getErrorCode())) {
            this.gM();
            this.JS.b(this.JV);
         }

         this.Ki = false;
      }

   }

   private void gK() {
      // $FF: Couldn't be decompiled
   }

   private void gM() {
      // $FF: Couldn't be decompiled
   }

   private void resume() {
      this.zO.lock();

      try {
         if(this.gL()) {
            this.connect();
         }
      } finally {
         this.zO.unlock();
      }

   }

   public Api.a a(Api.c var1) {
      Api.a var2 = (Api.a)this.Kg.get(var1);
      jx.b((Object)var2, "Appropriate Api was not requested.");
      return var2;
   }

   public BaseImplementation.a a(BaseImplementation.a var1) {
      this.zO.lock();

      try {
         if(this.isConnected()) {
            this.b(var1);
         } else {
            this.JU.add(var1);
         }
      } finally {
         this.zO.unlock();
      }

      return var1;
   }

   public boolean a(Scope var1) {
      return this.Kh.contains(var1.gO());
   }

   public BaseImplementation.a b(BaseImplementation.a var1) {
      boolean var2;
      if(!this.isConnected() && !this.gL()) {
         var2 = false;
      } else {
         var2 = true;
      }

      jx.a(var2, "GoogleApiClient is not connected yet.");
      this.gK();

      try {
         this.a((c.d)var1);
         return var1;
      } catch (DeadObjectException var4) {
         this.al(1);
         return var1;
      }
   }

   public ConnectionResult blockingConnect() {
      // $FF: Couldn't be decompiled
   }

   public ConnectionResult blockingConnect(long param1, TimeUnit param3) {
      // $FF: Couldn't be decompiled
   }

   public PendingResult clearDefaultAccountAndReconnect() {
      jx.a(this.isConnected(), "GoogleApiClient is not connected yet.");
      final f var1 = new f(this.JF);
      if(this.Kg.containsKey(kc.DQ)) {
         this.a(this, var1, false);
         return var1;
      } else {
         final AtomicReference var2 = new AtomicReference();
         GoogleApiClient.ConnectionCallbacks var3 = new GoogleApiClient.ConnectionCallbacks() {
            public void onConnected(Bundle var1x) {
               c.this.a((GoogleApiClient)var2.get(), var1, true);
            }

            public void onConnectionSuspended(int var1x) {
            }
         };
         GoogleApiClient.OnConnectionFailedListener var4 = new GoogleApiClient.OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult var1x) {
               var1.b(new Status(8));
            }
         };
         GoogleApiClient var5 = (new GoogleApiClient.Builder(this.mContext)).addApi(kc.API).addConnectionCallbacks(var3).addOnConnectionFailedListener(var4).setHandler(this.Kd).build();
         var2.set(var5);
         var5.connect();
         return var1;
      }
   }

   public void connect() {
      // $FF: Couldn't be decompiled
   }

   public d d(Object var1) {
      jx.b((Object)var1, "Listener must not be null");
      this.zO.lock();

      d var4;
      try {
         var4 = new d(this.JF, var1);
         this.Kj.add(var4);
      } finally {
         this.zO.unlock();
      }

      return var4;
   }

   public void disconnect() {
      this.gM();
      this.al(-1);
   }

   boolean gL() {
      return this.JY;
   }

   public Looper getLooper() {
      return this.JF;
   }

   public boolean isConnected() {
      return this.JX == 2;
   }

   public boolean isConnecting() {
      return this.JX == 1;
   }

   public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks var1) {
      return this.JS.isConnectionCallbacksRegistered(var1);
   }

   public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener var1) {
      return this.JS.isConnectionFailedListenerRegistered(var1);
   }

   public void reconnect() {
      this.disconnect();
      this.connect();
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.JS.registerConnectionCallbacks(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.JS.registerConnectionFailedListener(var1);
   }

   public void stopAutoManage(FragmentActivity var1) {
      boolean var2;
      if(this.JT >= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.a(var2, "Called stopAutoManage but automatic lifecycle management is not enabled.");
      g.a(var1).ao(this.JT);
   }

   public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.JS.unregisterConnectionCallbacks(var1);
   }

   public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.JS.unregisterConnectionFailedListener(var1);
   }

   private static class a extends BroadcastReceiver {
      private WeakReference Ks;

      a(c var1) {
         this.Ks = new WeakReference(var1);
      }

      public void onReceive(Context var1, Intent var2) {
         Uri var4 = var2.getData();
         String var3 = null;
         if(var4 != null) {
            var3 = var4.getSchemeSpecificPart();
         }

         if(var3 != null && var3.equals("com.google.android.gms")) {
            c var5 = (c)this.Ks.get();
            if(var5 != null && !var5.isConnected() && !var5.isConnecting() && var5.gL()) {
               var5.connect();
               return;
            }
         }

      }
   }

   interface b {
      void b(c.d var1);
   }

   private class c extends Handler {
      c(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            c.this.gM();
            return;
         case 2:
            c.this.resume();
            return;
         default:
            Log.w("GoogleApiClientImpl", "Unknown message id: " + var1.what);
         }
      }
   }

   interface d {
      void a(c.b var1);

      void b(Api.a var1) throws DeadObjectException;

      void cancel();

      int gF();

      Api.c gz();

      void l(Status var1);
   }
}
