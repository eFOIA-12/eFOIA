package com.google.android.gms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.a;
import com.google.android.gms.analytics.ac;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.ak;
import com.google.android.gms.analytics.an;
import com.google.android.gms.analytics.f;
import com.google.android.gms.analytics.g;
import com.google.android.gms.analytics.k;
import com.google.android.gms.analytics.q;
import com.google.android.gms.analytics.y;
import com.google.android.gms.internal.ha;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class x extends Thread implements f {
   private static x zM;
   private volatile boolean mClosed = false;
   private final Context mContext;
   private final LinkedBlockingQueue zJ = new LinkedBlockingQueue();
   private volatile boolean zK = false;
   private volatile String zL;
   private volatile ak zN;
   private final Lock zO;
   private final List zP = new ArrayList();

   private x(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.zP.add(new ha("appendVersion", "&_v".substring(1), "ma4.0.4"));
      this.zO = new ReentrantLock();
      this.start();
   }

   static x A(Context var0) {
      if(zM == null) {
         zM = new x(var0);
      }

      return zM;
   }

   static String B(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static int ah(String var0) {
      int var3 = 1;
      if(!TextUtils.isEmpty(var0)) {
         int var2 = var0.length();
         int var1 = 0;
         --var2;

         while(true) {
            var3 = var1;
            if(var2 < 0) {
               break;
            }

            char var5 = var0.charAt(var2);
            var3 = (var1 << 6 & 268435455) + var5 + (var5 << 14);
            int var4 = 266338304 & var3;
            var1 = var3;
            if(var4 != 0) {
               var1 = var3 ^ var4 >> 21;
            }

            --var2;
         }
      }

      return var3;
   }

   private void b(Runnable var1) {
      this.zJ.add(var1);
   }

   private String g(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   public void dQ() {
      this.b((Runnable)(new x.a(null)));
   }

   public void dW() {
      this.b((Runnable)(new x.c(null)));
   }

   public LinkedBlockingQueue dX() {
      return this.zJ;
   }

   public void dY() {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      this.b((Runnable)(new x.b(null)));
   }

   public Thread getThread() {
      return this;
   }

   protected void init() {
      // $FF: Couldn't be decompiled
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }

   public void u(Map var1) {
      this.b((Runnable)(new x.d(var1)));
   }

   private class a implements Runnable {
      private a() {
      }

      // $FF: synthetic method
      a(Object var2) {
         this();
      }

      public void run() {
         x.this.zN.dQ();
      }
   }

   private class b implements Runnable {
      private b() {
      }

      // $FF: synthetic method
      b(Object var2) {
         this();
      }

      public void run() {
         x.this.zN.dispatch();
      }
   }

   private class c implements Runnable {
      private c() {
      }

      // $FF: synthetic method
      c(Object var2) {
         this();
      }

      public void run() {
         x.this.zN.dW();
      }
   }

   private class d implements Runnable {
      private final Map zR;

      d(Map var2) {
         this.zR = new HashMap(var2);
         String var7 = (String)var2.get("&ht");
         String var6 = var7;
         if(var7 != null) {
            label17: {
               try {
                  Long.valueOf(var7);
               } catch (NumberFormatException var5) {
                  var6 = null;
                  break label17;
               }

               var6 = var7;
            }
         }

         if(var6 == null) {
            long var3 = System.currentTimeMillis();
            this.zR.put("&ht", Long.toString(var3));
         }

      }

      private String v(Map var1) {
         return var1.containsKey("useSecure")?(an.f((String)var1.get("useSecure"), true)?"https:":"http:"):"https:";
      }

      private void w(Map var1) {
         q var2 = a.w(x.this.mContext);
         an.a(var1, "&adid", var2);
         an.a(var1, "&ate", var2);
      }

      private void x(Map var1) {
         g var2 = g.dZ();
         an.a(var1, "&an", (q)var2);
         an.a(var1, "&av", (q)var2);
         an.a(var1, "&aid", (q)var2);
         an.a(var1, "&aiid", (q)var2);
         var1.put("&v", "1");
      }

      private boolean y(Map var1) {
         if(var1.get("&sf") == null) {
            return false;
         } else {
            double var2 = an.a((String)var1.get("&sf"), 100.0D);
            if(var2 >= 100.0D) {
               return false;
            } else if((double)(x.ah((String)var1.get("&cid")) % 10000) >= var2 * 100.0D) {
               String var4;
               if(var1.get("&t") == null) {
                  var4 = "unknown";
               } else {
                  var4 = (String)var1.get("&t");
               }

               ae.V(String.format("%s hit sampled out", new Object[]{var4}));
               return true;
            } else {
               return false;
            }
         }
      }

      public void run() {
         this.w(this.zR);
         if(TextUtils.isEmpty((CharSequence)this.zR.get("&cid"))) {
            this.zR.put("&cid", k.el().getValue("&cid"));
         }

         if(!GoogleAnalytics.getInstance(x.this.mContext).getAppOptOut() && !this.y(this.zR)) {
            if(!TextUtils.isEmpty(x.this.zL)) {
               y.eK().D(true);
               this.zR.putAll((new HitBuilders.HitBuilder()).setCampaignParamsFromUrl(x.this.zL).build());
               y.eK().D(false);
               x.this.zL = null;
            }

            this.x(this.zR);
            Map var1 = ac.z(this.zR);
            x.this.zN.b(var1, Long.valueOf((String)this.zR.get("&ht")).longValue(), this.v(this.zR), x.this.zP);
         }
      }
   }
}
