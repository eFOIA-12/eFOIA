package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.l;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class a extends l.a {
   private final BleScanCallback VC;

   private a(BleScanCallback var1) {
      this.VC = (BleScanCallback)jx.i(var1);
   }

   // $FF: synthetic method
   a(BleScanCallback var1, Object var2) {
      this(var1);
   }

   public void onDeviceFound(BleDevice var1) throws RemoteException {
      this.VC.onDeviceFound(var1);
   }

   public void onScanStopped() throws RemoteException {
      this.VC.onScanStopped();
   }

   public static class a {
      private static final a.a VD = new a.a();
      private final Map VE = new HashMap();

      public static a.a jP() {
         return VD;
      }

      public a a(BleScanCallback param1) {
         // $FF: Couldn't be decompiled
      }

      public a b(BleScanCallback param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
