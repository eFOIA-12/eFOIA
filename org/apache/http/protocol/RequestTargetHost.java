package org.apache.http.protocol;

import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.util.Args;

@Immutable
public class RequestTargetHost implements HttpRequestInterceptor {
   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      HttpCoreContext var8 = HttpCoreContext.adapt(var2);
      ProtocolVersion var6 = var1.getRequestLine().getProtocolVersion();
      if((!var1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") || !var6.lessEquals(HttpVersion.HTTP_1_0)) && !var1.containsHeader("Host")) {
         HttpHost var4 = var8.getTargetHost();
         HttpHost var5 = var4;
         if(var4 == null) {
            HttpConnection var10 = var8.getConnection();
            HttpHost var9 = var4;
            if(var10 instanceof HttpInetConnection) {
               InetAddress var7 = ((HttpInetConnection)var10).getRemoteAddress();
               int var3 = ((HttpInetConnection)var10).getRemotePort();
               var9 = var4;
               if(var7 != null) {
                  var9 = new HttpHost(var7.getHostName(), var3);
               }
            }

            var5 = var9;
            if(var9 == null) {
               if(!var6.lessEquals(HttpVersion.HTTP_1_0)) {
                  throw new ProtocolException("Target host missing");
               }

               return;
            }
         }

         var1.addHeader("Host", var5.toHostString());
      }
   }
}
