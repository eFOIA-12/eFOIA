package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.a;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class b extends aj {
   private static final String ID;
   private final a aqc;

   static {
      ID = com.google.android.gms.internal.a.u.toString();
   }

   public b(Context var1) {
      this(a.W(var1));
   }

   b(a var1) {
      super(ID, new String[0]);
      this.aqc = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var2 = this.aqc.pa();
      return var2 == null?di.rb():di.u(var2);
   }

   public boolean pe() {
      return false;
   }
}
