package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.k;
import com.google.android.gms.tagmanager.l;

class bb implements k {
   private LruCache arR;

   bb(final int var1, final l.a var2) {
      this.arR = new LruCache(var1) {
         protected int sizeOf(Object var1, Object var2x) {
            return var2.sizeOf(var1, var2x);
         }
      };
   }

   public void e(Object var1, Object var2) {
      this.arR.put(var1, var2);
   }

   public Object get(Object var1) {
      return this.arR.get(var1);
   }
}
