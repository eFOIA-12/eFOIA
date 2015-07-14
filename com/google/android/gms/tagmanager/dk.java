package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class dk extends aj {
   private static final String ID;
   private static final String arp;

   static {
      ID = com.google.android.gms.internal.a.aj.toString();
      arp = com.google.android.gms.internal.b.bw.toString();
   }

   public dk() {
      super(ID, new String[]{arp});
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return di.u(di.j((com.google.android.gms.internal.d)var1.get(arp)).toUpperCase());
   }

   public boolean pe() {
      return true;
   }
}
