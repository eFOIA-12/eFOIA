package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.jx;

public class g extends Fragment implements OnCancelListener, LoaderManager.LoaderCallbacks {
   private boolean KC;
   private int KD = -1;
   private ConnectionResult KE;
   private final Handler KF = new Handler(Looper.getMainLooper());
   private final SparseArray KG = new SparseArray();

   public static g a(FragmentActivity var0) {
      jx.aU("Must be called from main thread of process");
      FragmentManager var2 = var0.getSupportFragmentManager();

      g var1;
      try {
         var1 = (g)var2.findFragmentByTag("GmsSupportLifecycleFragment");
      } catch (ClassCastException var3) {
         throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", var3);
      }

      g var4;
      if(var1 != null) {
         var4 = var1;
         if(!var1.isRemoving()) {
            return var4;
         }
      }

      var4 = new g();
      var2.beginTransaction().add(var4, "GmsSupportLifecycleFragment").commit();
      var2.executePendingTransactions();
      return var4;
   }

   private void a(int var1, ConnectionResult var2) {
      if(!this.KC) {
         this.KC = true;
         this.KD = var1;
         this.KE = var2;
         this.KF.post(new g.c(var1, var2));
      }

   }

   private void aq(int var1) {
      if(var1 == this.KD) {
         this.gR();
      }

   }

   private void b(int var1, ConnectionResult var2) {
      Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
      g.b var3 = (g.b)this.KG.get(var1);
      if(var3 != null) {
         this.ao(var1);
         GoogleApiClient.OnConnectionFailedListener var4 = var3.KK;
         if(var4 != null) {
            var4.onConnectionFailed(var2);
         }
      }

      this.gR();
   }

   private void gR() {
      int var1 = 0;
      this.KC = false;
      this.KD = -1;
      this.KE = null;

      for(LoaderManager var3 = this.getLoaderManager(); var1 < this.KG.size(); ++var1) {
         int var2 = this.KG.keyAt(var1);
         g.a var4 = this.ap(var2);
         if(var4 != null) {
            var4.gS();
         }

         var3.initLoader(var2, (Bundle)null, this);
      }

   }

   public void a(int var1, GoogleApiClient var2, GoogleApiClient.OnConnectionFailedListener var3) {
      jx.b((Object)var2, "GoogleApiClient instance cannot be null");
      boolean var4;
      if(this.KG.indexOfKey(var1) < 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.a(var4, "Already managing a GoogleApiClient with id " + var1);
      g.b var5 = new g.b(var2, var3, null);
      this.KG.put(var1, var5);
      if(this.getActivity() != null) {
         this.getLoaderManager().initLoader(var1, (Bundle)null, this);
      }

   }

   public void a(Loader var1, ConnectionResult var2) {
      if(var2.isSuccess()) {
         this.aq(var1.getId());
      } else {
         this.a(var1.getId(), var2);
      }
   }

   public GoogleApiClient an(int var1) {
      if(this.getActivity() != null) {
         g.a var2 = this.ap(var1);
         if(var2 != null) {
            return var2.KH;
         }
      }

      return null;
   }

   public void ao(int var1) {
      this.getLoaderManager().destroyLoader(var1);
      this.KG.remove(var1);
   }

   g.a ap(int var1) {
      try {
         g.a var2 = (g.a)this.getLoaderManager().getLoader(var1);
         return var2;
      } catch (ClassCastException var3) {
         throw new IllegalStateException("Unknown loader in SupportLifecycleFragment", var3);
      }
   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      boolean var5;
      label21: {
         boolean var4 = true;
         switch(var1) {
         case 1:
            if(var2 == -1) {
               var5 = var4;
               break label21;
            }
            break;
         case 2:
            if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.getActivity()) == 0) {
               var5 = var4;
               break label21;
            }
         }

         var5 = false;
      }

