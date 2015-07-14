package io.fabric.sdk.android.services.network;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.HashMap;

class SystemKeyStore {
   private final HashMap trustRoots;
   final KeyStore trustStore;

   public SystemKeyStore(InputStream var1, String var2) {
      KeyStore var3 = this.getTrustStore(var1, var2);
      this.trustRoots = this.initializeTrustedRoots(var3);
      this.trustStore = var3;
   }

   private KeyStore getTrustStore(InputStream param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private HashMap initializeTrustedRoots(KeyStore param1) {
      // $FF: Couldn't be decompiled
   }

   public X509Certificate getTrustRootFor(X509Certificate var1) {
      X509Certificate var2 = (X509Certificate)this.trustRoots.get(var1.getIssuerX500Principal());
      if(var2 == null) {
         return null;
      } else if(var2.getSubjectX500Principal().equals(var1.getSubjectX500Principal())) {
         return null;
      } else {
         try {
            var1.verify(var2.getPublicKey());
            return var2;
         } catch (GeneralSecurityException var3) {
            return null;
         }
      }
   }

   public boolean isTrustRoot(X509Certificate var1) {
      X509Certificate var2 = (X509Certificate)this.trustRoots.get(var1.getSubjectX500Principal());
      return var2 != null && var2.getPublicKey().equals(var1.getPublicKey());
   }
}
