package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;
import com.google.android.gms.internal.eq;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public class eu implements InAppPurchaseResult {
   private final eq te;

   public eu(eq var1) {
      this.te = var1;
   }

   public void finishPurchase() {
      try {
         this.te.finishPurchase();
      } catch (RemoteException var2) {
         gr.d("Could not forward finishPurchase to InAppPurchaseResult", var2);
      }
   }

   public String getProductId() {
      try {
         String var1 = this.te.getProductId();
         return var1;
      } catch (RemoteException var2) {
         gr.d("Could not forward getProductId to InAppPurchaseResult", var2);
         return null;
      }
   }

   public Intent getPurchaseData() {
      try {
         Intent var1 = this.te.getPurchaseData();
         return var1;
      } catch (RemoteException var2) {
         gr.d("Could not forward getPurchaseData to InAppPurchaseResult", var2);
         return null;
      }
   }

   public int getResultCode() {
      try {
         int var1 = this.te.getResultCode();
         return var1;
      } catch (RemoteException var3) {
         gr.d("Could not forward getPurchaseData to InAppPurchaseResult", var3);
         return 0;
      }
   }

   public boolean isVerified() {
      try {
         boolean var1 = this.te.isVerified();
         return var1;
      } catch (RemoteException var3) {
         gr.d("Could not forward isVerified to InAppPurchaseResult", var3);
         return false;
      }
   }
}
