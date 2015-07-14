package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.by;
import com.google.android.gms.tagmanager.dh;
import java.util.Map;

class al extends by {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.ax.toString();
   }

   public al() {
      super(ID);
   }

   protected boolean a(dh var1, dh var2, Map var3) {
      return var1.a(var2) >= 0;
   }
}
