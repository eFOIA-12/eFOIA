package org.apache.http.protocol;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

@ThreadSafe
public class UriPatternMatcher {
   @GuardedBy("this")
   private final Map map = new HashMap();

   @Deprecated
   public Map getObjects() {
      synchronized(this){}

      Map var1;
      try {
         var1 = this.map;
      } finally {
         ;
      }

      return var1;
   }

   public Object lookup(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected boolean matchUriRequestPattern(String var1, String var2) {
      boolean var4 = false;
      if(var1.equals("*")) {
         return true;
      } else {
         boolean var3;
         if(!var1.endsWith("*") || !var2.startsWith(var1.substring(0, var1.length() - 1))) {
            var3 = var4;
            if(!var1.startsWith("*")) {
               return var3;
            }

            var3 = var4;
            if(!var2.endsWith(var1.substring(1, var1.length()))) {
               return var3;
            }
         }

         var3 = true;
         return var3;
      }
   }

   public void register(String var1, Object var2) {
      synchronized(this){}

      try {
         Args.notNull(var1, "URI request pattern");
         this.map.put(var1, var2);
      } finally {
         ;
      }

   }

   @Deprecated
   public void setHandlers(Map var1) {
      synchronized(this){}

      try {
         Args.notNull(var1, "Map of handlers");
         this.map.clear();
         this.map.putAll(var1);
      } finally {
         ;
      }

   }

   @Deprecated
   public void setObjects(Map var1) {
      synchronized(this){}

      try {
         Args.notNull(var1, "Map of handlers");
         this.map.clear();
         this.map.putAll(var1);
      } finally {
         ;
      }

   }

   public String toString() {
      return this.map.toString();
   }

   public void unregister(String var1) {
      synchronized(this){}
      if(var1 != null) {
         try {
            this.map.remove(var1);
         } finally {
            ;
         }
      }

   }
}
