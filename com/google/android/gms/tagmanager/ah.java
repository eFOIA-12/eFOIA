package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.ct;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class ah extends aj {
   private static final String ID;
   private final ct aqo;

   static {
      ID = com.google.android.gms.internal.a.K.toString();
   }

   public ah(ct var1) {
      super(ID, new String[0]);
      this.aqo = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var2 = this.aqo.qE();
      return var2 == null?di.rb():di.u(var2);
   }

   public boolean pe() {
      return false;
   }
}
