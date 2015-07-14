package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;
import org.apache.http.util.Args;

@Immutable
public class ResponseConnControl implements HttpResponseInterceptor {
   public void process(HttpResponse var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      HttpCoreContext var6 = HttpCoreContext.adapt(var2);
      int var3 = var1.getStatusLine().getStatusCode();
      if(var3 != 400 && var3 != 408 && var3 != 411 && var3 != 413 && var3 != 414 && var3 != 503 && var3 != 501) {
         Header var4 = var1.getFirstHeader("Connection");
         if(var4 == null || !"Close".equalsIgnoreCase(var4.getValue())) {
            HttpEntity var8 = var1.getEntity();
            if(var8 != null) {
               ProtocolVersion var5 = var1.getStatusLine().getProtocolVersion();
               if(var8.getContentLength() < 0L && (!var8.isChunked() || var5.lessEquals(HttpVersion.HTTP_1_0))) {
                  var1.setHeader("Connection", "Close");
                  return;
               }
            }

            HttpRequest var7 = var6.getRequest();
            if(var7 != null) {
               var4 = var7.getFirstHeader("Connection");
               if(var4 != null) {
                  var1.setHeader("Connection", var4.getValue());
                  return;
               }

               if(var7.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                  var1.setHeader("Connection", "Close");
                  return;
               }
            }
         }
      } else {
         var1.setHeader("Connection", "Close");
      }

   }
}
