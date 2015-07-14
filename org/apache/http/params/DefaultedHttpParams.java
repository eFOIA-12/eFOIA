package org.apache.http.params;

import java.util.HashSet;
import java.util.Set;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;
import org.apache.http.util.Args;

@Deprecated
public final class DefaultedHttpParams extends AbstractHttpParams {
   private final HttpParams defaults;
   private final HttpParams local;

   public DefaultedHttpParams(HttpParams var1, HttpParams var2) {
      this.local = (HttpParams)Args.notNull(var1, "Local HTTP parameters");
      this.defaults = var2;
   }

   private Set getNames(HttpParams var1) {
      if(var1 instanceof HttpParamsNames) {
         return ((HttpParamsNames)var1).getNames();
      } else {
         throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
      }
   }

   public HttpParams copy() {
      return new DefaultedHttpParams(this.local.copy(), this.defaults);
   }

   public Set getDefaultNames() {
      return new HashSet(this.getNames(this.defaults));
   }

   public HttpParams getDefaults() {
      return this.defaults;
   }

   public Set getLocalNames() {
      return new HashSet(this.getNames(this.local));
   }

   public Set getNames() {
      HashSet var1 = new HashSet(this.getNames(this.defaults));
      var1.addAll(this.getNames(this.local));
      return var1;
   }

   public Object getParameter(String var1) {
      Object var3 = this.local.getParameter(var1);
      Object var2 = var3;
      if(var3 == null) {
         var2 = var3;
         if(this.defaults != null) {
            var2 = this.defaults.getParameter(var1);
         }
      }

      return var2;
   }

   public boolean removeParameter(String var1) {
      return this.local.removeParameter(var1);
   }

   public HttpParams setParameter(String var1, Object var2) {
      return this.local.setParameter(var1, var2);
   }
}
