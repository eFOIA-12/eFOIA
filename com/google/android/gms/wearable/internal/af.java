package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.ad;
import com.google.android.gms.wearable.internal.ar;
import com.google.android.gms.wearable.internal.b;

public interface af extends IInterface {
   void a(ad var1) throws RemoteException;

   void a(ad var1, Uri var2) throws RemoteException;

   void a(ad var1, Asset var2) throws RemoteException;

   void a(ad var1, PutDataRequest var2) throws RemoteException;

   void a(ad var1, com.google.android.gms.wearable.c var2) throws RemoteException;

   void a(ad var1, ar var2) throws RemoteException;

   void a(ad var1, b var2) throws RemoteException;

   void a(ad var1, String var2) throws RemoteException;

   void a(ad var1, String var2, String var3, byte[] var4) throws RemoteException;

   void b(ad var1) throws RemoteException;

   void b(ad var1, Uri var2) throws RemoteException;

   void b(ad var1, com.google.android.gms.wearable.c var2) throws RemoteException;

   void b(ad var1, String var2) throws RemoteException;

   void c(ad var1) throws RemoteException;

   void c(ad var1, Uri var2) throws RemoteException;

   void c(ad var1, String var2) throws RemoteException;

   void d(ad var1) throws RemoteException;

   void e(ad var1) throws RemoteException;

   void f(ad var1) throws RemoteException;

   void g(ad var1) throws RemoteException;

   void h(ad var1) throws RemoteException;

   void i(ad var1) throws RemoteException;

   void j(ad var1) throws RemoteException;

   void k(ad var1) throws RemoteException;

   public abstract static class a extends Binder implements af {
      public static af bZ(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (af)(var1 != null && var1 instanceof af?(af)var1:new af.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         ad var6 = null;
         ad var7 = null;
         Object var8 = null;
         Object var9 = null;
         Object var10 = null;
         Object var11 = null;
         Object var12 = null;
         Object var13 = null;
         com.google.android.gms.wearable.c var5 = null;
         Uri var17;
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            var5 = (com.google.android.gms.wearable.c)var13;
            if(var2.readInt() != 0) {
               var5 = (com.google.android.gms.wearable.c)com.google.android.gms.wearable.c.CREATOR.createFromParcel(var2);
            }

            this.b(var6, var5);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.i(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.j(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.k(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var7 = ad.a.bX(var2.readStrongBinder());
            PutDataRequest var18 = var6;
            if(var2.readInt() != 0) {
               var18 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var7, var18);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            var17 = var7;
            if(var2.readInt() != 0) {
               var17 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var17);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.b(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            var17 = (Uri)var8;
            if(var2.readInt() != 0) {
               var17 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.b(var6, var17);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            var17 = (Uri)var9;
            if(var2.readInt() != 0) {
               var17 = (Uri)Uri.CREATOR.createFromParcel(var2);
            }

            this.c(var6, var17);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(ad.a.bX(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createByteArray());
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            Asset var16 = (Asset)var10;
            if(var2.readInt() != 0) {
               var16 = (Asset)Asset.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var16);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.c(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.d(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            b var15 = (b)var11;
            if(var2.readInt() != 0) {
               var15 = (b)b.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var15);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            ar var14 = (ar)var12;
            if(var2.readInt() != 0) {
               var14 = (ar)ar.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var14);
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.e(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.f(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            var6 = ad.a.bX(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var5 = (com.google.android.gms.wearable.c)com.google.android.gms.wearable.c.CREATOR.createFromParcel(var2);
            }

            this.a(var6, var5);
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(ad.a.bX(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.a(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.b(ad.a.bX(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.c(ad.a.bX(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.g(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
            this.h(ad.a.bX(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements af {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, Asset param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, PutDataRequest param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, com.google.android.gms.wearable.c param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, ar param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, b param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ad param1, String param2, String param3, byte[] param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(ad param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(ad param1, com.google.android.gms.wearable.c param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(ad param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(ad param1, Uri param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(ad param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void i(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void j(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void k(ad param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
