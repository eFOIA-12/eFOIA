package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
   public static cr.c cI(String var0) throws JSONException {
      com.google.android.gms.internal.d var3 = n(new JSONObject(var0));
      cr.d var2 = cr.c.qo();

      for(int var1 = 0; var1 < var3.gx.length; ++var1) {
         var2.a(cr.a.qk().b(com.google.android.gms.internal.b.df.toString(), var3.gx[var1]).b(com.google.android.gms.internal.b.cU.toString(), di.cZ(m.ph())).b(m.pi(), var3.gy[var1]).qn());
      }

      return var2.qr();
   }

   private static com.google.android.gms.internal.d n(Object var0) throws JSONException {
      return di.u(o(var0));
   }

   static Object o(Object var0) throws JSONException {
      if(var0 instanceof JSONArray) {
         throw new RuntimeException("JSONArrays are not supported");
      } else if(JSONObject.NULL.equals(var0)) {
         throw new RuntimeException("JSON nulls are not supported");
      } else {
         Object var1 = var0;
         if(var0 instanceof JSONObject) {
            JSONObject var4 = (JSONObject)var0;
            var1 = new HashMap();
            Iterator var2 = var4.keys();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               ((Map)var1).put(var3, o(var4.get(var3)));
            }
         }

         return var1;
      }
   }
}
