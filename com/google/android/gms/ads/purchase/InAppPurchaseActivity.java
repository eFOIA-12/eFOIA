package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.gr;

public final class InAppPurchaseActivity extends Activity {
   public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
   public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
   private eo xz;

   protected void onActivityResult(int var1, int var2, Intent var3) {
      try {
         if(this.xz != null) {
            this.xz.onActivityResult(var1, var2, var3);
         }
      } catch (RemoteException var5) {
         gr.d("Could not forward onActivityResult to in-app purchase manager:", var5);
      }

      super.onActivityResult(var1, var2, var3);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.xz = et.e(this);
      if(this.xz == null) {
         gr.W("Could not create in-app purchase manager.");
         this.finish();
      } else {
         try {
            this.xz.onCreate();
         } catch (RemoteException var2) {
            gr.d("Could not forward onCreate to in-app purchase manager:", var2);
            this.finish();
         }
      }
   }

   protected void onDestroy() {
      try {
         if(this.xz != null) {
            this.xz.onDestroy();
         }
      } catch (RemoteException var2) {
         gr.d("Could not forward onDestroy to in-app purchase manager:", var2);
      }

      super.onDestroy();
   }
}