      if(var5) {
         this.gR();
      } else {
         this.b(this.KD, this.KE);
      }
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);

      for(int var2 = 0; var2 < this.KG.size(); ++var2) {
         int var3 = this.KG.keyAt(var2);
         g.a var4 = this.ap(var3);
         if(var4 != null && ((g.b)this.KG.valueAt(var2)).KH != var4.KH) {
            this.getLoaderManager().restartLoader(var3, (Bundle)null, this);
         } else {
            this.getLoaderManager().initLoader(var3, (Bundle)null, this);
         }
      }

   }

   public void onCancel(DialogInterface var1) {
      this.b(this.KD, this.KE);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         this.KC = var1.getBoolean("resolving_error", false);
         this.KD = var1.getInt("failed_client_id", -1);
         if(this.KD >= 0) {
            this.KE = new ConnectionResult(var1.getInt("failed_status"), (PendingIntent)var1.getParcelable("failed_resolution"));
         }
      }

   }

   public Loader onCreateLoader(int var1, Bundle var2) {
      return new g.a(this.getActivity(), ((g.b)this.KG.get(var1)).KH);
   }

   // $FF: synthetic method
   public void onLoadFinished(Loader var1, Object var2) {
      this.a(var1, (ConnectionResult)var2);
   }

   public void onLoaderReset(Loader var1) {
      if(var1.getId() == this.KD) {
         this.gR();
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putBoolean("resolving_error", this.KC);
      if(this.KD >= 0) {
         var1.putInt("failed_client_id", this.KD);
         var1.putInt("failed_status", this.KE.getErrorCode());
         var1.putParcelable("failed_resolution", this.KE.getResolution());
      }

   }

   public void onStart() {
      super.onStart();
      if(!this.KC) {
         for(int var1 = 0; var1 < this.KG.size(); ++var1) {
            this.getLoaderManager().initLoader(this.KG.keyAt(var1), (Bundle)null, this);
         }
      }

   }

   static class a extends Loader implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
      public final GoogleApiClient KH;
      private boolean KI;
      private ConnectionResult KJ;

      public a(Context var1, GoogleApiClient var2) {
         super(var1);
         this.KH = var2;
      }

      private void a(ConnectionResult var1) {
         this.KJ = var1;
         if(this.isStarted() && !this.isAbandoned()) {
            this.deliverResult(var1);
         }

      }

      public void gS() {
         if(this.KI) {
            this.KI = false;
            if(this.isStarted() && !this.isAbandoned()) {
               this.KH.connect();
            }
         }

      }

      public void onConnected(Bundle var1) {
         this.KI = false;
         this.a(ConnectionResult.Iu);
      }

      public void onConnectionFailed(ConnectionResult var1) {
         this.KI = true;
         this.a(var1);
      }

      public void onConnectionSuspended(int var1) {
      }

      protected void onReset() {
         this.KJ = null;
         this.KI = false;
         this.KH.unregisterConnectionCallbacks(this);
         this.KH.unregisterConnectionFailedListener(this);
         this.KH.disconnect();
      }

      protected void onStartLoading() {
         super.onStartLoading();
         this.KH.registerConnectionCallbacks(this);
         this.KH.registerConnectionFailedListener(this);
         if(this.KJ != null) {
            this.deliverResult(this.KJ);
         }

         if(!this.KH.isConnected() && !this.KH.isConnecting() && !this.KI) {
            this.KH.connect();
         }

      }

      protected void onStopLoading() {
         this.KH.disconnect();
      }
   }

   private static class b {
      public final GoogleApiClient KH;
      public final GoogleApiClient.OnConnectionFailedListener KK;

      private b(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2) {
         this.KH = var1;
         this.KK = var2;
      }

      // $FF: synthetic method
      b(GoogleApiClient var1, GoogleApiClient.OnConnectionFailedListener var2, Object var3) {
         this(var1, var2);
      }
   }

   private class c implements Runnable {
      private final int KL;
      private final ConnectionResult KM;

      public c(int var2, ConnectionResult var3) {
         this.KL = var2;
         this.KM = var3;
      }

      public void run() {
         if(this.KM.hasResolution()) {
            try {
               int var1 = g.this.getActivity().getSupportFragmentManager().getFragments().indexOf(g.this);
               this.KM.startResolutionForResult(g.this.getActivity(), (var1 + 1 << 16) + 1);
            } catch (SendIntentException var3) {
               g.this.gR();
            }
         } else if(GooglePlayServicesUtil.isUserRecoverableError(this.KM.getErrorCode())) {
            GooglePlayServicesUtil.showErrorDialogFragment(this.KM.getErrorCode(), g.this.getActivity(), g.this, 2, g.this);
         } else {
            g.this.b(this.KL, this.KM);
         }
      }
   }
}
