package com.google.android.gms.internal;

import com.google.android.gms.internal.ah;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.u;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public class bv {
   private u pM;
   private ah pN;
   private JSONObject pO;

   public bv(u var1, ah var2, JSONObject var3) {
      this.pM = var1;
      this.pN = var2;
      this.pO = var3;
   }

   public void aw() {
      this.pM.an();
   }

   public void b(String var1, int var2) {
      try {
         JSONObject var3 = new JSONObject();
         var3.put("asset", var2);
         var3.put("template", var1);
         JSONObject var5 = new JSONObject();
         var5.put("ad", this.pO);
         var5.put("click", var3);
         this.pN.a("google.afma.nativeAds.handleClick", var5);
      } catch (JSONException var4) {
         gr.b("Unable to create click JSON.", var4);
      }
   }

   public interface a {
      void a(bv var1);
   }
}
