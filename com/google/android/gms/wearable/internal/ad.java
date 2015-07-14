package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ab;
import com.google.android.gms.wearable.internal.ap;
import com.google.android.gms.wearable.internal.at;
import com.google.android.gms.wearable.internal.aw;
import com.google.android.gms.wearable.internal.p;
import com.google.android.gms.wearable.internal.r;
import com.google.android.gms.wearable.internal.t;
import com.google.android.gms.wearable.internal.v;
import com.google.android.gms.wearable.internal.x;
import com.google.android.gms.wearable.internal.z;

public interface ad extends IInterface {
   void a(Status var1) throws RemoteException;

   void a(ab var1) throws RemoteException;

   void a(ap var1) throws RemoteException;

   void a(at var1) throws RemoteException;

   void a(aw var1) throws RemoteException;

   void a(p var1) throws RemoteException;

   void a(r var1) throws RemoteException;

   void a(t var1) throws RemoteException;

   void a(v var1) throws RemoteException;

   void a(x var1) throws RemoteException;

   void a(z var1) throws RemoteException;

   void ab(DataHolder var1) throws RemoteException;

   public abstract static class a extends Binder implements ad {
      public a() {
         this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
      }

      public static ad bX(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (ad)(var1 != null && var1 instanceof ad?(ad)var1:new ad.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         Object var6 = null;
         Object var7 = null;
         Object var8 = null;
         Object var9 = null;
         Object var10 = null;
         Object var11 = null;
         Object var12 = null;
         Object var13 = null;
         Object var14 = null;
         Object var15 = null;
         Object var16 = null;
         r var5 = null;
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            if(var2.readInt() != 0) {
               var5 = (r)r.CREATOR.createFromParcel(var2);
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            ap var27 = (ap)var7;
            if(var2.readInt() != 0) {
               var27 = (ap)ap.CREATOR.createFromParcel(var2);
            }

            this.a(var27);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            x var26 = (x)var8;
            if(var2.readInt() != 0) {
               var26 = (x)x.CREATOR.createFromParcel(var2);
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            DataHolder var25 = (DataHolder)var9;
            if(var2.readInt() != 0) {
               var25 = DataHolder.CREATOR.B(var2);
            }

            this.ab(var25);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            p var24 = (p)var10;
            if(var2.readInt() != 0) {
               var24 = (p)p.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            at var23 = (at)var11;
            if(var2.readInt() != 0) {
               var23 = (at)at.CREATOR.createFromParcel(var2);
            }

            this.a(var23);
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            z var22 = (z)var12;
            if(var2.readInt() != 0) {
               var22 = (z)z.CREATOR.createFromParcel(var2);
            }

            this.a(var22);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            ab var21 = (ab)var13;
            if(var2.readInt() != 0) {
               var21 = (ab)ab.CREATOR.createFromParcel(var2);
            }

            this.a(var21);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            v var20 = (v)var14;
            if(var2.readInt() != 0) {
               var20 = (v)v.CREATOR.createFromParcel(var2);
            }

            this.a(var20);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            Status var19 = (Status)var15;
            if(var2.readInt() != 0) {
               var19 = Status.CREATOR.createFromParcel(var2);
            }

            this.a(var19);
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            aw var18 = (aw)var16;
            if(var2.readInt() != 0) {
               var18 = (aw)aw.CREATOR.createFromParcel(var2);
            }

            this.a(var18);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            t var17 = (t)var6;
            if(var2.readInt() != 0) {
               var17 = (t)t.CREATOR.createFromParcel(var2);
            }

            this.a(var17);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ad {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ab param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ap param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(at param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(aw param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(p param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(r param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(t param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(v param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(x param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(z param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void ab(DataHolder param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
