package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dd;
import java.util.Map;

class q extends dd {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.as.toString();
   }

   public q() {
      super(ID);
   }

   protected boolean a(String var1, String var2, Map var3) {
      return var1.contains(var2);
   }
}
