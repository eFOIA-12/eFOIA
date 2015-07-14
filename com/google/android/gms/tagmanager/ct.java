package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.aa;
import com.google.android.gms.tagmanager.ac;
import com.google.android.gms.tagmanager.ad;
import com.google.android.gms.tagmanager.ae;
import com.google.android.gms.tagmanager.af;
import com.google.android.gms.tagmanager.ag;
import com.google.android.gms.tagmanager.ah;
import com.google.android.gms.tagmanager.aj;
import com.google.android.gms.tagmanager.al;
import com.google.android.gms.tagmanager.am;
import com.google.android.gms.tagmanager.an;
import com.google.android.gms.tagmanager.ao;
import com.google.android.gms.tagmanager.ax;
import com.google.android.gms.tagmanager.az;
import com.google.android.gms.tagmanager.b;
import com.google.android.gms.tagmanager.bc;
import com.google.android.gms.tagmanager.bd;
import com.google.android.gms.tagmanager.be;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.bj;
import com.google.android.gms.tagmanager.bk;
import com.google.android.gms.tagmanager.bl;
import com.google.android.gms.tagmanager.bx;
import com.google.android.gms.tagmanager.bz;
import com.google.android.gms.tagmanager.c;
import com.google.android.gms.tagmanager.ca;
import com.google.android.gms.tagmanager.cc;
import com.google.android.gms.tagmanager.cf;
import com.google.android.gms.tagmanager.ch;
import com.google.android.gms.tagmanager.ci;
import com.google.android.gms.tagmanager.cj;
import com.google.android.gms.tagmanager.ck;
import com.google.android.gms.tagmanager.cm;
import com.google.android.gms.tagmanager.cn;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.cs;
import com.google.android.gms.tagmanager.cu;
import com.google.android.gms.tagmanager.cv;
import com.google.android.gms.tagmanager.dc;
import com.google.android.gms.tagmanager.de;
import com.google.android.gms.tagmanager.di;
import com.google.android.gms.tagmanager.dj;
import com.google.android.gms.tagmanager.dk;
import com.google.android.gms.tagmanager.dl;
import com.google.android.gms.tagmanager.dm;
import com.google.android.gms.tagmanager.e;
import com.google.android.gms.tagmanager.f;
import com.google.android.gms.tagmanager.g;
import com.google.android.gms.tagmanager.h;
import com.google.android.gms.tagmanager.i;
import com.google.android.gms.tagmanager.k;
import com.google.android.gms.tagmanager.l;
import com.google.android.gms.tagmanager.m;
import com.google.android.gms.tagmanager.p;
import com.google.android.gms.tagmanager.q;
import com.google.android.gms.tagmanager.s;
import com.google.android.gms.tagmanager.u;
import com.google.android.gms.tagmanager.w;
import com.google.android.gms.tagmanager.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class ct {
   private static final bz atb = new bz(di.rb(), true);
   private final DataLayer aqn;
   private final cr.c atc;
   private final ag atd;
   private final Map ate;
   private final Map atf;
   private final Map atg;
   private final k ath;
   private final k ati;
   private final Set atj;
   private final Map atk;
   private volatile String atl;
   private int atm;

   public ct(Context var1, cr.c var2, DataLayer var3, s.a var4, s.a var5, ag var6) {
      if(var2 == null) {
         throw new NullPointerException("resource cannot be null");
      } else {
         this.atc = var2;
         this.atj = new HashSet(var2.qp());
         this.aqn = var3;
         this.atd = var6;
         l.a var9 = new l.a() {
            public int a(cr.a var1, bz var2) {
               return ((com.google.android.gms.internal.d)var2.getObject()).rY();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.a((cr.a)var1, (bz)var2);
            }
         };
         this.ath = (new l()).a(1048576, var9);
         var9 = new l.a() {
            public int a(String var1, ct.b var2) {
               return var1.length() + var2.getSize();
            }

            // $FF: synthetic method
            public int sizeOf(Object var1, Object var2) {
               return this.a((String)var1, (ct.b)var2);
            }
         };
         this.ati = (new l()).a(1048576, var9);
         this.ate = new HashMap();
         this.b(new i(var1));
         this.b(new s(var5));
         this.b(new w(var3));
         this.b(new dj(var1, var3));
         this.atf = new HashMap();
         this.c(new q());
         this.c(new ad());
         this.c(new ae());
         this.c(new al());
         this.c(new am());
         this.c(new bd());
         this.c(new be());
         this.c(new ci());
         this.c(new dc());
         this.atg = new HashMap();
         this.a(new b(var1));
         this.a(new c(var1));
         this.a(new e(var1));
         this.a(new f(var1));
         this.a(new g(var1));
         this.a(new h(var1));
         this.a(new m());
         this.a(new p(this.atc.getVersion()));
         this.a(new s(var4));
         this.a(new u(var3));
         this.a(new z(var1));
         this.a(new aa());
         this.a(new ac());
         this.a(new ah(this));
         this.a(new an());
         this.a(new ao());
         this.a(new ax(var1));
         this.a(new az());
         this.a(new bc());
         this.a(new bj());
         this.a(new bl(var1));
         this.a(new ca());
         this.a(new cc());
         this.a(new cf());
         this.a(new ch());
         this.a(new cj(var1));
         this.a(new cu());
         this.a(new cv());
         this.a(new de());
         this.a(new dk());
         this.atk = new HashMap();
         Iterator var11 = this.atj.iterator();

         while(var11.hasNext()) {
            cr.e var14 = (cr.e)var11.next();
            if(var6.pH()) {
               a(var14.qx(), var14.qy(), "add macro");
               a(var14.qC(), var14.qz(), "remove macro");
               a(var14.qv(), var14.qA(), "add tag");
               a(var14.qw(), var14.qB(), "remove tag");
            }

            int var7;
            String var8;
            String var10;
            ct.c var12;
            cr.a var17;
            for(var7 = 0; var7 < var14.qx().size(); ++var7) {
               var17 = (cr.a)var14.qx().get(var7);
               var10 = "Unknown";
               var8 = var10;
               if(var6.pH()) {
                  var8 = var10;
                  if(var7 < var14.qy().size()) {
                     var8 = (String)var14.qy().get(var7);
                  }
               }

               var12 = e(this.atk, h(var17));
               var12.b(var14);
               var12.a(var14, var17);
               var12.a(var14, var8);
            }

            for(var7 = 0; var7 < var14.qC().size(); ++var7) {
               var17 = (cr.a)var14.qC().get(var7);
               var10 = "Unknown";
               var8 = var10;
               if(var6.pH()) {
                  var8 = var10;
                  if(var7 < var14.qz().size()) {
                     var8 = (String)var14.qz().get(var7);
                  }
               }

               var12 = e(this.atk, h(var17));
               var12.b(var14);
               var12.b(var14, var17);
               var12.b(var14, var8);
            }
         }

         Iterator var13 = this.atc.qq().entrySet().iterator();

         while(var13.hasNext()) {
            Entry var15 = (Entry)var13.next();
            var11 = ((List)var15.getValue()).iterator();

            while(var11.hasNext()) {
               cr.a var16 = (cr.a)var11.next();
               if(!di.n((com.google.android.gms.internal.d)var16.ql().get(com.google.android.gms.internal.b.dG.toString())).booleanValue()) {
                  e(this.atk, (String)var15.getKey()).i(var16);
               }
            }
         }

      }
   }

   private bz a(com.google.android.gms.internal.d var1, Set var2, dl var3) {
      if(!var1.gF) {
         return new bz(var1, true);
      } else {
         int var4;
         com.google.android.gms.internal.d var5;
         bz var6;
         switch(var1.type) {
         case 2:
            var5 = cr.g(var1);
            var5.gw = new com.google.android.gms.internal.d[var1.gw.length];

            for(var4 = 0; var4 < var1.gw.length; ++var4) {
               var6 = this.a(var1.gw[var4], var2, var3.fK(var4));
               if(var6 == atb) {
                  return atb;
               }

               var5.gw[var4] = (com.google.android.gms.internal.d)var6.getObject();
            }

            return new bz(var5, false);
         case 3:
            var5 = cr.g(var1);
            if(var1.gx.length != var1.gy.length) {
               bh.T("Invalid serving value: " + var1.toString());
               return atb;
            } else {
               var5.gx = new com.google.android.gms.internal.d[var1.gx.length];
               var5.gy = new com.google.android.gms.internal.d[var1.gx.length];

               for(var4 = 0; var4 < var1.gx.length; ++var4) {
                  var6 = this.a(var1.gx[var4], var2, var3.fL(var4));
                  bz var7 = this.a(var1.gy[var4], var2, var3.fM(var4));
                  if(var6 == atb || var7 == atb) {
                     return atb;
                  }

                  var5.gx[var4] = (com.google.android.gms.internal.d)var6.getObject();
                  var5.gy[var4] = (com.google.android.gms.internal.d)var7.getObject();
               }

               return new bz(var5, false);
            }
         case 4:
            if(var2.contains(var1.gz)) {
               bh.T("Macro cycle detected.  Current macro reference: " + var1.gz + "." + "  Previous macro references: " + var2.toString() + ".");
               return atb;
            }

            var2.add(var1.gz);
            bz var8 = dm.a(this.a(var1.gz, var2, var3.pW()), var1.gE);
            var2.remove(var1.gz);
            return var8;
         case 5:
         case 6:
         default:
            bh.T("Unknown type: " + var1.type);
            return atb;
         case 7:
            var5 = cr.g(var1);
            var5.gD = new com.google.android.gms.internal.d[var1.gD.length];

            for(var4 = 0; var4 < var1.gD.length; ++var4) {
               var6 = this.a(var1.gD[var4], var2, var3.fN(var4));
               if(var6 == atb) {
                  return atb;
               }

               var5.gD[var4] = (com.google.android.gms.internal.d)var6.getObject();
            }

            return new bz(var5, false);
         }
      }
   }

   private bz a(String var1, Set var2, bk var3) {
      ++this.atm;
      ct.b var5 = (ct.b)this.ati.get(var1);
      if(var5 != null && !this.atd.pH()) {
         this.a(var5.qm(), var2);
         --this.atm;
         return var5.qG();
      } else {
         ct.c var8 = (ct.c)this.atk.get(var1);
         if(var8 == null) {
            bh.T(this.qF() + "Invalid macro: " + var1);
            --this.atm;
            return atb;
         } else {
            bz var6 = this.a(var1, var8.qH(), var8.qI(), var8.qJ(), var8.qL(), var8.qK(), var2, var3.py());
            cr.a var9;
            if(((Set)var6.getObject()).isEmpty()) {
               var9 = var8.qM();
            } else {
               if(((Set)var6.getObject()).size() > 1) {
                  bh.W(this.qF() + "Multiple macros active for macroName " + var1);
               }

               var9 = (cr.a)((Set)var6.getObject()).iterator().next();
            }

            if(var9 == null) {
               --this.atm;
               return atb;
            } else {
               bz var7 = this.a(this.atg, var9, var2, var3.pN());
               boolean var4;
               if(var6.pX() && var7.pX()) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               if(var7 == atb) {
                  var7 = atb;
               } else {
                  var7 = new bz(var7.getObject(), var4);
               }

               com.google.android.gms.internal.d var10 = var9.qm();
               if(var7.pX()) {
                  this.ati.e(var1, new ct.b(var7, var10));
               }

               this.a(var10, var2);
               --this.atm;
               return var7;
            }
         }
      }
   }

   private bz a(Map var1, cr.a var2, Set var3, ck var4) {
      boolean var6 = true;
      com.google.android.gms.internal.d var7 = (com.google.android.gms.internal.d)var2.ql().get(com.google.android.gms.internal.b.cU.toString());
      bz var12;
      if(var7 == null) {
         bh.T("No function id in properties");
         var12 = atb;
      } else {
         String var14 = var7.gA;
         aj var8 = (aj)var1.get(var14);
         if(var8 == null) {
            bh.T(var14 + " has no backing implementation.");
            return atb;
         }

         var12 = (bz)this.ath.get(var2);
         if(var12 == null || this.atd.pH()) {
            HashMap var13 = new HashMap();
            Iterator var9 = var2.ql().entrySet().iterator();

            boolean var5;
            Entry var10;
            bz var15;
            for(var5 = true; var9.hasNext(); var13.put(var10.getKey(), var15.getObject())) {
               var10 = (Entry)var9.next();
               cm var11 = var4.cJ((String)var10.getKey());
               var15 = this.a((com.google.android.gms.internal.d)var10.getValue(), var3, var11.e((com.google.android.gms.internal.d)var10.getValue()));
               if(var15 == atb) {
                  return atb;
               }

               if(var15.pX()) {
                  var2.a((String)var10.getKey(), (com.google.android.gms.internal.d)var15.getObject());
               } else {
                  var5 = false;
               }
            }

            if(!var8.a(var13.keySet())) {
               bh.T("Incorrect keys for function " + var14 + " required " + var8.pJ() + " had " + var13.keySet());
               return atb;
            }

            if(!var5 || !var8.pe()) {
               var6 = false;
            }

            var12 = new bz(var8.B(var13), var6);
            if(var6) {
               this.ath.e(var2, var12);
            }

            var4.d((com.google.android.gms.internal.d)var12.getObject());
            return var12;
         }
      }

      return var12;
   }

   private bz a(Set var1, Set var2, ct.a var3, cs var4) {
      HashSet var6 = new HashSet();
      HashSet var7 = new HashSet();
      Iterator var11 = var1.iterator();
      boolean var5 = true;

      while(var11.hasNext()) {
         cr.e var8 = (cr.e)var11.next();
         cn var9 = var4.pV();
         bz var10 = this.a(var8, var2, var9);
         if(((Boolean)var10.getObject()).booleanValue()) {
            var3.a(var8, var6, var7, var9);
         }

         if(var5 && var10.pX()) {
            var5 = true;
         } else {
            var5 = false;
         }
      }

      var6.removeAll(var7);
      var4.b(var6);
      return new bz(var6, var5);
   }

   private void a(com.google.android.gms.internal.d var1, Set var2) {
      if(var1 != null) {
         bz var3 = this.a((com.google.android.gms.internal.d)var1, (Set)var2, (dl)(new bx()));
         if(var3 != atb) {
            Object var4 = di.o((com.google.android.gms.internal.d)var3.getObject());
            if(var4 instanceof Map) {
               Map var6 = (Map)var4;
               this.aqn.push(var6);
               return;
            }

            if(!(var4 instanceof List)) {
               bh.W("pushAfterEvaluate: value not a Map or List");
               return;
            }

            Iterator var5 = ((List)var4).iterator();

            while(var5.hasNext()) {
               Object var7 = var5.next();
               if(var7 instanceof Map) {
                  Map var8 = (Map)var7;
                  this.aqn.push(var8);
               } else {
                  bh.W("pushAfterEvaluate: value not a Map");
               }
            }
         }
      }

   }

   private static void a(List var0, List var1, String var2) {
      if(var0.size() != var1.size()) {
         bh.U("Invalid resource: imbalance of rule names of functions for " + var2 + " operation. Using default rule name instead");
      }

   }

   private static void a(Map var0, aj var1) {
      if(var0.containsKey(var1.pI())) {
         throw new IllegalArgumentException("Duplicate function type name: " + var1.pI());
      } else {
         var0.put(var1.pI(), var1);
      }
   }

   private static ct.c e(Map var0, String var1) {
      ct.c var3 = (ct.c)var0.get(var1);
      ct.c var2 = var3;
      if(var3 == null) {
         var2 = new ct.c();
         var0.put(var1, var2);
      }

      return var2;
   }

   private static String h(cr.a var0) {
      return di.j((com.google.android.gms.internal.d)var0.ql().get(com.google.android.gms.internal.b.df.toString()));
   }

   private String qF() {
      if(this.atm <= 1) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append(Integer.toString(this.atm));

         for(int var1 = 2; var1 < this.atm; ++var1) {
            var2.append(' ');
         }

         var2.append(": ");
         return var2.toString();
      }
   }

   bz a(cr.a var1, Set var2, ck var3) {
      bz var4 = this.a(this.atf, var1, var2, var3);
      Boolean var5 = di.n((com.google.android.gms.internal.d)var4.getObject());
      var3.d(di.u(var5));
      return new bz(var5, var4.pX());
   }

   bz a(cr.e var1, Set var2, cn var3) {
      Iterator var5 = var1.qu().iterator();
      boolean var4 = true;

      while(var5.hasNext()) {
         bz var6 = this.a((cr.a)var5.next(), var2, var3.pP());
         if(((Boolean)var6.getObject()).booleanValue()) {
            var3.f(di.u(Boolean.valueOf(false)));
            return new bz(Boolean.valueOf(false), var6.pX());
         }

         if(var4 && var6.pX()) {
            var4 = true;
         } else {
            var4 = false;
         }
      }

      Iterator var7 = var1.qt().iterator();

      while(var7.hasNext()) {
         bz var8 = this.a((cr.a)var7.next(), var2, var3.pQ());
         if(!((Boolean)var8.getObject()).booleanValue()) {
            var3.f(di.u(Boolean.valueOf(false)));
            return new bz(Boolean.valueOf(false), var8.pX());
         }

         if(var4 && var8.pX()) {
            var4 = true;
         } else {
            var4 = false;
         }
      }

      var3.f(di.u(Boolean.valueOf(true)));
      return new bz(Boolean.valueOf(true), var4);
   }

   bz a(String var1, Set var2, final Map var3, final Map var4, final Map var5, final Map var6, Set var7, cs var8) {
      return this.a(var2, var7, new ct.a() {
         public void a(cr.e var1, Set var2, Set var3x, cn var4x) {
            List var5x = (List)var3.get(var1);
            List var6x = (List)var4.get(var1);
            if(var5x != null) {
               var2.addAll(var5x);
               var4x.pR().c(var5x, var6x);
            }

            List var8 = (List)var5.get(var1);
            List var7 = (List)var6.get(var1);
            if(var8 != null) {
               var3x.addAll(var8);
               var4x.pS().c(var8, var7);
            }

         }
      }, var8);
   }

   bz a(Set var1, cs var2) {
      return this.a((Set)var1, (Set)(new HashSet()), (ct.a)(new ct.a() {
         public void a(cr.e var1, Set var2, Set var3, cn var4) {
            var2.addAll(var1.qv());
            var3.addAll(var1.qw());
            var4.pT().c(var1.qv(), var1.qA());
            var4.pU().c(var1.qw(), var1.qB());
         }
      }), (cs)var2);
   }

   void a(aj var1) {
      a(this.atg, var1);
   }

   void b(aj var1) {
      a(this.ate, var1);
   }

   void c(aj var1) {
      a(this.atf, var1);
   }

   public bz cT(String var1) {
      this.atm = 0;
      af var2 = this.atd.cC(var1);
      bz var3 = this.a((String)var1, (Set)(new HashSet()), (bk)var2.pE());
      var2.pG();
      return var3;
   }

   void cU(String var1) {
      synchronized(this){}

      try {
         this.atl = var1;
      } finally {
         ;
      }

   }

   public void cr(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void l(List param1) {
      // $FF: Couldn't be decompiled
   }

   String qE() {
      synchronized(this){}

      String var1;
      try {
         var1 = this.atl;
      } finally {
         ;
      }

      return var1;
   }

   interface a {
      void a(cr.e var1, Set var2, Set var3, cn var4);
   }

   private static class b {
      private com.google.android.gms.internal.d asN;
      private bz ats;

      public b(bz var1, com.google.android.gms.internal.d var2) {
         this.ats = var1;
         this.asN = var2;
      }

      public int getSize() {
         int var2 = ((com.google.android.gms.internal.d)this.ats.getObject()).rY();
         int var1;
         if(this.asN == null) {
            var1 = 0;
         } else {
            var1 = this.asN.rY();
         }

         return var1 + var2;
      }

      public bz qG() {
         return this.ats;
      }

      public com.google.android.gms.internal.d qm() {
         return this.asN;
      }
   }

   private static class c {
      private final Set atj = new HashSet();
      private final Map att = new HashMap();
      private final Map atu = new HashMap();
      private final Map atv = new HashMap();
      private final Map atw = new HashMap();
      private cr.a atx;

      public void a(cr.e var1, cr.a var2) {
         List var4 = (List)this.att.get(var1);
         Object var3 = var4;
         if(var4 == null) {
            var3 = new ArrayList();
            this.att.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void a(cr.e var1, String var2) {
         List var4 = (List)this.atv.get(var1);
         Object var3 = var4;
         if(var4 == null) {
            var3 = new ArrayList();
            this.atv.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void b(cr.e var1) {
         this.atj.add(var1);
      }

      public void b(cr.e var1, cr.a var2) {
         List var4 = (List)this.atu.get(var1);
         Object var3 = var4;
         if(var4 == null) {
            var3 = new ArrayList();
            this.atu.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void b(cr.e var1, String var2) {
         List var4 = (List)this.atw.get(var1);
         Object var3 = var4;
         if(var4 == null) {
            var3 = new ArrayList();
            this.atw.put(var1, var3);
         }

         ((List)var3).add(var2);
      }

      public void i(cr.a var1) {
         this.atx = var1;
      }

      public Set qH() {
         return this.atj;
      }

      public Map qI() {
         return this.att;
      }

      public Map qJ() {
         return this.atv;
      }

      public Map qK() {
         return this.atw;
      }

      public Map qL() {
         return this.atu;
      }

      public cr.a qM() {
         return this.atx;
      }
   }
}
