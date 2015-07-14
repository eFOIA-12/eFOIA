package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import android.os.Build.VERSION;
import com.google.android.gms.internal.em;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ey
public final class ed extends em.a {
   private Context mContext;
   private String mG;
   private String sM;
   private ArrayList sN;

   public ed(String var1, ArrayList var2, Context var3, String var4) {
      this.sM = var1;
      this.sN = var2;
      this.mG = var4;
      this.mContext = var3;
   }

   private void cz() {
      try {
         this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object)null, new Object[]{this.mContext, this.sM, "", Boolean.valueOf(true)});
      } catch (ClassNotFoundException var2) {
         gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      } catch (NoSuchMethodException var3) {
         gr.W("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      } catch (Exception var4) {
         gr.d("Fail to report a conversion.", var4);
      }
   }

   protected String a(String var1, HashMap var2) {
      String var8 = this.mContext.getPackageName();

      String var7;
      try {
         var7 = this.mContext.getPackageManager().getPackageInfo(var8, 0).versionName;
      } catch (NameNotFoundException var11) {
         gr.d("Error to retrieve app version", var11);
         var7 = "";
      }

      long var3 = SystemClock.elapsedRealtime();
      long var5 = ga.dh().dq();

      String var10;
      for(Iterator var9 = var2.keySet().iterator(); var9.hasNext(); var1 = var1.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{var10}), String.format("$1%s$2", new Object[]{var2.get(var10)}))) {
         var10 = (String)var9.next();
      }

      return var1.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sessionid"}), String.format("$1%s$2", new Object[]{ga.vY})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appid"}), String.format("$1%s$2", new Object[]{var8})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"osversion"}), String.format("$1%s$2", new Object[]{String.valueOf(VERSION.SDK_INT)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"sdkversion"}), String.format("$1%s$2", new Object[]{this.mG})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"appversion"}), String.format("$1%s$2", new Object[]{var7})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"timestamp"}), String.format("$1%s$2", new Object[]{String.valueOf(var3 - var5)})).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[]{"[^@]+"}), String.format("$1%s$2", new Object[]{""})).replaceAll("@@", "@");
   }

   public String getProductId() {
      return this.sM;
   }

   protected int p(int var1) {
      return var1 == 0?1:(var1 == 1?2:(var1 == 4?3:0));
   }

   public void recordPlayBillingResolution(int var1) {
      if(var1 == 0) {
         this.cz();
      }

      HashMap var2 = new HashMap();
      var2.put("google_play_status", String.valueOf(var1));
      var2.put("sku", this.sM);
      var2.put("status", String.valueOf(this.p(var1)));
      Iterator var3 = this.sN.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         (new gp(this.mContext, this.mG, this.a(var4, var2))).start();
      }

   }

   public void recordResolution(int var1) {
      if(var1 == 1) {
         this.cz();
      }

      HashMap var2 = new HashMap();
      var2.put("status", String.valueOf(var1));
      var2.put("sku", this.sM);
      Iterator var3 = this.sN.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         (new gp(this.mContext, this.mG, this.a(var4, var2))).start();
      }

   }
}
