package com.google.android.gms.internal;

import com.google.android.gms.internal.aq;
import com.google.android.gms.internal.gr;
import java.util.PriorityQueue;

public class as {
   static long a(int var0, int var1, long var2, long var4, long var6) {
      return ((var2 + 1073807359L - ((long)var0 + 2147483647L) % 1073807359L * var4 % 1073807359L) % 1073807359L * var6 % 1073807359L + ((long)var1 + 2147483647L) % 1073807359L) % 1073807359L;
   }

   static long a(long var0, int var2) {
      long var3;
      if(var2 == 0) {
         var3 = 1L;
      } else {
         var3 = var0;
         if(var2 != 1) {
            if(var2 % 2 == 0) {
               return a(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L;
            }

            return a(var0 * var0 % 1073807359L, var2 / 2) % 1073807359L * var0 % 1073807359L;
         }
      }

      return var3;
   }

   static String a(String[] var0, int var1, int var2) {
      if(var0.length < var1 + var2) {
         gr.T("Unable to construct shingle");
         return "";
      } else {
         StringBuffer var4 = new StringBuffer();

         for(int var3 = var1; var3 < var1 + var2 - 1; ++var3) {
            var4.append(var0[var3]);
            var4.append(' ');
         }

         var4.append(var0[var1 + var2 - 1]);
         return var4.toString();
      }
   }

   static void a(int var0, long var1, String var3, PriorityQueue var4) {
      as.a var5 = new as.a(var1, var3);
      if((var4.size() != var0 || ((as.a)var4.peek()).value <= var5.value) && !var4.contains(var5)) {
         var4.add(var5);
         if(var4.size() > var0) {
            var4.poll();
            return;
         }
      }

   }

   public static void a(String[] var0, int var1, int var2, PriorityQueue var3) {
      long var5 = b(var0, 0, var2);
      a(var1, var5, a(var0, 0, var2), var3);
      long var7 = a(16785407L, var2 - 1);

      for(int var4 = 1; var4 < var0.length - var2 + 1; ++var4) {
         var5 = a(aq.o(var0[var4 - 1]), aq.o(var0[var4 + var2 - 1]), var5, var7, 16785407L);
         a(var1, var5, a(var0, var4, var2), var3);
      }

   }

   private static long b(String[] var0, int var1, int var2) {
      long var4 = ((long)aq.o(var0[var1]) + 2147483647L) % 1073807359L;

      for(int var3 = var1 + 1; var3 < var1 + var2; ++var3) {
         var4 = (var4 * 16785407L % 1073807359L + ((long)aq.o(var0[var3]) + 2147483647L) % 1073807359L) % 1073807359L;
      }

      return var4;
   }

   public static class a {
      final String oa;
      final long value;

      a(long var1, String var3) {
         this.value = var1;
         this.oa = var3;
      }

      public boolean equals(Object var1) {
         return var1 != null && var1 instanceof as.a && ((as.a)var1).value == this.value;
      }

      public int hashCode() {
         return (int)this.value;
      }
   }
}
