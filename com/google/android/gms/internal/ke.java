package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kb;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;
import com.google.android.gms.internal.ki;

public final class ke implements kd {
   public PendingResult c(final GoogleApiClient var1) {
      return (new kf.a(var1) {
         protected void a(kg var1) throws RemoteException {
            ((ki)var1.hw()).a(new ke.a(this));
         }
      }).gE();
   }

   private static class a extends kb {
      private final BaseImplementation.b Ea;

      public a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void aI(int var1) throws RemoteException {
         this.Ea.b(new Status(var1));
      }
   }
}
