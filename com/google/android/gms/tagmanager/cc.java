package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class cc extends aj {
   private static final String ID;
   private static final com.google.android.gms.internal.d asj;

   static {
      ID = com.google.android.gms.internal.a.P.toString();
      asj = di.u("Android");
   }

   public cc() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return asj;
   }

   public boolean pe() {
      return true;
   }
}
