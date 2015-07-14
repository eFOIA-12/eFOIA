package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.util.Args;

@Immutable
public class HttpRequestExecutor {
   public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
   private final int waitForContinue;

   public HttpRequestExecutor() {
      this(3000);
   }

   public HttpRequestExecutor(int var1) {
      this.waitForContinue = Args.positive(var1, "Wait for continue time");
   }

   private static void closeConnection(HttpClientConnection var0) {
      try {
         var0.close();
      } catch (IOException var1) {
         ;
      }
   }

   protected boolean canResponseHaveBody(HttpRequest var1, HttpResponse var2) {
      if(!"HEAD".equalsIgnoreCase(var1.getRequestLine().getMethod())) {
         int var3 = var2.getStatusLine().getStatusCode();
         if(var3 >= 200 && var3 != 204 && var3 != 304 && var3 != 205) {
            return true;
         }
      }

      return false;
   }

   protected HttpResponse doReceiveResponse(HttpRequest var1, HttpClientConnection var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "Client connection");
      Args.notNull(var3, "HTTP context");
      HttpResponse var5 = null;

      for(int var4 = 0; var5 == null || var4 < 200; var4 = var5.getStatusLine().getStatusCode()) {
         var5 = var2.receiveResponseHeader();
         if(this.canResponseHaveBody(var1, var5)) {
            var2.receiveResponseEntity(var5);
         }
      }

      return var5;
   }

   protected HttpResponse doSendRequest(HttpRequest var1, HttpClientConnection var2, HttpContext var3) throws IOException, HttpException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "Client connection");
      Args.notNull(var3, "HTTP context");
      HttpResponse var7 = null;
      Object var8 = null;
      var3.setAttribute("http.connection", var2);
      var3.setAttribute("http.request_sent", Boolean.FALSE);
      var2.sendRequestHeader(var1);
      if(var1 instanceof HttpEntityEnclosingRequest) {
         boolean var5 = true;
         ProtocolVersion var10 = var1.getRequestLine().getProtocolVersion();
         HttpResponse var6 = (HttpResponse)var8;
         boolean var4 = var5;
         if(((HttpEntityEnclosingRequest)var1).expectContinue()) {
            var6 = (HttpResponse)var8;
            var4 = var5;
            if(!var10.lessEquals(HttpVersion.HTTP_1_0)) {
               var2.flush();
               var6 = (HttpResponse)var8;
               var4 = var5;
               if(var2.isResponseAvailable(this.waitForContinue)) {
                  var6 = var2.receiveResponseHeader();
                  if(this.canResponseHaveBody(var1, var6)) {
                     var2.receiveResponseEntity(var6);
                  }

                  int var9 = var6.getStatusLine().getStatusCode();
                  if(var9 < 200) {
                     if(var9 != 100) {
                        throw new ProtocolException("Unexpected response: " + var6.getStatusLine());
                     }

                     var6 = null;
                     var4 = var5;
                  } else {
                     var4 = false;
                  }
               }
            }
         }

         var7 = var6;
         if(var4) {
            var2.sendRequestEntity((HttpEntityEnclosingRequest)var1);
            var7 = var6;
         }
      }

      var2.flush();
      var3.setAttribute("http.request_sent", Boolean.TRUE);
      return var7;
   }

   public HttpResponse execute(HttpRequest param1, HttpClientConnection param2, HttpContext param3) throws IOException, HttpException {
      // $FF: Couldn't be decompiled
   }

   public void postProcess(HttpResponse var1, HttpProcessor var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP response");
      Args.notNull(var2, "HTTP processor");
      Args.notNull(var3, "HTTP context");
      var3.setAttribute("http.response", var1);
      var2.process(var1, var3);
   }

   public void preProcess(HttpRequest var1, HttpProcessor var2, HttpContext var3) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP processor");
      Args.notNull(var3, "HTTP context");
      var3.setAttribute("http.request", var1);
      var2.process(var1, var3);
   }
}
