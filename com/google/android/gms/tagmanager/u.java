package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class u extends aj {
   private static final String ID;
   private static final String NAME;
   private static final String aqZ;
   private final DataLayer aqn;

   static {
      ID = com.google.android.gms.internal.a.C.toString();
      NAME = com.google.android.gms.internal.b.dB.toString();
      aqZ = com.google.android.gms.internal.b.cr.toString();
   }

   public u(DataLayer var1) {
      super(ID, new String[]{NAME});
      this.aqn = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      Object var2 = this.aqn.get(di.j((com.google.android.gms.internal.d)var1.get(NAME)));
      if(var2 == null) {
         com.google.android.gms.internal.d var3 = (com.google.android.gms.internal.d)var1.get(aqZ);
         return var3 != null?var3:di.rb();
      } else {
         return di.u(var2);
      }
   }

   public boolean pe() {
      return false;
   }
}
