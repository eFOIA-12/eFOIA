package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.af;
import com.google.android.gms.wearable.internal.ag;
import com.google.android.gms.wearable.internal.az;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ba extends jl {
   private final ExecutorService asJ = Executors.newCachedThreadPool();
   private final ag ayg = new ag.b();
   private final ag ayh = new ag.c();
   private final ag ayi = new ag.d();

   public ba(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   private FutureTask a(final ParcelFileDescriptor var1, final byte[] var2) {
      return new FutureTask(new Callable() {
         // $FF: synthetic method
         public Object call() throws Exception {
            return this.rr();
         }

         public Boolean rr() {
            if(Log.isLoggable("WearableClient", 3)) {
               Log.d("WearableClient", "processAssets: writing data to FD : " + var1);
            }

            AutoCloseOutputStream var1x = new AutoCloseOutputStream(var1);

            try {
               var1x.write(var2);
               var1x.flush();
               if(Log.isLoggable("WearableClient", 3)) {
                  Log.d("WearableClient", "processAssets: wrote data: " + var1);
               }

               Boolean var2x = Boolean.valueOf(true);
               return var2x;
            } catch (IOException var9) {
               Log.w("WearableClient", "processAssets: writing data failed: " + var1);
            } finally {
               try {
                  if(Log.isLoggable("WearableClient", 3)) {
                     Log.d("WearableClient", "processAssets: closing: " + var1);
                  }

                  var1x.close();
               } catch (IOException var8) {
                  ;
               }

            }

            return Boolean.valueOf(false);
         }
      });
   }

   protected void a(int var1, IBinder var2, Bundle var3) {
      if(Log.isLoggable("WearableClient", 2)) {
         Log.d("WearableClient", "onPostInitHandler: statusCode " + var1);
      }

      if(var1 == 0) {
         this.ayg.ca(var2);
         this.ayh.ca(var2);
         this.ayi.ca(var2);
      }

      super.a(var1, var2, var3);
   }

   public void a(BaseImplementation.b var1, Uri var2) throws RemoteException {
      ((af)this.hw()).a(new az.d(var1), (Uri)var2);
   }

   public void a(BaseImplementation.b var1, Asset var2) throws RemoteException {
      ((af)this.hw()).a(new az.f(var1), (Asset)var2);
   }

   public void a(BaseImplementation.b var1, DataApi.DataListener var2) throws RemoteException {
      this.ayg.a(this, var1, var2);
   }

   public void a(BaseImplementation.b var1, DataApi.DataListener var2, IntentFilter[] var3) throws RemoteException {
      this.ayg.a(this, var1, var2, var3);
   }

   public void a(BaseImplementation.b var1, DataItemAsset var2) throws RemoteException {
      this.a(var1, Asset.createFromRef(var2.getId()));
   }

   public void a(BaseImplementation.b var1, MessageApi.MessageListener var2) throws RemoteException {
      this.ayh.a(this, var1, var2);
   }

   public void a(BaseImplementation.b var1, MessageApi.MessageListener var2, IntentFilter[] var3) throws RemoteException {
      this.ayh.a(this, var1, var2, var3);
   }

   public void a(BaseImplementation.b var1, NodeApi.NodeListener var2) throws RemoteException, RemoteException {
      this.ayi.a(this, var1, var2, (IntentFilter[])null);
   }

   public void a(BaseImplementation.b var1, PutDataRequest var2) throws RemoteException {
      Iterator var3 = var2.getAssets().entrySet().iterator();

      Asset var4;
      do {
         if(!var3.hasNext()) {
            PutDataRequest var11 = PutDataRequest.k(var2.getUri());
            var11.setData(var2.getData());
            ArrayList var12 = new ArrayList();
            Iterator var5 = var2.getAssets().entrySet().iterator();

            while(var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               Asset var7 = (Asset)var6.getValue();
               if(var7.getData() == null) {
                  var11.putAsset((String)var6.getKey(), (Asset)var6.getValue());
               } else {
                  ParcelFileDescriptor[] var8;
                  try {
                     var8 = ParcelFileDescriptor.createPipe();
                  } catch (IOException var10) {
                     throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + var2, var10);
                  }

                  if(Log.isLoggable("WearableClient", 3)) {
                     Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + var7 + " read:" + var8[0] + " write:" + var8[1]);
                  }

                  var11.putAsset((String)var6.getKey(), Asset.createFromFd(var8[0]));
                  FutureTask var13 = this.a(var8[1], var7.getData());
                  var12.add(var13);
                  this.asJ.submit(var13);
               }
            }

            try {
               ((af)this.hw()).a(new az.i(var1, var12), (PutDataRequest)var11);
               return;
            } catch (NullPointerException var9) {
               throw new IllegalStateException("Unable to putDataItem: " + var2, var9);
            }
         }

         var4 = (Asset)((Entry)var3.next()).getValue();
      } while(var4.getData() != null || var4.getDigest() != null || var4.getFd() != null || var4.getUri() != null);

      throw new IllegalArgumentException("Put for " + var2.getUri() + " contains invalid asset: " + var4);
   }

   public void a(BaseImplementation.b var1, String var2, String var3, byte[] var4) throws RemoteException {
      ((af)this.hw()).a(new az.j(var1), var2, var3, var4);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.e(var2, 6587000, this.getContext().getPackageName());
   }

   public void b(BaseImplementation.b var1, Uri var2) throws RemoteException {
      ((af)this.hw()).b(new az.e(var1), (Uri)var2);
   }

   public void b(BaseImplementation.b var1, NodeApi.NodeListener var2) throws RemoteException {
      this.ayi.a(this, var1, var2);
   }

   protected String bK() {
      return "com.google.android.gms.wearable.BIND";
   }

   protected String bL() {
      return "com.google.android.gms.wearable.internal.IWearableService";
   }

   public void c(BaseImplementation.b var1, Uri var2) throws RemoteException {
      ((af)this.hw()).c(new az.b(var1), (Uri)var2);
   }

   protected af cb(IBinder var1) {
      return af.a.bZ(var1);
   }

   public void disconnect() {
      this.ayg.b(this);
      this.ayh.b(this);
      this.ayi.b(this);
      super.disconnect();
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.cb(var1);
   }

   public void n(BaseImplementation.b var1) throws RemoteException {
      ((af)this.hw()).b(new az.e(var1));
   }

   public void o(BaseImplementation.b var1) throws RemoteException {
      ((af)this.hw()).c(new az.g(var1));
   }

   public void p(BaseImplementation.b var1) throws RemoteException {
      ((af)this.hw()).d(new az.c(var1));
   }
}
