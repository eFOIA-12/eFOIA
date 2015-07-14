package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.analytics.ae;
import com.google.android.gms.analytics.ag;
import com.google.android.gms.analytics.aj;
import com.google.android.gms.analytics.d;
import com.google.android.gms.analytics.e;
import com.google.android.gms.analytics.f;
import com.google.android.gms.analytics.j;
import com.google.android.gms.analytics.u;
import com.google.android.gms.analytics.y;

class v extends aj {
   private static final Object yT = new Object();
   private static v zf;
   private Context mContext;
   private Handler mHandler;
   private d yU;
   private volatile f yV;
   private int yW = 1800;
   private boolean yX = true;
   private boolean yY;
   private String yZ;
   private boolean yt = false;
   private boolean za = true;
   private boolean zb = true;
   private e zc = new e() {
      public void B(boolean var1) {
         v.this.a(var1, v.this.za);
      }
   };
   private u zd;
   private boolean ze = false;

   public static v eu() {
      if(zf == null) {
         zf = new v();
      }

      return zf;
   }

   private void ev() {
      this.zd = new u(this);
      this.zd.z(this.mContext);
   }

   private void ew() {
      this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
         public boolean handleMessage(Message var1) {
            if(1 == var1.what && v.yT.equals(var1.obj)) {
               y.eK().D(true);
               v.this.dispatchLocalHits();
               y.eK().D(false);
               if(v.this.yW > 0 && !v.this.ze) {
                  v.this.mHandler.sendMessageDelayed(v.this.mHandler.obtainMessage(1, v.yT), (long)(v.this.yW * 1000));
               }
            }

            return true;
         }
      });
      if(this.yW > 0) {
         this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, yT), (long)(this.yW * 1000));
      }

   }

   void C(boolean var1) {
      synchronized(this){}

      try {
         this.a(this.ze, var1);
      } finally {
         ;
      }

   }

   void a(Context param1, f param2) {
      // $FF: Couldn't be decompiled
   }

   void a(boolean param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   void dW() {
      if(this.yV == null) {
         ae.V("setForceLocalDispatch() queued. It will be called once initialization is complete.");
         this.yY = true;
      } else {
         y.eK().a(y.a.Bb);
         this.yV.dW();
      }
   }

   void dispatchLocalHits() {
      synchronized(this){}

      try {
         if(this.yV == null) {
            ae.V("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.yX = true;
         } else {
            y.eK().a(y.a.AO);
            this.yV.dispatch();
         }
      } finally {
         ;
      }

   }

   d ex() {
      synchronized(this){}

      d var1;
      try {
         if(this.yU == null) {
            if(this.mContext == null) {
               throw new IllegalStateException("Cant get a store unless we have a context");
            }

            this.yU = new ag(this.zc, this.mContext, new j());
            this.yU.setDryRun(this.yt);
            if(this.yZ != null) {
               this.yU.dV().ad(this.yZ);
               this.yZ = null;
            }
         }

         if(this.mHandler == null) {
            this.ew();
         }

         if(this.zd == null && this.zb) {
            this.ev();
         }

         var1 = this.yU;
      } finally {
         ;
      }

      return var1;
   }

   void ey() {
      synchronized(this){}

      try {
         if(!this.ze && this.za && this.yW > 0) {
            this.mHandler.removeMessages(1, yT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, yT));
         }
      } finally {
         ;
      }

   }

   void setLocalDispatchPeriod(int param1) {
      // $FF: Couldn't be decompiled
   }
}
