package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.bb;
import com.google.android.gms.tagmanager.da;
import com.google.android.gms.tagmanager.k;

class l {
   final l.a aqk = new l.a() {
      public int sizeOf(Object var1, Object var2) {
         return 1;
      }
   };

   public k a(int var1, l.a var2) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("maxSize <= 0");
      } else {
         return (k)(this.pg() < 12?new da(var1, var2):new bb(var1, var2));
      }
   }

   int pg() {
      return VERSION.SDK_INT;
   }

   public interface a {
      int sizeOf(Object var1, Object var2);
   }
}
