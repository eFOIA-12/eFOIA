package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nn;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest implements SafeParcelable {
   public static final Creator CREATOR = new a();
   public static final int INITIAL_TRIGGER_DWELL = 4;
   public static final int INITIAL_TRIGGER_ENTER = 1;
   public static final int INITIAL_TRIGGER_EXIT = 2;
   private final int CK;
   private final List ago;
   private final int agp;

   GeofencingRequest(int var1, List var2, int var3) {
      this.CK = var1;
      this.ago = var2;
      this.agp = var3;
   }

   private GeofencingRequest(List var1, int var2) {
      this(1, var1, var2);
   }

   // $FF: synthetic method
   GeofencingRequest(List var1, int var2, Object var3) {
      this(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public List getGeofences() {
      ArrayList var1 = new ArrayList();
      var1.addAll(this.ago);
      return var1;
   }

   public int getInitialTrigger() {
      return this.agp;
   }

   public int getVersionCode() {
      return this.CK;
   }

   public List ng() {
      return this.ago;
   }

   public void writeToParcel(Parcel var1, int var2) {
      a.a(this, var1, var2);
   }

   public static final class Builder {
      private final List ago = new ArrayList();
      private int agp = 5;

      public static int ew(int var0) {
         return var0 & 7;
      }

      public GeofencingRequest.Builder addGeofence(Geofence var1) {
         jx.b((Object)var1, "geofence can\'t be null.");
         jx.b(var1 instanceof nn, "Geofence must be created using Geofence.Builder.");
         this.ago.add((nn)var1);
         return this;
      }

      public GeofencingRequest.Builder addGeofences(List var1) {
         if(var1 != null && !var1.isEmpty()) {
            Iterator var3 = var1.iterator();

            while(var3.hasNext()) {
               Geofence var2 = (Geofence)var3.next();
               if(var2 != null) {
                  this.addGeofence(var2);
               }
            }
         }

         return this;
      }

      public GeofencingRequest build() {
         boolean var1;
         if(!this.ago.isEmpty()) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.b(var1, "No geofence has been added to this request.");
         return new GeofencingRequest(this.ago, this.agp, null);
      }

      public GeofencingRequest.Builder setInitialTrigger(int var1) {
         this.agp = ew(var1);
         return this;
      }
   }
}
