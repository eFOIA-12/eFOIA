package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@Immutable
public class RequestExpectContinue implements HttpRequestInterceptor {
   private final boolean activeByDefault;

   @Deprecated
   public RequestExpectContinue() {
      this(false);
   }

   public RequestExpectContinue(boolean var1) {
      this.activeByDefault = var1;
   }

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      if(!var1.containsHeader("Expect") && var1 instanceof HttpEntityEnclosingRequest) {
         ProtocolVersion var4 = var1.getRequestLine().getProtocolVersion();
         HttpEntity var3 = ((HttpEntityEnclosingRequest)var1).getEntity();
         if(var3 != null && var3.getContentLength() != 0L && !var4.lessEquals(HttpVersion.HTTP_1_0) && var1.getParams().getBooleanParameter("http.protocol.expect-continue", this.activeByDefault)) {
            var1.addHeader("Expect", "100-continue");
         }
      }

   }
}
