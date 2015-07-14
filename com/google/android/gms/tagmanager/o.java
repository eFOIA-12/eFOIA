package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import com.google.android.gms.internal.pu;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.tagmanager.bf;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.ce;
import com.google.android.gms.tagmanager.cg;
import com.google.android.gms.tagmanager.cp;
import com.google.android.gms.tagmanager.cq;
import com.google.android.gms.tagmanager.cr;
import com.google.android.gms.tagmanager.n;
import com.google.android.gms.tagmanager.r;

class o extends BaseImplementation.AbstractPendingResult {
   private final Looper JF;
   private final o.d aqB;
   private final cg aqC;
   private final int aqD;
   private o.f aqE;
   private volatile n aqF;
   private volatile boolean aqG;
   private com.google.android.gms.internal.c aqH;
   private String aqI;
   private o.e aqJ;
   private o.a aqK;
   private final String aqm;
   private long aqr;
   private final TagManager aqy;
   private final Context mContext;
   private final ld wb;

   o(Context var1, TagManager var2, Looper var3, String var4, int var5, o.f var6, o.e var7, ld var8, cg var9) {
      Looper var10;
      if(var3 == null) {
         var10 = Looper.getMainLooper();
      } else {
         var10 = var3;
      }

      super(var10);
      this.mContext = var1;
      this.aqy = var2;
      Looper var11 = var3;
      if(var3 == null) {
         var11 = Looper.getMainLooper();
      }

      this.JF = var11;
      this.aqm = var4;
      this.aqD = var5;
      this.aqE = var6;
      this.aqJ = var7;
      this.aqB = new o.d(null);
      this.aqH = new com.google.android.gms.internal.c();
      this.wb = var8;
      this.aqC = var9;
      if(this.pr()) {
         this.ct(ce.qa().qc());
      }

   }

   public o(Context var1, TagManager var2, Looper var3, String var4, int var5, r var6) {
      this(var1, var2, var3, var4, var5, new cq(var1, var4), new cp(var1, var4, var6), lf.if(), new bf(30, 900000L, 5000L, "refreshing", lf.if()));
   }

   private void V(final boolean var1) {
      this.aqE.a(new o.b(null));
      this.aqJ.a(new o.c(null));
      cr.c var2 = this.aqE.fH(this.aqD);
      if(var2 != null) {
         this.aqF = new n(this.aqy, this.JF, new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0L, var2), this.aqB);
      }

