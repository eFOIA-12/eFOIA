package org.apache.http.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.Args;

public final class EntityUtils {
   public static void consume(HttpEntity var0) throws IOException {
      if(var0 != null && var0.isStreaming()) {
         InputStream var1 = var0.getContent();
         if(var1 != null) {
            var1.close();
            return;
         }
      }

   }

   public static void consumeQuietly(HttpEntity var0) {
      try {
         consume(var0);
      } catch (IOException var1) {
         ;
      }
   }

   @Deprecated
   public static String getContentCharSet(HttpEntity var0) throws ParseException {
      Args.notNull(var0, "Entity");
      Object var2 = null;
      String var1 = (String)var2;
      if(var0.getContentType() != null) {
         HeaderElement[] var3 = var0.getContentType().getElements();
         var1 = (String)var2;
         if(var3.length > 0) {
            NameValuePair var4 = var3[0].getParameterByName("charset");
            var1 = (String)var2;
            if(var4 != null) {
               var1 = var4.getValue();
            }
         }
      }

      return var1;
   }

   @Deprecated
   public static String getContentMimeType(HttpEntity var0) throws ParseException {
      Args.notNull(var0, "Entity");
      Object var2 = null;
      String var1 = (String)var2;
      if(var0.getContentType() != null) {
         HeaderElement[] var3 = var0.getContentType().getElements();
         var1 = (String)var2;
         if(var3.length > 0) {
            var1 = var3[0].getName();
         }
      }

      return var1;
   }

   public static byte[] toByteArray(HttpEntity param0) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public static String toString(HttpEntity var0) throws IOException, ParseException {
      return toString(var0, (Charset)null);
   }

   public static String toString(HttpEntity var0, String var1) throws IOException, ParseException {
      Charset var2;
      if(var1 != null) {
         var2 = Charset.forName(var1);
      } else {
         var2 = null;
      }

      return toString(var0, var2);
   }

   public static String toString(HttpEntity param0, Charset param1) throws IOException, ParseException {
      // $FF: Couldn't be decompiled
   }

   public static void updateEntity(HttpResponse var0, HttpEntity var1) throws IOException {
      Args.notNull(var0, "Response");
      consume(var0.getEntity());
      var0.setEntity(var1);
   }
}
