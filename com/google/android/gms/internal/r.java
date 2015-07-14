package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface r extends IInterface {
   Bundle a(String var1, Bundle var2) throws RemoteException;

   Bundle a(String var1, String var2, Bundle var3) throws RemoteException;

   AccountChangeEventsResponse a(AccountChangeEventsRequest var1) throws RemoteException;

   public abstract static class a extends Binder implements r {
      public static r a(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            return (r)(var1 != null && var1 instanceof r?(r)var1:new r.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var6 = null;
         String var7 = null;
         Bundle var5 = null;
         Bundle var9;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.auth.IAuthManagerService");
            var6 = var2.readString();
            var7 = var2.readString();
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            var9 = this.a(var6, var7, var5);
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 2:
            var2.enforceInterface("com.google.android.auth.IAuthManagerService");
            var7 = var2.readString();
            var5 = var6;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            }

            var9 = this.a(var7, var5);
            var3.writeNoException();
            if(var9 != null) {
               var3.writeInt(1);
               var9.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 3:
            var2.enforceInterface("com.google.android.auth.IAuthManagerService");
            AccountChangeEventsRequest var10 = var7;
            if(var2.readInt() != 0) {
               var10 = AccountChangeEventsRequest.CREATOR.createFromParcel(var2);
            }

            AccountChangeEventsResponse var8 = this.a(var10);
            var3.writeNoException();
            if(var8 != null) {
               var3.writeInt(1);
               var8.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 1598968902:
            var3.writeString("com.google.android.auth.IAuthManagerService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements r {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public Bundle a(String param1, Bundle param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Bundle a(String param1, String param2, Bundle param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public AccountChangeEventsResponse a(AccountChangeEventsRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
