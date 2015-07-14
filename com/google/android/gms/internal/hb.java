package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ha;
import java.util.List;
import java.util.Map;

public interface hb extends IInterface {
   void a(Map var1, long var2, String var4, List var5) throws RemoteException;

   void dQ() throws RemoteException;

   String getVersion() throws RemoteException;

   public abstract static class a extends Binder implements hb {
      public static hb D(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            return (hb)(var1 != null && var1 instanceof hb?(hb)var1:new hb.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.a(var2.readHashMap(this.getClass().getClassLoader()), var2.readLong(), var2.readString(), var2.createTypedArrayList(ha.CREATOR));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.dQ();
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
            String var5 = this.getVersion();
            var3.writeNoException();
            var3.writeString(var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements hb {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(Map var1, long var2, String var4, List var5) throws RemoteException {
         Parcel var6 = Parcel.obtain();
         Parcel var7 = Parcel.obtain();

         try {
            var6.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            var6.writeMap(var1);
            var6.writeLong(var2);
            var6.writeString(var4);
            var6.writeTypedList(var5);
            this.le.transact(1, var6, var7, 0);
            var7.readException();
         } finally {
            var7.recycle();
            var6.recycle();
         }

      }

      public IBinder asBinder() {
         return this.le;
      }

      public void dQ() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public String getVersion() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
            this.le.transact(3, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }
   }
}
