package com.google.android.gms.tagmanager;

import android.net.Uri;

class ce {
   private static ce asm;
   private volatile String aqm;
   private volatile ce.a asn;
   private volatile String aso;
   private volatile String asp;

   ce() {
      this.clear();
   }

   private String cK(String var1) {
      return var1.split("&")[0].split("=")[1];
   }

   private String j(Uri var1) {
      return var1.getQuery().replace("&gtm_debug=x", "");
   }

   static ce qa() {
      // $FF: Couldn't be decompiled
   }

   void clear() {
      this.asn = ce.a.asq;
      this.aso = null;
      this.aqm = null;
      this.asp = null;
   }

   String getContainerId() {
      return this.aqm;
   }

   boolean i(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   ce.a qb() {
      return this.asn;
   }

   String qc() {
      return this.aso;
   }

   static enum a {
      asq,
      asr,
      ass;
   }
}
