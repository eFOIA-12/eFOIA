package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dd;
import java.util.Map;

class ad extends dd {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.ar.toString();
   }

   public ad() {
      super(ID);
   }

   protected boolean a(String var1, String var2, Map var3) {
      return var1.endsWith(var2);
   }
}
