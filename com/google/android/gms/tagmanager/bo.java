package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.tagmanager.cx;

class bo extends BroadcastReceiver {
   static final String yR = bo.class.getName();
   private final cx asb;

   bo(cx var1) {
      this.asb = var1;
   }

   public static void aa(Context var0) {
      Intent var1 = new Intent("com.google.analytics.RADIO_POWERED");
      var1.addCategory(var0.getPackageName());
      var1.putExtra(yR, true);
      var0.sendBroadcast(var1);
   }

   public void onReceive(Context var1, Intent var2) {
      String var5 = var2.getAction();
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var5)) {
         Bundle var4 = var2.getExtras();
         Boolean var6 = Boolean.FALSE;
         if(var4 != null) {
            var6 = Boolean.valueOf(var2.getExtras().getBoolean("noConnectivity"));
         }

         cx var7 = this.asb;
         boolean var3;
         if(!var6.booleanValue()) {
            var3 = true;
         } else {
            var3 = false;
         }

         var7.C(var3);
      } else if("com.google.analytics.RADIO_POWERED".equals(var5) && !var2.hasExtra(yR)) {
         this.asb.ey();
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
