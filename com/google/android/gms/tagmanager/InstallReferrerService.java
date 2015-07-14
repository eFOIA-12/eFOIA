package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;
import com.google.android.gms.tagmanager.ay;

public final class InstallReferrerService extends IntentService {
   CampaignTrackingService arF;
   Context arG;

   public InstallReferrerService() {
      super("InstallReferrerService");
   }

   public InstallReferrerService(String var1) {
      super(var1);
   }

   private void a(Context var1, Intent var2) {
      if(this.arF == null) {
         this.arF = new CampaignTrackingService();
      }

      this.arF.processIntent(var1, var2);
   }

   protected void onHandleIntent(Intent var1) {
      String var3 = var1.getStringExtra("referrer");
      Context var2;
      if(this.arG != null) {
         var2 = this.arG;
      } else {
         var2 = this.getApplicationContext();
      }

      ay.d(var2, var3);
      this.a(var2, var1);
   }
}
