package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Iterator;
import java.util.Map;

abstract class cd extends aj {
   private static final String arp;
   private static final String ask;

   static {
      arp = com.google.android.gms.internal.b.bw.toString();
      ask = com.google.android.gms.internal.b.bx.toString();
   }

   public cd(String var1) {
      super(var1, new String[]{arp, ask});
   }

   public com.google.android.gms.internal.d B(Map var1) {
      Iterator var3 = var1.values().iterator();

      while(var3.hasNext()) {
         if((com.google.android.gms.internal.d)var3.next() == di.rb()) {
            return di.u(Boolean.valueOf(false));
         }
      }

      com.google.android.gms.internal.d var5 = (com.google.android.gms.internal.d)var1.get(arp);
      com.google.android.gms.internal.d var4 = (com.google.android.gms.internal.d)var1.get(ask);
      boolean var2;
      if(var5 != null && var4 != null) {
         var2 = this.a(var5, var4, var1);
      } else {
         var2 = false;
      }

      return di.u(Boolean.valueOf(var2));
   }

   protected abstract boolean a(com.google.android.gms.internal.d var1, com.google.android.gms.internal.d var2, Map var3);

   public boolean pe() {
      return true;
   }
}
