package org.apache.http.util;

public final class TextUtils {
   public static boolean isBlank(CharSequence var0) {
      if(var0 != null) {
         for(int var1 = 0; var1 < var0.length(); ++var1) {
            if(!Character.isWhitespace(var0.charAt(var1))) {
               return false;
            }
         }
      }

      return true;
   }

   public static boolean isEmpty(CharSequence var0) {
      return var0 == null || var0.length() == 0;
   }
}
