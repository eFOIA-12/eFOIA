package org.apache.http.message;

import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.LineFormatter;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@Immutable
public class BasicLineFormatter implements LineFormatter {
   @Deprecated
   public static final BasicLineFormatter DEFAULT = new BasicLineFormatter();
   public static final BasicLineFormatter INSTANCE = new BasicLineFormatter();

   public static String formatHeader(Header var0, LineFormatter var1) {
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineFormatter)var1).formatHeader((CharArrayBuffer)null, var0).toString();
   }

   public static String formatProtocolVersion(ProtocolVersion var0, LineFormatter var1) {
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineFormatter)var1).appendProtocolVersion((CharArrayBuffer)null, var0).toString();
   }

   public static String formatRequestLine(RequestLine var0, LineFormatter var1) {
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineFormatter)var1).formatRequestLine((CharArrayBuffer)null, var0).toString();
   }

   public static String formatStatusLine(StatusLine var0, LineFormatter var1) {
      if(var1 == null) {
         var1 = INSTANCE;
      }

      return ((LineFormatter)var1).formatStatusLine((CharArrayBuffer)null, var0).toString();
   }

   public CharArrayBuffer appendProtocolVersion(CharArrayBuffer var1, ProtocolVersion var2) {
      Args.notNull(var2, "Protocol version");
      int var3 = this.estimateProtocolVersionLen(var2);
      if(var1 == null) {
         var1 = new CharArrayBuffer(var3);
      } else {
         var1.ensureCapacity(var3);
      }

      var1.append(var2.getProtocol());
      var1.append('/');
      var1.append(Integer.toString(var2.getMajor()));
      var1.append('.');
      var1.append(Integer.toString(var2.getMinor()));
      return var1;
   }

   protected void doFormatHeader(CharArrayBuffer var1, Header var2) {
      String var5 = var2.getName();
      String var6 = var2.getValue();
      int var4 = var5.length() + 2;
      int var3 = var4;
      if(var6 != null) {
         var3 = var4 + var6.length();
      }

      var1.ensureCapacity(var3);
      var1.append(var5);
      var1.append(": ");
      if(var6 != null) {
         var1.append(var6);
      }

   }

   protected void doFormatRequestLine(CharArrayBuffer var1, RequestLine var2) {
      String var3 = var2.getMethod();
      String var4 = var2.getUri();
      var1.ensureCapacity(var3.length() + 1 + var4.length() + 1 + this.estimateProtocolVersionLen(var2.getProtocolVersion()));
      var1.append(var3);
      var1.append(' ');
      var1.append(var4);
      var1.append(' ');
      this.appendProtocolVersion(var1, var2.getProtocolVersion());
   }

   protected void doFormatStatusLine(CharArrayBuffer var1, StatusLine var2) {
      int var4 = this.estimateProtocolVersionLen(var2.getProtocolVersion()) + 1 + 3 + 1;
      String var5 = var2.getReasonPhrase();
      int var3 = var4;
      if(var5 != null) {
         var3 = var4 + var5.length();
      }

      var1.ensureCapacity(var3);
      this.appendProtocolVersion(var1, var2.getProtocolVersion());
      var1.append(' ');
      var1.append(Integer.toString(var2.getStatusCode()));
      var1.append(' ');
      if(var5 != null) {
         var1.append(var5);
      }

   }

   protected int estimateProtocolVersionLen(ProtocolVersion var1) {
      return var1.getProtocol().length() + 4;
   }

   public CharArrayBuffer formatHeader(CharArrayBuffer var1, Header var2) {
      Args.notNull(var2, "Header");
      if(var2 instanceof FormattedHeader) {
         return ((FormattedHeader)var2).getBuffer();
      } else {
         var1 = this.initBuffer(var1);
         this.doFormatHeader(var1, var2);
         return var1;
      }
   }

   public CharArrayBuffer formatRequestLine(CharArrayBuffer var1, RequestLine var2) {
      Args.notNull(var2, "Request line");
      var1 = this.initBuffer(var1);
      this.doFormatRequestLine(var1, var2);
      return var1;
   }

   public CharArrayBuffer formatStatusLine(CharArrayBuffer var1, StatusLine var2) {
      Args.notNull(var2, "Status line");
      var1 = this.initBuffer(var1);
      this.doFormatStatusLine(var1, var2);
      return var1;
   }

   protected CharArrayBuffer initBuffer(CharArrayBuffer var1) {
      if(var1 != null) {
         var1.clear();
         return var1;
      } else {
         return new CharArrayBuffer(64);
      }
   }
}
