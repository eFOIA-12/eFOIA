package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface bw extends IInterface {
   void aw() throws RemoteException;

   String bB() throws RemoteException;

   com.google.android.gms.dynamic.d bC() throws RemoteException;

   com.google.android.gms.dynamic.d bD() throws RemoteException;

   String bE() throws RemoteException;

   double bF() throws RemoteException;

   String bG() throws RemoteException;

   String bH() throws RemoteException;

   String getBody() throws RemoteException;

   void j(int var1) throws RemoteException;

   public abstract static class a extends Binder implements bw {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var8 = null;
         com.google.android.gms.dynamic.d var7 = null;
         String var9;
         IBinder var10;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            this.j(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var9 = this.bB();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var8 = this.bC();
            var3.writeNoException();
            var10 = var7;
            if(var8 != null) {
               var10 = var8.asBinder();
            }

            var3.writeStrongBinder(var10);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var9 = this.getBody();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var7 = this.bD();
            var3.writeNoException();
            var10 = var8;
            if(var7 != null) {
               var10 = var7.asBinder();
            }

            var3.writeStrongBinder(var10);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var9 = this.bE();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            double var5 = this.bF();
            var3.writeNoException();
            var3.writeDouble(var5);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var9 = this.bG();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            var9 = this.bH();
            var3.writeNoException();
            var3.writeString(var9);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
