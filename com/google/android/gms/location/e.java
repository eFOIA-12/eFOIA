package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.location.f;

public class e implements SafeParcelable {
   public static final f CREATOR = new f();
   private final int CK;
   int agw;
   int agx;
   long agy;

   public e(int var1, int var2, int var3, long var4) {
      this.CK = var1;
      this.agw = var2;
      this.agx = var3;
      this.agy = var4;
   }

   private String eB(int var1) {
      switch(var1) {
      case 0:
         return "STATUS_SUCCESSFUL";
      case 1:
      default:
         return "STATUS_UNKNOWN";
      case 2:
         return "STATUS_TIMED_OUT_ON_SCAN";
      case 3:
         return "STATUS_NO_INFO_IN_DATABASE";
      case 4:
         return "STATUS_INVALID_SCAN";
      case 5:
         return "STATUS_UNABLE_TO_QUERY_DATABASE";
      case 6:
         return "STATUS_SCANS_DISABLED_IN_SETTINGS";
      case 7:
         return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
      case 8:
         return "STATUS_IN_PROGRESS";
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof e) {
         e var2 = (e)var1;
         if(this.agw == var2.agw && this.agx == var2.agx && this.agy == var2.agy) {
            return true;
         }
      }

      return false;
   }

   int getVersionCode() {
      return this.CK;
   }

   public int hashCode() {
      return jv.hashCode(new Object[]{Integer.valueOf(this.agw), Integer.valueOf(this.agx), Long.valueOf(this.agy)});
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("LocationStatus[cell status: ").append(this.eB(this.agw));
      var1.append(", wifi status: ").append(this.eB(this.agx));
      var1.append(", elapsed realtime ns: ").append(this.agy);
      var1.append(']');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      f.a(this, var1, var2);
   }
}
