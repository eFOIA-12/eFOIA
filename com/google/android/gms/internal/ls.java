package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;

public class ls {
   public static boolean a(List var0, List var1) {
      if(var0.size() != var1.size()) {
         return false;
      } else {
         Iterator var2 = var0.iterator();

         do {
            if(!var2.hasNext()) {
               return true;
            }
         } while(var1.contains(var2.next()));

         return false;
      }
   }
}
