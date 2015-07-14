package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.lx;
import com.google.android.gms.internal.md;
import com.google.android.gms.internal.mq;
import com.google.android.gms.internal.ms;

public interface mu extends IInterface {
   void a(FitnessSensorServiceRequest var1, md var2) throws RemoteException;

   void a(mq var1, lx var2) throws RemoteException;

   void a(ms var1, md var2) throws RemoteException;

   public abstract static class a extends Binder implements mu {
      public a() {
         this.attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            mq var10 = (mq)var5;
            if(var2.readInt() != 0) {
               var10 = (mq)mq.CREATOR.createFromParcel(var2);
            }

            this.a(var10, lx.a.at(var2.readStrongBinder()));
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            FitnessSensorServiceRequest var9 = (FitnessSensorServiceRequest)var6;
            if(var2.readInt() != 0) {
               var9 = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var9, md.a.az(var2.readStrongBinder()));
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            ms var8 = (ms)var7;
            if(var2.readInt() != 0) {
               var8 = (ms)ms.CREATOR.createFromParcel(var2);
            }

            this.a(var8, md.a.az(var2.readStrongBinder()));
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
