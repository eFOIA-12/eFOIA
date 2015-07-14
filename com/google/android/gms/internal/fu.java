package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
class fu {
   private int tq;
   private final List uX;
   private final List uY;
   private final String uZ;
   private final String va;
   private final String vb;
   private final String vc;
   private final boolean vd;
   private final int ve;
   private String vf;

   public fu(int var1, Map var2) {
      this.vf = (String)var2.get("url");
      this.va = (String)var2.get("base_uri");
      this.vb = (String)var2.get("post_parameters");
      this.vd = parseBoolean((String)var2.get("drt_include"));
      this.uZ = (String)var2.get("activation_overlay_url");
      this.uY = this.J((String)var2.get("check_packages"));
      this.ve = this.parseInt((String)var2.get("request_id"));
      this.vc = (String)var2.get("type");
      this.uX = this.J((String)var2.get("errors"));
      this.tq = var1;
   }

   private List J(String var1) {
      return var1 == null?null:Arrays.asList(var1.split(","));
   }

   private static boolean parseBoolean(String var0) {
      return var0 != null && (var0.equals("1") || var0.equals("true"));
   }

   private int parseInt(String var1) {
      return var1 == null?0:Integer.parseInt(var1);
   }

   public List cT() {
      return this.uX;
   }

   public String cU() {
      return this.vb;
   }

   public boolean cV() {
      return this.vd;
   }

   public int getErrorCode() {
      return this.tq;
   }

   public String getType() {
      return this.vc;
   }

   public String getUrl() {
      return this.vf;
   }

   public void setUrl(String var1) {
      this.vf = var1;
   }
}
