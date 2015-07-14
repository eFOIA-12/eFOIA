package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.ld;

public final class lf implements ld {
   private static lf Of;

   public static ld if() {
      synchronized(lf.class){}

      lf var0;
      try {
         if(Of == null) {
            Of = new lf();
         }

         var0 = Of;
      } finally {
         ;
      }

      return var0;
   }

   public long currentTimeMillis() {
      return System.currentTimeMillis();
   }

   public long elapsedRealtime() {
      return SystemClock.elapsedRealtime();
   }
}
