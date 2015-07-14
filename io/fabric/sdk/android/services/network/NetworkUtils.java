package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.PinningInfoProvider;
import io.fabric.sdk.android.services.network.PinningTrustManager;
import io.fabric.sdk.android.services.network.SystemKeyStore;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class NetworkUtils {
   public static final SSLSocketFactory getSSLSocketFactory(PinningInfoProvider var0) throws KeyManagementException, NoSuchAlgorithmException {
      SSLContext var1 = SSLContext.getInstance("TLS");
      var1.init((KeyManager[])null, new TrustManager[]{new PinningTrustManager(new SystemKeyStore(var0.getKeyStoreStream(), var0.getKeyStorePassword()), var0)}, (SecureRandom)null);
      return var1.getSocketFactory();
   }
}
