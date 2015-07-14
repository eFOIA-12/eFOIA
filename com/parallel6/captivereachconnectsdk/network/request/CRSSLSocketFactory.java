package com.parallel6.captivereachconnectsdk.network.request;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class CRSSLSocketFactory extends SSLSocketFactory {
   SSLContext sslContext = SSLContext.getInstance("TLS");

   public CRSSLSocketFactory(KeyStore var1) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
      super(var1);
      X509TrustManager var2 = new X509TrustManager() {
         public void checkClientTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         public void checkServerTrusted(X509Certificate[] var1, String var2) throws CertificateException {
         }

         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }
      };
      this.sslContext.init((KeyManager[])null, new TrustManager[]{var2}, (SecureRandom)null);
   }

   public Socket createSocket() throws IOException {
      return this.sslContext.getSocketFactory().createSocket();
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) throws IOException {
      return this.sslContext.getSocketFactory().createSocket(var1, var2, var3, var4);
   }
}
