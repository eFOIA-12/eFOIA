package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class bj extends aj {
   private static final String ID;
   private static final String arp;

   static {
      ID = com.google.android.gms.internal.a.ai.toString();
      arp = com.google.android.gms.internal.b.bw.toString();
   }

   public bj() {
      super(ID, new String[]{arp});
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return di.u(di.j((com.google.android.gms.internal.d)var1.get(arp)).toLowerCase());
   }

   public boolean pe() {
      return true;
   }
}
