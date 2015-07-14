package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.N.toString();
   }

   public bc() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      Locale var2 = Locale.getDefault();
      if(var2 == null) {
         return di.rb();
      } else {
         String var3 = var2.getLanguage();
         return var3 == null?di.rb():di.u(var3.toLowerCase());
      }
   }

   public boolean pe() {
      return false;
   }
}
