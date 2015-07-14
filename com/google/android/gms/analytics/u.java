package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.analytics.aj;

class u extends BroadcastReceiver {
   static final String yR = u.class.getName();
   private final aj yS;

   u(aj var1) {
      this.yS = var1;
   }

   public void onReceive(Context var1, Intent var2) {
      boolean var3 = false;
      String var5 = var2.getAction();
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var5)) {
         boolean var4 = var2.getBooleanExtra("noConnectivity", false);
         aj var6 = this.yS;
         if(!var4) {
            var3 = true;
         }

         var6.C(var3);
      } else if("com.google.analytics.RADIO_POWERED".equals(var5) && !var2.hasExtra(yR)) {
         this.yS.ey();
         return;
      }

   }

   public void z(Context var1) {
      IntentFilter var2 = new IntentFilter();
      var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      var1.registerReceiver(this, var2);
      var2 = new IntentFilter();
      var2.addAction("com.google.analytics.RADIO_POWERED");
      var2.addCategory(var1.getPackageName());
      var1.registerReceiver(this, var2);
   }
}
