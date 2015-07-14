package org.apache.http.protocol;

import java.io.IOException;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpExpectationVerifier;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerMapper;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.util.Args;
import org.apache.http.util.EncodingUtils;

@Immutable
public class HttpService {
   private volatile ConnectionReuseStrategy connStrategy;
   private volatile HttpExpectationVerifier expectationVerifier;
   private volatile HttpRequestHandlerMapper handlerMapper;
   private volatile HttpParams params;
   private volatile HttpProcessor processor;
   private volatile HttpResponseFactory responseFactory;

   @Deprecated
   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3) {
      this.params = null;
      this.processor = null;
      this.handlerMapper = null;
      this.connStrategy = null;
      this.responseFactory = null;
      this.expectationVerifier = null;
      this.setHttpProcessor(var1);
      this.setConnReuseStrategy(var2);
      this.setResponseFactory(var3);
   }

   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerMapper var4) {
      this(var1, var2, var3, (HttpRequestHandlerMapper)var4, (HttpExpectationVerifier)null);
   }

   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerMapper var4, HttpExpectationVerifier var5) {
      this.params = null;
      this.processor = null;
      this.handlerMapper = null;
      this.connStrategy = null;
      this.responseFactory = null;
      this.expectationVerifier = null;
      this.processor = (HttpProcessor)Args.notNull(var1, "HTTP processor");
      if(var2 == null) {
         var2 = DefaultConnectionReuseStrategy.INSTANCE;
      }

      this.connStrategy = (ConnectionReuseStrategy)var2;
      if(var3 == null) {
         var3 = DefaultHttpResponseFactory.INSTANCE;
      }

      this.responseFactory = (HttpResponseFactory)var3;
      this.handlerMapper = var4;
      this.expectationVerifier = var5;
   }

   @Deprecated
   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerResolver var4, HttpParams var5) {
      this(var1, var2, var3, (HttpRequestHandlerMapper)(new HttpService.HttpRequestHandlerResolverAdapter(var4)), (HttpExpectationVerifier)null);
      this.params = var5;
   }

   @Deprecated
   public HttpService(HttpProcessor var1, ConnectionReuseStrategy var2, HttpResponseFactory var3, HttpRequestHandlerResolver var4, HttpExpectationVerifier var5, HttpParams var6) {
      this(var1, var2, var3, (HttpRequestHandlerMapper)(new HttpService.HttpRequestHandlerResolverAdapter(var4)), (HttpExpectationVerifier)var5);
      this.params = var6;
   }

   public HttpService(HttpProcessor var1, HttpRequestHandlerMapper var2) {
      this(var1, (ConnectionReuseStrategy)null, (HttpResponseFactory)null, (HttpRequestHandlerMapper)var2, (HttpExpectationVerifier)null);
   }

   protected void doService(HttpRequest var1, HttpResponse var2, HttpContext var3) throws HttpException, IOException {
      HttpRequestHandler var4 = null;
      if(this.handlerMapper != null) {
         var4 = this.handlerMapper.lookup(var1);
      }

      if(var4 != null) {
         var4.handle(var1, var2, var3);
      } else {
         var2.setStatusCode(501);
      }
   }

   @Deprecated
   public HttpParams getParams() {
      return this.params;
   }

   protected void handleException(HttpException var1, HttpResponse var2) {
      if(var1 instanceof MethodNotSupportedException) {
         var2.setStatusCode(501);
      } else if(var1 instanceof UnsupportedHttpVersionException) {
         var2.setStatusCode(505);
      } else if(var1 instanceof ProtocolException) {
         var2.setStatusCode(400);
      } else {
         var2.setStatusCode(500);
      }

      String var4 = var1.getMessage();
      String var3 = var4;
      if(var4 == null) {
         var3 = var1.toString();
      }

      ByteArrayEntity var5 = new ByteArrayEntity(EncodingUtils.getAsciiBytes(var3));
      var5.setContentType("text/plain; charset=US-ASCII");
      var2.setEntity(var5);
   }

   public void handleRequest(HttpServerConnection param1, HttpContext param2) throws IOException, HttpException {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public void setConnReuseStrategy(ConnectionReuseStrategy var1) {
      Args.notNull(var1, "Connection reuse strategy");
      this.connStrategy = var1;
   }

   @Deprecated
   public void setExpectationVerifier(HttpExpectationVerifier var1) {
      this.expectationVerifier = var1;
   }

   @Deprecated
   public void setHandlerResolver(HttpRequestHandlerResolver var1) {
      this.handlerMapper = new HttpService.HttpRequestHandlerResolverAdapter(var1);
   }

   @Deprecated
   public void setHttpProcessor(HttpProcessor var1) {
      Args.notNull(var1, "HTTP processor");
      this.processor = var1;
   }

   @Deprecated
   public void setParams(HttpParams var1) {
      this.params = var1;
   }

   @Deprecated
   public void setResponseFactory(HttpResponseFactory var1) {
      Args.notNull(var1, "Response factory");
      this.responseFactory = var1;
   }

   @Deprecated
   private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
      private final HttpRequestHandlerResolver resolver;

      public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver var1) {
         this.resolver = var1;
      }

      public HttpRequestHandler lookup(HttpRequest var1) {
         return this.resolver.lookup(var1.getRequestLine().getUri());
      }
   }
}
