package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tagmanager.InstallReferrerService;
import com.google.android.gms.tagmanager.ay;

public final class InstallReferrerReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("referrer");
      if("com.android.vending.INSTALL_REFERRER".equals(var2.getAction()) && var3 != null) {
         ay.cH(var3);
         var2 = new Intent(var1, InstallReferrerService.class);
         var2.putExtra("referrer", var3);
         var1.startService(var2);
      }
   }
}
