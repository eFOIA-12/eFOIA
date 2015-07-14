package com.google.android.gms.common.data;

import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class FreezableUtils {
   public static ArrayList freeze(ArrayList var0) {
      ArrayList var3 = new ArrayList(var0.size());
      int var2 = var0.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.add(((Freezable)var0.get(var1)).freeze());
      }

      return var3;
   }

   public static ArrayList freeze(Freezable[] var0) {
      ArrayList var2 = new ArrayList(var0.length);

      for(int var1 = 0; var1 < var0.length; ++var1) {
         var2.add(var0[var1].freeze());
      }

      return var2;
   }

   public static ArrayList freezeIterable(Iterable var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         var1.add(((Freezable)var2.next()).freeze());
      }

      return var1;
   }
}
