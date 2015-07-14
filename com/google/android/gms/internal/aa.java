package com.google.android.gms.internal;

import com.google.android.gms.internal.ac;
import com.google.android.gms.internal.af;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gu;
import java.util.HashMap;
import java.util.Map;

@ey
class aa implements ac {
   private gu mt;

   public aa(gu var1) {
      this.mt = var1;
   }

   public void a(af var1, boolean var2) {
      HashMap var3 = new HashMap();
      String var4;
      if(var2) {
         var4 = "1";
      } else {
         var4 = "0";
      }

      var3.put("isVisible", var4);
      this.mt.a((String)"onAdVisibilityChanged", (Map)var3);
   }
}
