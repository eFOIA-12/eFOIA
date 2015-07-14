package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.ki;

public class kg extends jl {
   public kg(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String... var5) {
      super(var1, var2, var3, var4, var5);
   }

   protected ki T(IBinder var1) {
      return ki.a.V(var1);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.j(var2, 6587000, this.getContext().getPackageName());
   }

   public String bK() {
      return "com.google.android.gms.common.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.common.internal.service.ICommonService";
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.T(var1);
   }
}
