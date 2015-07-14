package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb;
import com.google.android.gms.internal.qi;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.fragment.WalletFragmentInitParams;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle;

public final class WalletFragment extends Fragment {
   private final Fragment TG = this;
   private WalletFragmentOptions awe;
   private WalletFragmentInitParams awf;
   private MaskedWalletRequest awg;
   private MaskedWallet awh;
   private Boolean awi;
   private WalletFragment.b awn;
   private final com.google.android.gms.dynamic.b awo = com.google.android.gms.dynamic.b.a(this);
   private final WalletFragment.c awp = new WalletFragment.c(null);
   private WalletFragment.a awq = new WalletFragment.a(this);
   private boolean mCreated = false;

   public static WalletFragment newInstance(WalletFragmentOptions var0) {
      WalletFragment var1 = new WalletFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("extraWalletFragmentOptions", var0);
      var1.TG.setArguments(var2);
      return var1;
   }

   public int getState() {
      return this.awn != null?this.awn.getState():0;
   }

   public void initialize(WalletFragmentInitParams var1) {
      if(this.awn != null) {
         this.awn.initialize(var1);
         this.awf = null;
      } else {
         if(this.awf != null) {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
            return;
         }

         this.awf = var1;
         if(this.awg != null) {
            Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
         }

         if(this.awh != null) {
            Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            return;
         }
      }

   }

   public void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(this.awn != null) {
         this.awn.onActivityResult(var1, var2, var3);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(var1 != null) {
         var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
         WalletFragmentInitParams var2 = (WalletFragmentInitParams)var1.getParcelable("walletFragmentInitParams");
         if(var2 != null) {
            if(this.awf != null) {
               Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
            }

            this.awf = var2;
         }

         if(this.awg == null) {
            this.awg = (MaskedWalletRequest)var1.getParcelable("maskedWalletRequest");
         }

         if(this.awh == null) {
            this.awh = (MaskedWallet)var1.getParcelable("maskedWallet");
         }

         if(var1.containsKey("walletFragmentOptions")) {
            this.awe = (WalletFragmentOptions)var1.getParcelable("walletFragmentOptions");
         }

         if(var1.containsKey("enabled")) {
            this.awi = Boolean.valueOf(var1.getBoolean("enabled"));
         }
      } else if(this.TG.getArguments() != null) {
         WalletFragmentOptions var3 = (WalletFragmentOptions)this.TG.getArguments().getParcelable("extraWalletFragmentOptions");
         if(var3 != null) {
            var3.ab(this.TG.getActivity());
            this.awe = var3;
         }
      }

      this.mCreated = true;
      this.awp.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.awp.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      super.onDestroy();
      this.mCreated = false;
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      if(this.awe == null) {
         this.awe = WalletFragmentOptions.a((Context)var1, (AttributeSet)var2);
      }

      Bundle var4 = new Bundle();
      var4.putParcelable("attrKeyWalletFragmentOptions", this.awe);
      this.awp.onInflate(var1, var4, var3);
   }

   public void onPause() {
      super.onPause();
      this.awp.onPause();
   }

