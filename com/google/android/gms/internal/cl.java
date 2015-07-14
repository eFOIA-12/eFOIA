package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.cm;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;

@ey
public class cl extends jl {
   final int qg;

   public cl(Context var1, GoogleApiClient.ConnectionCallbacks var2, GoogleApiClient.OnConnectionFailedListener var3, int var4) {
      super(var1, var1.getMainLooper(), var2, var3, new String[0]);
      this.qg = var4;
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var1.g(var2, this.qg, this.getContext().getPackageName(), var3);
   }

   protected String bK() {
      return "com.google.android.gms.ads.gservice.START";
   }

   protected String bL() {
      return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
   }

   public cm bM() throws DeadObjectException {
      return (cm)super.hw();
   }

   protected cm k(IBinder var1) {
      return cm.a.m(var1);
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.k(var1);
   }
}
