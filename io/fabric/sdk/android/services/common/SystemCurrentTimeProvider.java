package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;

public class SystemCurrentTimeProvider implements CurrentTimeProvider {
   public long getCurrentTimeMillis() {
      return System.currentTimeMillis();
   }
}
