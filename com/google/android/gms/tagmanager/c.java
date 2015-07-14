package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.a;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class c extends aj {
   private static final String ID;
   private final a aqc;

   static {
      ID = com.google.android.gms.internal.a.v.toString();
   }

   public c(Context var1) {
      this(a.W(var1));
   }

   c(a var1) {
      super(ID, new String[0]);
      this.aqc = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      boolean var2;
      if(!this.aqc.isLimitAdTrackingEnabled()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return di.u(Boolean.valueOf(var2));
   }

   public boolean pe() {
      return false;
   }
}
