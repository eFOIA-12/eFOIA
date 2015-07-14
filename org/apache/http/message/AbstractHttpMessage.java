package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;

@NotThreadSafe
public abstract class AbstractHttpMessage implements HttpMessage {
   protected HeaderGroup headergroup;
   @Deprecated
   protected HttpParams params;

   protected AbstractHttpMessage() {
      this((HttpParams)null);
   }

   @Deprecated
   protected AbstractHttpMessage(HttpParams var1) {
      this.headergroup = new HeaderGroup();
      this.params = var1;
   }

   public void addHeader(String var1, String var2) {
      Args.notNull(var1, "Header name");
      this.headergroup.addHeader(new BasicHeader(var1, var2));
   }

   public void addHeader(Header var1) {
      this.headergroup.addHeader(var1);
   }

   public boolean containsHeader(String var1) {
      return this.headergroup.containsHeader(var1);
   }

   public Header[] getAllHeaders() {
      return this.headergroup.getAllHeaders();
   }

   public Header getFirstHeader(String var1) {
      return this.headergroup.getFirstHeader(var1);
   }

   public Header[] getHeaders(String var1) {
      return this.headergroup.getHeaders(var1);
   }

   public Header getLastHeader(String var1) {
      return this.headergroup.getLastHeader(var1);
   }

   @Deprecated
   public HttpParams getParams() {
      if(this.params == null) {
         this.params = new BasicHttpParams();
      }

      return this.params;
   }

   public HeaderIterator headerIterator() {
      return this.headergroup.iterator();
   }

   public HeaderIterator headerIterator(String var1) {
      return this.headergroup.iterator(var1);
   }

   public void removeHeader(Header var1) {
      this.headergroup.removeHeader(var1);
   }

   public void removeHeaders(String var1) {
      if(var1 != null) {
         HeaderIterator var2 = this.headergroup.iterator();

         while(var2.hasNext()) {
            if(var1.equalsIgnoreCase(var2.nextHeader().getName())) {
               var2.remove();
            }
         }
      }

   }

   public void setHeader(String var1, String var2) {
      Args.notNull(var1, "Header name");
      this.headergroup.updateHeader(new BasicHeader(var1, var2));
   }

   public void setHeader(Header var1) {
      this.headergroup.updateHeader(var1);
   }

   public void setHeaders(Header[] var1) {
      this.headergroup.setHeaders(var1);
   }

   @Deprecated
   public void setParams(HttpParams var1) {
      this.params = (HttpParams)Args.notNull(var1, "HTTP parameters");
   }
}
