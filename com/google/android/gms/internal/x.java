package com.google.android.gms.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.g;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.j;
import com.google.android.gms.internal.u;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@ey
class x implements g, Runnable {
   private u.b lB;
   private final List mp = new Vector();
   private final AtomicReference mq = new AtomicReference();
   CountDownLatch mr = new CountDownLatch(1);

   public x(u.b var1) {
      this.lB = var1;
      if(gq.dB()) {
         gh.a(this);
      } else {
         this.run();
      }
   }

   private void aB() {
      if(!this.mp.isEmpty()) {
         Iterator var1 = this.mp.iterator();

         while(var1.hasNext()) {
            Object[] var2 = (Object[])var1.next();
            if(var2.length == 1) {
               ((g)this.mq.get()).a((MotionEvent)var2[0]);
            } else if(var2.length == 3) {
               ((g)this.mq.get()).a(((Integer)var2[0]).intValue(), ((Integer)var2[1]).intValue(), ((Integer)var2[2]).intValue());
            }
         }
      }

   }

   private Context i(Context var1) {
      if(this.aC()) {
         Context var2 = var1.getApplicationContext();
         if(var2 != null) {
            return var2;
         }
      }

      return var1;
   }

   public String a(Context var1) {
      if(this.aA()) {
         g var2 = (g)this.mq.get();
         if(var2 != null) {
            this.aB();
            return var2.a(this.i(var1));
         }
      }

      return "";
   }

   public String a(Context var1, String var2) {
      if(this.aA()) {
         g var3 = (g)this.mq.get();
         if(var3 != null) {
            this.aB();
            return var3.a(this.i(var1), var2);
         }
      }

      return "";
   }

   public void a(int var1, int var2, int var3) {
      g var4 = (g)this.mq.get();
      if(var4 != null) {
         this.aB();
         var4.a(var1, var2, var3);
      } else {
         this.mp.add(new Object[]{Integer.valueOf(var1), Integer.valueOf(var2), Integer.valueOf(var3)});
      }
   }

   public void a(MotionEvent var1) {
      g var2 = (g)this.mq.get();
      if(var2 != null) {
         this.aB();
         var2.a(var1);
      } else {
         this.mp.add(new Object[]{var1});
      }
   }

   protected void a(g var1) {
      this.mq.set(var1);
   }

   protected boolean aA() {
      try {
         this.mr.await();
         return true;
      } catch (InterruptedException var2) {
         gr.d("Interrupted during GADSignals creation.", var2);
         return false;
      }
   }

   protected boolean aC() {
      return ga.bN().getBoolean("gads:spam_app_context:enabled", false);
   }

   public void run() {
      try {
         this.a((g)j.a(this.lB.lO.wS, this.i(this.lB.lM)));
      } finally {
         this.mr.countDown();
         this.lB = null;
      }

   }
}
