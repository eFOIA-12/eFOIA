package com.parallel6.ui.fragments.maps;

import android.os.Bundle;
import com.google.android.gms.maps.MapFragment;

public class GoogleMapFragment extends MapFragment {
   private GoogleMapFragment.OnMapReadyListener mapReadyListener;

   public static MapFragment newMapInstance() {
      return new GoogleMapFragment();
   }

   public void onActivityCreated(Bundle var1) {
      super.onActivityCreated(var1);
      if(this.mapReadyListener != null) {
         this.mapReadyListener.onMapReady();
      }

   }

   public void setOnMapReadyListener(GoogleMapFragment.OnMapReadyListener var1) {
      this.mapReadyListener = var1;
   }

   public interface OnMapReadyListener {
      void onMapReady();
   }
}
