package org.apache.http;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;
import org.apache.http.util.LangUtils;

@Immutable
public final class HttpHost implements Cloneable, Serializable {
   public static final String DEFAULT_SCHEME_NAME = "http";
   private static final long serialVersionUID = -7529410654042457626L;
   protected final InetAddress address;
   protected final String hostname;
   protected final String lcHostname;
   protected final int port;
   protected final String schemeName;

   public HttpHost(String var1) {
      this((String)var1, -1, (String)null);
   }

   public HttpHost(String var1, int var2) {
      this((String)var1, var2, (String)null);
   }

   public HttpHost(String var1, int var2, String var3) {
      this.hostname = (String)Args.notBlank(var1, "Host name");
      this.lcHostname = var1.toLowerCase(Locale.ENGLISH);
      if(var3 != null) {
         this.schemeName = var3.toLowerCase(Locale.ENGLISH);
      } else {
         this.schemeName = "http";
      }

      this.port = var2;
      this.address = null;
   }

   public HttpHost(InetAddress var1) {
      this((InetAddress)var1, -1, (String)null);
   }

   public HttpHost(InetAddress var1, int var2) {
      this((InetAddress)var1, var2, (String)null);
   }

   public HttpHost(InetAddress var1, int var2, String var3) {
      this.address = (InetAddress)Args.notNull(var1, "Inet address");
      this.hostname = var1.getHostAddress();
      this.lcHostname = this.hostname.toLowerCase(Locale.ENGLISH);
      if(var3 != null) {
         this.schemeName = var3.toLowerCase(Locale.ENGLISH);
      } else {
         this.schemeName = "http";
      }

      this.port = var2;
   }

   public HttpHost(HttpHost var1) {
      Args.notNull(var1, "HTTP host");
      this.hostname = var1.hostname;
      this.lcHostname = var1.lcHostname;
      this.schemeName = var1.schemeName;
      this.port = var1.port;
      this.address = var1.address;
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof HttpHost)) {
            return false;
         }

         HttpHost var2 = (HttpHost)var1;
         if(!this.lcHostname.equals(var2.lcHostname) || this.port != var2.port || !this.schemeName.equals(var2.schemeName)) {
            return false;
         }
      }

      return true;
   }

   public InetAddress getAddress() {
      return this.address;
   }

   public String getHostName() {
      return this.hostname;
   }

   public int getPort() {
      return this.port;
   }

   public String getSchemeName() {
      return this.schemeName;
   }

   public int hashCode() {
      return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
   }

   public String toHostString() {
      if(this.port != -1) {
         StringBuilder var1 = new StringBuilder(this.hostname.length() + 6);
         var1.append(this.hostname);
         var1.append(":");
         var1.append(Integer.toString(this.port));
         return var1.toString();
      } else {
         return this.hostname;
      }
   }

   public String toString() {
      return this.toURI();
   }

   public String toURI() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.schemeName);
      var1.append("://");
      var1.append(this.hostname);
      if(this.port != -1) {
         var1.append(':');
         var1.append(Integer.toString(this.port));
      }

      return var1.toString();
   }
}
