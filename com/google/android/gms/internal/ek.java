package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.internal.ei;
import com.google.android.gms.internal.el;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;

@ey
public class ek {
   private final String oK;

   public ek(String var1) {
      this.oK = var1;
   }

   public boolean a(String var1, int var2, Intent var3) {
      if(var1 != null && var3 != null) {
         String var4 = ei.e(var3);
         String var5 = ei.f(var3);
         if(var4 != null && var5 != null) {
            if(!var1.equals(ei.D(var4))) {
               gr.W("Developer payload not match.");
               return false;
            }

            if(this.oK != null && !el.b(this.oK, var4, var5)) {
               gr.W("Fail to verify signature.");
               return false;
            }

            return true;
         }
      }

      return false;
   }

   public String cC() {
      return gi.dx();
   }
}
