package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.jr;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.ky;
import com.google.android.gms.plus.internal.b;
import java.util.List;

public interface d extends IInterface {
   jr a(b var1, int var2, int var3, int var4, String var5) throws RemoteException;

   void a(ky var1) throws RemoteException;

   void a(b var1) throws RemoteException;

   void a(b var1, int var2, String var3, Uri var4, String var5, String var6) throws RemoteException;

   void a(b var1, Uri var2, Bundle var3) throws RemoteException;

   void a(b var1, ky var2) throws RemoteException;

   void a(b var1, String var2) throws RemoteException;

   void a(b var1, String var2, String var3) throws RemoteException;

   void a(b var1, List var2) throws RemoteException;

   void a(String var1, kk var2, kk var3) throws RemoteException;

   void b(b var1) throws RemoteException;

   void b(b var1, String var2) throws RemoteException;

   void c(b var1, String var2) throws RemoteException;

   void clearDefaultAccount() throws RemoteException;

   void d(b var1, String var2) throws RemoteException;

   void e(b var1, String var2) throws RemoteException;

   String getAccountName() throws RemoteException;

   String ou() throws RemoteException;

   boolean ov() throws RemoteException;

   String ow() throws RemoteException;

   void removeMoment(String var1) throws RemoteException;

   public abstract static class a extends Binder implements d {
      public static d bM(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (d)(var1 != null && var1 instanceof d?(d)var1:new d.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var8 = null;
         kk var7 = null;
         kk var6 = null;
         String var10;
         b var15;
         Uri var17;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(b.a.bK(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(b.a.bK(var2.readStrongBinder()), var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(b.a.bK(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            ky var13;
            if(var2.readInt() != 0) {
               var13 = ky.CREATOR.Q(var2);
            } else {
               var13 = null;
            }

            this.a(var13);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var10 = this.getAccountName();
            var3.writeNoException();
            var3.writeString(var10);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.clearDefaultAccount();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(b.a.bK(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var15 = b.a.bK(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var17 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            Bundle var12;
            if(var2.readInt() != 0) {
               var12 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var12 = null;
            }

            this.a(var15, var17, var12);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var15 = b.a.bK(var2.readStrongBinder());
            var1 = var2.readInt();
            var8 = var2.readString();
            if(var2.readInt() != 0) {
               var17 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var17 = null;
            }

            this.a(var15, var1, var8, var17, var2.readString(), var2.readString());
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            jr var16 = this.a(b.a.bK(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readInt(), var2.readString());
            var3.writeNoException();
            IBinder var11 = var6;
            if(var16 != null) {
               var11 = var16.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.removeMoment(var2.readString());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.c(b.a.bK(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.b(b.a.bK(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.a(b.a.bK(var2.readStrongBinder()), var2.createStringArrayList());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.d(b.a.bK(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var10 = this.ou();
            var3.writeNoException();
            var3.writeString(var10);
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            boolean var5 = this.ov();
            var3.writeNoException();
            byte var9;
            if(var5) {
               var9 = 1;
            } else {
               var9 = 0;
            }

            var3.writeInt(var9);
            return true;
         case 43:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var10 = this.ow();
            var3.writeNoException();
            var3.writeString(var10);
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            this.e(b.a.bK(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var15 = b.a.bK(var2.readStrongBinder());
            ky var14 = var8;
            if(var2.readInt() != 0) {
               var14 = ky.CREATOR.Q(var2);
            }

            this.a(var15, var14);
            var3.writeNoException();
            return true;
         case 46:
            var2.enforceInterface("com.google.android.gms.plus.internal.IPlusService");
            var8 = var2.readString();
            if(var2.readInt() != 0) {
               var6 = kk.CREATOR.I(var2);
            } else {
               var6 = null;
            }

            if(var2.readInt() != 0) {
               var7 = kk.CREATOR.I(var2);
            }

            this.a(var8, var6, var7);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.plus.internal.IPlusService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements d {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public jr a(b param1, int param2, int param3, int param4, String param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ky param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, int param2, String param3, Uri param4, String param5, String param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, Uri param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, ky param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, String param2, String param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(b param1, List param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, kk param2, kk param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(b param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(b param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(b param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void clearDefaultAccount() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void d(b param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(b param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public String getAccountName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public String ou() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.le.transact(41, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public boolean ov() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.le.transact(42, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public String ow() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            this.le.transact(43, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void removeMoment(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
            var2.writeString(var1);
            this.le.transact(17, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }
   }
}
