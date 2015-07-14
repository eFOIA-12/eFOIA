package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.cd;
import com.google.android.gms.tagmanager.dh;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

abstract class by extends cd {
   public by(String var1) {
      super(var1);
   }

   protected boolean a(com.google.android.gms.internal.d var1, com.google.android.gms.internal.d var2, Map var3) {
      dh var4 = di.k(var1);
      dh var5 = di.k(var2);
      return var4 != di.qZ() && var5 != di.qZ()?this.a(var4, var5, var3):false;
   }

   protected abstract boolean a(dh var1, dh var2, Map var3);
}
