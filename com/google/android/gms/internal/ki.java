package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.kh;

public interface ki extends IInterface {
   void a(kh var1) throws RemoteException;

   public abstract static class a extends Binder implements ki {
      public static ki V(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (ki)(var1 != null && var1 instanceof ki?(ki)var1:new ki.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
            this.a(kh.a.U(var2.readStrongBinder()));
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.common.internal.service.ICommonService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ki {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(kh param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
