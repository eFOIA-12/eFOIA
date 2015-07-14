package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class LaxContentLengthStrategy implements ContentLengthStrategy {
   public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
   private final int implicitLen;

   public LaxContentLengthStrategy() {
      this(-1);
   }

   public LaxContentLengthStrategy(int var1) {
      this.implicitLen = var1;
   }

   public long determineLength(HttpMessage var1) throws HttpException {
      Args.notNull(var1, "HTTP message");
      Header var7 = var1.getFirstHeader("Transfer-Encoding");
      int var2;
      long var5;
      if(var7 != null) {
         HeaderElement[] var10;
         try {
            var10 = var7.getElements();
         } catch (ParseException var8) {
            throw new ProtocolException("Invalid Transfer-Encoding header value: " + var7, var8);
         }

         var2 = var10.length;
         if(!"identity".equalsIgnoreCase(var7.getValue())) {
            if(var2 > 0 && "chunked".equalsIgnoreCase(var10[var2 - 1].getName())) {
               return -2L;
            }

            return -1L;
         }

         var5 = -1L;
      } else {
         if(var1.getFirstHeader("Content-Length") == null) {
            return (long)this.implicitLen;
         }

         var5 = -1L;
         Header[] var11 = var1.getHeaders("Content-Length");
         var2 = var11.length - 1;

         long var3;
         while(true) {
            var3 = var5;
            if(var2 < 0) {
               break;
            }

            var7 = var11[var2];

            try {
               var3 = Long.parseLong(var7.getValue());
               break;
            } catch (NumberFormatException var9) {
               --var2;
            }
         }

         var5 = var3;
         if(var3 < 0L) {
            return -1L;
         }
      }

      return var5;
   }
}
