package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.ov;
import java.util.List;

public interface oq extends IInterface {
   void a(String var1, ov var2, or var3) throws RemoteException;

   void a(String var1, ov var2, List var3) throws RemoteException;

   void a(String var1, ov var2, byte[] var3) throws RemoteException;

   public abstract static class a extends Binder implements oq {
      public static oq bI(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (oq)(var1 != null && var1 instanceof oq?(oq)var1:new oq.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         String var6 = null;
         Object var7 = null;
         or var5 = null;
         ov var8;
         String var9;
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            var6 = var2.readString();
            if(var2.readInt() != 0) {
               var8 = ov.CREATOR.du(var2);
            } else {
               var8 = null;
            }

            if(var2.readInt() != 0) {
               var5 = or.CREATOR.dt(var2);
            }

            this.a(var6, var8, var5);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            var9 = var2.readString();
            var8 = var6;
            if(var2.readInt() != 0) {
               var8 = ov.CREATOR.du(var2);
            }

            this.a(var9, var8, var2.createTypedArrayList(or.CREATOR));
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            var9 = var2.readString();
            var8 = (ov)var7;
            if(var2.readInt() != 0) {
               var8 = ov.CREATOR.du(var2);
            }

            this.a(var9, var8, var2.createByteArray());
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements oq {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(String param1, ov param2, or param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, ov param2, List param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(String param1, ov param2, byte[] param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
