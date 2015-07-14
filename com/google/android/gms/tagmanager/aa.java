package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class aa extends aj {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.F.toString();
   }

   public aa() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var3 = Build.MANUFACTURER;
      String var2 = Build.MODEL;
      String var4 = var2;
      if(!var2.startsWith(var3)) {
         var4 = var2;
         if(!var3.equals("unknown")) {
            var4 = var3 + " " + var2;
         }
      }

      return di.u(var4);
   }

   public boolean pe() {
      return true;
   }
}
