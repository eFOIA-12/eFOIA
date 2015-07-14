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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.m;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapFragment extends Fragment {
   private final MapFragment.b akR = new MapFragment.b(this);
   private GoogleMap akS;

   public static MapFragment newInstance() {
      return new MapFragment();
   }

   public static MapFragment newInstance(GoogleMapOptions var0) {
      MapFragment var1 = new MapFragment();
      Bundle var2 = new Bundle();
      var2.putParcelable("MapOptions", var0);
      var1.setArguments(var2);
      return var1;
   }

   @Deprecated
   public final GoogleMap getMap() {
      IMapFragmentDelegate var1 = this.nN();
      if(var1 != null) {
         IGoogleMapDelegate var3;
         try {
            var3 = var1.getMap();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }

         if(var3 != null) {
            if(this.akS == null || this.akS.nC().asBinder() != var3.asBinder()) {
               this.akS = new GoogleMap(var3);
            }

            return this.akS;
         }
      }

      return null;
   }

   public void getMapAsync(OnMapReadyCallback var1) {
      jx.aU("getMapAsync must be called on the main thread.");
      this.akR.getMapAsync(var1);
   }

   protected IMapFragmentDelegate nN() {
      this.akR.nO();
      return this.akR.je() == null?null:((MapFragment.a)this.akR.je()).nN();
   }

   public void onActivityCreated(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onActivityCreated(var1);
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.akR.setActivity(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.akR.onCreate(var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return this.akR.onCreateView(var1, var2, var3);
   }

   public void onDestroy() {
      this.akR.onDestroy();
      super.onDestroy();
   }

   public void onDestroyView() {
      this.akR.onDestroyView();
      super.onDestroyView();
   }

   public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
      super.onInflate(var1, var2, var3);
      this.akR.setActivity(var1);
      GoogleMapOptions var5 = GoogleMapOptions.createFromAttributes(var1, var2);
      Bundle var4 = new Bundle();
      var4.putParcelable("MapOptions", var5);
      this.akR.onInflate(var1, var4, var3);
   }

   public void onLowMemory() {
      this.akR.onLowMemory();
      super.onLowMemory();
   }

   public void onPause() {
      this.akR.onPause();
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      this.akR.onResume();
   }

   public void onSaveInstanceState(Bundle var1) {
      if(var1 != null) {
         var1.setClassLoader(MapFragment.class.getClassLoader());
      }

      super.onSaveInstanceState(var1);
      this.akR.onSaveInstanceState(var1);
   }

   public void setArguments(Bundle var1) {
      super.setArguments(var1);
   }

   static class a implements MapLifecycleDelegate {
      private final Fragment TG;
      private final IMapFragmentDelegate akT;

      public a(Fragment var1, IMapFragmentDelegate var2) {
         this.akT = (IMapFragmentDelegate)jx.i(var2);
         this.TG = (Fragment)jx.i(var1);
      }

      public void getMapAsync(final OnMapReadyCallback var1) {
         try {
            this.akT.getMapAsync(new m.a() {
               public void a(IGoogleMapDelegate var1x) throws RemoteException {
                  var1.onMapReady(new GoogleMap(var1x));
               }
            });
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public IMapFragmentDelegate nN() {
         return this.akT;
      }

      public void onCreate(Bundle param1) {
         // $FF: Couldn't be decompiled
      }

      public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
         d var5;
         try {
            var5 = this.akT.onCreateView(e.k(var1), e.k(var2), var3);
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }

         return (View)e.f(var5);
      }

      public void onDestroy() {
         try {
            this.akT.onDestroy();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onDestroyView() {
         try {
            this.akT.onDestroyView();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onInflate(Activity var1, Bundle var2, Bundle var3) {
         GoogleMapOptions var5 = (GoogleMapOptions)var2.getParcelable("MapOptions");

         try {
            this.akT.onInflate(e.k(var1), var5, var3);
         } catch (RemoteException var4) {
            throw new RuntimeRemoteException(var4);
         }
      }

      public void onLowMemory() {
         try {
            this.akT.onLowMemory();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onPause() {
         try {
            this.akT.onPause();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onResume() {
         try {
            this.akT.onResume();
         } catch (RemoteException var2) {
            throw new RuntimeRemoteException(var2);
         }
      }

      public void onSaveInstanceState(Bundle var1) {
         try {
            this.akT.onSaveInstanceState(var1);
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
      private final List akX = new ArrayList();
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

      public void getMapAsync(OnMapReadyCallback var1) {
         if(this.je() != null) {
            ((MapFragment.a)this.je()).getMapAsync(var1);
         } else {
            this.akX.add(var1);
         }
      }

      public void nO() {
         // $FF: Couldn't be decompiled
      }
   }
}
