package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.by;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

class be extends by {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.au.toString();
   }

   public be() {
      super(ID);
   }

   protected boolean a(dh var1, dh var2, Map var3) {
      return var1.a(var2) < 0;
   }
}
