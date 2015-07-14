package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.DefaultLogger;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.network.NetworkUtils;
import io.fabric.sdk.android.services.network.PinningInfoProvider;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class DefaultHttpRequestFactory implements HttpRequestFactory {
   private static final String HTTPS = "https";
   private boolean attemptedSslInit;
   private final Logger logger;
   private PinningInfoProvider pinningInfo;
   private SSLSocketFactory sslSocketFactory;

   public DefaultHttpRequestFactory() {
      this(new DefaultLogger());
   }

   public DefaultHttpRequestFactory(Logger var1) {
      this.logger = var1;
   }

   private SSLSocketFactory getSSLSocketFactory() {
      synchronized(this){}

      SSLSocketFactory var1;
      try {
         if(this.sslSocketFactory == null && !this.attemptedSslInit) {
            this.sslSocketFactory = this.initSSLSocketFactory();
         }

         var1 = this.sslSocketFactory;
      } finally {
         ;
      }

      return var1;
   }

   private SSLSocketFactory initSSLSocketFactory() {
      synchronized(this){}
      boolean var4 = false;

      SSLSocketFactory var1;
      try {
         var4 = true;
         this.attemptedSslInit = true;

         try {
            var1 = NetworkUtils.getSSLSocketFactory(this.pinningInfo);
            this.logger.d("Fabric", "Custom SSL pinning enabled");
            var4 = false;
            return var1;
         } catch (Exception var5) {
            this.logger.e("Fabric", "Exception while validating pinned certs", var5);
            var4 = false;
         }
      } finally {
         if(var4) {
            ;
         }
      }

      var1 = null;
      return var1;
   }

   private boolean isHttps(String var1) {
      return var1 != null && var1.toLowerCase(Locale.US).startsWith("https");
   }

   private void resetSSLSocketFactory() {
      synchronized(this){}

      try {
         this.attemptedSslInit = false;
         this.sslSocketFactory = null;
      } finally {
         ;
      }

   }

   public HttpRequest buildHttpRequest(HttpMethod var1, String var2) {
      return this.buildHttpRequest(var1, var2, Collections.emptyMap());
   }

   public HttpRequest buildHttpRequest(HttpMethod var1, String var2, Map var3) {
      HttpRequest var4;
      switch(null.$SwitchMap$io$fabric$sdk$android$services$network$HttpMethod[var1.ordinal()]) {
      case 1:
         var4 = HttpRequest.get(var2, var3, true);
         break;
      case 2:
         var4 = HttpRequest.post(var2, var3, true);
         break;
      case 3:
         var4 = HttpRequest.put((CharSequence)var2);
         break;
      case 4:
         var4 = HttpRequest.delete((CharSequence)var2);
         break;
      default:
         throw new IllegalArgumentException("Unsupported HTTP method!");
      }

      if(this.isHttps(var2) && this.pinningInfo != null) {
         SSLSocketFactory var5 = this.getSSLSocketFactory();
         if(var5 != null) {
            ((HttpsURLConnection)var4.getConnection()).setSSLSocketFactory(var5);
         }
      }

      return var4;
   }

   public PinningInfoProvider getPinningInfoProvider() {
      return this.pinningInfo;
   }

   public void setPinningInfoProvider(PinningInfoProvider var1) {
      if(this.pinningInfo != var1) {
         this.pinningInfo = var1;
         this.resetSSLSocketFactory();
      }

   }
}
