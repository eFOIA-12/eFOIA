package com.google.android.gms.analytics;

import android.text.TextUtils;

public class ab {
   private String Bu;
   private final long Bv;
   private final long Bw;
   private final String Bx;
   private String By;
   private String Bz = "https:";

   public ab(String var1, long var2, long var4, String var6) {
      this.Bu = var1;
      this.Bv = var2;
      this.Bw = var4;
      this.Bx = var6;
   }

   public void aj(String var1) {
      this.Bu = var1;
   }

   public void ak(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.By = var1;
         if(var1.toLowerCase().startsWith("http:")) {
            this.Bz = "http:";
            return;
         }
      }

   }

   public String fa() {
      return this.Bu;
   }

   public long fb() {
      return this.Bv;
   }

   public long fc() {
      return this.Bw;
   }

   public String fd() {
      return this.Bz;
   }
}
