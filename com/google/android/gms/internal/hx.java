package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.hu;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;

public class hx extends jl {
   public hx(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
      super(var1, var2, var3, var4, new String[0]);
   }

   protected hu G(IBinder var1) {
      return hu.a.E(var1);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.b(var2, 6587000, this.getContext().getPackageName());
   }

   protected String bK() {
      return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
   }

   protected String bL() {
      return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
   }

   public hu fH() throws DeadObjectException {
      return (hu)this.hw();
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.G(var1);
   }
}
