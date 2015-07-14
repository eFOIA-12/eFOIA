package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.eq;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public final class eg extends eq.a implements ServiceConnection {
   private Context mContext;
   private eb sF;
   private String sM;
   private ef sQ;
   private boolean sW = false;
   private int sX;
   private Intent sY;

   public eg(Context var1, String var2, boolean var3, int var4, Intent var5, ef var6) {
      this.sM = var2;
      this.sX = var4;
      this.sY = var5;
      this.sW = var3;
      this.mContext = var1;
      this.sQ = var6;
   }

   public void finishPurchase() {
      int var1 = ei.d(this.sY);
      if(this.sX == -1 && var1 == 0) {
         this.sF = new eb(this.mContext);
         Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
         var2.setPackage("com.android.vending");
         this.mContext.bindService(var2, this, 1);
      }
   }

   public String getProductId() {
      return this.sM;
   }

   public Intent getPurchaseData() {
      return this.sY;
   }

   public int getResultCode() {
      return this.sX;
   }

   public boolean isVerified() {
      return this.sW;
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      gr.U("In-app billing service connected.");
      this.sF.t(var2);
      String var3 = ei.E(ei.e(this.sY));
      if(var3 != null) {
         if(this.sF.c(this.mContext.getPackageName(), var3) == 0) {
            eh.j(this.mContext).a(this.sQ);
         }

         this.mContext.unbindService(this);
         this.sF.destroy();
      }
   }

   public void onServiceDisconnected(ComponentName var1) {
      gr.U("In-app billing service disconnected.");
      this.sF.destroy();
   }
}
