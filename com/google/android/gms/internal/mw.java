package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.mx;
import com.google.android.gms.internal.my;

public class mw extends jl {
   private final String DZ;
   private mw.a afJ;
   private final int mTheme;
   private Activity nB;

   public mw(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, int var6) {
      super(var1, var2, var3, var4, new String[0]);
      this.DZ = var5;
      this.nB = var1;
      this.mTheme = var6;
   }

   public void a(UserAddressRequest var1, int var2) {
      this.ne();
      this.afJ = new mw.a(var2, this.nB);

      try {
         Bundle var3 = new Bundle();
         var3.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", this.getContext().getPackageName());
         if(!TextUtils.isEmpty(this.DZ)) {
            var3.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.DZ, "com.google"));
         }

         var3.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
         this.nd().a(this.afJ, var1, var3);
      } catch (RemoteException var4) {
         Log.e("AddressClientImpl", "Exception requesting user address", var4);
         Bundle var5 = new Bundle();
         var5.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
         this.afJ.g(1, var5);
      }
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.d(var2, 6587000, this.getContext().getPackageName());
   }

   protected my aI(IBinder var1) {
      return my.a.aK(var1);
   }

   protected String bK() {
      return "com.google.android.gms.identity.service.BIND";
   }

   protected String bL() {
      return "com.google.android.gms.identity.intents.internal.IAddressService";
   }

   public void disconnect() {
      super.disconnect();
      if(this.afJ != null) {
         this.afJ.setActivity((Activity)null);
         this.afJ = null;
      }

   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.aI(var1);
   }

   protected my nd() throws DeadObjectException {
      return (my)super.hw();
   }

   protected void ne() {
      super.dS();
   }

   public static final class a extends mx.a {
      private final int My;
      private Activity nB;

      public a(int var1, Activity var2) {
         this.My = var1;
         this.nB = var2;
      }

      private void setActivity(Activity var1) {
         this.nB = var1;
      }

      public void g(int param1, Bundle param2) {
         // $FF: Couldn't be decompiled
      }
   }
}
