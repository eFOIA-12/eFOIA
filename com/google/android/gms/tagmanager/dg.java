package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

abstract class dg extends aj {
   public dg(String var1, String... var2) {
      super(var1, var2);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      this.D(var1);
      return di.rb();
   }

   public abstract void D(Map var1);

   public boolean pe() {
      return false;
   }
}
