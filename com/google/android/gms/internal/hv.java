package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.hl;

public interface hv extends IInterface {
   void a(Status var1) throws RemoteException;

   void a(Status var1, ParcelFileDescriptor var2) throws RemoteException;

   void a(Status var1, boolean var2) throws RemoteException;

   void a(hl.b var1) throws RemoteException;

   public abstract static class a extends Binder implements hv {
      public a() {
         this.attachInterface(this, "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
      }

      public static hv F(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return (hv)(var1 != null && var1 instanceof hv?(hv)var1:new hv.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         ParcelFileDescriptor var6 = null;
         Object var8 = null;
         Object var9 = null;
         Object var7 = null;
         Status var11;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            var11 = (Status)var7;
            if(var2.readInt() != 0) {
               var11 = Status.CREATOR.createFromParcel(var2);
            }

            this.a(var11);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            if(var2.readInt() != 0) {
               var11 = Status.CREATOR.createFromParcel(var2);
            } else {
               var11 = null;
            }

            if(var2.readInt() != 0) {
               var6 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(var2);
            }

            this.a(var11, var6);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            var11 = (Status)var8;
            if(var2.readInt() != 0) {
               var11 = Status.CREATOR.createFromParcel(var2);
            }

            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.a(var11, var5);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            hl.b var10 = (hl.b)var9;
            if(var2.readInt() != 0) {
               var10 = hl.b.CREATOR.q(var2);
            }

            this.a(var10);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearchCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements hv {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(Status param1, ParcelFileDescriptor param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(Status param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(hl.b param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
