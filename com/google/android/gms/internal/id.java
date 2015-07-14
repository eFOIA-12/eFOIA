package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ic;

public interface id extends IInterface {
   void a(ic var1) throws RemoteException;

   void a(ic var1, int var2) throws RemoteException;

   void a(ic var1, int var2, String var3, byte[] var4) throws RemoteException;

   void a(ic var1, int var2, byte[] var3) throws RemoteException;

   void b(ic var1) throws RemoteException;

   void b(ic var1, int var2) throws RemoteException;

   void c(ic var1) throws RemoteException;

   int fL() throws RemoteException;

   int fM() throws RemoteException;

   public abstract static class a extends Binder implements id {
      public static id J(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
            return (id)(var1 != null && var1 instanceof id?(id)var1:new id.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            var1 = this.fL();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            var1 = this.fM();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(ic.a.I(var2.readStrongBinder()), var2.readInt(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(ic.a.I(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(ic.a.I(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.a(ic.a.I(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.b(ic.a.I(var2.readStrongBinder()), var2.readInt());
            var3.writeNoException();
            return true;
         case 5008:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.b(ic.a.I(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5009:
            var2.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            this.c(ic.a.I(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appstate.internal.IAppStateService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements id {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(ic param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ic param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ic param1, int param2, String param3, byte[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ic param1, int param2, byte[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(ic param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(ic param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(ic param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int fL() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            this.le.transact(5001, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public int fM() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            this.le.transact(5002, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }
   }
}
