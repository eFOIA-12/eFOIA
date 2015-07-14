package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class lt {
   private static final List TS;

   static {
      TS = Arrays.asList(new TimeUnit[]{TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS});
   }

   public static long a(long var0, TimeUnit var2, TimeUnit var3) {
      return var2.convert(var3.convert(var0, var2), var3);
   }

   public static boolean a(TimeUnit var0) {
      return a(var0, TimeUnit.MILLISECONDS);
   }

   private static boolean a(TimeUnit var0, TimeUnit var1) {
      return TS.indexOf(var0) < TS.indexOf(var1);
   }
}
