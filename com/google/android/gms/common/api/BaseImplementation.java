package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BaseImplementation {
   static void a(Result var0) {
      if(var0 instanceof Releasable) {
         try {
            ((Releasable)var0).release();
         } catch (RuntimeException var2) {
            Log.w("GoogleApi", "Unable to release " + var0, var2);
            return;
         }
      }

   }

   public abstract static class AbstractPendingResult implements BaseImplementation.b, PendingResult {
      private final Object Jp = new Object();
      private final ArrayList Jq = new ArrayList();
      private ResultCallback Jr;
      private volatile Result Js;
      private volatile boolean Jt;
      private boolean Ju;
      private boolean Jv;
      private jr Jw;
      protected final BaseImplementation.CallbackHandler mHandler;
      private final CountDownLatch mr = new CountDownLatch(1);

      protected AbstractPendingResult(Looper var1) {
         this.mHandler = new BaseImplementation.CallbackHandler(var1);
      }

      protected AbstractPendingResult(BaseImplementation.CallbackHandler var1) {
         this.mHandler = var1;
      }

      private void c(Result var1) {
         this.Js = var1;
         this.Jw = null;
         this.mr.countDown();
         Status var3 = this.Js.getStatus();
         if(this.Jr != null) {
            this.mHandler.removeTimeoutMessages();
            if(!this.Ju) {
               this.mHandler.sendResultCallback(this.Jr, this.gA());
            }
         }

         Iterator var2 = this.Jq.iterator();

         while(var2.hasNext()) {
            ((PendingResult.a)var2.next()).m(var3);
         }

         this.Jq.clear();
      }

      private Result gA() {
         // $FF: Couldn't be decompiled
      }

      private void gC() {
         // $FF: Couldn't be decompiled
      }

      private void gD() {
         // $FF: Couldn't be decompiled
      }

      public final void a(PendingResult.a param1) {
         // $FF: Couldn't be decompiled
      }

      protected final void a(jr param1) {
         // $FF: Couldn't be decompiled
      }

      public final Result await() {
         boolean var2 = true;
         boolean var1;
         if(Looper.myLooper() != Looper.getMainLooper()) {
            var1 = true;
         } else {
            var1 = false;
         }

         jx.a(var1, "await must not be called on the UI thread");
         if(!this.Jt) {
            var1 = var2;
         } else {
            var1 = false;
         }

         jx.a(var1, "Result has already been consumed");

         try {
            this.mr.await();
         } catch (InterruptedException var4) {
            this.gC();
         }

         jx.a(this.isReady(), "Result is not ready.");
         return this.gA();
      }

      public final Result await(long var1, TimeUnit var3) {
         boolean var5 = true;
         boolean var4;
         if(var1 > 0L && Looper.myLooper() == Looper.getMainLooper()) {
            var4 = false;
         } else {
            var4 = true;
         }

         jx.a(var4, "await must not be called on the UI thread when time is greater than zero.");
         if(!this.Jt) {
            var4 = var5;
         } else {
            var4 = false;
         }

         jx.a(var4, "Result has already been consumed.");

         try {
            if(!this.mr.await(var1, var3)) {
               this.gD();
            }
         } catch (InterruptedException var6) {
            this.gC();
         }

         jx.a(this.isReady(), "Result is not ready.");
         return this.gA();
      }

      public final void b(Result param1) {
         // $FF: Couldn't be decompiled
      }

      protected abstract Result c(Status var1);

      public void cancel() {
         // $FF: Couldn't be decompiled
      }

      protected void gB() {
         this.Jt = true;
         this.Js = null;
         this.Jr = null;
      }

      public boolean isCanceled() {
         // $FF: Couldn't be decompiled
      }

      public final boolean isReady() {
         return this.mr.getCount() == 0L;
      }

      public final void setResultCallback(ResultCallback param1) {
         // $FF: Couldn't be decompiled
      }

      public final void setResultCallback(ResultCallback param1, long param2, TimeUnit param4) {
         // $FF: Couldn't be decompiled
      }
   }

   public static class CallbackHandler extends Handler {
      public static final int CALLBACK_ON_COMPLETE = 1;
      public static final int CALLBACK_ON_TIMEOUT = 2;

      public CallbackHandler() {
         this(Looper.getMainLooper());
      }

      public CallbackHandler(Looper var1) {
         super(var1);
      }

      protected void deliverResultCallback(ResultCallback var1, Result var2) {
         try {
            var1.onResult(var2);
         } catch (RuntimeException var3) {
            BaseImplementation.a(var2);
            throw var3;
         }
      }

      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            Pair var2 = (Pair)var1.obj;
            this.deliverResultCallback((ResultCallback)var2.first, (Result)var2.second);
            return;
         case 2:
            ((BaseImplementation.AbstractPendingResult)var1.obj).gD();
            return;
         default:
            Log.wtf("GoogleApi", "Don\'t know how to handle this message.");
         }
      }

      public void removeTimeoutMessages() {
         this.removeMessages(2);
      }

      public void sendResultCallback(ResultCallback var1, Result var2) {
         this.sendMessage(this.obtainMessage(1, new Pair(var1, var2)));
      }

      public void sendTimeoutResultCallback(BaseImplementation.AbstractPendingResult var1, long var2) {
         this.sendMessageDelayed(this.obtainMessage(2, var1), var2);
      }
   }

   public abstract static class a extends BaseImplementation.AbstractPendingResult implements c.d {
      private final Api.c Jn;
      private final GoogleApiClient Jx;
      private c.b Jy;

      protected a(Api.c var1, GoogleApiClient var2) {
         super(var2.getLooper());
         this.Jn = (Api.c)jx.i(var1);
         this.Jx = var2;
      }

      private void a(RemoteException var1) {
         this.l(new Status(8, var1.getLocalizedMessage(), (PendingIntent)null));
      }

      protected abstract void a(Api.a var1) throws RemoteException;

      public void a(c.b var1) {
         this.Jy = var1;
      }

      public final void b(Api.a var1) throws DeadObjectException {
         try {
            this.a(var1);
         } catch (DeadObjectException var2) {
            this.a((RemoteException)var2);
            throw var2;
         } catch (RemoteException var3) {
            this.a(var3);
         }
      }

      protected void gB() {
         super.gB();
         if(this.Jy != null) {
            this.Jy.b(this);
            this.Jy = null;
         }

      }

      public final BaseImplementation.a gE() {
         jx.b((Object)this.Jx, "GoogleApiClient was not set.");
         this.Jx.b(this);
         return this;
      }

      public int gF() {
         return 0;
      }

      public final Api.c gz() {
         return this.Jn;
      }

      public final void l(Status var1) {
         boolean var2;
         if(!var1.isSuccess()) {
            var2 = true;
         } else {
            var2 = false;
         }

         jx.b(var2, "Failed result must not be success");
         this.b(this.c(var1));
      }
   }

   public interface b {
      void b(Object var1);
   }
}
