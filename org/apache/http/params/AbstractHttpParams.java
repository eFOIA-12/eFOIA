package org.apache.http.params;

import java.util.Set;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpParamsNames;

@Deprecated
public abstract class AbstractHttpParams implements HttpParams, HttpParamsNames {
   public boolean getBooleanParameter(String var1, boolean var2) {
      Object var3 = this.getParameter(var1);
      return var3 == null?var2:((Boolean)var3).booleanValue();
   }

   public double getDoubleParameter(String var1, double var2) {
      Object var4 = this.getParameter(var1);
      return var4 == null?var2:((Double)var4).doubleValue();
   }

   public int getIntParameter(String var1, int var2) {
      Object var3 = this.getParameter(var1);
      return var3 == null?var2:((Integer)var3).intValue();
   }

   public long getLongParameter(String var1, long var2) {
      Object var4 = this.getParameter(var1);
      return var4 == null?var2:((Long)var4).longValue();
   }

   public Set getNames() {
      throw new UnsupportedOperationException();
   }

   public boolean isParameterFalse(String var1) {
      boolean var2 = false;
      if(!this.getBooleanParameter(var1, false)) {
         var2 = true;
      }

      return var2;
   }

   public boolean isParameterTrue(String var1) {
      return this.getBooleanParameter(var1, false);
   }

   public HttpParams setBooleanParameter(String var1, boolean var2) {
      Boolean var3;
      if(var2) {
         var3 = Boolean.TRUE;
      } else {
         var3 = Boolean.FALSE;
      }

      this.setParameter(var1, var3);
      return this;
   }

   public HttpParams setDoubleParameter(String var1, double var2) {
      this.setParameter(var1, Double.valueOf(var2));
      return this;
   }

   public HttpParams setIntParameter(String var1, int var2) {
      this.setParameter(var1, Integer.valueOf(var2));
      return this;
   }

   public HttpParams setLongParameter(String var1, long var2) {
      this.setParameter(var1, Long.valueOf(var2));
      return this;
   }
}
