package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.ay;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class ax extends aj {
   private static final String ID;
   private static final String aqd;
   private final Context lM;

   static {
      ID = com.google.android.gms.internal.a.ad.toString();
      aqd = com.google.android.gms.internal.b.bW.toString();
   }

   public ax(Context var1) {
      super(ID, new String[0]);
      this.lM = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var2;
      if((com.google.android.gms.internal.d)var1.get(aqd) != null) {
         var2 = di.j((com.google.android.gms.internal.d)var1.get(aqd));
      } else {
         var2 = null;
      }

      var2 = ay.e(this.lM, var2);
      return var2 != null?di.u(var2):di.rb();
   }

   public boolean pe() {
      return true;
   }
}
