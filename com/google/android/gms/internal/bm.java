package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.ey;

@ey
public final class bm {
   private String pd = null;
   private String pe = null;
   private String pf = null;
   private String pg = null;

   public bm() {
      this.pd = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
      this.pe = null;
      this.pf = null;
      this.pg = null;
   }

   public bm(String var1, String var2, String var3, String var4) {
      if(TextUtils.isEmpty(var1)) {
         this.pd = "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html";
      } else {
         this.pd = var1;
      }

      this.pe = var2;
      this.pf = var3;
      this.pg = var4;
   }

   public String bu() {
      return this.pd;
   }

   public String bv() {
      return this.pe;
   }

   public String bw() {
      return this.pf;
   }

   public String bx() {
      return this.pg;
   }
}
