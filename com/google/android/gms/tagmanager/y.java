package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.aq;
import com.google.android.gms.tagmanager.ar;
import com.google.android.gms.tagmanager.as;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.cg;
import com.google.android.gms.tagmanager.cw;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class y implements aq {
   private static y arl;
   private static final Object xO = new Object();
   private cg aqC;
   private String arm;
   private String arn;
   private ar aro;

   private y(Context var1) {
      this(as.Z(var1), new cw());
   }

   y(ar var1, cg var2) {
      this.aro = var1;
      this.aqC = var2;
   }

   public static aq X(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean cB(String var1) {
      if(!this.aqC.fe()) {
         bh.W("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
         return false;
      } else {
         String var2 = var1;
         if(this.arm != null) {
            var2 = var1;
            if(this.arn != null) {
               try {
                  var2 = this.arm + "?" + this.arn + "=" + URLEncoder.encode(var1, "UTF-8");
                  bh.V("Sending wrapped url hit: " + var2);
               } catch (UnsupportedEncodingException var3) {
                  bh.d("Error wrapping URL for testing.", var3);
                  return false;
               }
            }
         }

         this.aro.cE(var2);
         return true;
      }
   }
}
