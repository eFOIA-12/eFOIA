package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.l;

public class k {
   private String kU = "googleads.g.doubleclick.net";
   private String kV = "/pagead/ads";
   private String kW = "ad.doubleclick.net";
   private String[] kX = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
   private g kY;

   public k(g var1) {
      this.kY = var1;
   }

   private Uri a(Uri param1, Context param2, String param3, boolean param4) throws l {
      // $FF: Couldn't be decompiled
   }

   private Uri a(Uri var1, String var2, String var3) throws UnsupportedOperationException {
      String var6 = var1.toString();
      int var5 = var6.indexOf("&adurl");
      int var4 = var5;
      if(var5 == -1) {
         var4 = var6.indexOf("?adurl");
      }

      return var4 != -1?Uri.parse(var6.substring(0, var4 + 1) + var2 + "=" + var3 + "&" + var6.substring(var4 + 1)):var1.buildUpon().appendQueryParameter(var2, var3).build();
   }

   private Uri b(Uri var1, String var2, String var3) {
      String var5 = var1.toString();
      int var4 = var5.indexOf(";adurl");
      if(var4 != -1) {
         return Uri.parse(var5.substring(0, var4 + 1) + var2 + "=" + var3 + ";" + var5.substring(var4 + 1));
      } else {
         String var6 = var1.getEncodedPath();
         var4 = var5.indexOf(var6);
         return Uri.parse(var5.substring(0, var6.length() + var4) + ";" + var2 + "=" + var3 + ";" + var5.substring(var6.length() + var4));
      }
   }

   public g C() {
      return this.kY;
   }

   public Uri a(Uri var1, Context var2) throws l {
      try {
         var1 = this.a(var1, var2, var1.getQueryParameter("ai"), true);
         return var1;
      } catch (UnsupportedOperationException var3) {
         throw new l("Provided Uri is not in a valid state");
      }
   }

   public void a(MotionEvent var1) {
      this.kY.a(var1);
   }

   public boolean a(Uri var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         try {
            boolean var2 = var1.getHost().equals(this.kW);
            return var2;
         } catch (NullPointerException var3) {
            return false;
         }
      }
   }

   public boolean b(Uri param1) {
      // $FF: Couldn't be decompiled
   }
}
