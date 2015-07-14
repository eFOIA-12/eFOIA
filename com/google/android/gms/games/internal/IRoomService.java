package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.IRoomServiceCallbacks;

public interface IRoomService extends IInterface {
   void R(boolean var1) throws RemoteException;

   void a(IBinder var1, IRoomServiceCallbacks var2) throws RemoteException;

   void a(DataHolder var1, boolean var2) throws RemoteException;

   void a(byte[] var1, String var2, int var3) throws RemoteException;

   void a(byte[] var1, String[] var2) throws RemoteException;

   void bQ(String var1) throws RemoteException;

   void bR(String var1) throws RemoteException;

   void c(String var1, String var2, String var3) throws RemoteException;

   void lN() throws RemoteException;

   void lO() throws RemoteException;

   void lP() throws RemoteException;

   void lQ() throws RemoteException;

   void v(String var1, int var2) throws RemoteException;

   void w(String var1, int var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IRoomService {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var6 = false;
         boolean var5 = false;
         switch(var1) {
         case 1001:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.readStrongBinder(), IRoomServiceCallbacks.Stub.aH(var2.readStrongBinder()));
            return true;
         case 1002:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lN();
            return true;
         case 1003:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lO();
            return true;
         case 1004:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.c(var2.readString(), var2.readString(), var2.readString());
            return true;
         case 1005:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lP();
            return true;
         case 1006:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            DataHolder var7;
            if(var2.readInt() != 0) {
               var7 = DataHolder.CREATOR.B(var2);
            } else {
               var7 = null;
            }

            if(var2.readInt() != 0) {
               var5 = true;
            }

            this.a(var7, var5);
            return true;
         case 1007:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.lQ();
            return true;
         case 1008:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            var5 = var6;
            if(var2.readInt() != 0) {
               var5 = true;
            }

            this.R(var5);
            return true;
         case 1009:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.createByteArray(), var2.readString(), var2.readInt());
            return true;
         case 1010:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.a(var2.createByteArray(), var2.createStringArray());
            return true;
         case 1011:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.v(var2.readString(), var2.readInt());
            return true;
         case 1012:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.w(var2.readString(), var2.readInt());
            return true;
         case 1013:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.bQ(var2.readString());
            return true;
         case 1014:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomService");
            this.bR(var2.readString());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IRoomService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IRoomService {
      private IBinder le;

      public void R(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(IBinder param1, IRoomServiceCallbacks param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DataHolder param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(byte[] var1, String var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var4.writeByteArray(var1);
            var4.writeString(var2);
            var4.writeInt(var3);
            this.le.transact(1009, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      public void a(byte[] var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeByteArray(var1);
            var3.writeStringArray(var2);
            this.le.transact(1010, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void bQ(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var2.writeString(var1);
            this.le.transact(1013, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bR(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var2.writeString(var1);
            this.le.transact(1014, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void c(String var1, String var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var4.writeString(var1);
            var4.writeString(var2);
            var4.writeString(var3);
            this.le.transact(1004, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      public void lN() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.le.transact(1002, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void lO() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.le.transact(1003, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void lP() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.le.transact(1005, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void lQ() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            this.le.transact(1007, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void v(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(1011, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void w(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomService");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(1012, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
