package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class cv extends aj {
   private static final String ID;

   static {
      ID = com.google.android.gms.internal.a.U.toString();
   }

   public cv() {
      super(ID, new String[0]);
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return di.u(Integer.valueOf(VERSION.SDK_INT));
   }

   public boolean pe() {
      return true;
   }
}
