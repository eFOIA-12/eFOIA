package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

public class CharsetUtils {
   public static Charset get(String var0) throws UnsupportedEncodingException {
      if(var0 == null) {
         return null;
      } else {
         try {
            Charset var1 = Charset.forName(var0);
            return var1;
         } catch (UnsupportedCharsetException var2) {
            throw new UnsupportedEncodingException(var0);
         }
      }
   }

   public static Charset lookup(String var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            Charset var2 = Charset.forName(var0);
            return var2;
         } catch (UnsupportedCharsetException var1) {
            return null;
         }
      }
   }
}
