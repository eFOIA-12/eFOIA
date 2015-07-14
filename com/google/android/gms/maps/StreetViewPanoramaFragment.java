package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaFragment extends Fragment {
   private final StreetViewPanoramaFragment.b all = new StreetViewPanoramaFragment.b(this);
   private StreetViewPanorama alm;

   public static StreetViewPanoramaFragment newInstance() {
      return new StreetViewPanoramaFragment();
   }

   public static StreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions var0) {
      StreetViewPanoramaFragment var1 = new StreetViewPanoramaFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("StreetViewPanoramaOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   @Deprecated
   public final StreetViewPanorama getStreetViewPanorama() {
      IStreetViewPanoramaFragmentDelegate var1 = this.nR();
      if(var1 != null) {
         IStreetViewPanoramaDelegate var3;
         try {
            var3 = var1.getStreetViewPanorama();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }

         if(var3 != null) {
            if(this.alm == null || this.alm.nQ().asBinder() != var3.asBinder()) {
               this.alm = new StreetViewPanorama(var3);
            }

            return this.alm;
         }
      }

      return null;
   }

   public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
      jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
      this.all.getStreetViewPanoramaAsync(var1);
   }

   protected IStreetViewPanoramaFragmentDelegate nR() {
      this.all.nO();
      return this.all.je() == null?null:((StreetViewPanoramaFragment.a)this.all.je()).nR();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.all.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.all.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.all.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.all.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.all.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.all.setActivity(var1);
      Bundle var4 = new Bundle();
      this.all.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.all.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.all.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.all.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(StreetViewPanoramaFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.all.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class a implements StreetViewLifecycleDelegate {
      private final Fragment TG;
      private final IStreetViewPanoramaFragmentDelegate aln;

      public a(Fragment var1, IStreetViewPanoramaFragmentDelegate var2) {
         this.aln = (IStreetViewPanoramaFragmentDelegate)jx.i(var2);
         this.TG = (Fragment)jx.i(var1);
      }

      public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback var1) {
         try {
            this.aln.getStreetViewPanoramaAsync(new u.a() {
               public void a(IStreetViewPanoramaDelegate var1x) throws RemoteException {
                  var1.onStreetViewPanoramaReady(new StreetViewPanorama(var1x));
               }
            });
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public IStreetViewPanoramaFragmentDelegate nR() {
         return this.aln;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         d var5;
         try {
            var5 = this.aln.onCreateView(e.k(var1), e.k(var2), var3);
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         return (View)e.f(var5);
      }

      public void onDestroy() {
         try {
            this.aln.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.aln.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         try {
            this.aln.onInflate(e.k(var1), (StreetViewPanoramaOptions)null, var3);
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }

      public void onLowMemory() {
         try {
            this.aln.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.aln.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.aln.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.aln.onSaveInstanceState(var1);
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onStart() {
      }

      public void onStop() {
      }
   }

   static class b extends com.google.android.gms.dynamic.a {
      private final Fragment TG;
      protected f akW;
      private final List alq = new ArrayList();
      private Activity nB;

      b(Fragment var1) {
         this.TG = var1;
      }

      private void setActivity(Activity var1) {
         this.nB = var1;
         this.nO();
      }

      protected void a(f var1) {
         this.akW = var1;
         this.nO();
      }

      public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
         if(this.je() != null) {
            ((StreetViewPanoramaFragment.a)this.je()).getStreetViewPanoramaAsync(var1);
         } else {
            this.alq.add(var1);
         }
      }

      public void nO() {
         // $FF: Couldn't be decompiled
      }
   }
}
