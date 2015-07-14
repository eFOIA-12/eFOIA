package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class ResponseContent implements HttpResponseInterceptor {
   private final boolean overwrite;

   public ResponseContent() {
      this(false);
   }

   public ResponseContent(boolean var1) {
      this.overwrite = var1;
   }

   public void process(HttpResponse var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      if(this.overwrite) {
         var1.removeHeaders("Transfer-Encoding");
         var1.removeHeaders("Content-Length");
      } else {
         if(var1.containsHeader("Transfer-Encoding")) {
            throw new ProtocolException("Transfer-encoding header already present");
         }

         if(var1.containsHeader("Content-Length")) {
            throw new ProtocolException("Content-Length header already present");
         }
      }

      ProtocolVersion var7 = var1.getStatusLine().getProtocolVersion();
      HttpEntity var6 = var1.getEntity();
      if(var6 != null) {
         long var4 = var6.getContentLength();
         if(var6.isChunked() && !var7.lessEquals(HttpVersion.HTTP_1_0)) {
            var1.addHeader("Transfer-Encoding", "chunked");
         } else if(var4 >= 0L) {
            var1.addHeader("Content-Length", Long.toString(var6.getContentLength()));
         }

         if(var6.getContentType() != null && !var1.containsHeader("Content-Type")) {
            var1.addHeader(var6.getContentType());
         }

         if(var6.getContentEncoding() != null && !var1.containsHeader("Content-Encoding")) {
            var1.addHeader(var6.getContentEncoding());
         }
      } else {
         int var3 = var1.getStatusLine().getStatusCode();
         if(var3 != 204 && var3 != 304 && var3 != 205) {
            var1.addHeader("Content-Length", "0");
            return;
         }
      }

   }
}
