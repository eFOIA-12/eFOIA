package com.crashlytics.android.core.internal.models;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;

public class SessionEventData {
   public final BinaryImageData[] binaryImages;
   public final CustomAttributeData[] customAttributes;
   public final DeviceData deviceData;
   public final SignalData signal;
   public final ThreadData[] threads;
   public final long timestamp;

   public SessionEventData(long var1, SignalData var3, ThreadData[] var4, BinaryImageData[] var5, CustomAttributeData[] var6, DeviceData var7) {
      this.timestamp = var1;
      this.signal = var3;
      this.threads = var4;
      this.binaryImages = var5;
      this.customAttributes = var6;
      this.deviceData = var7;
   }
}
