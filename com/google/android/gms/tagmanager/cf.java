package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.dh;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class cf extends aj {
   private static final String ID;
   private static final String asu;
   private static final String asv;

   static {
      ID = com.google.android.gms.internal.a.Q.toString();
      asu = com.google.android.gms.internal.b.dz.toString();
      asv = com.google.android.gms.internal.b.dy.toString();
   }

   public cf() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      com.google.android.gms.internal.d var6 = (com.google.android.gms.internal.d)var1.get(asu);
      com.google.android.gms.internal.d var8 = (com.google.android.gms.internal.d)var1.get(asv);
      double var2;
      double var4;
      if(var6 != null && var6 != di.rb() && var8 != null && var8 != di.rb()) {
         dh var7 = di.k(var6);
         dh var9 = di.k(var8);
         if(var7 != di.qZ() && var9 != di.qZ()) {
            var4 = var7.doubleValue();
            var2 = var9.doubleValue();
            if(var4 <= var2) {
               return di.u(Long.valueOf(Math.round((var2 - var4) * Math.random() + var4)));
            }
         }
      }

      var2 = 2.147483647E9D;
      var4 = 0.0D;
      return di.u(Long.valueOf(Math.round((var2 - var4) * Math.random() + var4)));
   }

   public boolean pe() {
      return false;
   }
}
