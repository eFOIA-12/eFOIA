package com.google.android.gms.internal;

import com.google.android.gms.internal.ey;
import com.google.android.gms.internal.gh;

@ey
public abstract class gf {
   private final Runnable mv = new Runnable() {
      public final void run() {
         gf.this.wu = Thread.currentThread();
         gf.this.cx();
      }
   };
   private volatile Thread wu;

   public final void cancel() {
      this.onStop();
      if(this.wu != null) {
         this.wu.interrupt();
      }

   }

   public abstract void cx();

   public abstract void onStop();

   public final void start() {
      gh.a(this.mv);
   }
}
