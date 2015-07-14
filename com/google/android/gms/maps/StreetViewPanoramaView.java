package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.u;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
   private StreetViewPanorama alm;
   private final StreetViewPanoramaView.b aly;

   public StreetViewPanoramaView(Context var1) {
      super(var1);
      this.aly = new StreetViewPanoramaView.b(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.aly = new StreetViewPanoramaView.b(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.aly = new StreetViewPanoramaView.b(this, var1, (StreetViewPanoramaOptions)null);
   }

   public StreetViewPanoramaView(Context var1, StreetViewPanoramaOptions var2) {
      super(var1);
      this.aly = new StreetViewPanoramaView.b(this, var1, var2);
   }

   @Deprecated
   public final StreetViewPanorama getStreetViewPanorama() {
      if(this.alm != null) {
         return this.alm;
      } else {
         this.aly.nO();
         if(this.aly.je() == null) {
            return null;
         } else {
            try {
               this.alm = new StreetViewPanorama(((StreetViewPanoramaView.a)this.aly.je()).nV().getStreetViewPanorama());
            } catch (RemoteException var2) {
               throw new RuntimeRemoteException(var2);
            }

            return this.alm;
         }
      }
   }

   public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
      jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
      this.aly.getStreetViewPanoramaAsync(var1);
   }

   public final void onCreate(Bundle var1) {
      this.aly.onCreate(var1);
      if(this.aly.je() == null) {
         com.google.android.gms.dynamic.a.b((FrameLayout)this);
      }

   }

   public final void onDestroy() {
      this.aly.onDestroy();
   }

   public final void onLowMemory() {
      this.aly.onLowMemory();
   }

   public final void onPause() {
      this.aly.onPause();
   }

   public final void onResume() {
      this.aly.onResume();
   }

   public final void onSaveInstanceState(Bundle var1) {
      this.aly.onSaveInstanceState(var1);
   }

   static class a implements StreetViewLifecycleDelegate {
      private final ViewGroup akZ;
      private View alA;
      private final IStreetViewPanoramaViewDelegate alz;

      public a(ViewGroup var1, IStreetViewPanoramaViewDelegate var2) {
         this.alz = (IStreetViewPanoramaViewDelegate)jx.i(var2);
         this.akZ = (ViewGroup)jx.i(var1);
      }

      public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback var1) {
         try {
            this.alz.getStreetViewPanoramaAsync(new u.a() {
               public void a(IStreetViewPanoramaDelegate var1x) throws RemoteException {
                  var1.onStreetViewPanoramaReady(new StreetViewPanorama(var1x));
               }
            });
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public IStreetViewPanoramaViewDelegate nV() {
         return this.alz;
      }

      public void onCreate(Bundle var1) {
         try {
            this.alz.onCreate(var1);
            this.alA = (View)e.f(this.alz.getView());
            this.akZ.removeAllViews();
            this.akZ.addView(this.alA);
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onDestroy() {
         try {
            this.alz.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
      }

      public void onLowMemory() {
         try {
            this.alz.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.alz.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.alz.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.alz.onSaveInstanceState(var1);
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
      protected f akW;
      private final StreetViewPanoramaOptions alC;
      private final ViewGroup ald;
      private final List alq = new ArrayList();
      private final Context mContext;

      b(ViewGroup var1, Context var2, StreetViewPanoramaOptions var3) {
         this.ald = var1;
         this.mContext = var2;
         this.alC = var3;
      }

      protected void a(f var1) {
         this.akW = var1;
         this.nO();
      }

      public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback var1) {
         if(this.je() != null) {
            ((StreetViewPanoramaView.a)this.je()).getStreetViewPanoramaAsync(var1);
         } else {
            this.alq.add(var1);
         }
      }

      public void nO() {
         // $FF: Couldn't be decompiled
      }
   }
}
