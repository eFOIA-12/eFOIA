package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class af {
   private final Map BO = new HashMap();
   private final Map BP = new HashMap();
   private final boolean BQ;
   private final String BR;

   public af(String var1, boolean var2) {
      this.BQ = var2;
      this.BR = var1;
   }

   public void e(String var1, int var2) {
      if(this.BQ) {
         Integer var4 = (Integer)this.BO.get(var1);
         Integer var3 = var4;
         if(var4 == null) {
            var3 = Integer.valueOf(0);
         }

         this.BO.put(var1, Integer.valueOf(var3.intValue() + var2));
      }
   }

   public String fg() {
      if(!this.BQ) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder();
         var1.append(this.BR);
         Iterator var2 = this.BO.keySet().iterator();

         String var3;
         while(var2.hasNext()) {
            var3 = (String)var2.next();
            var1.append("&").append(var3).append("=").append(this.BO.get(var3));
         }

         var2 = this.BP.keySet().iterator();

         while(var2.hasNext()) {
            var3 = (String)var2.next();
            var1.append("&").append(var3).append("=").append((String)this.BP.get(var3));
         }

         return var1.toString();
      }
   }

   public void g(String var1, String var2) {
      if(this.BQ && !TextUtils.isEmpty(var1)) {
         this.BP.put(var1, var2);
      }
   }
}
