package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.gr;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ey
public final class ft {
   private int mOrientation = -1;
   private String pD;
   private String uJ;
   private String uK;
   private List uL;
   private String uM;
   private String uN;
   private List uO;
   private long uP = -1L;
   private boolean uQ = false;
   private final long uR = -1L;
   private long uS = -1L;
   private boolean uT = false;
   private boolean uU = false;
   private boolean uV = false;
   private boolean uW = true;
   private List uo;

   static String a(Map var0, String var1) {
      List var2 = (List)var0.get(var1);
      return var2 != null && !var2.isEmpty()?(String)var2.get(0):null;
   }

   static long b(Map var0, String var1) {
      List var5 = (List)var0.get(var1);
      if(var5 != null && !var5.isEmpty()) {
         String var6 = (String)var5.get(0);

         float var2;
         try {
            var2 = Float.parseFloat(var6);
         } catch (NumberFormatException var4) {
            gr.W("Could not parse float from " + var1 + " header: " + var6);
            return -1L;
         }

         return (long)(var2 * 1000.0F);
      } else {
         return -1L;
      }
   }

   static List c(Map var0, String var1) {
      List var2 = (List)var0.get(var1);
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if(var3 != null) {
            return Arrays.asList(var3.trim().split("\\s+"));
         }
      }

      return null;
   }

   private boolean d(Map var1, String var2) {
      List var3 = (List)var1.get(var2);
      return var3 != null && !var3.isEmpty() && Boolean.valueOf((String)var3.get(0)).booleanValue();
   }

   private void f(Map var1) {
      this.uJ = a(var1, "X-Afma-Ad-Size");
   }

   private void g(Map var1) {
      List var2 = c(var1, "X-Afma-Click-Tracking-Urls");
      if(var2 != null) {
         this.uL = var2;
      }

   }

   private void h(Map var1) {
      List var2 = (List)var1.get("X-Afma-Debug-Dialog");
      if(var2 != null && !var2.isEmpty()) {
         this.uM = (String)var2.get(0);
      }

   }

   private void i(Map var1) {
      List var2 = c(var1, "X-Afma-Tracking-Urls");
      if(var2 != null) {
         this.uO = var2;
      }

   }

   private void j(Map var1) {
      long var2 = b(var1, "X-Afma-Interstitial-Timeout");
      if(var2 != -1L) {
         this.uP = var2;
      }

   }

   private void k(Map var1) {
      this.uN = a(var1, "X-Afma-ActiveView");
   }

   private void l(Map var1) {
      this.uU |= this.d(var1, "X-Afma-Native");
   }

   private void m(Map var1) {
      this.uT |= this.d(var1, "X-Afma-Custom-Rendering-Allowed");
   }

   private void n(Map var1) {
      this.uQ |= this.d(var1, "X-Afma-Mediation");
   }

   private void o(Map var1) {
      List var2 = c(var1, "X-Afma-Manual-Tracking-Urls");
      if(var2 != null) {
         this.uo = var2;
      }

   }

   private void p(Map var1) {
      long var2 = b(var1, "X-Afma-Refresh-Rate");
      if(var2 != -1L) {
         this.uS = var2;
      }

   }

   private void q(Map var1) {
      List var2 = (List)var1.get("X-Afma-Orientation");
      if(var2 != null && !var2.isEmpty()) {
         String var3 = (String)var2.get(0);
         if("portrait".equalsIgnoreCase(var3)) {
            this.mOrientation = gi.dv();
         } else if("landscape".equalsIgnoreCase(var3)) {
            this.mOrientation = gi.du();
            return;
         }
      }

   }

   private void r(Map var1) {
      List var2 = (List)var1.get("X-Afma-Use-HTTPS");
      if(var2 != null && !var2.isEmpty()) {
         this.uV = Boolean.valueOf((String)var2.get(0)).booleanValue();
      }

   }

   private void s(Map var1) {
      List var2 = (List)var1.get("X-Afma-Content-Url-Opted-Out");
      if(var2 != null && !var2.isEmpty()) {
         this.uW = Boolean.valueOf((String)var2.get(0)).booleanValue();
      }

   }

   public void a(String var1, Map var2, String var3) {
      this.uK = var1;
      this.pD = var3;
      this.e(var2);
   }

   public void e(Map var1) {
      this.f(var1);
      this.g(var1);
      this.h(var1);
      this.i(var1);
      this.j(var1);
      this.n(var1);
      this.o(var1);
      this.p(var1);
      this.q(var1);
      this.k(var1);
      this.r(var1);
      this.m(var1);
      this.l(var1);
      this.s(var1);
   }

   public fj i(long var1) {
      return new fj(this.uK, this.pD, this.uL, this.uO, this.uP, this.uQ, -1L, this.uo, this.uS, this.mOrientation, this.uJ, var1, this.uM, this.uN, this.uT, this.uU, this.uV, this.uW);
   }
}
