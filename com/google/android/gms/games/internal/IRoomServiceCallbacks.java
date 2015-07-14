package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.games.internal.ConnectionInfo;

public interface IRoomServiceCallbacks extends IInterface {
   void a(ParcelFileDescriptor var1, int var2) throws RemoteException;

   void a(ConnectionInfo var1) throws RemoteException;

   void a(String var1, byte[] var2, int var3) throws RemoteException;

   void a(String var1, String[] var2) throws RemoteException;

   void aG(IBinder var1) throws RemoteException;

   void b(String var1, String[] var2) throws RemoteException;

   void bS(String var1) throws RemoteException;

   void bT(String var1) throws RemoteException;

   void bU(String var1) throws RemoteException;

   void bV(String var1) throws RemoteException;

   void bW(String var1) throws RemoteException;

   void bX(String var1) throws RemoteException;

   void c(int var1, int var2, String var3) throws RemoteException;

   void c(String var1, byte[] var2) throws RemoteException;

   void c(String var1, String[] var2) throws RemoteException;

   void d(String var1, String[] var2) throws RemoteException;

   void dX(int var1) throws RemoteException;

   void e(String var1, String[] var2) throws RemoteException;

   void f(String var1, String[] var2) throws RemoteException;

   void g(String var1, String[] var2) throws RemoteException;

   void j(String var1, boolean var2) throws RemoteException;

   void lR() throws RemoteException;

   void lS() throws RemoteException;

   void onP2PConnected(String var1) throws RemoteException;

   void onP2PDisconnected(String var1) throws RemoteException;

   void x(String var1, int var2) throws RemoteException;

   public abstract static class Stub extends Binder implements IRoomServiceCallbacks {
      public Stub() {
         this.attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
      }

      public static IRoomServiceCallbacks aH(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return (IRoomServiceCallbacks)(var1 != null && var1 instanceof IRoomServiceCallbacks?(IRoomServiceCallbacks)var1:new IRoomServiceCallbacks.Proxy(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var7 = null;
         Object var6 = null;
         switch(var1) {
         case 1001:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readInt(), var2.readInt(), var2.readString());
            return true;
         case 1002:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.a(var2.readString(), var2.createByteArray(), var2.readInt());
            return true;
         case 1003:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bS(var2.readString());
            return true;
         case 1004:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bT(var2.readString());
            return true;
         case 1005:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bU(var2.readString());
            return true;
         case 1006:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bV(var2.readString());
            return true;
         case 1007:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bW(var2.readString());
            return true;
         case 1008:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.a(var2.readString(), var2.createStringArray());
            return true;
         case 1009:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.b(var2.readString(), var2.createStringArray());
            return true;
         case 1010:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readString(), var2.createStringArray());
            return true;
         case 1011:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.d(var2.readString(), var2.createStringArray());
            return true;
         case 1012:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.e(var2.readString(), var2.createStringArray());
            return true;
         case 1013:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.f(var2.readString(), var2.createStringArray());
            return true;
         case 1014:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.onP2PConnected(var2.readString());
            return true;
         case 1015:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.onP2PDisconnected(var2.readString());
            return true;
         case 1016:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.lR();
            return true;
         case 1017:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.g(var2.readString(), var2.createStringArray());
            return true;
         case 1018:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.c(var2.readString(), var2.createByteArray());
            return true;
         case 1019:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.bX(var2.readString());
            return true;
         case 1020:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.dX(var2.readInt());
            return true;
         case 1021:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.aG(var2.readStrongBinder());
            return true;
         case 1022:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            ConnectionInfo var10 = (ConnectionInfo)var6;
            if(var2.readInt() != 0) {
               var10 = ConnectionInfo.CREATOR.ct(var2);
            }

            this.a(var10);
            return true;
         case 1023:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.lS();
            return true;
         case 1024:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            ParcelFileDescriptor var9 = (ParcelFileDescriptor)var7;
            if(var2.readInt() != 0) {
               var9 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var9, var2.readInt());
            return true;
         case 1025:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.x(var2.readString(), var2.readInt());
            return true;
         case 1026:
            var2.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            String var8 = var2.readString();
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.j(var8, var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class Proxy implements IRoomServiceCallbacks {
      private IBinder le;

      Proxy(IBinder var1) {
         this.le = var1;
      }

      public void a(ParcelFileDescriptor param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ConnectionInfo param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String var1, byte[] var2, int var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeString(var1);
            var4.writeByteArray(var2);
            var4.writeInt(var3);
            this.le.transact(1002, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      public void a(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1008, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void aG(IBinder var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeStrongBinder(var1);
            this.le.transact(1021, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1009, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void bS(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1003, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bT(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1004, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bU(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1005, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bV(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1006, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bW(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1007, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void bX(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1019, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void c(int var1, int var2, String var3) throws RemoteException {
         Parcel var4 = Parcel.obtain();

         try {
            var4.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var4.writeInt(var1);
            var4.writeInt(var2);
            var4.writeString(var3);
            this.le.transact(1001, var4, (Parcel)null, 1);
         } finally {
            var4.recycle();
         }

      }

      public void c(String var1, byte[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeByteArray(var2);
            this.le.transact(1018, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void c(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1010, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void d(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1011, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void dX(int var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeInt(var1);
            this.le.transact(1020, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void e(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1012, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void f(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1013, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void g(String var1, String[] var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeStringArray(var2);
            this.le.transact(1017, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }

      public void j(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void lR() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.le.transact(1016, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void lS() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            this.le.transact(1023, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void onP2PConnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1014, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void onP2PDisconnected(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var2.writeString(var1);
            this.le.transact(1015, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void x(String var1, int var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
            var3.writeString(var1);
            var3.writeInt(var2);
            this.le.transact(1025, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
