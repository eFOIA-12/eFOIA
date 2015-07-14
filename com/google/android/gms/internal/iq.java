package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

public interface iq extends IInterface {
   void a(double var1, double var3, boolean var5) throws RemoteException;

   void a(String var1, LaunchOptions var2) throws RemoteException;

   void a(String var1, String var2, long var3) throws RemoteException;

   void a(String var1, byte[] var2, long var3) throws RemoteException;

   void a(boolean var1, double var2, boolean var4) throws RemoteException;

   void aH(String var1) throws RemoteException;

   void aI(String var1) throws RemoteException;

   void aJ(String var1) throws RemoteException;

   void disconnect() throws RemoteException;

   void fY() throws RemoteException;

   void g(String var1, boolean var2) throws RemoteException;

   void gl() throws RemoteException;

   void k(String var1, String var2) throws RemoteException;

   public abstract static class a extends Binder implements iq {
      public static iq M(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            return (iq)(var1 != null && var1 instanceof iq?(iq)var1:new iq.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var10 = false;
         boolean var9 = false;
         double var5;
         String var12;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.disconnect();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            var12 = var2.readString();
            if(var2.readInt() != 0) {
               var9 = true;
            }

            this.g(var12, var9);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.k(var2.readString(), var2.readString());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.gl();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aH(var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.fY();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            var5 = var2.readDouble();
            double var7 = var2.readDouble();
            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            this.a(var5, var7, var9);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            if(var2.readInt() != 0) {
               var9 = true;
            } else {
               var9 = false;
            }

            var5 = var2.readDouble();
            if(var2.readInt() != 0) {
               var10 = true;
            }

            this.a(var9, var5, var10);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.a(var2.readString(), var2.readString(), var2.readLong());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.a(var2.readString(), var2.createByteArray(), var2.readLong());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aI(var2.readString());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            this.aJ(var2.readString());
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
            var12 = var2.readString();
            LaunchOptions var11;
            if(var2.readInt() != 0) {
               var11 = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            this.a(var12, var11);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements iq {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(double param1, double param3, boolean param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, LaunchOptions param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String var1, String var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeString(var2);
            var5.writeLong(var3);
            this.le.transact(9, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      public void a(String var1, byte[] var2, long var3) throws RemoteException {
         Parcel var5 = Parcel.obtain();

         try {
            var5.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var5.writeString(var1);
            var5.writeByteArray(var2);
            var5.writeLong(var3);
            this.le.transact(10, var5, (Parcel)null, 1);
         } finally {
            var5.recycle();
         }

      }

      public void a(boolean param1, double param2, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void aH(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.le.transact(5, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void aI(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.le.transact(11, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public void aJ(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var2.writeString(var1);
            this.le.transact(12, var2, (Parcel)null, 1);
         } finally {
            var2.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void disconnect() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.le.transact(1, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void fY() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.le.transact(6, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void g(String param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void gl() throws RemoteException {
         Parcel var1 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            this.le.transact(4, var1, (Parcel)null, 1);
         } finally {
            var1.recycle();
         }

      }

      public void k(String var1, String var2) throws RemoteException {
         Parcel var3 = Parcel.obtain();

         try {
            var3.writeInterfaceToken("com.google.android.gms.cast.internal.ICastDeviceController");
            var3.writeString(var1);
            var3.writeString(var2);
            this.le.transact(3, var3, (Parcel)null, 1);
         } finally {
            var3.recycle();
         }

      }
   }
}
