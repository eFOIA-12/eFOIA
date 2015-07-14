package org.apache.http.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

@ThreadSafe
public class BasicHttpContext implements HttpContext {
   private final Map map;
   private final HttpContext parentContext;

   public BasicHttpContext() {
      this((HttpContext)null);
   }

   public BasicHttpContext(HttpContext var1) {
      this.map = new ConcurrentHashMap();
      this.parentContext = var1;
   }

   public void clear() {
      this.map.clear();
   }

   public Object getAttribute(String var1) {
      Args.notNull(var1, "Id");
      Object var3 = this.map.get(var1);
      Object var2 = var3;
      if(var3 == null) {
         var2 = var3;
         if(this.parentContext != null) {
            var2 = this.parentContext.getAttribute(var1);
         }
      }

      return var2;
   }

   public Object removeAttribute(String var1) {
      Args.notNull(var1, "Id");
      return this.map.remove(var1);
   }

   public void setAttribute(String var1, Object var2) {
      Args.notNull(var1, "Id");
      if(var2 != null) {
         this.map.put(var1, var2);
      } else {
         this.map.remove(var1);
      }
   }

   public String toString() {
      return this.map.toString();
   }
}
