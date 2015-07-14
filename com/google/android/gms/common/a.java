package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class a implements ServiceConnection {
   boolean Is = false;
   private final BlockingQueue It = new LinkedBlockingQueue();

   public IBinder gs() throws InterruptedException {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
      } else if(this.Is) {
         throw new IllegalStateException();
      } else {
         this.Is = true;
         return (IBinder)this.It.take();
      }
   }

   public void onServiceConnected(ComponentName var1, IBinder var2) {
      this.It.add(var2);
   }

   public void onServiceDisconnected(ComponentName var1) {
   }
}
