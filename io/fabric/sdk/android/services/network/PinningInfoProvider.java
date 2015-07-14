package io.fabric.sdk.android.services.network;

import java.io.InputStream;

public interface PinningInfoProvider {
   long PIN_CREATION_TIME_UNDEFINED = -1L;

   String getKeyStorePassword();

   InputStream getKeyStoreStream();

   long getPinCreationTimeInMillis();

   String[] getPins();
}
