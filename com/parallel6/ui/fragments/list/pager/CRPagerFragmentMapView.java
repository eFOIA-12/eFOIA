package com.parallel6.ui.fragments.list.pager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parallel6.captivereachconnectsdk.R;
import com.parallel6.captivereachconnectsdk.utils.SettingsUtils;
import com.parallel6.captivereachconnectsdk.utils.StringUtils;
import com.parallel6.ui.fragments.maps.GoogleMapFragment;
import com.parallel6.ui.models.Place;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CRPagerFragmentMapView extends RelativeLayout {
   protected float MAP_ZOOM;
   protected GoogleMap googleMap;
   private List mMarkersList;
   private List mPlacesList;

   public CRPagerFragmentMapView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CRPagerFragmentMapView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CRPagerFragmentMapView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.MAP_ZOOM = 13.0F;
      this.mPlacesList = new ArrayList();
      this.mMarkersList = new ArrayList();
   }

   private void addMarker(Place var1) {
      try {
         LatLng var2 = new LatLng(var1.getLocation().getLat(), var1.getLocation().getLon());
         MarkerOptions var3 = new MarkerOptions();
         var3.icon(BitmapDescriptorFactory.defaultMarker(210.0F));
         var3.title(var1.getTitle());
         var3.position(var2);
         Marker var5 = this.googleMap.addMarker(var3);
         var1.setGoogleMarkerId(var5.getId());
         this.mMarkersList.add(var5);
      } catch (Exception var4) {
         Log.e(CRPagerFragmentMapView.class.getSimpleName(), "" + var4);
      }
   }

   public void initView(List var1) {
      this.mPlacesList = var1;
      Fragment var2 = ((Activity)this.getContext()).getFragmentManager().findFragmentById(R.id.pager_view_map_lyt_googleMap);
      Object var3 = var2;
      if(var2 == null) {
         var3 = GoogleMapFragment.newMapInstance();
         ((GoogleMapFragment)var3).setOnMapReadyListener(new GoogleMapFragment.OnMapReadyListener() {
            public void onMapReady() {
               CRPagerFragmentMapView.this.setupMapIfNeeded();
            }
         });
      }

      ((Activity)this.getContext()).getFragmentManager().beginTransaction().replace(R.id.pager_view_map_lyt_googleMap, (Fragment)var3).commit();
   }

   public void setupMapIfNeeded() {
      if(this.googleMap == null) {
         Fragment var1 = ((Activity)this.getContext()).getFragmentManager().findFragmentById(R.id.pager_view_map_lyt_googleMap);
         if(var1 != null) {
            this.setupMapIfNeeded((MapFragment)var1);
         }

      } else {
         this.updatePinPoints(this.mPlacesList);
      }
   }

   public void setupMapIfNeeded(MapFragment var1) {
      if(var1 != null) {
         this.googleMap = var1.getMap();
         this.googleMap.setMyLocationEnabled(true);
         if(this.googleMap != null) {
            Log.d("GoogleMap", "Map initiated!");
            Log.d("GoogleMap", "Max zoom level = " + this.googleMap.getMaxZoomLevel());
            Log.d("GoogleMap", "Min zoom level = " + this.googleMap.getMinZoomLevel());
            LatLng var2 = null;
            if(this.getContext() != null) {
               if(!StringUtils.isEmpty(SettingsUtils.getLat(this.getContext())) && !StringUtils.isEmpty(SettingsUtils.getLng(this.getContext()))) {
                  var2 = new LatLng(Double.parseDouble(SettingsUtils.getLat(this.getContext())), Double.parseDouble(SettingsUtils.getLng(this.getContext())));
               } else {
                  var2 = new LatLng(35.8574708D, 104.1361118D);
               }
            }

            this.googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(var2, this.MAP_ZOOM));
         }

         if(this.mPlacesList != null) {
            this.updatePinPoints(this.mPlacesList);
         }
      }

   }

   public void updatePinPoints(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.addMarker((Place)var2.next());
      }

   }
}
