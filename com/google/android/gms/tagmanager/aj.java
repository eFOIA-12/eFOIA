package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
   private final Set art;
   private final String aru;

   public aj(String var1, String... var2) {
      this.aru = var1;
      this.art = new HashSet(var2.length);
      int var4 = var2.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var1 = var2[var3];
         this.art.add(var1);
      }

   }

   public abstract com.google.android.gms.internal.d B(Map var1);

   boolean a(Set var1) {
      return var1.containsAll(this.art);
   }

   public String pI() {
      return this.aru;
   }

   public Set pJ() {
      return this.art;
   }

   public abstract boolean pe();
}
