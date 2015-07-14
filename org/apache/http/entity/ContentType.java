package org.apache.http.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.annotation.Immutable;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.TextUtils;

@Immutable
public final class ContentType implements Serializable {
   public static final ContentType APPLICATION_ATOM_XML;
   public static final ContentType APPLICATION_FORM_URLENCODED;
   public static final ContentType APPLICATION_JSON;
   public static final ContentType APPLICATION_OCTET_STREAM;
   public static final ContentType APPLICATION_SVG_XML;
   public static final ContentType APPLICATION_XHTML_XML;
   public static final ContentType APPLICATION_XML;
   public static final ContentType DEFAULT_BINARY;
   public static final ContentType DEFAULT_TEXT;
   public static final ContentType MULTIPART_FORM_DATA;
   public static final ContentType TEXT_HTML;
   public static final ContentType TEXT_PLAIN;
   public static final ContentType TEXT_XML;
   public static final ContentType WILDCARD;
   private static final long serialVersionUID = -7768694718232371896L;
   private final Charset charset;
   private final String mimeType;
   private final NameValuePair[] params;

   static {
      APPLICATION_ATOM_XML = create("application/atom+xml", Consts.ISO_8859_1);
      APPLICATION_FORM_URLENCODED = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
      APPLICATION_JSON = create("application/json", Consts.UTF_8);
      APPLICATION_OCTET_STREAM = create("application/octet-stream", (Charset)null);
      APPLICATION_SVG_XML = create("application/svg+xml", Consts.ISO_8859_1);
      APPLICATION_XHTML_XML = create("application/xhtml+xml", Consts.ISO_8859_1);
      APPLICATION_XML = create("application/xml", Consts.ISO_8859_1);
      MULTIPART_FORM_DATA = create("multipart/form-data", Consts.ISO_8859_1);
      TEXT_HTML = create("text/html", Consts.ISO_8859_1);
      TEXT_PLAIN = create("text/plain", Consts.ISO_8859_1);
      TEXT_XML = create("text/xml", Consts.ISO_8859_1);
      WILDCARD = create("*/*", (Charset)null);
      DEFAULT_TEXT = TEXT_PLAIN;
      DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
   }

   ContentType(String var1, Charset var2) {
      this.mimeType = var1;
      this.charset = var2;
      this.params = null;
   }

   ContentType(String var1, NameValuePair[] var2) throws UnsupportedCharsetException {
      this.mimeType = var1;
      this.params = var2;
      var1 = this.getParameter("charset");
      Charset var3;
      if(!TextUtils.isBlank(var1)) {
         var3 = Charset.forName(var1);
      } else {
         var3 = null;
      }

      this.charset = var3;
   }

   public static ContentType create(String var0) {
      return new ContentType(var0, (Charset)null);
   }

   public static ContentType create(String var0, String var1) throws UnsupportedCharsetException {
      Charset var2;
      if(!TextUtils.isBlank(var1)) {
         var2 = Charset.forName(var1);
      } else {
         var2 = null;
      }

      return create(var0, var2);
   }

   public static ContentType create(String var0, Charset var1) {
      var0 = ((String)Args.notBlank(var0, "MIME type")).toLowerCase(Locale.US);
      Args.check(valid(var0), "MIME type may not contain reserved characters");
      return new ContentType(var0, var1);
   }

   private static ContentType create(HeaderElement var0) {
      String var1 = var0.getName();
      NameValuePair[] var2 = var0.getParameters();
      if(var2 == null || var2.length <= 0) {
         var2 = null;
      }

      return new ContentType(var1, var2);
   }

   public static ContentType get(HttpEntity var0) throws ParseException, UnsupportedCharsetException {
      if(var0 != null) {
         Header var1 = var0.getContentType();
         if(var1 != null) {
            HeaderElement[] var2 = var1.getElements();
            if(var2.length > 0) {
               return create(var2[0]);
            }
         }
      }

      return null;
   }

   public static ContentType getOrDefault(HttpEntity var0) throws ParseException, UnsupportedCharsetException {
      ContentType var1 = get(var0);
      return var1 != null?var1:DEFAULT_TEXT;
   }

   public static ContentType parse(String var0) throws ParseException, UnsupportedCharsetException {
      Args.notNull(var0, "Content type");
      CharArrayBuffer var1 = new CharArrayBuffer(var0.length());
      var1.append(var0);
      ParserCursor var2 = new ParserCursor(0, var0.length());
      HeaderElement[] var3 = BasicHeaderValueParser.INSTANCE.parseElements(var1, var2);
      if(var3.length > 0) {
         return create(var3[0]);
      } else {
         throw new ParseException("Invalid content type: " + var0);
      }
   }

   private static boolean valid(String var0) {
      for(int var1 = 0; var1 < var0.length(); ++var1) {
         char var2 = var0.charAt(var1);
         if(var2 == 34 || var2 == 44 || var2 == 59) {
            return false;
         }
      }

      return true;
   }

   public Charset getCharset() {
      return this.charset;
   }

   public String getMimeType() {
      return this.mimeType;
   }

   public String getParameter(String var1) {
      Args.notEmpty((CharSequence)var1, "Parameter name");
      if(this.params != null) {
         NameValuePair[] var4 = this.params;
         int var3 = var4.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            NameValuePair var5 = var4[var2];
            if(var5.getName().equalsIgnoreCase(var1)) {
               return var5.getValue();
            }
         }
      }

      return null;
   }

   public String toString() {
      CharArrayBuffer var1 = new CharArrayBuffer(64);
      var1.append(this.mimeType);
      if(this.params != null) {
         var1.append("; ");
         BasicHeaderValueFormatter.INSTANCE.formatParameters(var1, this.params, false);
      } else if(this.charset != null) {
         var1.append("; charset=");
         var1.append(this.charset.name());
      }

      return var1.toString();
   }

   public ContentType withCharset(String var1) {
      return create(this.getMimeType(), var1);
   }

   public ContentType withCharset(Charset var1) {
      return create(this.getMimeType(), var1);
   }
}
