package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.lu;
import com.google.android.gms.internal.lz;

public class lv extends jl implements lu {
   private final String DZ;

   public lv(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
      super(var1, var2, var3, var4, var6);
      this.DZ = var5;
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.a(var2, 6587000, this.getContext().getPackageName(), (String)this.DZ, (String[])this.hv(), (Bundle)(new Bundle()));
   }

   protected lz ar(IBinder var1) {
      return lz.a.av(var1);
   }

   protected String bK() {
      return "com.google.android.gms.fitness.GoogleFitnessService.START";
   }

   protected String bL() {
      return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
   }

   public lz jM() throws DeadObjectException {
      return (lz)this.hw();
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.ar(var1);
   }
}
