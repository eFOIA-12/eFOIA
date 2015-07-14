package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.bg;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.co;
import com.google.android.gms.tagmanager.o;
import com.google.android.gms.tagmanager.r;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class cp implements o.e {
   private String aqI;
   private final String aqm;
   private bg asC;
   private r asD;
   private final ScheduledExecutorService asF;
   private final cp.a asG;
   private ScheduledFuture asH;
   private boolean mClosed;
   private final Context mContext;

   public cp(Context var1, String var2, r var3) {
      this(var1, var2, var3, (cp.b)null, (cp.a)null);
   }

   cp(Context var1, String var2, r var3, cp.b var4, cp.a var5) {
      this.asD = var3;
      this.mContext = var1;
      this.aqm = var2;
      cp.b var6 = var4;
      if(var4 == null) {
         var6 = new cp.b() {
            public ScheduledExecutorService qh() {
               return Executors.newSingleThreadScheduledExecutor();
            }
         };
      }

      this.asF = var6.qh();
      if(var5 == null) {
         this.asG = new cp.a() {
            public co a(r var1) {
               return new co(cp.this.mContext, cp.this.aqm, var1);
            }
         };
      } else {
         this.asG = var5;
      }
   }

   private co cM(String var1) {
      co var2 = this.asG.a(this.asD);
      var2.a(this.asC);
      var2.cw(this.aqI);
      var2.cL(var1);
      return var2;
   }

   private void qg() {
      synchronized(this){}

      try {
         if(this.mClosed) {
            throw new IllegalStateException("called method after closed");
         }
      } finally {
         ;
      }

   }

   public void a(bg var1) {
      synchronized(this){}

      try {
         this.qg();
         this.asC = var1;
      } finally {
         ;
      }

   }

   public void cw(String var1) {
      synchronized(this){}

      try {
         this.qg();
         this.aqI = var1;
      } finally {
         ;
      }

   }

   public void e(long var1, String var3) {
      synchronized(this){}

      try {
         bh.V("loadAfterDelay: containerId=" + this.aqm + " delay=" + var1);
         this.qg();
         if(this.asC == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
         }

         if(this.asH != null) {
            this.asH.cancel(false);
         }

         this.asH = this.asF.schedule(this.cM(var3), var1, TimeUnit.MILLISECONDS);
      } finally {
         ;
      }

   }

   public void release() {
      synchronized(this){}

      try {
         this.qg();
         if(this.asH != null) {
            this.asH.cancel(false);
         }

         this.asF.shutdown();
         this.mClosed = true;
      } finally {
         ;
      }

   }

   interface a {
      co a(r var1);
   }

   interface b {
      ScheduledExecutorService qh();
   }
}
