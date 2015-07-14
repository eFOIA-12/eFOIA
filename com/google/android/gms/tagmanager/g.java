package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class g extends aj {
   private static final String ID;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.x.toString();
   }

   public g(Context var1) {
      super(ID, new String[0]);
      this.mContext = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      try {
         PackageManager var3 = this.mContext.getPackageManager();
         com.google.android.gms.internal.d var4 = di.u(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
         return var4;
      } catch (NameNotFoundException var2) {
         bh.b("App name is not found.", var2);
         return di.rb();
      }
   }

   public boolean pe() {
      return true;
   }
}
