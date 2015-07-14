package com.parallel6.captivereachconnectsdk.network.request;

import com.parallel6.captivereachconnectsdk.network.request.CRSSLSocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientFactory {
   private static DefaultHttpClient client;

   public static SchemeRegistry getSchemeRegistry() throws KeyStoreException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyManagementException, IOException, CertificateException {
      KeyStore var0 = KeyStore.getInstance(KeyStore.getDefaultType());
      var0.load((InputStream)null, (char[])null);
      CRSSLSocketFactory var2 = new CRSSLSocketFactory(var0);
      var2.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      SchemeRegistry var1 = new SchemeRegistry();
      var1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      var1.register(new Scheme("https", var2, 443));
      return var1;
   }

   public static DefaultHttpClient getThreadSafeClient() {
      synchronized(HttpClientFactory.class){}
      boolean var4 = false;

      DefaultHttpClient var0;
      label43: {
         try {
            var4 = true;
            if(client != null) {
               var0 = client;
               var4 = false;
            } else {
               client = new DefaultHttpClient();
               HttpParams var7 = client.getParams();
               var7.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
               var7.setBooleanParameter("http.protocol.expect-continue", false);
               ThreadSafeClientConnManager var1 = new ThreadSafeClientConnManager(var7, getSchemeRegistry());
               HttpConnectionParams.setConnectionTimeout(var7, 30000);
               HttpConnectionParams.setSoTimeout(var7, 30000);
               HttpConnectionParams.setTcpNoDelay(var7, true);
               client = new DefaultHttpClient(new ThreadSafeClientConnManager(var7, var1.getSchemeRegistry()), var7);
               var0 = client;
               var4 = false;
            }
            break label43;
         } catch (Exception var5) {
            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }

         var0 = null;
      }

      return var0;
   }
}
