package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.oj;

public interface ok extends IInterface {
   void a(oj var1, Uri var2, Bundle var3, boolean var4) throws RemoteException;

   public abstract static class a extends Binder implements ok {
      public static ok bG(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            return (ok)(var1 != null && var1 instanceof ok?(ok)var1:new ok.a(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            oj var7 = oj.a.bF(var2.readStrongBinder());
            Uri var8;
            if(var2.readInt() != 0) {
               var8 = (Uri)Uri.CREATOR.createFromParcel(var2);
            } else {
               var8 = null;
            }

            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            boolean var5;
            if(var2.readInt() != 0) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.a(var7, var8, var6, var5);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements ok {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(oj param1, Uri param2, Bundle param3, boolean param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }
   }
}
