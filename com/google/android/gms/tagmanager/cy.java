package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.tagmanager.ar;
import com.google.android.gms.tagmanager.at;
import com.google.android.gms.tagmanager.au;
import com.google.android.gms.tagmanager.bh;
import com.google.android.gms.tagmanager.bo;
import com.google.android.gms.tagmanager.cb;
import com.google.android.gms.tagmanager.cx;

class cy extends cx {
   private static cy atJ;
   private static final Object yT = new Object();
   private at atA;
   private volatile ar atB;
   private int atC = 1800000;
   private boolean atD = true;
   private boolean atE = false;
   private boolean atF = true;
   private au atG = new au() {
      public void B(boolean var1) {
         cy.this.a(var1, cy.this.connected);
      }
   };
   private bo atH;
   private boolean atI = false;
   private Context atz;
   private boolean connected = true;
   private Handler handler;

   private void ev() {
      this.atH = new bo(this);
      this.atH.z(this.atz);
   }

   private void ew() {
      this.handler = new Handler(this.atz.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && cy.yT.equals(var1.obj)) {
               cy.this.dispatch();
               if(cy.this.atC > 0 && !cy.this.atI) {
                  cy.this.handler.sendMessageDelayed(cy.this.handler.obtainMessage(1, cy.yT), (long)cy.this.atC);
               }
            }

            return true;
         }
      });
      if(this.atC > 0) {
         this.handler.sendMessageDelayed(this.handler.obtainMessage(1, yT), (long)this.atC);
      }

   }

   public static cy qN() {
      if(atJ == null) {
         atJ = new cy();
      }

      return atJ;
   }

   void C(boolean var1) {
      synchronized(this){}

      try {
         this.a(this.atI, var1);
      } finally {
         ;
      }

   }

   void a(Context param1, ar param2) {
      // $FF: Couldn't be decompiled
   }

   void a(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void dispatch() {
      synchronized(this){}

      try {
         if(!this.atE) {
            bh.V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.atD = true;
         } else {
            this.atB.b(new Runnable() {
               public void run() {
                  cy.this.atA.dispatch();
               }
            });
         }
      } finally {
         ;
      }

   }

   void ey() {
      synchronized(this){}

      try {
         if(!this.atI && this.connected && this.atC > 0) {
            this.handler.removeMessages(1, yT);
            this.handler.sendMessage(this.handler.obtainMessage(1, yT));
         }
      } finally {
         ;
      }

   }

   at qO() {
      synchronized(this){}

      at var1;
      try {
         if(this.atA == null) {
            if(this.atz == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.atA = new cb(this.atG, this.atz);
         }

         if(this.handler == null) {
            this.ew();
         }

         this.atE = true;
         if(this.atD) {
            this.dispatch();
            this.atD = false;
         }

         if(this.atH == null && this.atF) {
            this.ev();
         }

         var1 = this.atA;
      } finally {
         ;
      }

      return var1;
   }
}
