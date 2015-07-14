package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.di;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr {
   private static com.google.android.gms.internal.d a(int var0, com.google.android.gms.internal.c var1, com.google.android.gms.internal.d[] var2, Set var3) throws cr.g {
      byte var6 = 0;
      byte var7 = 0;
      int var5 = 0;
      if(var3.contains(Integer.valueOf(var0))) {
         cN("Value cycle detected.  Current value reference: " + var0 + "." + "  Previous value references: " + var3 + ".");
      }

      com.google.android.gms.internal.d var10 = (com.google.android.gms.internal.d)a(var1.fG, var0, "values");
      if(var2[var0] != null) {
         return var2[var0];
      } else {
         com.google.android.gms.internal.d var9;
         var9 = null;
         var3.add(Integer.valueOf(var0));
         int var4;
         com.google.android.gms.internal.d var11;
         int[] var12;
         int var13;
         int var14;
         com.google.android.gms.internal.c var15;
         label54:
         switch(var10.type) {
         case 1:
         case 5:
         case 6:
         case 8:
            var9 = var10;
            break;
         case 2:
            var15 = h(var10);
            var11 = g(var10);
            var11.gw = new com.google.android.gms.internal.d[var15.gh.length];
            var12 = var15.gh;
            var13 = var12.length;
            var4 = 0;

            while(true) {
               var9 = var11;
               if(var5 >= var13) {
                  break label54;
               }

               var14 = var12[var5];
               var11.gw[var4] = a(var14, var1, var2, var3);
               ++var5;
               ++var4;
            }
         case 3:
            var11 = g(var10);
            var15 = h(var10);
            if(var15.gi.length != var15.gj.length) {
               cN("Uneven map keys (" + var15.gi.length + ") and map values (" + var15.gj.length + ")");
            }

            var11.gx = new com.google.android.gms.internal.d[var15.gi.length];
            var11.gy = new com.google.android.gms.internal.d[var15.gi.length];
            var12 = var15.gi;
            var14 = var12.length;
            var5 = 0;

            for(var4 = 0; var5 < var14; ++var4) {
               int var8 = var12[var5];
               var11.gx[var4] = a(var8, var1, var2, var3);
               ++var5;
            }

            var12 = var15.gj;
            var14 = var12.length;
            var4 = 0;
            var5 = var6;

            while(true) {
               var9 = var11;
               if(var5 >= var14) {
                  break label54;
               }

               var13 = var12[var5];
               var11.gy[var4] = a(var13, var1, var2, var3);
               ++var5;
               ++var4;
            }
         case 4:
            var9 = g(var10);
            var9.gz = di.j(a(h(var10).gm, var1, var2, var3));
            break;
         case 7:
            var11 = g(var10);
            var15 = h(var10);
            var11.gD = new com.google.android.gms.internal.d[var15.gl.length];
            var12 = var15.gl;
            var13 = var12.length;
            var4 = 0;
            var5 = var7;

            while(true) {
               var9 = var11;
               if(var5 >= var13) {
                  break;
               }

               var14 = var12[var5];
               var11.gD[var4] = a(var14, var1, var2, var3);
               ++var5;
               ++var4;
            }
         }

         if(var9 == null) {
            cN("Invalid value: " + var10);
         }

         var2[var0] = var9;
         var3.remove(Integer.valueOf(var0));
         return var9;
      }
   }

   private static cr.a a(com.google.android.gms.internal.c var0, com.google.android.gms.internal.c var1, com.google.android.gms.internal.d[] var2, int var3) throws cr.g {
      cr.b var6 = cr.a.qk();
      int[] var9 = var0.fq;
      int var4 = var9.length;

      for(var3 = 0; var3 < var4; ++var3) {
         int var5 = var9[var3];
         com.google.android.gms.internal.c var8 = (com.google.android.gms.internal.c)a(var1.fH, Integer.valueOf(var5).intValue(), "properties");
         String var7 = (String)a(var1.fF, var8.key, "keys");
         com.google.android.gms.internal.d var10 = (com.google.android.gms.internal.d)a(var2, var8.value, "values");
         if(com.google.android.gms.internal.b.ec.toString().equals(var7)) {
            var6.i(var10);
         } else {
            var6.b(var7, var10);
         }
      }

      return var6.qn();
   }

   private static cr.e a(com.google.android.gms.internal.c var0, List var1, List var2, List var3, com.google.android.gms.internal.c var4) {
      cr.f var8 = cr.e.qs();
      int[] var9 = var0.fV;
      int var6 = var9.length;

      int var5;
      for(var5 = 0; var5 < var6; ++var5) {
         var8.b((cr.a)var3.get(Integer.valueOf(var9[var5]).intValue()));
      }

      var9 = var0.fW;
      var6 = var9.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var8.c((cr.a)var3.get(Integer.valueOf(var9[var5]).intValue()));
      }

      int[] var12 = var0.fX;
      var6 = var12.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var8.d((cr.a)var1.get(Integer.valueOf(var12[var5]).intValue()));
      }

      var12 = var0.fZ;
      var6 = var12.length;

      int var7;
      for(var5 = 0; var5 < var6; ++var5) {
         var7 = var12[var5];
         var8.cP(var4.fG[Integer.valueOf(var7).intValue()].gv);
      }

      var12 = var0.fY;
      var6 = var12.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var8.e((cr.a)var1.get(Integer.valueOf(var12[var5]).intValue()));
      }

      int[] var11 = var0.ga;
      var6 = var11.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var7 = var11[var5];
         var8.cQ(var4.fG[Integer.valueOf(var7).intValue()].gv);
      }

      var11 = var0.gb;
      var6 = var11.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var8.f((cr.a)var2.get(Integer.valueOf(var11[var5]).intValue()));
      }

      var11 = var0.gd;
      var6 = var11.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var7 = var11[var5];
         var8.cR(var4.fG[Integer.valueOf(var7).intValue()].gv);
      }

      var11 = var0.gc;
      var6 = var11.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var8.g((cr.a)var2.get(Integer.valueOf(var11[var5]).intValue()));
      }

      int[] var10 = var0.ge;
      var6 = var10.length;

      for(var5 = 0; var5 < var6; ++var5) {
         var7 = var10[var5];
         var8.cS(var4.fG[Integer.valueOf(var7).intValue()].gv);
      }

      return var8.qD();
   }

   private static Object a(Object[] var0, int var1, String var2) throws cr.g {
      if(var1 < 0 || var1 >= var0.length) {
         cN("Index out of bounds detected: " + var1 + " in " + var2);
      }

      return var0[var1];
   }

   public static cr.c b(com.google.android.gms.internal.c var0) throws cr.g {
      byte var2 = 0;
      com.google.android.gms.internal.d[] var8 = new com.google.android.gms.internal.d[var0.fG.length];

      int var1;
      for(var1 = 0; var1 < var0.fG.length; ++var1) {
         a(var1, var0, var8, new HashSet(0));
      }

      cr.d var4 = cr.c.qo();
      ArrayList var5 = new ArrayList();

      for(var1 = 0; var1 < var0.fJ.length; ++var1) {
         var5.add(a(var0.fJ[var1], var0, var8, var1));
      }

      ArrayList var6 = new ArrayList();

      for(var1 = 0; var1 < var0.fK.length; ++var1) {
         var6.add(a(var0.fK[var1], var0, var8, var1));
      }

      ArrayList var7 = new ArrayList();

      for(var1 = 0; var1 < var0.fI.length; ++var1) {
         cr.a var9 = a(var0.fI[var1], var0, var8, var1);
         var4.a(var9);
         var7.add(var9);
      }

      com.google.android.gms.internal.c[] var10 = var0.fL;
      int var3 = var10.length;

      for(var1 = var2; var1 < var3; ++var1) {
         var4.a(a(var10[var1], var5, var7, var6, var0));
      }

      var4.cO(var0.version);
      var4.fO(var0.fT);
      return var4.qr();
   }

   public static void b(InputStream var0, OutputStream var1) throws IOException {
      byte[] var3 = new byte[1024];

      while(true) {
         int var2 = var0.read(var3);
         if(var2 == -1) {
            return;
         }

         var1.write(var3, 0, var2);
      }
   }

   private static void cN(String var0) throws cr.g {
      bh.T(var0);
      throw new cr.g(var0);
   }

   public static com.google.android.gms.internal.d g(com.google.android.gms.internal.d var0) {
      com.google.android.gms.internal.d var1 = new com.google.android.gms.internal.d();
      var1.type = var0.type;
      var1.gE = (int[])var0.gE.clone();
      if(var0.gF) {
         var1.gF = var0.gF;
      }

      return var1;
   }

   private static com.google.android.gms.internal.c h(com.google.android.gms.internal.d var0) throws cr.g {
      if((com.google.android.gms.internal.c)var0.a(com.google.android.gms.internal.c.gf) == null) {
         cN("Expected a ServingValue and didn\'t get one. Value is: " + var0);
      }

      return (com.google.android.gms.internal.c)var0.a(com.google.android.gms.internal.c.gf);
   }

   public static class a {
      private final Map asM;
      private final com.google.android.gms.internal.d asN;

      private a(Map var1, com.google.android.gms.internal.d var2) {
         this.asM = var1;
         this.asN = var2;
      }

      // $FF: synthetic method
      a(Map var1, com.google.android.gms.internal.d var2, Object var3) {
         this(var1, var2);
      }

      public static cr.b qk() {
         return new cr.b(null);
      }

      public void a(String var1, com.google.android.gms.internal.d var2) {
         this.asM.put(var1, var2);
      }

      public Map ql() {
         return Collections.unmodifiableMap(this.asM);
      }

      public com.google.android.gms.internal.d qm() {
         return this.asN;
      }

      public String toString() {
         return "Properties: " + this.ql() + " pushAfterEvaluate: " + this.asN;
      }
   }

   public static class b {
      private final Map asM;
      private com.google.android.gms.internal.d asN;

      private b() {
         this.asM = new HashMap();
      }

      // $FF: synthetic method
      b(Object var1) {
         this();
      }

      public cr.b b(String var1, com.google.android.gms.internal.d var2) {
         this.asM.put(var1, var2);
         return this;
      }

      public cr.b i(com.google.android.gms.internal.d var1) {
         this.asN = var1;
         return this;
      }

      public cr.a qn() {
         return new cr.a(this.asM, this.asN, null);
      }
   }

   public static class c {
      private final String TU;
      private final List asO;
      private final Map asP;
      private final int asQ;

      private c(List var1, Map var2, String var3, int var4) {
         this.asO = Collections.unmodifiableList(var1);
         this.asP = Collections.unmodifiableMap(var2);
         this.TU = var3;
         this.asQ = var4;
      }

      // $FF: synthetic method
      c(List var1, Map var2, String var3, int var4, Object var5) {
         this(var1, var2, var3, var4);
      }

      public static cr.d qo() {
         return new cr.d(null);
      }

      public String getVersion() {
         return this.TU;
      }

      public List qp() {
         return this.asO;
      }

      public Map qq() {
         return this.asP;
      }

      public String toString() {
         return "Rules: " + this.qp() + "  Macros: " + this.asP;
      }
   }

   public static class d {
      private String TU;
      private final List asO;
      private final Map asP;
      private int asQ;

      private d() {
         this.asO = new ArrayList();
         this.asP = new HashMap();
         this.TU = "";
         this.asQ = 0;
      }

      // $FF: synthetic method
      d(Object var1) {
         this();
      }

      public cr.d a(cr.a var1) {
         String var4 = di.j((com.google.android.gms.internal.d)var1.ql().get(com.google.android.gms.internal.b.df.toString()));
         List var3 = (List)this.asP.get(var4);
         Object var2 = var3;
         if(var3 == null) {
            var2 = new ArrayList();
            this.asP.put(var4, var2);
         }

         ((List)var2).add(var1);
         return this;
      }

      public cr.d a(cr.e var1) {
         this.asO.add(var1);
         return this;
      }

      public cr.d cO(String var1) {
         this.TU = var1;
         return this;
      }

      public cr.d fO(int var1) {
         this.asQ = var1;
         return this;
      }

      public cr.c qr() {
         return new cr.c(this.asO, this.asP, this.TU, this.asQ, null);
      }
   }

   public static class e {
      private final List asR;
      private final List asS;
      private final List asT;
      private final List asU;
      private final List asV;
      private final List asW;
      private final List asX;
      private final List asY;
      private final List asZ;
      private final List ata;

      private e(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10) {
         this.asR = Collections.unmodifiableList(var1);
         this.asS = Collections.unmodifiableList(var2);
         this.asT = Collections.unmodifiableList(var3);
         this.asU = Collections.unmodifiableList(var4);
         this.asV = Collections.unmodifiableList(var5);
         this.asW = Collections.unmodifiableList(var6);
         this.asX = Collections.unmodifiableList(var7);
         this.asY = Collections.unmodifiableList(var8);
         this.asZ = Collections.unmodifiableList(var9);
         this.ata = Collections.unmodifiableList(var10);
      }

      // $FF: synthetic method
      e(List var1, List var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, Object var11) {
         this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public static cr.f qs() {
         return new cr.f(null);
      }

      public List qA() {
         return this.asZ;
      }

      public List qB() {
         return this.ata;
      }

      public List qC() {
         return this.asW;
      }

      public List qt() {
         return this.asR;
      }

      public List qu() {
         return this.asS;
      }

      public List qv() {
         return this.asT;
      }

      public List qw() {
         return this.asU;
      }

      public List qx() {
         return this.asV;
      }

      public List qy() {
         return this.asX;
      }

      public List qz() {
         return this.asY;
      }

      public String toString() {
         return "Positive predicates: " + this.qt() + "  Negative predicates: " + this.qu() + "  Add tags: " + this.qv() + "  Remove tags: " + this.qw() + "  Add macros: " + this.qx() + "  Remove macros: " + this.qC();
      }
   }

   public static class f {
      private final List asR;
      private final List asS;
      private final List asT;
      private final List asU;
      private final List asV;
      private final List asW;
      private final List asX;
      private final List asY;
      private final List asZ;
      private final List ata;

      private f() {
         this.asR = new ArrayList();
         this.asS = new ArrayList();
         this.asT = new ArrayList();
         this.asU = new ArrayList();
         this.asV = new ArrayList();
         this.asW = new ArrayList();
         this.asX = new ArrayList();
         this.asY = new ArrayList();
         this.asZ = new ArrayList();
         this.ata = new ArrayList();
      }

      // $FF: synthetic method
      f(Object var1) {
         this();
      }

      public cr.f b(cr.a var1) {
         this.asR.add(var1);
         return this;
      }

      public cr.f c(cr.a var1) {
         this.asS.add(var1);
         return this;
      }

      public cr.f cP(String var1) {
         this.asZ.add(var1);
         return this;
      }

      public cr.f cQ(String var1) {
         this.ata.add(var1);
         return this;
      }

      public cr.f cR(String var1) {
         this.asX.add(var1);
         return this;
      }

      public cr.f cS(String var1) {
         this.asY.add(var1);
         return this;
      }

      public cr.f d(cr.a var1) {
         this.asT.add(var1);
         return this;
      }

      public cr.f e(cr.a var1) {
         this.asU.add(var1);
         return this;
      }

      public cr.f f(cr.a var1) {
         this.asV.add(var1);
         return this;
      }

      public cr.f g(cr.a var1) {
         this.asW.add(var1);
         return this;
      }

      public cr.e qD() {
         return new cr.e(this.asR, this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata, null);
      }
   }

   public static class g extends Exception {
      public g(String var1) {
         super(var1);
      }
   }
}
