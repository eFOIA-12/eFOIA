package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import java.util.Map;

class ai {
   private static void a(DataLayer var0, com.google.android.gms.internal.c var1) {
      com.google.android.gms.internal.d[] var4 = var1.fB;
      int var3 = var4.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.cx(di.j(var4[var2]));
      }

   }

   public static void a(DataLayer var0, com.google.android.gms.internal.c var1) {
      if(var1.gq == null) {
         bh.W("supplemental missing experimentSupplemental");
      } else {
         a(var0, var1.gq);
         b(var0, var1.gq);
         c(var0, var1.gq);
      }
   }

   private static void b(DataLayer var0, com.google.android.gms.internal.c var1) {
      com.google.android.gms.internal.d[] var5 = var1.fA;
      int var3 = var5.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Map var4 = c(var5[var2]);
         if(var4 != null) {
            var0.push(var4);
         }
      }

   }

   private static Map c(com.google.android.gms.internal.d var0) {
      Object var1 = di.o(var0);
      if(!(var1 instanceof Map)) {
         bh.W("value: " + var1 + " is not a map value, ignored.");
         return null;
      } else {
         return (Map)var1;
      }
   }

   private static void c(DataLayer var0, com.google.android.gms.internal.c var1) {
      com.google.android.gms.internal.c[] var9 = var1.fC;
      int var3 = var9.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         com.google.android.gms.internal.c var10 = var9[var2];
         if(var10.fv == null) {
            bh.W("GaExperimentRandom: No key");
         } else {
            Object var8 = var0.get(var10.fv);
            Long var11;
            if(!(var8 instanceof Number)) {
               var11 = null;
            } else {
               var11 = Long.valueOf(((Number)var8).longValue());
            }

            long var4 = var10.fw;
            long var6 = var10.fx;
            if(!var10.fy || var11 == null || var11.longValue() < var4 || var11.longValue() > var6) {
               if(var4 > var6) {
                  bh.W("GaExperimentRandom: random range invalid");
                  continue;
               }

               var8 = Long.valueOf(Math.round(Math.random() * (double)(var6 - var4) + (double)var4));
            }

            var0.cx(var10.fv);
            Map var12 = var0.c(var10.fv, var8);
            if(var10.fz > 0L) {
               if(!var12.containsKey("gtm")) {
                  var12.put("gtm", DataLayer.mapOf(new Object[]{"lifetime", Long.valueOf(var10.fz)}));
               } else {
                  var8 = var12.get("gtm");
                  if(var8 instanceof Map) {
                     ((Map)var8).put("lifetime", Long.valueOf(var10.fz));
                  } else {
                     bh.W("GaExperimentRandom: gtm not a map");
                  }
               }
            }

            var0.push(var12);
         }
      }

   }
}
