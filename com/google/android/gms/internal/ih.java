package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.if;

public interface ih extends IInterface {
   void a(int var1, String var2, PendingIntent var3) throws RemoteException;

   void a(if var1) throws RemoteException;

   public abstract static class a extends Binder implements ih {
      public a() {
         this.attachInterface(this, "com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
      }

      public static ih K(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return (ih)(var1 != null && var1 instanceof ih?(ih)var1:new ih.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         PendingIntent var5 = null;
         String var6 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            if var7 = var6;
            if(var2.readInt() != 0) {
               var7 = if.CREATOR.t(var2);
            }

            this.a(var7);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            var1 = var2.readInt();
            var6 = var2.readString();
            if(var2.readInt() != 0) {
               var5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(var2);
            }

            this.a(var1, var6, var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.auth.api.IGoogleAuthApiCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ih {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(int param1, String param2, PendingIntent param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(if param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
