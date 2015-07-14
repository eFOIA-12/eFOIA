package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class cj extends aj {
   private static final String ID;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.S.toString();
   }

   public cj(Context var1) {
      super(ID, new String[0]);
      this.mContext = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      DisplayMetrics var4 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var4);
      int var2 = var4.widthPixels;
      int var3 = var4.heightPixels;
      return di.u(var2 + "x" + var3);
   }

   public boolean pe() {
      return true;
   }
}
