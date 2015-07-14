package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class ap {
   private final long Bv;
   private final long Bw;
   private String By;
   private final long arw;

   ap(long var1, long var3, long var5) {
      this.Bv = var1;
      this.Bw = var3;
      this.arw = var5;
   }

   void ak(String var1) {
      if(var1 != null && !TextUtils.isEmpty(var1.trim())) {
         this.By = var1;
      }
   }

   long fb() {
      return this.Bv;
   }

   long pK() {
      return this.arw;
   }

   String pL() {
      return this.By;
   }
}
