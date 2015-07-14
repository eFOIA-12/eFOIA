package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gr;
import com.google.android.gms.internal.u;
import java.lang.ref.WeakReference;

@ey
public class ab {
   private final ab.a mu;
   private final Runnable mv;
   private av mw;
   private boolean mx;
   private boolean my;
   private long mz;

   public ab(u var1) {
      this(var1, new ab.a(gq.wR));
   }

   ab(final u var1, ab.a var2) {
      this.mx = false;
      this.my = false;
      this.mz = 0L;
      this.mu = var2;
      this.mv = new Runnable() {
         private final WeakReference mA = new WeakReference(var1);

         public void run() {
            ab.this.mx = false;
            u var1x = (u)this.mA.get();
            if(var1x != null) {
               var1x.b(ab.this.mw);
            }

         }
      };
   }

   public void a(av var1, long var2) {
      if(this.mx) {
         gr.W("An ad refresh is already scheduled.");
      } else {
         this.mw = var1;
         this.mx = true;
         this.mz = var2;
         if(!this.my) {
            gr.U("Scheduling ad refresh " + var2 + " milliseconds from now.");
            this.mu.postDelayed(this.mv, var2);
            return;
         }
      }

   }

   public boolean aD() {
      return this.mx;
   }

   public void c(av var1) {
      this.a(var1, 60000L);
   }

   public void cancel() {
      this.mx = false;
      this.mu.removeCallbacks(this.mv);
   }

   public void pause() {
      this.my = true;
      if(this.mx) {
         this.mu.removeCallbacks(this.mv);
      }

   }

   public void resume() {
      this.my = false;
      if(this.mx) {
         this.mx = false;
         this.a(this.mw, this.mz);
      }

   }

   public static class a {
      private final Handler mHandler;

      public a(Handler var1) {
         this.mHandler = var1;
      }

      public boolean postDelayed(Runnable var1, long var2) {
         return this.mHandler.postDelayed(var1, var2);
      }

      public void removeCallbacks(Runnable var1) {
         this.mHandler.removeCallbacks(var1);
      }
   }
}
