package com.crashlytics.android.core;

import android.content.Context;
import java.io.OutputStream;
import java.io.Writer;

final class ExceptionUtils {
   private static String getMessage(Throwable var0) {
      String var1 = var0.getLocalizedMessage();
      return var1 == null?null:var1.replaceAll("(\r\n|\n|\f)", " ");
   }

   public static void writeStackTrace(Context param0, Throwable param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private static void writeStackTrace(Throwable param0, OutputStream param1) {
      // $FF: Couldn't be decompiled
   }

   private static void writeStackTrace(Throwable param0, Writer param1) {
      // $FF: Couldn't be decompiled
   }

   public static void writeStackTraceIfNotNull(Throwable var0, OutputStream var1) {
      if(var1 != null) {
         writeStackTrace(var0, var1);
      }

   }
}
