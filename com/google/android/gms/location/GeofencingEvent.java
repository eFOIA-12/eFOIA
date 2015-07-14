package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
   private final int agl;
   private final List agm;
   private final Location agn;
   private final int tq;

   private GeofencingEvent(int var1, int var2, List var3, Location var4) {
      this.tq = var1;
      this.agl = var2;
      this.agm = var3;
      this.agn = var4;
   }

   public static GeofencingEvent fromIntent(Intent var0) {
      return var0 == null?null:new GeofencingEvent(var0.getIntExtra("gms_error_code", -1), k(var0), l(var0), (Location)var0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
   }

   private static int k(Intent var0) {
      int var1 = var0.getIntExtra("com.google.android.location.intent.extra.transition", -1);
      return var1 != -1 && (var1 == 1 || var1 == 2 || var1 == 4)?var1:-1;
   }

   private static List l(Intent var0) {
      ArrayList var1 = (ArrayList)var0.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
      if(var1 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList(var1.size());
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            var2.add(nn.h((byte[])var3.next()));
         }

         return var2;
      }
   }

   public int getErrorCode() {
      return this.tq;
   }

   public int getGeofenceTransition() {
      return this.agl;
   }

   public List getTriggeringGeofences() {
      return this.agm;
   }

   public Location getTriggeringLocation() {
      return this.agn;
   }

   public boolean hasError() {
      return this.tq != -1;
   }
}
