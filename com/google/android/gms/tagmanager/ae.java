package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.dd;
import java.util.Map;

class ae extends dd {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.at.toString();
   }

   public ae() {
      super(ID);
   }

   protected boolean a(String var1, String var2, Map var3) {
      return var1.equals(var2);
   }
}
