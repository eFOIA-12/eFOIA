package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.ae;
import java.io.FileOutputStream;
import java.io.IOException;

public class CampaignTrackingService extends IntentService {
   public CampaignTrackingService() {
      super("CampaignIntentService");
   }

   public CampaignTrackingService(String var1) {
      super(var1);
   }

   public void onHandleIntent(Intent var1) {
      this.processIntent(this, var1);
   }

   public void processIntent(Context var1, Intent var2) {
      String var5 = var2.getStringExtra("referrer");

      try {
         FileOutputStream var4 = var1.openFileOutput("gaInstallData", 0);
         var4.write(var5.getBytes());
         var4.close();
         ae.V("Stored campaign information.");
      } catch (IOException var3) {
         ae.T("Error storing install campaign.");
      }
   }
}
