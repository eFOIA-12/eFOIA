package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import com.google.android.gms.internal.jx;
import java.util.Iterator;
import java.util.List;

class b implements SensorEventDispatcher {
   private final k VW;

   b(k var1) {
      this.VW = (k)jx.i(var1);
   }

   public void publish(DataPoint var1) throws RemoteException {
      this.VW.c(var1);
   }

   public void publish(List var1) throws RemoteException {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         this.publish((DataPoint)var2.next());
      }

   }
}
