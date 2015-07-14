package com.google.android.gms.deviceconnection.features;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.deviceconnection.features.DeviceFeature;
import com.google.android.gms.deviceconnection.features.a;

public class DeviceFeatureBuffer extends DataBuffer {
   public DeviceFeature get(int var1) {
      return new a(this.JG, var1);
   }
}
