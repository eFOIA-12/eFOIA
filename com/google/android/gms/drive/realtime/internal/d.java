package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

public interface d extends IInterface {
   void a(ParcelableCollaborator var1) throws RemoteException;

   void b(ParcelableCollaborator var1) throws RemoteException;

   public abstract static class a extends Binder implements d {
      public static d ac(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            return (d)(var1 != null && var1 instanceof d?(d)var1:new d.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         ParcelableCollaborator var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            if(var2.readInt() != 0) {
               var5 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
            var5 = (ParcelableCollaborator)var6;
            if(var2.readInt() != 0) {
               var5 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
            }

            this.b(var5);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
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

      public void a(ParcelableCollaborator param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(ParcelableCollaborator param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