   public void onResume() {
      super.onResume();
      this.awp.onResume();
      FragmentManager var1 = this.TG.getActivity().getFragmentManager();
      Fragment var2 = var1.findFragmentByTag("GooglePlayServicesErrorDialog");
      if(var2 != null) {
         var1.beginTransaction().remove(var2).commit();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.TG.getActivity()), this.TG.getActivity(), -1);
      }

   }

   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      this.awp.onSaveInstanceState(var1);
      if(this.awf != null) {
         var1.putParcelable("walletFragmentInitParams", this.awf);
         this.awf = null;
      }

      if(this.awg != null) {
         var1.putParcelable("maskedWalletRequest", this.awg);
         this.awg = null;
      }

      if(this.awh != null) {
         var1.putParcelable("maskedWallet", this.awh);
         this.awh = null;
      }

      if(this.awe != null) {
         var1.putParcelable("walletFragmentOptions", this.awe);
         this.awe = null;
      }

      if(this.awi != null) {
         var1.putBoolean("enabled", this.awi.booleanValue());
         this.awi = null;
      }

   }

   public void onStart() {
      super.onStart();
      this.awp.onStart();
   }

   public void onStop() {
      super.onStop();
      this.awp.onStop();
   }

   public void setEnabled(boolean var1) {
      if(this.awn != null) {
         this.awn.setEnabled(var1);
         this.awi = null;
      } else {
         this.awi = Boolean.valueOf(var1);
      }
   }

   public void setOnStateChangedListener(WalletFragment.OnStateChangedListener var1) {
      this.awq.a(var1);
   }

   public void updateMaskedWallet(MaskedWallet var1) {
      if(this.awn != null) {
         this.awn.updateMaskedWallet(var1);
         this.awh = null;
      } else {
         this.awh = var1;
      }
   }

   public void updateMaskedWalletRequest(MaskedWalletRequest var1) {
      if(this.awn != null) {
         this.awn.updateMaskedWalletRequest(var1);
         this.awg = null;
      } else {
         this.awg = var1;
      }
   }

   public interface OnStateChangedListener {
      void onStateChanged(WalletFragment var1, int var2, int var3, Bundle var4);
   }

   static class a extends qb.a {
      private WalletFragment.OnStateChangedListener awr;
      private final WalletFragment aws;

      a(WalletFragment var1) {
         this.aws = var1;
      }

      public void a(int var1, int var2, Bundle var3) {
         if(this.awr != null) {
            this.awr.onStateChanged(this.aws, var1, var2, var3);
         }

      }

      public void a(WalletFragment.OnStateChangedListener var1) {
         this.awr = var1;
      }
   }

   private static class b implements LifecycleDelegate {
      private final qa awl;

      private b(qa var1) {
         this.awl = var1;
      }

      // $FF: synthetic method
      b(qa var1, Object var2) {
         this(var1);
      }

      private int getState() {
         try {
            int var1 = this.awl.getState();
            return var1;
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void initialize(WalletFragmentInitParams var1) {
         try {
            this.awl.initialize(var1);
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      private void onActivityResult(int var1, int var2, Intent var3) {
         try {
            this.awl.onActivityResult(var1, var2, var3);
         } catch (RemoteException var4) {
            throw new RuntimeException(var4);
         }
      }

      private void setEnabled(boolean var1) {
         try {
            this.awl.setEnabled(var1);
         } catch (RemoteException var3) {
            throw new RuntimeException(var3);
         }
      }

      private void updateMaskedWallet(MaskedWallet var1) {
         try {
            this.awl.updateMaskedWallet(var1);
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      private void updateMaskedWalletRequest(MaskedWalletRequest var1) {
         try {
            this.awl.updateMaskedWalletRequest(var1);
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onCreate(Bundle var1) {
         try {
            this.awl.onCreate(var1);
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         try {
            View var5 = (View)e.f(this.awl.onCreateView(e.k(var1), e.k(var2), var3));
            return var5;
         } catch (RemoteException var4) {
            throw new RuntimeException(var4);
         }
      }

      public void onDestroy() {
      }

      public void onDestroyView() {
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         WalletFragmentOptions var5 = (WalletFragmentOptions)var2.getParcelable("extraWalletFragmentOptions");

         try {
            this.awl.a(e.k(var1), var5, var3);
         } catch (RemoteException var4) {
            throw new RuntimeException(var4);
         }
      }

      public void onLowMemory() {
      }

      public void onPause() {
         try {
            this.awl.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onResume() {
         try {
            this.awl.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.awl.onSaveInstanceState(var1);
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onStart() {
         try {
            this.awl.onStart();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }

      public void onStop() {
         try {
            this.awl.onStop();
         } catch (RemoteException var2) {
            throw new RuntimeException(var2);
         }
      }
   }

   private class c extends com.google.android.gms.dynamic.a implements OnClickListener {
      private c() {
      }

      // $FF: synthetic method
      c(Object var2) {
         this();
      }

      protected void a(FrameLayout var1) {
         Button var6 = new Button(WalletFragment.this.TG.getActivity());
         var6.setText(R.string.wallet_buy_button_place_holder);
         byte var4 = -1;
         byte var5 = -2;
         int var3 = var5;
         int var2 = var4;
         if(WalletFragment.this.awe != null) {
            WalletFragmentStyle var7 = WalletFragment.this.awe.getFragmentStyle();
            var3 = var5;
            var2 = var4;
            if(var7 != null) {
               DisplayMetrics var8 = WalletFragment.this.TG.getResources().getDisplayMetrics();
               var2 = var7.a("buyButtonWidth", var8, -1);
               var3 = var7.a("buyButtonHeight", var8, -2);
            }
         }

         var6.setLayoutParams(new LayoutParams(var2, var3));
         var6.setOnClickListener(this);
         var1.addView(var6);
      }

      protected void a(f var1) {
         Activity var2 = WalletFragment.this.TG.getActivity();
         if(WalletFragment.this.awn == null && WalletFragment.this.mCreated && var2 != null) {
            try {
               qa var4 = qi.a(var2, WalletFragment.this.awo, WalletFragment.this.awe, WalletFragment.this.awq);
               WalletFragment.this.awn = new WalletFragment.b(var4, null);
               WalletFragment.this.awe = null;
            } catch (GooglePlayServicesNotAvailableException var3) {
               return;
            }

            var1.a(WalletFragment.this.awn);
            if(WalletFragment.this.awf != null) {
               WalletFragment.this.awn.initialize(WalletFragment.this.awf);
               WalletFragment.this.awf = null;
            }

            if(WalletFragment.this.awg != null) {
               WalletFragment.this.awn.updateMaskedWalletRequest(WalletFragment.this.awg);
               WalletFragment.this.awg = null;
            }

            if(WalletFragment.this.awh != null) {
               WalletFragment.this.awn.updateMaskedWallet(WalletFragment.this.awh);
               WalletFragment.this.awh = null;
            }

            if(WalletFragment.this.awi != null) {
               WalletFragment.this.awn.setEnabled(WalletFragment.this.awi.booleanValue());
               WalletFragment.this.awi = null;
            }
         }

      }

      public void onClick(View var1) {
         Activity var2 = WalletFragment.this.TG.getActivity();
         GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var2), var2, -1);
      }
   }
}
