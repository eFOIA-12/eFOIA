package org.apache.http.protocol;

import java.util.Map;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.protocol.HttpRequestHandlerResolver;
import org.apache.http.protocol.UriPatternMatcher;
import org.apache.http.util.Args;

@Deprecated
@ThreadSafe
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
   private final UriPatternMatcher matcher = new UriPatternMatcher();

   public Map getHandlers() {
      return this.matcher.getObjects();
   }

   public HttpRequestHandler lookup(String var1) {
      return (HttpRequestHandler)this.matcher.lookup(var1);
   }

   public void register(String var1, HttpRequestHandler var2) {
      Args.notNull(var1, "URI request pattern");
      Args.notNull(var2, "Request handler");
      this.matcher.register(var1, var2);
   }

   public void setHandlers(Map var1) {
      this.matcher.setObjects(var1);
   }

   public void unregister(String var1) {
      this.matcher.unregister(var1);
   }
}
