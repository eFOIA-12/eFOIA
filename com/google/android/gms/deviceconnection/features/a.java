package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.deviceconnection.features.DeviceFeature;
import com.google.android.gms.internal.jv;

public final class a extends d implements DeviceFeature {
   public a(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public String getFeatureName() {
      return this.getString("feature_name");
   }

   public long getLastConnectionTimestampMillis() {
      return this.getLong("last_connection_timestamp");
   }

   public String toString() {
      return jv.h(this).a("FeatureName", this.getFeatureName()).a("Timestamp", Long.valueOf(this.getLastConnectionTimestampMillis())).toString();
   }
}
