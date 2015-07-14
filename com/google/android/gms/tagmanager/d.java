package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.ay;
import java.util.Map;

class d implements DataLayer.b {
   private final Context lM;

   public d(Context var1) {
      this.lM = var1;
   }

   public void C(Map var1) {
      Object var3;
      label22: {
         Object var2 = var1.get("gtm.url");
         if(var2 == null) {
            var3 = var1.get("gtm");
            if(var3 != null && var3 instanceof Map) {
               var3 = ((Map)var3).get("url");
               break label22;
            }
         }

         var3 = var2;
      }

      if(var3 != null && var3 instanceof String) {
         String var4 = Uri.parse((String)var3).getQueryParameter("referrer");
         if(var4 != null) {
            ay.f(this.lM, var4);
            return;
         }
      }

   }
}
