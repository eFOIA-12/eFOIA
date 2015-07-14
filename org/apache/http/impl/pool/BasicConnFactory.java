package org.apache.http.impl.pool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionFactory;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.DefaultBHttpClientConnection;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.params.HttpParamConfig;
import org.apache.http.params.HttpParams;
import org.apache.http.pool.ConnFactory;
import org.apache.http.util.Args;

@Immutable
public class BasicConnFactory implements ConnFactory {
   private final HttpConnectionFactory connFactory;
   private final int connectTimeout;
   private final SocketFactory plainfactory;
   private final SocketConfig sconfig;
   private final SSLSocketFactory sslfactory;

   public BasicConnFactory() {
      this((SocketFactory)null, (SSLSocketFactory)null, 0, SocketConfig.DEFAULT, ConnectionConfig.DEFAULT);
   }

   public BasicConnFactory(int var1, SocketConfig var2, ConnectionConfig var3) {
      this((SocketFactory)null, (SSLSocketFactory)null, var1, var2, var3);
   }

   public BasicConnFactory(SocketFactory var1, SSLSocketFactory var2, int var3, SocketConfig var4, ConnectionConfig var5) {
      this.plainfactory = var1;
      this.sslfactory = var2;
      this.connectTimeout = var3;
      if(var4 == null) {
         var4 = SocketConfig.DEFAULT;
      }

      this.sconfig = var4;
      if(var5 == null) {
         var5 = ConnectionConfig.DEFAULT;
      }

      this.connFactory = new DefaultBHttpClientConnectionFactory(var5);
   }

   @Deprecated
   public BasicConnFactory(SSLSocketFactory var1, HttpParams var2) {
      Args.notNull(var2, "HTTP params");
      this.plainfactory = null;
      this.sslfactory = var1;
      this.connectTimeout = var2.getIntParameter("http.connection.timeout", 0);
      this.sconfig = HttpParamConfig.getSocketConfig(var2);
      this.connFactory = new DefaultBHttpClientConnectionFactory(HttpParamConfig.getConnectionConfig(var2));
   }

   public BasicConnFactory(SocketConfig var1, ConnectionConfig var2) {
      this((SocketFactory)null, (SSLSocketFactory)null, 0, var1, var2);
   }

   @Deprecated
   public BasicConnFactory(HttpParams var1) {
      this((SSLSocketFactory)null, (HttpParams)var1);
   }

   @Deprecated
   protected HttpClientConnection create(Socket var1, HttpParams var2) throws IOException {
      DefaultBHttpClientConnection var3 = new DefaultBHttpClientConnection(var2.getIntParameter("http.socket.buffer-size", 8192));
      var3.bind(var1);
      return var3;
   }

   public HttpClientConnection create(HttpHost var1) throws IOException {
      String var6 = var1.getSchemeName();
      Socket var5 = null;
      if("http".equalsIgnoreCase(var6)) {
         if(this.plainfactory != null) {
            var5 = this.plainfactory.createSocket();
         } else {
            var5 = new Socket();
         }
      }

      if("https".equalsIgnoreCase(var6)) {
         Object var7;
         if(this.sslfactory != null) {
            var7 = this.sslfactory;
         } else {
            var7 = SSLSocketFactory.getDefault();
         }

         var5 = ((SocketFactory)var7).createSocket();
      }

      if(var5 == null) {
         throw new IOException(var6 + " scheme is not supported");
      } else {
         var6 = var1.getHostName();
         int var3 = var1.getPort();
         int var2 = var3;
         if(var3 == -1) {
            if(var1.getSchemeName().equalsIgnoreCase("http")) {
               var2 = 80;
            } else {
               var2 = var3;
               if(var1.getSchemeName().equalsIgnoreCase("https")) {
                  var2 = 443;
               }
            }
         }

         var5.setSoTimeout(this.sconfig.getSoTimeout());
         var5.connect(new InetSocketAddress(var6, var2), this.connectTimeout);
         var5.setTcpNoDelay(this.sconfig.isTcpNoDelay());
         var2 = this.sconfig.getSoLinger();
         if(var2 >= 0) {
            boolean var4;
            if(var2 > 0) {
               var4 = true;
            } else {
               var4 = false;
            }

            var5.setSoLinger(var4, var2);
         }

         var5.setKeepAlive(this.sconfig.isSoKeepAlive());
         return (HttpClientConnection)this.connFactory.createConnection(var5);
      }
   }
}
