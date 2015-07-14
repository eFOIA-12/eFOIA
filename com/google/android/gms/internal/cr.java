package com.google.android.gms.internal;

import com.google.android.gms.internal.cq;
import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cr {
   public final long qA;
   public int qB;
   public int qC;
   public final List qu;
   public final long qv;
   public final List qw;
   public final List qx;
   public final List qy;
   public final String qz;

   public cr(String var1) throws JSONException {
      JSONObject var10 = new JSONObject(var1);
      if(gr.v(2)) {
         gr.V("Mediation Response JSON: " + var10.toString(2));
      }

      JSONArray var7 = var10.getJSONArray("ad_networks");
      ArrayList var8 = new ArrayList(var7.length());
      int var3 = -1;

      int var4;
      for(int var2 = 0; var2 < var7.length(); var3 = var4) {
         cq var9 = new cq(var7.getJSONObject(var2));
         var8.add(var9);
         var4 = var3;
         if(var3 < 0) {
            var4 = var3;
            if(this.a(var9)) {
               var4 = var2;
            }
         }

         ++var2;
      }

      this.qB = var3;
      this.qC = var7.length();
      this.qu = Collections.unmodifiableList(var8);
      this.qz = var10.getString("qdata");
      var10 = var10.optJSONObject("settings");
      if(var10 != null) {
         this.qv = var10.optLong("ad_network_timeout_millis", -1L);
         this.qw = cw.a(var10, "click_urls");
         this.qx = cw.a(var10, "imp_urls");
         this.qy = cw.a(var10, "nofill_urls");
         long var5 = var10.optLong("refresh", -1L);
         if(var5 > 0L) {
            var5 *= 1000L;
         } else {
            var5 = -1L;
         }

         this.qA = var5;
      } else {
         this.qv = -1L;
         this.qw = null;
         this.qx = null;
         this.qy = null;
         this.qA = -1L;
      }
   }

   private boolean a(cq var1) {
      Iterator var2 = var1.qp.iterator();

      do {
         if(!var2.hasNext()) {
            return false;
         }
      } while(!((String)var2.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"));

      return true;
   }
}
