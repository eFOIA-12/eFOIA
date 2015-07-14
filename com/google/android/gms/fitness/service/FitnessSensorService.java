package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.ll;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mq;
import com.google.android.gms.internal.ms;
import com.google.android.gms.internal.mu;
import java.util.List;

public abstract class FitnessSensorService extends Service {
   public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
   private FitnessSensorService.a Ww;

   public final IBinder onBind(Intent var1) {
      if("com.google.android.gms.fitness.service.FitnessSensorService".equals(var1.getAction())) {
         if(Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + var1 + " received by " + this.getClass().getName());
         }

         return this.Ww.asBinder();
      } else {
         return null;
      }
   }

   public void onCreate() {
      super.onCreate();
      this.Ww = new FitnessSensorService.a(this, null);
   }

   public abstract List onFindDataSources(List var1);

   public abstract boolean onRegister(FitnessSensorServiceRequest var1);

   public abstract boolean onUnregister(DataSource var1);

   private static class a extends mu.a {
      private final FitnessSensorService Wx;

      private a(FitnessSensorService var1) {
         this.Wx = var1;
      }

      // $FF: synthetic method
      a(FitnessSensorService var1, Object var2) {
         this(var1);
      }

      private void kw() throws SecurityException {
         int var1 = Binder.getCallingUid();
         if(ll.im()) {
            ((AppOpsManager)this.Wx.getSystemService("appops")).checkPackage(var1, "com.google.android.gms");
         } else {
            String[] var3 = this.Wx.getPackageManager().getPackagesForUid(var1);
            if(var3 != null) {
               int var2 = var3.length;

               for(var1 = 0; var1 < var2; ++var1) {
                  if(var3[var1].equals("com.google.android.gms")) {
                     return;
                  }
               }
            }

            throw new SecurityException("Unauthorized caller");
         }
      }

      public void a(FitnessSensorServiceRequest var1, md var2) throws RemoteException {
         this.kw();
         if(this.Wx.onRegister(var1)) {
            var2.j(Status.Kw);
         } else {
            var2.j(new Status(13));
         }
      }

      public void a(mq var1, lx var2) throws RemoteException {
         this.kw();
         var2.a(new DataSourcesResult(this.Wx.onFindDataSources(var1.getDataTypes()), Status.Kw));
      }

      public void a(ms var1, md var2) throws RemoteException {
         this.kw();
         if(this.Wx.onUnregister(var1.getDataSource())) {
            var2.j(Status.Kw);
         } else {
            var2.j(new Status(13));
         }
      }
   }
}
