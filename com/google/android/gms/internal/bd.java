package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.bc;
import com.google.android.gms.internal.bf;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.er;

public interface bd extends IInterface {
   void a(ay var1) throws RemoteException;

   void a(bc var1) throws RemoteException;

   void a(bf var1) throws RemoteException;

   void a(br var1) throws RemoteException;

   void a(en var1) throws RemoteException;

   void a(er var1, String var2) throws RemoteException;

   boolean a(av var1) throws RemoteException;

   com.google.android.gms.dynamic.d ab() throws RemoteException;

   ay ac() throws RemoteException;

   void an() throws RemoteException;

   void destroy() throws RemoteException;

   String getMediationAdapterClassName() throws RemoteException;

   boolean isReady() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   void stopLoading() throws RemoteException;

   public abstract static class a extends Binder implements bd {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
      }

      public static bd f(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return (bd)(var1 != null && var1 instanceof bd?(bd)var1:new bd.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var8 = null;
         Object var9 = null;
         ay var7 = null;
         byte var5 = 0;
         boolean var6;
         byte var10;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            var8 = this.ab();
            var3.writeNoException();
            IBinder var13 = var7;
            if(var8 != null) {
               var13 = var8.asBinder();
            }

            var3.writeStrongBinder(var13);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.destroy();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            var6 = this.isReady();
            var3.writeNoException();
            if(var6) {
               var10 = 1;
            } else {
               var10 = 0;
            }

            var3.writeInt(var10);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            av var14 = var8;
            if(var2.readInt() != 0) {
               var14 = av.CREATOR.b(var2);
            }

            var6 = this.a(var14);
            var3.writeNoException();
            var10 = var5;
            if(var6) {
               var10 = 1;
            }

            var3.writeInt(var10);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.pause();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.resume();
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(bc.a.e(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(bf.a.h(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.showInterstitial();
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.stopLoading();
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.an();
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            ay var12 = this.ac();
            var3.writeNoException();
            if(var12 != null) {
               var3.writeInt(1);
               var12.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            var7 = (ay)var9;
            if(var2.readInt() != 0) {
               var7 = ay.CREATOR.c(var2);
            }

            this.a(var7);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(en.a.v(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(er.a.z(var2.readStrongBinder()), var2.readString());
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            String var11 = this.getMediationAdapterClassName();
            var3.writeNoException();
            var3.writeString(var11);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
            this.a(br.a.j(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.client.IAdManager");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements bd {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(ay param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(bc param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(bf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(br param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(en param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(er param1, String param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public boolean a(av param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.dynamic.d ab() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(1, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public ay ac() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         ay var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
               this.le.transact(12, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = ay.CREATOR.c(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public void an() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(11, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String getMediationAdapterClassName() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(18, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public boolean isReady() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(3, var3, var4, 0);
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

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void resume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void showInterstitial() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(9, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void stopLoading() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
            this.le.transact(10, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
