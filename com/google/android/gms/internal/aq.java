package com.google.android.gms.internal;

import com.google.android.gms.internal.lk;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;

public class aq {
   private static boolean a(UnicodeBlock var0) {
      return var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || var0 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || var0 == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || var0 == UnicodeBlock.CJK_RADICALS_SUPPLEMENT || var0 == UnicodeBlock.CJK_COMPATIBILITY || var0 == UnicodeBlock.CJK_COMPATIBILITY_FORMS || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || var0 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT || var0 == UnicodeBlock.BOPOMOFO || var0 == UnicodeBlock.HIRAGANA || var0 == UnicodeBlock.KATAKANA || var0 == UnicodeBlock.HANGUL_SYLLABLES || var0 == UnicodeBlock.HANGUL_JAMO;
   }

   static boolean d(int var0) {
      return Character.isLetter(var0) && a(UnicodeBlock.of(var0));
   }

   public static int o(String var0) {
      byte[] var1;
      byte[] var3;
      try {
         var1 = var0.getBytes("UTF-8");
      } catch (UnsupportedEncodingException var2) {
         var3 = var0.getBytes();
         return lk.a(var3, 0, var3.length, 0);
      }

      var3 = var1;
      return lk.a(var3, 0, var3.length, 0);
   }

   public static String[] p(String var0) {
      if(var0 == null) {
         return null;
      } else {
         ArrayList var7 = new ArrayList();
         char[] var8 = var0.toCharArray();
         int var5 = var0.length();
         boolean var2 = false;
         int var1 = 0;

         int var3;
         int var4;
         for(var3 = 0; var3 < var5; var3 = var4) {
            var4 = Character.codePointAt(var8, var3);
            int var6 = Character.charCount(var4);
            boolean var9;
            int var10;
            if(d(var4)) {
               if(var2) {
                  var7.add(new String(var8, var1, var3 - var1));
               }

               var7.add(new String(var8, var3, var6));
               boolean var11 = false;
               var10 = var1;
               var9 = var11;
            } else if(Character.isLetterOrDigit(var4)) {
               if(!var2) {
                  var1 = var3;
               }

               var10 = var1;
               var9 = true;
            } else if(var2) {
               var7.add(new String(var8, var1, var3 - var1));
               var10 = var1;
               var9 = false;
            } else {
               var4 = var1;
               var9 = var2;
               var10 = var4;
            }

            var4 = var3 + var6;
            var3 = var10;
            var2 = var9;
            var1 = var3;
         }

         if(var2) {
            var7.add(new String(var8, var1, var3 - var1));
         }

         return (String[])var7.toArray(new String[var7.size()]);
      }
   }
}
