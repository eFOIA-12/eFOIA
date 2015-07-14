package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public class ev implements InAppPurchase {
   private final em sP;

   public ev(em var1) {
      this.sP = var1;
   }

   public String getProductId() {
      try {
         String var1 = this.sP.getProductId();
         return var1;
      } catch (RemoteException var2) {
         gr.d("Could not forward getProductId to InAppPurchase", var2);
         return null;
      }
   }

   public void recordPlayBillingResolution(int var1) {
      try {
         this.sP.recordPlayBillingResolution(var1);
      } catch (RemoteException var3) {
         gr.d("Could not forward recordPlayBillingResolution to InAppPurchase", var3);
      }
   }

   public void recordResolution(int var1) {
      try {
         this.sP.recordResolution(var1);
      } catch (RemoteException var3) {
         gr.d("Could not forward recordResolution to InAppPurchase", var3);
      }
   }
}
