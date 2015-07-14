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
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;

public class nc extends jl {
   protected final np Ee = new np() {
      public void dS() {
         nc.this.dS();
      }

      // $FF: synthetic method
      public IInterface hw() throws DeadObjectException {
         return this.nh();
      }

      public ni nh() throws DeadObjectException {
         return (ni)nc.this.hw();
      }
   };
   private final String agD;

   public nc(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5) {
      super(var1, var2, var3, var4, new String[0]);
      this.agD = var5;
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      Bundle var3 = new Bundle();
      var3.putString("client_name", this.agD);
      var1.e(var2, 6587000, this.getContext().getPackageName(), var3);
   }

   protected ni aM(IBinder var1) {
      return ni.a.aO(var1);
   }

   protected String bK() {
      return "com.google.android.location.internal.GoogleLocationManagerService.START";
   }

   protected String bL() {
      return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.aM(var1);
   }
}
