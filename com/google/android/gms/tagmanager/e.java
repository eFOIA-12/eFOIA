package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.ay;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class e extends aj {
   private static final String ID;
   private static final String aqd;
   private static final String aqe;
   private final Context lM;

   static {
      ID = com.google.android.gms.internal.a.Y.toString();
      aqd = com.google.android.gms.internal.b.bW.toString();
      aqe = com.google.android.gms.internal.b.bZ.toString();
   }

   public e(Context var1) {
      super(ID, new String[]{aqe});
      this.lM = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      com.google.android.gms.internal.d var2 = (com.google.android.gms.internal.d)var1.get(aqe);
      if(var2 == null) {
         return di.rb();
      } else {
         String var5 = di.j(var2);
         com.google.android.gms.internal.d var3 = (com.google.android.gms.internal.d)var1.get(aqd);
         String var4;
         if(var3 != null) {
            var4 = di.j(var3);
         } else {
            var4 = null;
         }

         var4 = ay.f(this.lM, var5, var4);
         return var4 != null?di.u(var4):di.rb();
      }
   }

   public boolean pe() {
      return true;
   }
}
