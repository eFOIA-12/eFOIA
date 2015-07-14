package com.crashlytics.android.core;

import com.crashlytics.android.core.PinningInfoProvider;
import java.io.InputStream;

class CrashlyticsPinningInfoProvider implements io.fabric.sdk.android.services.network.PinningInfoProvider {
   private final PinningInfoProvider pinningInfo;

   public CrashlyticsPinningInfoProvider(PinningInfoProvider var1) {
      this.pinningInfo = var1;
   }

   public String getKeyStorePassword() {
      return this.pinningInfo.getKeyStorePassword();
   }

   public InputStream getKeyStoreStream() {
      return this.pinningInfo.getKeyStoreStream();
   }

   public long getPinCreationTimeInMillis() {
      return -1L;
   }

   public String[] getPins() {
      return this.pinningInfo.getPins();
   }
}
