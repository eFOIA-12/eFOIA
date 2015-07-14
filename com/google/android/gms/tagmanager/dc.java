package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dd;
import java.util.Map;

class dc extends dd {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.aq.toString();
   }

   public dc() {
      super(ID);
   }

   protected boolean a(String var1, String var2, Map var3) {
      return var1.startsWith(var2);
   }
}
