package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.py;
import com.google.android.gms.internal.qc;
import com.google.android.gms.internal.qf;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;

public class qh extends jl {
   private final String DZ;
   private final int avV;
   private final int mTheme;
   private final Activity nB;

   public qh(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, int var5, String var6, int var7) {
      super(var1, var2, var3, var4, new String[0]);
      this.nB = var1;
      this.avV = var5;
      this.DZ = var6;
      this.mTheme = var7;
   }

   public static Bundle a(int var0, String var1, String var2, int var3) {
      Bundle var4 = new Bundle();
      var4.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", var0);
      var4.putString("androidPackageName", var1);
      if(!TextUtils.isEmpty(var2)) {
         var4.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(var2, "com.google"));
      }

      var4.putInt("com.google.android.gms.wallet.EXTRA_THEME", var3);
      return var4;
   }

   private Bundle rf() {
      return a(this.avV, this.nB.getPackageName(), this.DZ, this.mTheme);
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      var1.k(var2, 6587000, this.getContext().getPackageName());
   }

   public void a(FullWalletRequest var1, int var2) {
      qh.b var3 = new qh.b(var2);
      Bundle var4 = this.rf();

      try {
         ((qc)this.hw()).a((FullWalletRequest)var1, var4, (qf)var3);
      } catch (RemoteException var5) {
         Log.e("WalletClientImpl", "RemoteException getting full wallet", var5);
         var3.a(8, (FullWallet)null, Bundle.EMPTY);
      }
   }

   public void a(MaskedWalletRequest var1, int var2) {
      Bundle var4 = this.rf();
      qh.b var3 = new qh.b(var2);

      try {
         ((qc)this.hw()).a((MaskedWalletRequest)var1, var4, (qf)var3);
      } catch (RemoteException var5) {
         Log.e("WalletClientImpl", "RemoteException getting masked wallet", var5);
         var3.a(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   public void a(NotifyTransactionStatusRequest var1) {
      Bundle var2 = this.rf();

      try {
         ((qc)this.hw()).a(var1, var2);
      } catch (RemoteException var3) {
         ;
      }
   }

   protected String bK() {
      return "com.google.android.gms.wallet.service.BIND";
   }

   protected String bL() {
      return "com.google.android.gms.wallet.internal.IOwService";
   }

   protected qc bV(IBinder var1) {
      return qc.a.bR(var1);
   }

   public void d(String var1, String var2, int var3) {
      Bundle var5 = this.rf();
      qh.b var4 = new qh.b(var3);

      try {
         ((qc)this.hw()).a(var1, var2, var5, var4);
      } catch (RemoteException var6) {
         Log.e("WalletClientImpl", "RemoteException changing masked wallet", var6);
         var4.a(8, (MaskedWallet)null, Bundle.EMPTY);
      }
   }

   public void gk(int var1) {
      Bundle var3 = this.rf();
      qh.b var2 = new qh.b(var1);

      try {
         ((qc)this.hw()).a((Bundle)var3, (qf)var2);
      } catch (RemoteException var4) {
         Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", var4);
         var2.a(8, false, Bundle.EMPTY);
      }
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.bV(var1);
   }

   private static class a extends qf.a {
      private a() {
      }

      // $FF: synthetic method
      a(Object var1) {
         this();
      }

      public void a(int var1, FullWallet var2, Bundle var3) {
      }

      public void a(int var1, MaskedWallet var2, Bundle var3) {
      }

      public void a(int var1, boolean var2, Bundle var3) {
      }

      public void a(Status var1, py var2, Bundle var3) {
      }

      public void i(int var1, Bundle var2) {
      }
   }

   final class b extends qh.a {
      private final int My;

      public b(int var2) {
         super(null);
         this.My = var2;
      }

      public void a(int var1, FullWallet var2, Bundle var3) {
         PendingIntent var5 = null;
         if(var3 != null) {
            var5 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var9 = new ConnectionResult(var1, var5);
         if(var9.hasResolution()) {
            try {
               var9.startResolutionForResult(qh.this.nB, this.My);
            } catch (SendIntentException var6) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var6);
            }
         } else {
            Intent var10 = new Intent();
            byte var4;
            if(var9.isSuccess()) {
               var4 = -1;
               var10.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", var2);
            } else {
               if(var1 == 408) {
                  var4 = 0;
               } else {
                  var4 = 1;
               }

               var10.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", var1);
            }

            PendingIntent var8 = qh.this.nB.createPendingResult(this.My, var10, 1073741824);
            if(var8 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
            } else {
               try {
                  var8.send(var4);
               } catch (CanceledException var7) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var7);
               }
            }
         }
      }

      public void a(int var1, MaskedWallet var2, Bundle var3) {
         PendingIntent var5 = null;
         if(var3 != null) {
            var5 = (PendingIntent)var3.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
         }

         ConnectionResult var9 = new ConnectionResult(var1, var5);
         if(var9.hasResolution()) {
            try {
               var9.startResolutionForResult(qh.this.nB, this.My);
            } catch (SendIntentException var6) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var6);
            }
         } else {
            Intent var10 = new Intent();
            byte var4;
            if(var9.isSuccess()) {
               var4 = -1;
               var10.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", var2);
            } else {
               if(var1 == 408) {
                  var4 = 0;
               } else {
                  var4 = 1;
               }

               var10.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", var1);
            }

            PendingIntent var8 = qh.this.nB.createPendingResult(this.My, var10, 1073741824);
            if(var8 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
            } else {
               try {
                  var8.send(var4);
               } catch (CanceledException var7) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var7);
               }
            }
         }
      }

      public void a(int var1, boolean var2, Bundle var3) {
         Intent var5 = new Intent();
         var5.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", var2);
         PendingIntent var6 = qh.this.nB.createPendingResult(this.My, var5, 1073741824);
         if(var6 == null) {
            Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
         } else {
            try {
               var6.send(-1);
            } catch (CanceledException var4) {
               Log.w("WalletClientImpl", "Exception setting pending result", var4);
            }
         }
      }

      public void i(int var1, Bundle var2) {
         jx.b((Object)var2, "Bundle should not be null");
         ConnectionResult var5 = new ConnectionResult(var1, (PendingIntent)var2.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
         if(var5.hasResolution()) {
            try {
               var5.startResolutionForResult(qh.this.nB, this.My);
            } catch (SendIntentException var3) {
               Log.w("WalletClientImpl", "Exception starting pending intent", var3);
            }
         } else {
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + var5);
            Intent var6 = new Intent();
            var6.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            PendingIntent var7 = qh.this.nB.createPendingResult(this.My, var6, 1073741824);
            if(var7 == null) {
               Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
            } else {
               try {
                  var7.send(1);
               } catch (CanceledException var4) {
                  Log.w("WalletClientImpl", "Exception setting pending result", var4);
               }
            }
         }
      }
   }
}
