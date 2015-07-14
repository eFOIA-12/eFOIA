package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.cd;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

abstract class dd extends cd {
   public dd(String var1) {
      super(var1);
   }

   protected boolean a(com.google.android.gms.internal.d var1, com.google.android.gms.internal.d var2, Map var3) {
      String var4 = di.j(var1);
      String var5 = di.j(var2);
      return var4 != di.ra() && var5 != di.ra()?this.a(var4, var5, var3):false;
   }

   protected abstract boolean a(String var1, String var2, Map var3);
}
