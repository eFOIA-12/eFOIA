package org.apache.http.util;

import java.io.UnsupportedEncodingException;
import org.apache.http.Consts;
import org.apache.http.util.Args;

public final class EncodingUtils {
   public static byte[] getAsciiBytes(String var0) {
      Args.notNull(var0, "Input");

      try {
         byte[] var2 = var0.getBytes(Consts.ASCII.name());
         return var2;
      } catch (UnsupportedEncodingException var1) {
         throw new Error("ASCII not supported");
      }
   }

   public static String getAsciiString(byte[] var0) {
      Args.notNull(var0, "Input");
      return getAsciiString(var0, 0, var0.length);
   }

   public static String getAsciiString(byte[] var0, int var1, int var2) {
      Args.notNull(var0, "Input");

      try {
         String var4 = new String(var0, var1, var2, Consts.ASCII.name());
         return var4;
      } catch (UnsupportedEncodingException var3) {
         throw new Error("ASCII not supported");
      }
   }

   public static byte[] getBytes(String var0, String var1) {
      Args.notNull(var0, "Input");
      Args.notEmpty((CharSequence)var1, "Charset");

      try {
         byte[] var3 = var0.getBytes(var1);
         return var3;
      } catch (UnsupportedEncodingException var2) {
         return var0.getBytes();
      }
   }

   public static String getString(byte[] var0, int var1, int var2, String var3) {
      Args.notNull(var0, "Input");
      Args.notEmpty((CharSequence)var3, "Charset");

      try {
         var3 = new String(var0, var1, var2, var3);
         return var3;
      } catch (UnsupportedEncodingException var4) {
         return new String(var0, var1, var2);
      }
   }

   public static String getString(byte[] var0, String var1) {
      Args.notNull(var0, "Input");
      return getString(var0, 0, var0.length, var1);
   }
}
