package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.WearableStatusCodes;

public final class av {
   public static Status gN(int var0) {
      return new Status(var0, WearableStatusCodes.getStatusCodeString(var0));
   }
}
