package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.tagmanager.ar;
import com.google.android.gms.tagmanager.at;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.cy;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class as extends Thread implements ar {
   private static as ary;
   private final LinkedBlockingQueue arx = new LinkedBlockingQueue();
   private volatile at arz;
   private volatile boolean mClosed = false;
   private final Context mContext;
   private volatile boolean zK = false;

   private as(Context var1) {
      super("GAThread");
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      this.start();
   }

   static as Z(Context var0) {
      if(ary == null) {
         ary = new as(var0);
      }

      return ary;
   }

   private String g(Throwable var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      PrintStream var3 = new PrintStream(var2);
      var1.printStackTrace(var3);
      var3.flush();
      return new String(var2.toByteArray());
   }

   public void b(Runnable var1) {
      this.arx.add(var1);
   }

   void b(final String var1, final long var2) {
      this.b(new Runnable() {
         public void run() {
            if(as.this.arz == null) {
               cy var1x = cy.qN();
               var1x.a(as.this.mContext, as.this);
               as.this.arz = var1x.qO();
            }

            as.this.arz.f(var2, var1);
         }
      });
   }

   public void cE(String var1) {
      this.b(var1, System.currentTimeMillis());
   }

   public void run() {
      while(!this.mClosed) {
         try {
            try {
               Runnable var1 = (Runnable)this.arx.take();
               if(!this.zK) {
                  var1.run();
               }
            } catch (InterruptedException var2) {
               bh.U(var2.toString());
            }
         } catch (Throwable var3) {
            bh.T("Error on Google TagManager Thread: " + this.g(var3));
            bh.T("Google TagManager is shutting down.");
            this.zK = true;
         }
      }

   }
}
