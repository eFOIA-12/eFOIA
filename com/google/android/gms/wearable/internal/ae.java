package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public interface ae extends IInterface {
   void a(ai var1) throws RemoteException;

   void a(al var1) throws RemoteException;

   void aa(DataHolder var1) throws RemoteException;

   void b(al var1) throws RemoteException;

   public abstract static class a extends Binder implements ae {
      public a() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
      }

      public static ae bY(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (ae)(var1 != null && var1 instanceof ae?(ae)var1:new ae.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var8 = null;
         Object var5 = null;
         al var9;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            DataHolder var11 = (DataHolder)var5;
            if(var2.readInt() != 0) {
               var11 = DataHolder.CREATOR.B(var2);
            }

            this.aa(var11);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            ai var10 = (ai)var6;
            if(var2.readInt() != 0) {
               var10 = (ai)ai.CREATOR.createFromParcel(var2);
            }

            this.a(var10);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            var9 = (al)var7;
            if(var2.readInt() != 0) {
               var9 = (al)al.CREATOR.createFromParcel(var2);
            }

            this.a(var9);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
            var9 = (al)var8;
            if(var2.readInt() != 0) {
               var9 = (al)al.CREATOR.createFromParcel(var2);
            }

            this.b(var9);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ae {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(ai param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(al param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void aa(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(al param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
