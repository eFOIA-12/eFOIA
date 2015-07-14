package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.dg;
import com.google.android.gms.tagmanager.di;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class w extends dg {
   private static final String ID;
   private static final String VALUE;
   private static final String ark;
   private final DataLayer aqn;

   static {
      ID = com.google.android.gms.internal.a.ah.toString();
      VALUE = com.google.android.gms.internal.b.ff.toString();
      ark = com.google.android.gms.internal.b.bS.toString();
   }

   public w(DataLayer var1) {
      super(ID, new String[]{VALUE});
      this.aqn = var1;
   }

   private void a(com.google.android.gms.internal.d var1) {
      if(var1 != null && var1 != di.qV()) {
         String var2 = di.j(var1);
         if(var2 != di.ra()) {
            this.aqn.cx(var2);
            return;
         }
      }

   }

   private void b(com.google.android.gms.internal.d var1) {
      if(var1 != null && var1 != di.qV()) {
         Object var3 = di.o(var1);
         if(var3 instanceof List) {
            Iterator var4 = ((List)var3).iterator();

            while(var4.hasNext()) {
               Object var2 = var4.next();
               if(var2 instanceof Map) {
                  Map var5 = (Map)var2;
                  this.aqn.push(var5);
               }
            }
         }
      }

   }

   public void D(Map var1) {
      this.b((com.google.android.gms.internal.d)var1.get(VALUE));
      this.a((com.google.android.gms.internal.d)var1.get(ark));
   }
}
