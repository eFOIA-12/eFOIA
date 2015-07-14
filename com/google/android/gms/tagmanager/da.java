package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.k;
import com.google.android.gms.tagmanager.l;
import java.util.HashMap;
import java.util.Map;

class da implements k {
   private final Map atM = new HashMap();
   private final int atN;
   private final l.a atO;
   private int atP;

   da(int var1, l.a var2) {
      this.atN = var1;
      this.atO = var2;
   }

   public void e(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public Object get(Object var1) {
      synchronized(this){}

      try {
         var1 = this.atM.get(var1);
      } finally {
         ;
      }

      return var1;
   }
}
