package com.parallel6.captivereachconnectsdk.gcm;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.parallel6.captivereachconnectsdk.CaptiveReachConnect;
import com.parallel6.captivereachconnectsdk.gcm.GcmBroadcastReceiver;

public class GcmIntentService extends IntentService {
   private static final String TAG = GcmIntentService.class.getSimpleName();

   public GcmIntentService() {
      super("GcmIntentService");
   }

   protected void onHandleIntent(Intent var1) {
      Bundle var2 = var1.getExtras();
      String var3 = GoogleCloudMessaging.getInstance(this).getMessageType(var1);
      if(!var2.isEmpty() && "gcm".equals(var3)) {
         if(CaptiveReachConnect.getGcmListener() != null) {
            CaptiveReachConnect.getGcmListener().onNotificationReceived(var1, var2.getString("json"));
         }

         Log.i(TAG, "Received: " + var2.toString());
      }

      GcmBroadcastReceiver.completeWakefulIntent(var1);
   }
}
