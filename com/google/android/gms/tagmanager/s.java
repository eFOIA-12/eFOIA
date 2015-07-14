package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class s extends aj {
   private static final String ID;
   private static final String aqO;
   private static final String aqf;
   private final s.a aqP;

   static {
      ID = com.google.android.gms.internal.a.L.toString();
      aqO = com.google.android.gms.internal.b.cV.toString();
      aqf = com.google.android.gms.internal.b.bl.toString();
   }

   public s(s.a var1) {
      super(ID, new String[]{aqO});
      this.aqP = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var2 = di.j((com.google.android.gms.internal.d)var1.get(aqO));
      HashMap var3 = new HashMap();
      com.google.android.gms.internal.d var6 = (com.google.android.gms.internal.d)var1.get(aqf);
      if(var6 != null) {
         Object var7 = di.o(var6);
         if(!(var7 instanceof Map)) {
            bh.W("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
            return di.rb();
         }

         Iterator var8 = ((Map)var7).entrySet().iterator();

         while(var8.hasNext()) {
            Entry var4 = (Entry)var8.next();
            var3.put(var4.getKey().toString(), var4.getValue());
         }
      }

      try {
         var6 = di.u(this.aqP.b(var2, var3));
         return var6;
      } catch (Exception var5) {
         bh.W("Custom macro/tag " + var2 + " threw exception " + var5.getMessage());
         return di.rb();
      }
   }

   public boolean pe() {
      return false;
   }

   public interface a {
      Object b(String var1, Map var2);
   }
}