      this.aqK = new o.a() {
         public boolean b(Container var1x) {
            if(var1) {
               if(var1x.getLastRefreshTime() + 43200000L < o.this.wb.currentTimeMillis()) {
                  return false;
               }
            } else if(var1x.isDefault()) {
               return false;
            }

            return true;
         }
      };
      if(this.pr()) {
         this.aqJ.e(0L, "");
      } else {
         this.aqE.pt();
      }
   }

   private void a(com.google.android.gms.internal.c var1) {
      synchronized(this){}

      try {
         if(this.aqE != null) {
            pu.a var2 = new pu.a();
            var2.auB = this.aqr;
            var2.gs = new com.google.android.gms.internal.c();
            var2.auC = var1;
            this.aqE.b(var2);
         }
      } finally {
         ;
      }

   }

   private void a(com.google.android.gms.internal.c param1, long param2, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(o var0, com.google.android.gms.internal.c var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(o var0, com.google.android.gms.internal.c var1, long var2, boolean var4) {
      var0.a(var1, var2, var4);
   }

   // $FF: synthetic method
   static com.google.android.gms.internal.c c(o var0) {
      return var0.aqH;
   }

   // $FF: synthetic method
   static long d(o var0) {
      return var0.aqr;
   }

   // $FF: synthetic method
   static boolean e(o var0) {
      return var0.pr();
   }

   private boolean pr() {
      ce var1 = ce.qa();
      return (var1.qb() == ce.a.asr || var1.qb() == ce.a.ass) && this.aqm.equals(var1.getContainerId());
   }

   private void w(long var1) {
      synchronized(this){}

      try {
         if(this.aqJ == null) {
            bh.W("Refresh requested, but no network load scheduler.");
         } else {
            this.aqJ.e(var1, this.aqH.gt);
         }
      } finally {
         ;
      }

   }

   protected ContainerHolder aD(Status var1) {
      if(this.aqF != null) {
         return this.aqF;
      } else {
         if(var1 == Status.Kz) {
            bh.T("timer expired: setting result to failure");
         }

         return new n(var1);
      }
   }

   // $FF: synthetic method
   protected Result c(Status var1) {
      return this.aD(var1);
   }

   void ct(String var1) {
      synchronized(this){}

      try {
         this.aqI = var1;
         if(this.aqJ != null) {
            this.aqJ.cw(var1);
         }
      } finally {
         ;
      }

   }

   String pl() {
      synchronized(this){}

      String var1;
      try {
         var1 = this.aqI;
      } finally {
         ;
      }

      return var1;
   }

   public void po() {
      cr.c var1 = this.aqE.fH(this.aqD);
      if(var1 != null) {
         Container var2 = new Container(this.mContext, this.aqy.getDataLayer(), this.aqm, 0L, var1);
         this.b(new n(this.aqy, this.JF, var2, new n.a() {
            public void ct(String var1) {
               o.this.ct(var1);
            }

            public String pl() {
               return o.this.pl();
            }

            public void pn() {
               bh.W("Refresh ignored: container loaded as default only.");
            }
         }));
      } else {
         bh.T("Default was requested, but no default container was found");
         this.b(this.aD(new Status(10, "Default was requested, but no default container was found", (PendingIntent)null)));
      }

      this.aqJ = null;
      this.aqE = null;
   }

   public void pp() {
      this.V(false);
   }

   public void pq() {
      this.V(true);
   }

   interface a {
      boolean b(Container var1);
   }

   private class b implements bg {
      private b() {
      }

      // $FF: synthetic method
      b(Object var2) {
         this();
      }

      public void a(pu.a var1) {
         com.google.android.gms.internal.c var2;
         if(var1.auC != null) {
            var2 = var1.auC;
         } else {
            com.google.android.gms.internal.c var3 = var1.gs;
            var2 = new com.google.android.gms.internal.c();
            var2.gs = var3;
            var2.gr = null;
            var2.gt = var3.version;
         }

         o.a(o.this, var2, var1.auB, true);
      }

      public void a(bg.a var1) {
         if(!o.this.aqG) {
            o.this.w(0L);
         }

      }

      // $FF: synthetic method
      public void l(Object var1) {
         this.a((pu.a)var1);
      }

      public void ps() {
      }
   }

   private class c implements bg {
      private c() {
      }

      // $FF: synthetic method
      c(Object var2) {
         this();
      }

      public void a(bg.a var1) {
         if(o.this.aqF != null) {
            o.this.b(o.this.aqF);
         } else {
            o.this.b(o.this.aD(Status.Kz));
         }

         o.this.w(3600000L);
      }

      public void b(com.google.android.gms.internal.c param1) {
         // $FF: Couldn't be decompiled
      }

      // $FF: synthetic method
      public void l(Object var1) {
         this.b((com.google.android.gms.internal.c)var1);
      }

      public void ps() {
      }
   }

   private class d implements n.a {
      private d() {
      }

      // $FF: synthetic method
      d(Object var2) {
         this();
      }

      public void ct(String var1) {
         o.this.ct(var1);
      }

      public String pl() {
         return o.this.pl();
      }

      public void pn() {
         if(o.this.aqC.fe()) {
            o.this.w(0L);
         }

      }
   }

   interface e extends Releasable {
      void a(bg var1);

      void cw(String var1);

      void e(long var1, String var3);
   }

   interface f extends Releasable {
      void a(bg var1);

      void b(pu.a var1);

      cr.c fH(int var1);

      void pt();
   }
}
