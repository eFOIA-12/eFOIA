package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class p extends aj {
   private static final String ID;
   private final String TU;

   static {
      ID = com.google.android.gms.internal.a.D.toString();
   }

   public p(String var1) {
      super(ID, new String[0]);
      this.TU = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return this.TU == null?di.rb():di.u(this.TU);
   }

   public boolean pe() {
      return true;
   }
}
