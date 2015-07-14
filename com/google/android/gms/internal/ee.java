package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.ea;
import com.google.android.gms.internal.eb;
import com.google.android.gms.internal.ef;
import com.google.android.gms.internal.eh;
import com.google.android.gms.internal.ej;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public class ee extends eo.a implements ServiceConnection {
   private final Activity nB;
   private eb sF;
   private final eh sG;
   private ek sI;
   private Context sO;
   private em sP;
   private ef sQ;
   private ej sR;
   private String sS = null;

   public ee(Activity var1) {
      this.nB = var1;
      this.sG = eh.j(this.nB.getApplicationContext());
   }

   public static void a(Context var0, boolean var1, ea var2) {
      Intent var3 = new Intent();
      var3.setClassName(var0, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
      var3.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", var1);
      ea.a(var3, var2);
      var0.startActivity(var3);
   }

   private void a(String var1, boolean var2, int var3, Intent var4) {
      if(this.sR != null) {
         this.sR.a(var1, var2, var3, var4, this.sQ);
      }

   }

   public void onActivityResult(int param1, int param2, Intent param3) {
      // $FF: Couldn't be decompiled
   }

   public void onCreate() {
      ea var1 = ea.c(this.nB.getIntent());
      this.sR = var1.sB;
      this.sI = var1.md;
      this.sP = var1.sz;
      this.sF = new eb(this.nB.getApplicationContext());
      this.sO = var1.sA;
      if(this.nB.getResources().getConfiguration().orientation == 2) {
         this.nB.setRequestedOrientation(6);
      } else {
         this.nB.setRequestedOrientation(7);
      }

      Intent var2 = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      var2.setPackage("com.android.vending");
      this.nB.bindService(var2, this, 1);
   }

   public void onDestroy() {
      this.nB.unbindService(this);
      this.sF.destroy();
   }

   public void onServiceConnected(ComponentName param1, IBinder param2) {
      // $FF: Couldn't be decompiled
   }

   public void onServiceDisconnected(ComponentName var1) {
      gr.U("In-app billing service disconnected.");
      this.sF.destroy();
   }
}
