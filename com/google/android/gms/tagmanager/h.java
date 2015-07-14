package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class h extends aj {
   private static final String ID;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.y.toString();
   }

   public h(Context var1) {
      super(ID, new String[0]);
      this.mContext = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      try {
         com.google.android.gms.internal.d var3 = di.u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
         return var3;
      } catch (NameNotFoundException var2) {
         bh.T("Package name " + this.mContext.getPackageName() + " not found. " + var2.getMessage());
         return di.rb();
      }
   }

   public boolean pe() {
      return true;
   }
}
