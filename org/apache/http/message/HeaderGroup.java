package org.apache.http.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicListHeaderIterator;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class HeaderGroup implements Cloneable, Serializable {
   private static final long serialVersionUID = 2608834160639271617L;
   private final List headers = new ArrayList(16);

   public void addHeader(Header var1) {
      if(var1 != null) {
         this.headers.add(var1);
      }
   }

   public void clear() {
      this.headers.clear();
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public boolean containsHeader(String var1) {
      for(int var2 = 0; var2 < this.headers.size(); ++var2) {
         if(((Header)this.headers.get(var2)).getName().equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   public HeaderGroup copy() {
      HeaderGroup var1 = new HeaderGroup();
      var1.headers.addAll(this.headers);
      return var1;
   }

   public Header[] getAllHeaders() {
      return (Header[])this.headers.toArray(new Header[this.headers.size()]);
   }

   public Header getCondensedHeader(String var1) {
      Header[] var3 = this.getHeaders(var1);
      if(var3.length == 0) {
         return null;
      } else if(var3.length == 1) {
         return var3[0];
      } else {
         CharArrayBuffer var4 = new CharArrayBuffer(128);
         var4.append(var3[0].getValue());

         for(int var2 = 1; var2 < var3.length; ++var2) {
            var4.append(", ");
            var4.append(var3[var2].getValue());
         }

         return new BasicHeader(var1.toLowerCase(Locale.ENGLISH), var4.toString());
      }
   }

   public Header getFirstHeader(String var1) {
      for(int var2 = 0; var2 < this.headers.size(); ++var2) {
         Header var3 = (Header)this.headers.get(var2);
         if(var3.getName().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public Header[] getHeaders(String var1) {
      ArrayList var3 = new ArrayList();

      for(int var2 = 0; var2 < this.headers.size(); ++var2) {
         Header var4 = (Header)this.headers.get(var2);
         if(var4.getName().equalsIgnoreCase(var1)) {
            var3.add(var4);
         }
      }

      return (Header[])var3.toArray(new Header[var3.size()]);
   }

   public Header getLastHeader(String var1) {
      for(int var2 = this.headers.size() - 1; var2 >= 0; --var2) {
         Header var3 = (Header)this.headers.get(var2);
         if(var3.getName().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public HeaderIterator iterator() {
      return new BasicListHeaderIterator(this.headers, (String)null);
   }

   public HeaderIterator iterator(String var1) {
      return new BasicListHeaderIterator(this.headers, var1);
   }

   public void removeHeader(Header var1) {
      if(var1 != null) {
         this.headers.remove(var1);
      }
   }

   public void setHeaders(Header[] var1) {
      this.clear();
      if(var1 != null) {
         Collections.addAll(this.headers, var1);
      }
   }

   public String toString() {
      return this.headers.toString();
   }

   public void updateHeader(Header var1) {
      if(var1 != null) {
         for(int var2 = 0; var2 < this.headers.size(); ++var2) {
            if(((Header)this.headers.get(var2)).getName().equalsIgnoreCase(var1.getName())) {
               this.headers.set(var2, var1);
               return;
            }
         }

         this.headers.add(var1);
      }
   }
}
