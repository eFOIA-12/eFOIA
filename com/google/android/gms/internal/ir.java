package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.io;

public interface ir extends IInterface {
   void a(ApplicationMetadata var1, String var2, String var3, boolean var4) throws RemoteException;

   void a(String var1, double var2, boolean var4) throws RemoteException;

   void a(String var1, long var2) throws RemoteException;

   void a(String var1, long var2, int var4) throws RemoteException;

   void ad(int var1) throws RemoteException;

   void ae(int var1) throws RemoteException;

   void af(int var1) throws RemoteException;

   void ag(int var1) throws RemoteException;

   void b(ij var1) throws RemoteException;

   void b(io var1) throws RemoteException;

   void b(String var1, byte[] var2) throws RemoteException;

   void j(String var1, String var2) throws RemoteException;

   void onApplicationDisconnected(int var1) throws RemoteException;

   public abstract static class a extends Binder implements ir {
      public a() {
         this.attachInterface(this, "com.google.android.gms.cast.internal.ICastDeviceControllerListener");
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         boolean var8 = false;
         boolean var7 = false;
         String var10 = null;
         Object var11 = null;
         String var9 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ad(var2.readInt());
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            ApplicationMetadata var15 = var9;
            if(var2.readInt() != 0) {
               var15 = (ApplicationMetadata)ApplicationMetadata.CREATOR.createFromParcel(var2);
            }

            var9 = var2.readString();
            var10 = var2.readString();
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var15, var9, var10, var7);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ae(var2.readInt());
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            String var14 = var2.readString();
            double var5 = var2.readDouble();
            var7 = var8;
            if(var2.readInt() != 0) {
               var7 = true;
            }

            this.a(var14, var5, var7);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.j(var2.readString(), var2.readString());
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.b(var2.readString(), var2.createByteArray());
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.ag(var2.readInt());
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.af(var2.readInt());
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.onApplicationDisconnected(var2.readInt());
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.a(var2.readString(), var2.readLong(), var2.readInt());
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            this.a(var2.readString(), var2.readLong());
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            ij var13 = var10;
            if(var2.readInt() != 0) {
               var13 = (ij)ij.CREATOR.createFromParcel(var2);
            }

            this.b(var13);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            io var12 = (io)var11;
            if(var2.readInt() != 0) {
               var12 = (io)io.CREATOR.createFromParcel(var2);
            }

            this.b(var12);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }
}
