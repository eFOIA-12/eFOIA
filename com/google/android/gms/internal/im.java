package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.io;
import com.google.android.gms.internal.iq;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.is;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class im extends jl {
   private static final Object HB = new Object();
   private static final Object HC = new Object();
   private static final is Hh = new is("CastClientImpl");
   private final Cast.Listener FD;
   private double Gp;
   private boolean Gq;
   private BaseImplementation.b HA;
   private ApplicationMetadata Hi;
   private final CastDevice Hj;
   private final Map Hk;
   private final long Hl;
   private im.c Hm;
   private String Hn;
   private boolean Ho;
   private boolean Hp;
   private boolean Hq;
   private int Hr;
   private int Hs;
   private final AtomicLong Ht;
   private String Hu;
   private String Hv;
   private Bundle Hw;
   private final Map Hx;
   private final im.b Hy;
   private BaseImplementation.b Hz;
   private final Handler mHandler;

   public im(Context var1, Looper var2, CastDevice var3, long var4, Cast.Listener var6, GoogleApiClient.ConnectionCallbacks var7, GoogleApiClient.OnConnectionFailedListener var8) {
      super(var1, var2, var7, var8, (String[])null);
      this.Hj = var3;
      this.FD = var6;
      this.Hl = var4;
      this.mHandler = new Handler(var2);
      this.Hk = new HashMap();
      this.Ht = new AtomicLong(0L);
      this.Hx = new HashMap();
      this.fW();
      this.Hy = new im.b(null);
      this.registerConnectionFailedListener(this.Hy);
   }

   // $FF: synthetic method
   static ApplicationMetadata a(im var0, ApplicationMetadata var1) {
      var0.Hi = var1;
      return var1;
   }

   // $FF: synthetic method
   static BaseImplementation.b a(im var0, BaseImplementation.b var1) {
      var0.Hz = var1;
      return var1;
   }

   private void a(ij var1) {
      String var3 = var1.fT();
      boolean var2;
      if(!in.a(var3, this.Hn)) {
         this.Hn = var3;
         var2 = true;
      } else {
         var2 = false;
      }

      Hh.b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[]{Boolean.valueOf(var2), Boolean.valueOf(this.Ho)});
      if(this.FD != null && (var2 || this.Ho)) {
         this.FD.onApplicationStatusChanged();
      }

      this.Ho = false;
   }

   private void a(io var1) {
      ApplicationMetadata var7 = var1.getApplicationMetadata();
      if(!in.a(var7, this.Hi)) {
         this.Hi = var7;
         this.FD.onApplicationMetadataChanged(this.Hi);
      }

      double var2 = var1.fZ();
      boolean var5;
      if(var2 != Double.NaN && var2 != this.Gp) {
         this.Gp = var2;
         var5 = true;
      } else {
         var5 = false;
      }

      boolean var6 = var1.gi();
      if(var6 != this.Gq) {
         this.Gq = var6;
         var5 = true;
      }

      Hh.b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(var5), Boolean.valueOf(this.Hp)});
      if(this.FD != null && (var5 || this.Hp)) {
         this.FD.onVolumeChanged();
      }

      int var4 = var1.gj();
      if(var4 != this.Hr) {
         this.Hr = var4;
         var5 = true;
      } else {
         var5 = false;
      }

      Hh.b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(var5), Boolean.valueOf(this.Hp)});
      if(this.FD != null && (var5 || this.Hp)) {
         this.FD.X(this.Hr);
      }

      var4 = var1.gk();
      if(var4 != this.Hs) {
         this.Hs = var4;
         var5 = true;
      } else {
         var5 = false;
      }

      Hh.b("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(var5), Boolean.valueOf(this.Hp)});
      if(this.FD != null && (var5 || this.Hp)) {
         this.FD.Y(this.Hs);
      }

      this.Hp = false;
   }

   // $FF: synthetic method
   static BaseImplementation.b b(im var0, BaseImplementation.b var1) {
      var0.HA = var1;
      return var1;
   }

   private void c(BaseImplementation.b param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static BaseImplementation.b d(im var0) {
      return var0.Hz;
   }

   private void e(BaseImplementation.b param1) {
      // $FF: Couldn't be decompiled
   }

   private void fW() {
      this.Hq = false;
      this.Hr = -1;
      this.Hs = -1;
      this.Hi = null;
      this.Hn = null;
      this.Gp = 0.0D;
      this.Gq = false;
   }

   // $FF: synthetic method
   static Map g(im var0) {
      return var0.Hk;
   }

   private void ga() {
      // $FF: Couldn't be decompiled
   }

   private void gb() throws IllegalStateException {
      if(!this.Hq || this.Hm == null || this.Hm.gh()) {
         throw new IllegalStateException("Not connected to a device");
      }
   }

   // $FF: synthetic method
   static Object ge() {
      return HB;
   }

   // $FF: synthetic method
   static Object gf() {
      return HC;
   }

   // $FF: synthetic method
   static CastDevice h(im var0) {
      return var0.Hj;
   }

   // $FF: synthetic method
   static Map i(im var0) {
      return var0.Hx;
   }

   // $FF: synthetic method
   static BaseImplementation.b j(im var0) {
      return var0.HA;
   }

   public void I(boolean var1) throws IllegalStateException, RemoteException {
      ((iq)this.hw()).a(var1, this.Gp, this.Gq);
   }

   protected iq L(IBinder var1) {
      return iq.a.M(var1);
   }

   public void a(double var1) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(!Double.isInfinite(var1) && !Double.isNaN(var1)) {
         ((iq)this.hw()).a(var1, this.Gp, this.Gq);
      } else {
         throw new IllegalArgumentException("Volume cannot be " + var1);
      }
   }

   protected void a(int var1, IBinder var2, Bundle var3) {
      Hh.b("in onPostInitHandler; statusCode=%d", new Object[]{Integer.valueOf(var1)});
      if(var1 != 0 && var1 != 1001) {
         this.Hq = false;
      } else {
         this.Hq = true;
         this.Ho = true;
         this.Hp = true;
      }

      int var4 = var1;
      if(var1 == 1001) {
         this.Hw = new Bundle();
         this.Hw.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
         var4 = 0;
      }

      super.a(var4, var2, var3);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = new Bundle();
      Hh.b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", new Object[]{this.Hu, this.Hv});
      this.Hj.putInBundle(var3);
      var3.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.Hl);
      if(this.Hu != null) {
         var3.putString("last_application_id", this.Hu);
         if(this.Hv != null) {
            var3.putString("last_session_id", this.Hv);
         }
      }

      this.Hm = new im.c(null);
      var1.a(var2, 6587000, this.getContext().getPackageName(), (IBinder)this.Hm.asBinder(), (Bundle)var3);
   }

   public void a(String param1, Cast.MessageReceivedCallback param2) throws IllegalArgumentException, IllegalStateException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void a(String var1, LaunchOptions var2, BaseImplementation.b var3) throws IllegalStateException, RemoteException {
      this.c(var3);
      ((iq)this.hw()).a(var1, var2);
   }

   public void a(String var1, BaseImplementation.b var2) throws IllegalStateException, RemoteException {
      this.e(var2);
      ((iq)this.hw()).aH(var1);
   }

   public void a(String var1, String var2, BaseImplementation.b var3) throws IllegalArgumentException, IllegalStateException, RemoteException {
      if(TextUtils.isEmpty(var2)) {
         throw new IllegalArgumentException("The message payload cannot be null or empty");
      } else if(var2.length() > 65536) {
         throw new IllegalArgumentException("Message exceeds maximum size");
      } else {
         in.aF(var1);
         this.gb();
         long var4 = this.Ht.incrementAndGet();

         try {
            this.Hx.put(Long.valueOf(var4), var3);
            ((iq)this.hw()).a(var1, var2, var4);
         } catch (Throwable var6) {
            this.Hx.remove(Long.valueOf(var4));
            throw var6;
         }
      }
   }

   public void a(String var1, boolean var2, BaseImplementation.b var3) throws IllegalStateException, RemoteException {
      this.c(var3);
      ((iq)this.hw()).g(var1, var2);
   }

   public void aE(String param1) throws IllegalArgumentException, RemoteException {
      // $FF: Couldn't be decompiled
   }

   public void b(String var1, String var2, BaseImplementation.b var3) throws IllegalStateException, RemoteException {
      this.c(var3);
      ((iq)this.hw()).k(var1, var2);
   }

   protected String bK() {
      return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
   }

   protected String bL() {
      return "com.google.android.gms.cast.internal.ICastDeviceController";
   }

   public void d(BaseImplementation.b var1) throws IllegalStateException, RemoteException {
      this.e(var1);
      ((iq)this.hw()).gl();
   }

   public void disconnect() {
      Hh.b("disconnect(); ServiceListener=%s, isConnected=%b", new Object[]{this.Hm, Boolean.valueOf(this.isConnected())});
      im.c var1 = this.Hm;
      this.Hm = null;
      if(var1 != null && var1.gg()) {
         this.ga();

         try {
            if(this.isConnected() || this.isConnecting()) {
               ((iq)this.hw()).disconnect();
            }

            return;
         } catch (RemoteException var4) {
            Hh.a(var4, "Error while disconnecting the controller interface: %s", new Object[]{var4.getMessage()});
         } finally {
            super.disconnect();
         }

      } else {
         Hh.b("already disposed, so short-circuiting", new Object[0]);
      }
   }

   public Bundle fX() {
      if(this.Hw != null) {
         Bundle var1 = this.Hw;
         this.Hw = null;
         return var1;
      } else {
         return super.fX();
      }
   }

   public void fY() throws IllegalStateException, RemoteException {
      ((iq)this.hw()).fY();
   }

   public double fZ() throws IllegalStateException {
      this.gb();
      return this.Gp;
   }

   public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
      this.gb();
      return this.Hi;
   }

   public String getApplicationStatus() throws IllegalStateException {
      this.gb();
      return this.Hn;
   }

   public boolean isMute() throws IllegalStateException {
      this.gb();
      return this.Gq;
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.L(var1);
   }

   private static final class a implements Cast.ApplicationConnectionResult {
      private final Status Eb;
      private final ApplicationMetadata HD;
      private final String HE;
      private final boolean HF;
      private final String vZ;

      public a(Status var1) {
         this(var1, (ApplicationMetadata)null, (String)null, (String)null, false);
      }

      public a(Status var1, ApplicationMetadata var2, String var3, String var4, boolean var5) {
         this.Eb = var1;
         this.HD = var2;
         this.HE = var3;
         this.vZ = var4;
         this.HF = var5;
      }

      public ApplicationMetadata getApplicationMetadata() {
         return this.HD;
      }

      public String getApplicationStatus() {
         return this.HE;
      }

      public String getSessionId() {
         return this.vZ;
      }

      public Status getStatus() {
         return this.Eb;
      }

      public boolean getWasLaunched() {
         return this.HF;
      }
   }

   private class b implements GoogleApiClient.OnConnectionFailedListener {
      private b() {
      }

      // $FF: synthetic method
      b(Object var2) {
         this();
      }

      public void onConnectionFailed(ConnectionResult var1) {
         im.this.ga();
      }
   }

   private class c extends ir.a {
      private final AtomicBoolean HH;

      private c() {
         this.HH = new AtomicBoolean(false);
      }

      // $FF: synthetic method
      c(Object var2) {
         this();
      }

      private boolean ah(int param1) {
         // $FF: Couldn't be decompiled
      }

      private void c(long param1, int param3) {
         // $FF: Couldn't be decompiled
      }

      public void a(ApplicationMetadata param1, String param2, String param3, boolean param4) {
         // $FF: Couldn't be decompiled
      }

      public void a(String var1, double var2, boolean var4) {
         im.Hh.b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
      }

      public void a(String var1, long var2) {
         if(!this.HH.get()) {
            this.c(var2, 0);
         }
      }

      public void a(String var1, long var2, int var4) {
         if(!this.HH.get()) {
            this.c(var2, var4);
         }
      }

      public void ad(int var1) {
         if(this.gg()) {
            im.Hh.b("ICastDeviceControllerListener.onDisconnected: %d", new Object[]{Integer.valueOf(var1)});
            if(var1 != 0) {
               im.this.aD(2);
               return;
            }
         }

      }

      public void ae(int param1) {
         // $FF: Couldn't be decompiled
      }

      public void af(int var1) {
         if(!this.HH.get()) {
            this.ah(var1);
         }
      }

      public void ag(int var1) {
         if(!this.HH.get()) {
            this.ah(var1);
         }
      }

      public void b(final ij var1) {
         if(!this.HH.get()) {
            im.Hh.b("onApplicationStatusChanged", new Object[0]);
            im.this.mHandler.post(new Runnable() {
               public void run() {
                  im.this.a(var1);
               }
            });
         }
      }

      public void b(final io var1) {
         if(!this.HH.get()) {
            im.Hh.b("onDeviceStatusChanged", new Object[0]);
            im.this.mHandler.post(new Runnable() {
               public void run() {
                  im.this.a(var1);
               }
            });
         }
      }

      public void b(String var1, byte[] var2) {
         if(!this.HH.get()) {
            im.Hh.b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", new Object[]{var1, Integer.valueOf(var2.length)});
         }
      }

      public boolean gg() {
         if(this.HH.getAndSet(true)) {
            return false;
         } else {
            im.this.fW();
            return true;
         }
      }

      public boolean gh() {
         return this.HH.get();
      }

      public void j(final String var1, final String var2) {
         if(!this.HH.get()) {
            im.Hh.b("Receive (type=text, ns=%s) %s", new Object[]{var1, var2});
            im.this.mHandler.post(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
         }
      }

      public void onApplicationDisconnected(final int var1) {
         if(!this.HH.get()) {
            im.this.Hu = null;
            im.this.Hv = null;
            this.ah(var1);
            if(im.this.FD != null) {
               im.this.mHandler.post(new Runnable() {
                  public void run() {
                     if(im.this.FD != null) {
                        im.this.FD.onApplicationDisconnected(var1);
                     }

                  }
               });
               return;
            }
         }

      }
   }
}
