package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class bl extends aj {
   private static final String ID;
   private final Context mContext;

   static {
      ID = com.google.android.gms.internal.a.af.toString();
   }

   public bl(Context var1) {
      super(ID, new String[0]);
      this.mContext = var1;
   }

   public com.google.android.gms.internal.d B(Map var1) {
      String var2 = this.Y(this.mContext);
      return var2 == null?di.rb():di.u(var2);
   }

   protected String Y(Context var1) {
      return Secure.getString(var1.getContentResolver(), "android_id");
   }

   public boolean pe() {
      return true;
   }
}
