package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.services.network.SystemKeyStore;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;

final class CertificateChainCleaner {
   public static X509Certificate[] getCleanChain(X509Certificate[] var0, SystemKeyStore var1) throws CertificateException {
      LinkedList var5 = new LinkedList();
      boolean var2 = false;
      if(var1.isTrustRoot(var0[0])) {
         var2 = true;
      }

      var5.add(var0[0]);
      int var4 = 1;

      boolean var3;
      while(true) {
         var3 = var2;
         if(var4 >= var0.length) {
            break;
         }

         if(var1.isTrustRoot(var0[var4])) {
            var2 = true;
         }

         var3 = var2;
         if(!isValidLink(var0[var4], var0[var4 - 1])) {
            break;
         }

         var5.add(var0[var4]);
         ++var4;
      }

      X509Certificate var6 = var1.getTrustRootFor(var0[var4 - 1]);
      if(var6 != null) {
         var5.add(var6);
         var3 = true;
      }

      if(var3) {
         return (X509Certificate[])var5.toArray(new X509Certificate[var5.size()]);
      } else {
         throw new CertificateException("Didn\'t find a trust anchor in chain cleanup!");
      }
   }

   private static boolean isValidLink(X509Certificate var0, X509Certificate var1) {
      if(!var0.getSubjectX500Principal().equals(var1.getIssuerX500Principal())) {
         return false;
      } else {
         try {
            var1.verify(var0.getPublicKey());
            return true;
         } catch (GeneralSecurityException var2) {
            return false;
         }
      }
   }
}
