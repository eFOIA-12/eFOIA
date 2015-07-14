package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.network.CertificateChainCleaner;
import io.fabric.sdk.android.services.network.PinningInfoProvider;
import io.fabric.sdk.android.services.network.SystemKeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class PinningTrustManager implements X509TrustManager {
   private static final long PIN_FRESHNESS_DURATION_MILLIS = 15552000000L;
   private final Set cache = Collections.synchronizedSet(new HashSet());
   private final long pinCreationTimeMillis;
   private final List pins = new LinkedList();
   private final SystemKeyStore systemKeyStore;
   private final TrustManager[] systemTrustManagers;

   public PinningTrustManager(SystemKeyStore var1, PinningInfoProvider var2) {
      this.systemTrustManagers = this.initializeSystemTrustManagers(var1);
      this.systemKeyStore = var1;
      this.pinCreationTimeMillis = var2.getPinCreationTimeInMillis();
      String[] var5 = var2.getPins();
      int var4 = var5.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String var6 = var5[var3];
         this.pins.add(this.hexStringToByteArray(var6));
      }

   }

   private void checkPinTrust(X509Certificate[] var1) throws CertificateException {
      if(this.pinCreationTimeMillis != -1L && System.currentTimeMillis() - this.pinCreationTimeMillis > 15552000000L) {
         Fabric.getLogger().w("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.pinCreationTimeMillis) + " millis vs " + 15552000000L + " millis) " + "falling back to system trust.");
      } else {
         var1 = CertificateChainCleaner.getCleanChain(var1, this.systemKeyStore);
         int var3 = var1.length;
         int var2 = 0;

         while(true) {
            if(var2 >= var3) {
               throw new CertificateException("No valid pins found in chain!");
            }

            if(this.isValidPin(var1[var2])) {
               break;
            }

            ++var2;
         }
      }

   }

   private void checkSystemTrust(X509Certificate[] var1, String var2) throws CertificateException {
      TrustManager[] var5 = this.systemTrustManagers;
      int var4 = var5.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         ((X509TrustManager)var5[var3]).checkServerTrusted(var1, var2);
      }

   }

   private byte[] hexStringToByteArray(String var1) {
      int var3 = var1.length();
      byte[] var4 = new byte[var3 / 2];

      for(int var2 = 0; var2 < var3; var2 += 2) {
         var4[var2 / 2] = (byte)((Character.digit(var1.charAt(var2), 16) << 4) + Character.digit(var1.charAt(var2 + 1), 16));
      }

      return var4;
   }

   private TrustManager[] initializeSystemTrustManagers(SystemKeyStore var1) {
      try {
         TrustManagerFactory var2 = TrustManagerFactory.getInstance("X509");
         var2.init(var1.trustStore);
         TrustManager[] var5 = var2.getTrustManagers();
         return var5;
      } catch (NoSuchAlgorithmException var3) {
         throw new AssertionError(var3);
      } catch (KeyStoreException var4) {
         throw new AssertionError(var4);
      }
   }

   private boolean isValidPin(X509Certificate param1) throws CertificateException {
      // $FF: Couldn't be decompiled
   }

   public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
      throw new CertificateException("Client certificates not supported!");
   }

   public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
      if(!this.cache.contains(var1[0])) {
         this.checkSystemTrust(var1, var2);
         this.checkPinTrust(var1);
         this.cache.add(var1[0]);
      }
   }

   public X509Certificate[] getAcceptedIssuers() {
      return null;
   }
}
