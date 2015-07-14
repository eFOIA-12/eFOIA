package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tagmanager.ab;
import com.google.android.gms.tagmanager.ap;
import com.google.android.gms.tagmanager.bh;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class db implements ab {
   private final String atQ;
   private final HttpClient atR;
   private db.a atS;
   private final Context atz;

   db(HttpClient var1, Context var2, db.a var3) {
      this.atz = var2.getApplicationContext();
      this.atQ = this.a("GoogleTagManager", "4.00", VERSION.RELEASE, c(Locale.getDefault()), Build.MODEL, Build.ID);
      this.atR = var1;
      this.atS = var3;
   }

   private HttpEntityEnclosingRequest a(URL var1) {
      URISyntaxException var2;
      BasicHttpEntityEnclosingRequest var5;
      label17: {
         try {
            var5 = new BasicHttpEntityEnclosingRequest("GET", var1.toURI().toString());
         } catch (URISyntaxException var4) {
            var2 = var4;
            var5 = null;
            break label17;
         }

         try {
            var5.addHeader("User-Agent", this.atQ);
            return var5;
         } catch (URISyntaxException var3) {
            var2 = var3;
         }
      }

      bh.W("Exception sending hit: " + var2.getClass().getSimpleName());
      bh.W(var2.getMessage());
      return var5;
   }

   private void a(HttpEntityEnclosingRequest param1) {
      // $FF: Couldn't be decompiled
   }

   static String c(Locale var0) {
      if(var0 != null && var0.getLanguage() != null && var0.getLanguage().length() != 0) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.getLanguage().toLowerCase());
         if(var0.getCountry() != null && var0.getCountry().length() != 0) {
            var1.append("-").append(var0.getCountry().toLowerCase());
         }

         return var1.toString();
      } else {
         return null;
      }
   }

   String a(String var1, String var2, String var3, String var4, String var5, String var6) {
      return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{var1, var2, var3, var4, var5, var6});
   }

   URL d(ap var1) {
      String var3 = var1.pL();

      try {
         URL var4 = new URL(var3);
         return var4;
      } catch (MalformedURLException var2) {
         bh.T("Error trying to parse the GTM url.");
         return null;
      }
   }

   public boolean ea() {
      NetworkInfo var1 = ((ConnectivityManager)this.atz.getSystemService("connectivity")).getActiveNetworkInfo();
      if(var1 != null && var1.isConnected()) {
         return true;
      } else {
         bh.V("...no network connectivity");
         return false;
      }
   }

   public void k(List param1) {
      // $FF: Couldn't be decompiled
   }

   public interface a {
      void a(ap var1);

      void b(ap var1);

      void c(ap var1);
   }
}
