package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;

@ey
public class eb {
   private final Context mContext;
   private Object sC;

   public eb(Context var1) {
      this.mContext = var1;
   }

   public Bundle a(String var1, String var2, String var3) {
      try {
         Class var4 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
         Bundle var6 = (Bundle)var4.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(var4.cast(this.sC), new Object[]{Integer.valueOf(3), var1, var2, "inapp", var3});
         return var6;
      } catch (Exception var5) {
         gr.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var5);
         return null;
      }
   }

   public int c(String var1, String var2) {
      try {
         Class var4 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
         int var3 = ((Integer)var4.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(var4.cast(this.sC), new Object[]{Integer.valueOf(3), var1, var2})).intValue();
         return var3;
      } catch (Exception var5) {
         gr.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var5);
         return 5;
      }
   }

   public Bundle d(String var1, String var2) {
      try {
         Class var3 = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
         Bundle var5 = (Bundle)var3.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(var3.cast(this.sC), new Object[]{Integer.valueOf(3), var1, "inapp", var2});
         return var5;
      } catch (Exception var4) {
         gr.d("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", var4);
         return null;
      }
   }

   public void destroy() {
      this.sC = null;
   }

   public void t(IBinder var1) {
      try {
         this.sC = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object)null, new Object[]{var1});
      } catch (Exception var2) {
         gr.W("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
      }
   }
}
