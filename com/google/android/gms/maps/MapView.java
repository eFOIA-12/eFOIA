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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.m;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
   private GoogleMap akS;
   private final MapView.b akY;

   public MapView(Context var1) {
      super(var1);
      this.akY = new MapView.b(this, var1, (GoogleMapOptions)null);
   }

   public MapView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.akY = new MapView.b(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
   }

   public MapView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.akY = new MapView.b(this, var1, GoogleMapOptions.createFromAttributes(var1, var2));
   }

   public MapView(Context var1, GoogleMapOptions var2) {
      super(var1);
      this.akY = new MapView.b(this, var1, var2);
   }

   @Deprecated
   public final GoogleMap getMap() {
      if(this.akS != null) {
         return this.akS;
      } else {
         this.akY.nO();
         if(this.akY.je() == null) {
            return null;
         } else {
            try {
               this.akS = new GoogleMap(((MapView.a)this.akY.je()).nP().getMap());
            } catch (RemoteException var2) {
               throw new RuntimeRemoteException(var2);
            }

            return this.akS;
         }
      }
   }

   public void getMapAsync(OnMapReadyCallback var1) {
      jx.aU("getMapAsync() must be called on the main thread");
      this.akY.getMapAsync(var1);
   }

   public final void onCreate(Bundle var1) {
      this.akY.onCreate(var1);
      if(this.akY.je() == null) {
         com.google.android.gms.dynamic.a.b((FrameLayout)this);
      }

   }

   public final void onDestroy() {
      this.akY.onDestroy();
   }

   public final void onLowMemory() {
      this.akY.onLowMemory();
   }

   public final void onPause() {
      this.akY.onPause();
   }

   public final void onResume() {
      this.akY.onResume();
   }

   public final void onSaveInstanceState(Bundle var1) {
      this.akY.onSaveInstanceState(var1);
   }

   static class a implements MapLifecycleDelegate {
      private final ViewGroup akZ;
      private final IMapViewDelegate ala;
      private View alb;

      public a(ViewGroup var1, IMapViewDelegate var2) {
         this.ala = (IMapViewDelegate)jx.i(var2);
         this.akZ = (ViewGroup)jx.i(var1);
      }

      public void getMapAsync(final OnMapReadyCallback var1) {
         try {
            this.ala.getMapAsync(new m.a() {
               public void a(IGoogleMapDelegate var1x) throws RemoteException {
                  var1.onMapReady(new GoogleMap(var1x));
               }
            });
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public IMapViewDelegate nP() {
         return this.ala;
      }

      public void onCreate(Bundle var1) {
         try {
            this.ala.onCreate(var1);
            this.alb = (View)e.f(this.ala.getView());
            this.akZ.removeAllViews();
            this.akZ.addView(this.alb);
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
      }

      public void onDestroy() {
         try {
            this.ala.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
      }

      public void onLowMemory() {
         try {
            this.ala.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.ala.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.ala.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.ala.onSaveInstanceState(var1);
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
      private final List akX = new ArrayList();
      private final ViewGroup ald;
      private final GoogleMapOptions ale;
      private final Context mContext;

      b(ViewGroup var1, Context var2, GoogleMapOptions var3) {
         this.ald = var1;
         this.mContext = var2;
         this.ale = var3;
      }

      protected void a(f var1) {
         this.akW = var1;
         this.nO();
      }

      public void getMapAsync(OnMapReadyCallback var1) {
         if(this.je() != null) {
            ((MapView.a)this.je()).getMapAsync(var1);
         } else {
            this.akX.add(var1);
         }
      }

      public void nO() {
         // $FF: Couldn't be decompiled
      }
   }
}
