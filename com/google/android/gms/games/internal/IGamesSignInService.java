package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.games.internal.IGamesSignInCallbacks;

public interface IGamesSignInService extends IInterface {
   void a(IGamesSignInCallbacks var1, String var2) throws RemoteException;

   void a(IGamesSignInCallbacks var1, String var2, String var3) throws RemoteException;

   void a(IGamesSignInCallbacks var1, String var2, String var3, String var4) throws RemoteException;

   void a(IGamesSignInCallbacks var1, String var2, String var3, String var4, String[] var5) throws RemoteException;

   void a(IGamesSignInCallbacks var1, String var2, String var3, String[] var4) throws RemoteException;

   void a(IGamesSignInCallbacks var1, String var2, String var3, String[] var4, String var5) throws RemoteException;

   void b(IGamesSignInCallbacks var1, String var2, String var3, String var4) throws RemoteException;

   String bO(String var1) throws RemoteException;

   String bP(String var1) throws RemoteException;

   String i(String var1, boolean var2) throws RemoteException;

   void v(String var1, String var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IGamesSignInService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var7;
         switch(var1) {
         case 5001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            var7 = this.bO(var2.readString());
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 5002:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            var7 = this.bP(var2.readString());
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 5003:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray(), var2.readString());
            var3.writeNoException();
            return true;
         case 5004:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5005:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5006:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5007:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.b(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 5008:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.readString(), var2.createStringArray());
            var3.writeNoException();
            return true;
         case 5009:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            String var6 = var2.readString();
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            var7 = this.i(var6, var5);
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 9001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.v(var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 14001:
            var2.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
            this.a(IGamesSignInCallbacks.Stub.aF(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IGamesSignInService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IGamesSignInService {
      private IBinder le;

      public void a(IGamesSignInCallbacks param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesSignInCallbacks param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesSignInCallbacks param1, String param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesSignInCallbacks param1, String param2, String param3, String param4, String[] param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesSignInCallbacks param1, String param2, String param3, String[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IGamesSignInCallbacks param1, String param2, String param3, String[] param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(IGamesSignInCallbacks param1, String param2, String param3, String param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String bO(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
            var2.writeString(var1);
            this.le.transact(5001, var2, var3, 0);
            var3.readException();
            var1 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String bP(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
            var2.writeString(var1);
            this.le.transact(5002, var2, var3, 0);
            var3.readException();
            var1 = var3.readString();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public String i(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void v(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IGamesSignInService");
            var3.writeString(var1);
            var3.writeString(var2);
            this.le.transact(9001, var3, var4, 0);
            var4.readException();
         } finally {
            var4.recycle();
            var3.recycle();
         }

      }
   }
}
