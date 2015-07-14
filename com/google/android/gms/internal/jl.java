package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.jm;
import com.google.android.gms.internal.jn;
import com.google.android.gms.internal.js;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public abstract class jl implements Api.a, jm.b {
   public static final String[] MP = new String[]{"service_esmobile", "service_googleme"};
   private final Looper JF;
   private final jm JS;
   private IInterface MJ;
   private final ArrayList MK;
   private jl.f ML;
   private int MM;
   private final String[] MN;
   boolean MO;
   private final Context mContext;
   private final Object mH;
   final Handler mHandler;

   protected jl(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
      this.mH = new Object();
      this.MK = new ArrayList();
      this.MM = 1;
      this.MO = false;
      this.mContext = (Context)jx.i(var1);
      this.JF = (Looper)jx.b((Object)var2, "Looper must not be null");
      this.JS = new jm(var1, var2, this);
      this.mHandler = new jl.a(var2);
      this.c(var5);
      this.MN = var5;
      this.registerConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)jx.i(var3));
      this.registerConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener)jx.i(var4));
   }

   @Deprecated
   protected jl(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, String... var4) {
      this(var1, var1.getMainLooper(), new jl.c(var2), new jl.g(var3), var4);
   }

   // $FF: synthetic method
   static jl.f a(jl var0, jl.f var1) {
      var0.ML = var1;
      return var1;
   }

   private void a(int param1, IInterface param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean a(int param1, int param2, IInterface param3) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static ArrayList b(jl var0) {
      return var0.MK;
   }

   // $FF: synthetic method
   static jl.f c(jl var0) {
      return var0.ML;
   }

   // $FF: synthetic method
   static Context d(jl var0) {
      return var0.mContext;
   }

   protected final void N(IBinder var1) {
      try {
         this.a(jt.a.Q(var1), new jl.e(this));
      } catch (DeadObjectException var2) {
         Log.w("GmsClient", "service died");
         this.aD(1);
      } catch (RemoteException var3) {
         Log.w("GmsClient", "Remote exception occurred", var3);
      }
   }

   protected void a(int var1, IBinder var2, Bundle var3) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new jl.h(var1, var2, var3)));
   }

   @Deprecated
   public final void a(jl.b param1) {
      // $FF: Couldn't be decompiled
   }

   protected abstract void a(jt var1, jl.e var2) throws RemoteException;

   public void aD(int var1) {
      this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(var1)));
   }

   protected abstract String bK();

   protected abstract String bL();

   protected void c(String... var1) {
   }

   public void connect() {
      this.MO = true;
      this.a(2, (IInterface)null);
      int var1 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
      if(var1 != 0) {
         this.a(1, (IInterface)null);
         this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(var1)));
      } else {
         if(this.ML != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + this.bK());
            jn.J(this.mContext).b(this.bK(), this.ML);
         }

         this.ML = new jl.f();
         if(!jn.J(this.mContext).a(this.bK(), this.ML)) {
            Log.e("GmsClient", "unable to connect to service: " + this.bK());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
            return;
         }
      }

   }

   protected final void dS() {
      if(!this.isConnected()) {
         throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
      }
   }

   public void disconnect() {
      // $FF: Couldn't be decompiled
   }

   public Bundle fX() {
      return null;
   }

   public boolean gN() {
      return this.MO;
   }

   public final Context getContext() {
      return this.mContext;
   }

   public final Looper getLooper() {
      return this.JF;
   }

   public final String[] hv() {
      return this.MN;
   }

   public final IInterface hw() throws DeadObjectException {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnected() {
      // $FF: Couldn't be decompiled
   }

   public boolean isConnecting() {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks var1) {
      return this.JS.isConnectionCallbacksRegistered(new jl.c(var1));
   }

   @Deprecated
   public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      return this.JS.isConnectionFailedListenerRegistered(var1);
   }

   protected abstract IInterface l(IBinder var1);

   @Deprecated
   public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.JS.registerConnectionCallbacks(new jl.c(var1));
   }

   public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks var1) {
      this.JS.registerConnectionCallbacks(var1);
   }

   @Deprecated
   public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.JS.registerConnectionFailedListener(var1);
   }

   public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener var1) {
      this.JS.registerConnectionFailedListener(var1);
   }

   @Deprecated
   public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks var1) {
      this.JS.unregisterConnectionCallbacks(new jl.c(var1));
   }

   @Deprecated
   public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener var1) {
      this.JS.unregisterConnectionFailedListener(var1);
   }

   final class a extends Handler {
      public a(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         jl.b var2;
         if(var1.what == 1 && !jl.this.isConnecting()) {
            var2 = (jl.b)var1.obj;
            var2.hx();
            var2.unregister();
         } else if(var1.what == 3) {
            jl.this.JS.b(new ConnectionResult(((Integer)var1.obj).intValue(), (PendingIntent)null));
         } else if(var1.what == 4) {
            jl.this.a(4, (IInterface)null);
            jl.this.JS.aE(((Integer)var1.obj).intValue());
            jl.this.a(4, 1, (IInterface)null);
         } else if(var1.what == 2 && !jl.this.isConnected()) {
            var2 = (jl.b)var1.obj;
            var2.hx();
            var2.unregister();
         } else if(var1.what != 2 && var1.what != 1) {
            Log.wtf("GmsClient", "Don\'t know how to handle this message.");
         } else {
            ((jl.b)var1.obj).hy();
         }
      }
   }

   protected abstract class b {
      private boolean MR;
      private Object mListener;

      public b(Object var2) {
         this.mListener = var2;
         this.MR = false;
      }

      protected abstract void g(Object var1);

      protected abstract void hx();

      public void hy() {
         // $FF: Couldn't be decompiled
      }

      public void hz() {
         // $FF: Couldn't be decompiled
      }

      public void unregister() {
         // $FF: Couldn't be decompiled
      }
   }

   public static final class c implements GoogleApiClient.ConnectionCallbacks {
      private final GooglePlayServicesClient.ConnectionCallbacks MS;

      public c(GooglePlayServicesClient.ConnectionCallbacks var1) {
         this.MS = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof jl.c?this.MS.equals(((jl.c)var1).MS):this.MS.equals(var1);
      }

      public void onConnected(Bundle var1) {
         this.MS.onConnected(var1);
      }

      public void onConnectionSuspended(int var1) {
         this.MS.onDisconnected();
      }
   }

   public abstract class d extends jl.b {
      private final DataHolder JG;

      public d(Object var2, DataHolder var3) {
         super();
         this.JG = var3;
      }

      protected abstract void b(Object var1, DataHolder var2);

      protected final void g(Object var1) {
         this.b(var1, this.JG);
      }

      protected void hx() {
         if(this.JG != null) {
            this.JG.close();
         }

      }
   }

   public static final class e extends js.a {
      private jl MT;

      public e(jl var1) {
         this.MT = var1;
      }

      public void b(int var1, IBinder var2, Bundle var3) {
         jx.b((Object)"onPostInitComplete can be called only once per call to getServiceFromBroker", this.MT);
         this.MT.a(var1, var2, var3);
         this.MT = null;
      }
   }

   public final class f implements ServiceConnection {
      public void onServiceConnected(ComponentName var1, IBinder var2) {
         jl.this.N(var2);
      }

      public void onServiceDisconnected(ComponentName var1) {
         jl.this.mHandler.sendMessage(jl.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
      }
   }

   public static final class g implements GoogleApiClient.OnConnectionFailedListener {
      private final GooglePlayServicesClient.OnConnectionFailedListener MU;

      public g(GooglePlayServicesClient.OnConnectionFailedListener var1) {
         this.MU = var1;
      }

      public boolean equals(Object var1) {
         return var1 instanceof jl.g?this.MU.equals(((jl.g)var1).MU):this.MU.equals(var1);
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.MU.onConnectionFailed(var1);
      }
   }

   protected final class h extends jl.b {
      public final Bundle MV;
      public final IBinder MW;
      public final int statusCode;

      public h(int var2, IBinder var3, Bundle var4) {
         super();
         this.statusCode = var2;
         this.MW = var3;
         this.MV = var4;
      }

      protected void b(Boolean param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      protected void g(Object var1) {
         this.b((Boolean)var1);
      }

      protected void hx() {
      }
   }
}
