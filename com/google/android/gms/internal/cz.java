package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.av;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.da;

public interface cz extends IInterface {
   void a(com.google.android.gms.dynamic.d var1, av var2, String var3, da var4) throws RemoteException;

   void a(com.google.android.gms.dynamic.d var1, av var2, String var3, String var4, da var5) throws RemoteException;

   void a(com.google.android.gms.dynamic.d var1, ay var2, av var3, String var4, da var5) throws RemoteException;

   void a(com.google.android.gms.dynamic.d var1, ay var2, av var3, String var4, String var5, da var6) throws RemoteException;

   void destroy() throws RemoteException;

   com.google.android.gms.dynamic.d getView() throws RemoteException;

   void pause() throws RemoteException;

   void resume() throws RemoteException;

   void showInterstitial() throws RemoteException;

   public abstract static class a extends Binder implements cz {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      }

      public static cz o(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (cz)(var1 != null && var1 instanceof cz?(cz)var1:new cz.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var6 = null;
         av var5 = null;
         com.google.android.gms.dynamic.d var7;
         ay var9;
         av var10;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var9 = ay.CREATOR.c(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var10 = av.CREATOR.b(var2);
            } else {
               var10 = null;
            }

            this.a(var7, var9, var10, var2.readString(), da.a.p(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            var6 = this.getView();
            var3.writeNoException();
            IBinder var8 = var5;
            if(var6 != null) {
               var8 = var6.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            var5 = var6;
            if(var2.readInt() != 0) {
               var5 = av.CREATOR.b(var2);
            }

            this.a(var7, var5, var2.readString(), da.a.p(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.showInterstitial();
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.destroy();
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            var7 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var9 = ay.CREATOR.c(var2);
            } else {
               var9 = null;
            }

            if(var2.readInt() != 0) {
               var10 = av.CREATOR.b(var2);
            } else {
               var10 = null;
            }

            this.a(var7, var9, var10, var2.readString(), var2.readString(), da.a.p(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            var6 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
            if(var2.readInt() != 0) {
               var5 = av.CREATOR.b(var2);
            } else {
               var5 = null;
            }

            this.a(var6, var5, var2.readString(), var2.readString(), da.a.p(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.pause();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.resume();
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements cz {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(com.google.android.gms.dynamic.d param1, av param2, String param3, da param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.dynamic.d param1, av param2, String param3, String param4, da param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.dynamic.d param1, ay param2, av param3, String param4, da param5) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(com.google.android.gms.dynamic.d param1, ay param2, av param3, String param4, String param5, da param6) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void destroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public com.google.android.gms.dynamic.d getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.dynamic.d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = com.google.android.gms.dynamic.d.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void pause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.le.transact(8, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.le.transact(9, var1, var2, 0);
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
            var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            this.le.transact(4, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
