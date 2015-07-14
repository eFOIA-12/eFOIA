package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.c;

public class bg extends c {
   private final BaseImplementation.b Ea;

   public bg(BaseImplementation.b var1) {
      this.Ea = var1;
   }

   public void n(Status var1) throws RemoteException {
      this.Ea.b(var1);
   }

   public void onSuccess() throws RemoteException {
      this.Ea.b(Status.Kw);
   }
}
