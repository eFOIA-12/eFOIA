package com.google.android.gms.internal;

import com.google.android.gms.internal.cd;
import com.google.android.gms.internal.ce;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.gu;
import com.google.android.gms.internal.gv;
import com.google.android.gms.internal.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@ey
public final class ci implements cd {
   private final ce qc;
   private final v qd;

   public ci(ce var1, v var2) {
      this.qc = var1;
      this.qd = var2;
   }

   private static boolean b(Map var0) {
      return "1".equals(var0.get("custom_close"));
   }

   private static int c(Map var0) {
      String var1 = (String)var0.get("o");
      if(var1 != null) {
         if("p".equalsIgnoreCase(var1)) {
            return gi.dv();
         }

         if("l".equalsIgnoreCase(var1)) {
            return gi.du();
         }
      }

      return -1;
   }

   public void a(gu var1, Map var2) {
      String var4 = (String)var2.get("a");
      if(var4 == null) {
         gr.W("Action missing from an open GMSG.");
      } else {
         if(this.qd != null && !this.qd.az()) {
            this.qd.d((String)var2.get("u"));
            return;
         }

         gv var3 = var1.dD();
         if("expand".equalsIgnoreCase(var4)) {
            if(var1.dH()) {
               gr.W("Cannot expand WebView that is already expanded.");
               return;
            }

            var3.a(b(var2), c(var2));
            return;
         }

         String var5;
         if("webapp".equalsIgnoreCase(var4)) {
            var5 = (String)var2.get("u");
            if(var5 != null) {
               var3.a(b(var2), c(var2), var5);
               return;
            }

            var3.a(b(var2), c(var2), (String)var2.get("html"), (String)var2.get("baseurl"));
            return;
         }

         if(!"in_app_purchase".equalsIgnoreCase(var4)) {
            var3.a(new do((String)var2.get("i"), (String)var2.get("u"), (String)var2.get("m"), (String)var2.get("p"), (String)var2.get("c"), (String)var2.get("f"), (String)var2.get("e")));
            return;
         }

         var5 = (String)var2.get("product_id");
         String var6 = (String)var2.get("report_urls");
         if(this.qc != null) {
            if(var6 != null && !var6.isEmpty()) {
               String[] var7 = var6.split(" ");
               this.qc.a(var5, new ArrayList(Arrays.asList(var7)));
               return;
            }

            this.qc.a(var5, new ArrayList());
            return;
         }
      }

   }
}
