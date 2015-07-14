package com.google.android.gms.internal;

import com.google.android.gms.internal.cw;
import com.google.android.gms.internal.ey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class cq {
   public final String qn;
   public final String qo;
   public final List qp;
   public final String qq;
   public final String qr;
   public final List qs;
   public final String qt;

   public cq(JSONObject var1) throws JSONException {
      Object var4 = null;
      super();
      this.qo = var1.getString("id");
      JSONArray var3 = var1.getJSONArray("adapters");
      ArrayList var5 = new ArrayList(var3.length());

      for(int var2 = 0; var2 < var3.length(); ++var2) {
         var5.add(var3.getString(var2));
      }

      this.qp = Collections.unmodifiableList(var5);
      this.qq = var1.optString("allocation_id", (String)null);
      this.qs = cw.a(var1, "imp_urls");
      JSONObject var7 = var1.optJSONObject("ad");
      String var8;
      if(var7 != null) {
         var8 = var7.toString();
      } else {
         var8 = null;
      }

      this.qn = var8;
      var7 = var1.optJSONObject("data");
      String var6;
      if(var7 != null) {
         var6 = var7.toString();
      } else {
         var6 = null;
      }

      this.qt = var6;
      var6 = (String)var4;
      if(var7 != null) {
         var6 = var7.optString("class_name");
      }

      this.qr = var6;
   }
}
