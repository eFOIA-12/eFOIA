package com.google.android.gms.fitness;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class a {
   public static String bt(String var0) {
      String var1;
      if(var0.equals("https://www.googleapis.com/auth/fitness.activity.read")) {
         var1 = "https://www.googleapis.com/auth/fitness.activity.write";
      } else {
         if(var0.equals("https://www.googleapis.com/auth/fitness.location.read")) {
            return "https://www.googleapis.com/auth/fitness.location.write";
         }

         var1 = var0;
         if(var0.equals("https://www.googleapis.com/auth/fitness.body.read")) {
            return "https://www.googleapis.com/auth/fitness.body.write";
         }
      }

      return var1;
   }

   public static String[] e(List var0) {
      HashSet var1 = new HashSet(var0.size());
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         String var4 = bt(var3);
         if(var4.equals(var3) || !var0.contains(var4)) {
            var1.add(var3);
         }
      }

      return (String[])var1.toArray(new String[var1.size()]);
   }
}
