package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.q;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

class k implements q {
   private static final Object xO = new Object();
   private static k yD;
   private final Context mContext;
   private String yE;
   private boolean yF = false;
   private final Object yG = new Object();

   protected k(Context var1) {
      this.mContext = var1;
      this.ep();
   }

   // $FF: synthetic method
   static Object a(k var0) {
      return var0.yG;
   }

   // $FF: synthetic method
   static String a(k var0, String var1) {
      var0.yE = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean a(k var0, boolean var1) {
      var0.yF = var1;
      return var1;
   }

   private boolean ae(String var1) {
      try {
         ae.V("Storing clientId.");
         FileOutputStream var2 = this.mContext.openFileOutput("gaClientId", 0);
         var2.write(var1.getBytes());
         var2.close();
         return true;
      } catch (FileNotFoundException var3) {
         ae.T("Error creating clientId file.");
         return false;
      } catch (IOException var4) {
         ae.T("Error writing to clientId file.");
         return false;
      }
   }

   public static k el() {
      // $FF: Couldn't be decompiled
   }

   private String en() {
      // $FF: Couldn't be decompiled
   }

   private void ep() {
      (new Thread("client_id_fetcher") {
         public void run() {
            // $FF: Couldn't be decompiled
         }
      }).start();
   }

   public static void y(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean ac(String var1) {
      return "&cid".equals(var1);
   }

   String em() {
      // $FF: Couldn't be decompiled
   }

   protected String eo() {
      String var2 = UUID.randomUUID().toString().toLowerCase();
      String var1 = var2;

      try {
         if(this.ae(var2)) {
            return var1;
         }
      } catch (Exception var3) {
         return null;
      }

      var1 = "0";
      return var1;
   }

   String eq() {
      // $FF: Couldn't be decompiled
   }

   public String getValue(String var1) {
      return "&cid".equals(var1)?this.en():null;
   }
}
