package com.parallel6.ui.configurability.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.builders.DynamicContentTaskBuilder;
import com.parallel6.captivereachconnectsdk.network.request.TaskListener;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.configurability.fragments.BaseLayoutFragment;
import com.parallel6.ui.configurability.models.DynamicContentHashResponse;
import com.parallel6.ui.fragments.maps.GoogleMapFragment;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRConfMapFragment extends BaseLayoutFragment {
   private static final double DEFAULT_LAT = 32.7160827D;
   private static final double DEFAULT_LNG = -117.1616727D;
   private static final float DEFAULT_ZOOM = 13.0F;
   protected TaskListener dynamicTaskListener = new TaskListener() {
      public void onTaskCancelled() {
      }

      public void onTaskFailure(Exception var1) {
      }

      public void onTaskSuccess(DynamicContentHashResponse var1) {
         if(var1.getContent().size() > 0) {
            CRConfMapFragment.this.setupValuesMap(var1.getContent());
         }

      }

      public void onTaskTimeOut() {
      }
   };
   private GoogleMap googleMap;
   private List valuesListMap = new ArrayList();

   private void animateCameraWithZoom(LatLng var1, float var2) {
      if(this.googleMap != null) {
         this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(var1, var2));
      }

   }

   private void setupValuesMap(List var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         LinkedTreeMap var2 = (LinkedTreeMap)var3.next();
         this.valuesListMap.add(var2);
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      Type var2 = (new TypeToken() {
      }).getType();
      (new DynamicContentTaskBuilder()).withContext(this.getActivity()).withMethod("GET").withParam("page", "0").withPermanentLink(this.permanentLink).withTaskListener(this.dynamicTaskListener).withType(var2).build().execute();
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      return var1.inflate(R.layout.config_map, (ViewGroup)null);
   }

   public void onViewCreated(View var1, Bundle var2) {
      super.onViewCreated(var1, var2);
      Fragment var4 = this.getFragmentManager().findFragmentById(R.id.config_map_map);
      Object var3 = var4;
      if(var4 == null) {
         var3 = GoogleMapFragment.newMapInstance();
         ((GoogleMapFragment)var3).setOnMapReadyListener(new GoogleMapFragment.OnMapReadyListener() {
            public void onMapReady() {
               CRConfMapFragment.this.setupMapIfNeeded();
            }
         });
      }

      this.getFragmentManager().beginTransaction().replace(R.id.config_map_map, (Fragment)var3).commit();
   }

   public void setupMapIfNeeded() {
      if(this.googleMap == null) {
         Fragment var1 = this.getActivity().getFragmentManager().findFragmentById(R.id.config_map_map);
         if(var1 != null) {
            this.setupMapIfNeeded((MapFragment)var1);
         }
      }

   }

   public void setupMapIfNeeded(MapFragment var1) {
      if(var1 != null) {
         this.googleMap = var1.getMap();
         this.googleMap.setMyLocationEnabled(true);
         if(this.googleMap != null) {
            this.googleMap.setInfoWindowAdapter((GoogleMap.InfoWindowAdapter)null);
            this.googleMap.setOnMapClickListener((GoogleMap.OnMapClickListener)null);
            this.googleMap.setOnInfoWindowClickListener((GoogleMap.OnInfoWindowClickListener)null);
            this.googleMap.setOnMarkerClickListener((GoogleMap.OnMarkerClickListener)null);
         }

         if(!StringUtils.isNotEmpty(SettingsUtils.getLat(this.getActivity())) || !StringUtils.isNotEmpty(SettingsUtils.getLng(this.getActivity()))) {
            this.animateCameraWithZoom(new LatLng(32.7160827D, -117.1616727D), 13.0F);
            return;
         }

         this.animateCameraWithZoom(new LatLng(Double.parseDouble(SettingsUtils.getLat(this.getActivity())), Double.parseDouble(SettingsUtils.getLng(this.getActivity()))), 13.0F);
      }

   }
}
