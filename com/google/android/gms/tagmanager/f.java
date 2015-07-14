package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class f extends aj {
   private static final String ID;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.w.toString();
   }

   public f(Context var1) {
      super(ID, new String[0]);
      this.mContext = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      return di.u(this.mContext.getPackageName());
   }

   public boolean pe() {
      return true;
   }
}
