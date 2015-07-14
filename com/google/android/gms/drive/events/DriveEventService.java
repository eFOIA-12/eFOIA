package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.ag;
import com.google.android.gms.drive.internal.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
   public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
   private CountDownLatch Pg;
   DriveEventService.a Ph;
   boolean Pi;
   int Pj;
   private final String mName;

   protected DriveEventService() {
      this("DriveEventService");
   }

   protected DriveEventService(String var1) {
      this.Pi = false;
      this.Pj = -1;
      this.mName = var1;
   }

   // $FF: synthetic method
   static void a(DriveEventService var0) throws SecurityException {
      var0.iD();
   }

   private void a(OnEventResponse param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean bh(int var1) {
      boolean var4 = false;
      String[] var5 = this.getPackageManager().getPackagesForUid(var1);
      boolean var3 = var4;
      if(var5 != null) {
         int var2 = var5.length;
         var1 = 0;

         while(true) {
            var3 = var4;
            if(var1 >= var2) {
               break;
            }

            if("com.google.android.gms".equals(var5[var1])) {
               var3 = true;
               break;
            }

            ++var1;
         }
      }

      return var3;
   }

   private void iD() throws SecurityException {
      int var1 = this.getCallingUid();
      if(var1 != this.Pj) {
         if(GooglePlayServicesUtil.b(this.getPackageManager(), "com.google.android.gms") && this.bh(var1)) {
            this.Pj = var1;
         } else {
            throw new SecurityException("Caller is not GooglePlayServices");
         }
      }
   }

   protected int getCallingUid() {
      return Binder.getCallingUid();
   }

   public final IBinder onBind(Intent var1) {
      synchronized(this){}
      boolean var4 = false;

      IBinder var8;
      try {
         var4 = true;
         if("com.google.android.gms.drive.events.HANDLE_EVENT".equals(var1.getAction())) {
            if(this.Ph == null && !this.Pi) {
               this.Pi = true;
               final CountDownLatch var7 = new CountDownLatch(1);
               this.Pg = new CountDownLatch(1);
               (new Thread() {
                  public void run() {
                     try {
                        Looper.prepare();
                        DriveEventService.this.Ph = DriveEventService.this.new a();
                        DriveEventService.this.Pi = false;
                        var7.countDown();
                        w.m("DriveEventService", "Bound and starting loop");
                        Looper.loop();
                        w.m("DriveEventService", "Finished loop");
                     } finally {
                        if(DriveEventService.this.Pg != null) {
                           DriveEventService.this.Pg.countDown();
                        }

                     }

                  }
               }).start();

               try {
                  if(!var7.await(5000L, TimeUnit.MILLISECONDS)) {
                     w.p("DriveEventService", "Failed to synchronously initialize event handler.");
                  }
               } catch (InterruptedException var5) {
                  throw new RuntimeException("Unable to start event handler", var5);
               }
            }

            var8 = (new DriveEventService.b()).asBinder();
            var4 = false;
            return var8;
         }

         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      var8 = null;
      return var8;
   }

   public void onChange(ChangeEvent var1) {
      w.o(this.mName, "Unhandled change event: " + var1);
   }

   public void onCompletion(CompletionEvent var1) {
      w.o(this.mName, "Unhandled completion event: " + var1);
   }

   public void onDestroy() {
      synchronized(this){}

      try {
         w.m("DriveEventService", "onDestroy");
         if(this.Ph != null) {
            Message var1 = this.Ph.iE();
            this.Ph.sendMessage(var1);
            this.Ph = null;

            try {
               if(!this.Pg.await(5000L, TimeUnit.MILLISECONDS)) {
                  w.o("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
               }
            } catch (InterruptedException var4) {
               ;
            }

            this.Pg = null;
         }

         super.onDestroy();
      } finally {
         ;
      }

   }

   public boolean onUnbind(Intent var1) {
      return true;
   }

   final class a extends Handler {
      // $FF: synthetic method
      static Message a(DriveEventService.a var0, OnEventResponse var1) {
         return var0.b(var1);
      }

      private Message b(OnEventResponse var1) {
         return this.obtainMessage(1, var1);
      }

      private Message iE() {
         return this.obtainMessage(2);
      }

      public void handleMessage(Message var1) {
         w.m("DriveEventService", "handleMessage message type:" + var1.what);
         switch(var1.what) {
         case 1:
            DriveEventService.this.a((OnEventResponse)var1.obj);
            return;
         case 2:
            this.getLooper().quit();
            return;
         default:
            w.o("DriveEventService", "Unexpected message type:" + var1.what);
         }
      }
   }

   final class b extends ag.a {
      public void c(OnEventResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
