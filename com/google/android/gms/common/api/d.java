package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.jx;

public final class d {
   private final d.a Kt;
   private volatile Object mListener;

   d(Looper var1, Object var2) {
      this.Kt = new d.a(var1);
      this.mListener = jx.b((Object)var2, "Listener must not be null");
   }

   public void a(d.b var1) {
      jx.b((Object)var1, "Notifier must not be null");
      Message var2 = this.Kt.obtainMessage(1, var1);
      this.Kt.sendMessage(var2);
   }

   void b(d.b var1) {
      Object var2 = this.mListener;
      if(var2 == null) {
         var1.gG();
      } else {
         try {
            var1.c(var2);
         } catch (Exception var3) {
            Log.w("ListenerHolder", "Notifying listener failed", var3);
            var1.gG();
         }
      }
   }

   public void clear() {
      this.mListener = null;
   }

   private final class a extends Handler {
      public a(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         boolean var2 = true;
         if(var1.what != 1) {
            var2 = false;
         }

         jx.L(var2);
         d.this.b((d.b)var1.obj);
      }
   }

   public interface b {
      void c(Object var1);

      void gG();
   }
}
