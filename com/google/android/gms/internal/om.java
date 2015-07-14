package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ok;

public class om extends jl {
   public om(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, (String[])null);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.a(var2, 6587000, this.getContext().getPackageName(), (Bundle)var3);
   }

   public ok bH(IBinder var1) {
      return ok.a.bG(var1);
   }

   protected String bK() {
      return "com.google.android.gms.panorama.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.panorama.internal.IPanoramaService";
   }

   // $FF: synthetic method
   public IInterface l(IBinder var1) {
      return this.bH(var1);
   }
}
