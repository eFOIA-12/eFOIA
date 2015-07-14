package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.hl;
import com.google.android.gms.internal.hr;
import com.google.android.gms.internal.hv;

public interface hu extends IInterface {
   void a(hl.a var1, hv var2) throws RemoteException;

   void a(hv var1) throws RemoteException;

   void a(hv var1, String var2, hr[] var3) throws RemoteException;

   void a(hv var1, boolean var2) throws RemoteException;

   void b(hv var1) throws RemoteException;

   public abstract static class a extends Binder implements hu {
      public static hu E(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (hu)(var1 != null && var1 instanceof hu?(hu)var1:new hu.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(hv.a.F(var2.readStrongBinder()), var2.readString(), (hr[])var2.createTypedArray(hr.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.a(hv.a.F(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            this.b(hv.a.F(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            hv var7 = hv.a.F(var2.readStrongBinder());
            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.a(var7, var5);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            hl.a var6;
            if(var2.readInt() != 0) {
               var6 = hl.a.CREATOR.p(var2);
            } else {
               var6 = null;
            }

            this.a(var6, hv.a.F(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements hu {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(hl.a param1, hv param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(hv param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(hv param1, String param2, hr[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(hv param1, boolean param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(hv param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
