package com.parallel6.captivereachconnectsdk.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.parallel6.captivereachconnectsdk.gcm.GcmIntentService;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      startWakefulService(var1, var2.setComponent(new ComponentName(var1.getPackageName(), GcmIntentService.class.getName())));
      this.setResultCode(-1);
   }
}
