package com.google.android.gms.fitness.data;

import java.util.List;

public class t {
   public static int a(Object var0, List var1) {
      int var2;
      if(var0 == null) {
         var2 = -1;
      } else {
         int var3 = var1.indexOf(var0);
         var2 = var3;
         if(var3 < 0) {
            var1.add(var0);
            return var1.size() - 1;
         }
      }

      return var2;
   }
}
