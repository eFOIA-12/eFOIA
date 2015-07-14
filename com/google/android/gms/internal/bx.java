package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface bx extends IInterface {
   void aw() throws RemoteException;

   String bB() throws RemoteException;

   com.google.android.gms.dynamic.d bC() throws RemoteException;

   String bE() throws RemoteException;

   com.google.android.gms.dynamic.d bI() throws RemoteException;

   String bJ() throws RemoteException;

   String getBody() throws RemoteException;

   void j(int var1) throws RemoteException;

   public abstract static class a extends Binder implements bx {
      public a() {
         this.attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         com.google.android.gms.dynamic.d var6 = null;
         com.google.android.gms.dynamic.d var5 = null;
         String var7;
         IBinder var8;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            this.j(var2.readInt());
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            this.aw();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var7 = this.bB();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var6 = this.bC();
            var3.writeNoException();
            var8 = var5;
            if(var6 != null) {
               var8 = var6.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var7 = this.getBody();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var5 = this.bI();
            var3.writeNoException();
            var8 = var6;
            if(var5 != null) {
               var8 = var5.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var7 = this.bE();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            var7 = this.bJ();
            var3.writeNoException();
            var3.writeString(var7);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
