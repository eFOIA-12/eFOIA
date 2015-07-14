package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class de extends aj {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.W.toString();
   }

   public de() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return di.u(Long.valueOf(System.currentTimeMillis()));
   }

   public boolean pe() {
      return false;
   }
}
