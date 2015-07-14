package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;

public interface c extends IInterface {
   void d(d var1) throws RemoteException;

   void e(d var1) throws RemoteException;

   Bundle getArguments() throws RemoteException;

   int getId() throws RemoteException;

   boolean getRetainInstance() throws RemoteException;

   String getTag() throws RemoteException;

   int getTargetRequestCode() throws RemoteException;

   boolean getUserVisibleHint() throws RemoteException;

   d getView() throws RemoteException;

   boolean isAdded() throws RemoteException;

   boolean isDetached() throws RemoteException;

   boolean isHidden() throws RemoteException;

   boolean isInLayout() throws RemoteException;

   boolean isRemoving() throws RemoteException;

   boolean isResumed() throws RemoteException;

   boolean isVisible() throws RemoteException;

   d jf() throws RemoteException;

   c jg() throws RemoteException;

   d jh() throws RemoteException;

   c ji() throws RemoteException;

   void setHasOptionsMenu(boolean var1) throws RemoteException;

   void setMenuVisibility(boolean var1) throws RemoteException;

   void setRetainInstance(boolean var1) throws RemoteException;

   void setUserVisibleHint(boolean var1) throws RemoteException;

   void startActivity(Intent var1) throws RemoteException;

   void startActivityForResult(Intent var1, int var2) throws RemoteException;

   public abstract static class a extends Binder implements c {
      public a() {
         this.attachInterface(this, "com.google.android.gms.dynamic.IFragmentWrapper");
      }

      public static c ao(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return (c)(var1 != null && var1 instanceof c?(c)var1:new c.a(var0));
         }
      }

      public IBinder asBinder() {
         return this;
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         d var18 = null;
         Object var19 = null;
         Object var20 = null;
         Object var21 = null;
         Object var22 = null;
         Object var23 = null;
         Intent var17 = null;
         byte var6 = 0;
         byte var7 = 0;
         byte var8 = 0;
         byte var9 = 0;
         byte var10 = 0;
         byte var11 = 0;
         byte var12 = 0;
         boolean var13 = false;
         boolean var14 = false;
         boolean var15 = false;
         boolean var16 = false;
         byte var5 = 0;
         byte var24;
         IBinder var25;
         d var28;
         c var29;
         switch(var1) {
         case 2:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var18 = this.jf();
            var3.writeNoException();
            var25 = var17;
            if(var18 != null) {
               var25 = var18.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            Bundle var27 = this.getArguments();
            var3.writeNoException();
            if(var27 != null) {
               var3.writeInt(1);
               var27.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var1 = this.getId();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var29 = this.jg();
            var3.writeNoException();
            var25 = var18;
            if(var29 != null) {
               var25 = var29.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var28 = this.jh();
            var3.writeNoException();
            var25 = (IBinder)var19;
            if(var28 != null) {
               var25 = var28.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.getRetainInstance();
            var3.writeNoException();
            if(var13) {
               var24 = 1;
            } else {
               var24 = 0;
            }

            var3.writeInt(var24);
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            String var26 = this.getTag();
            var3.writeNoException();
            var3.writeString(var26);
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var29 = this.ji();
            var3.writeNoException();
            var25 = (IBinder)var20;
            if(var29 != null) {
               var25 = var29.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var1 = this.getTargetRequestCode();
            var3.writeNoException();
            var3.writeInt(var1);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.getUserVisibleHint();
            var3.writeNoException();
            var24 = var5;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var28 = this.getView();
            var3.writeNoException();
            var25 = (IBinder)var21;
            if(var28 != null) {
               var25 = var28.asBinder();
            }

            var3.writeStrongBinder(var25);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isAdded();
            var3.writeNoException();
            var24 = var6;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isDetached();
            var3.writeNoException();
            var24 = var7;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isHidden();
            var3.writeNoException();
            var24 = var8;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isInLayout();
            var3.writeNoException();
            var24 = var9;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isRemoving();
            var3.writeNoException();
            var24 = var10;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isResumed();
            var3.writeNoException();
            var24 = var11;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = this.isVisible();
            var3.writeNoException();
            var24 = var12;
            if(var13) {
               var24 = 1;
            }

            var3.writeInt(var24);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            this.d(d.a.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if(var2.readInt() != 0) {
               var13 = true;
            }

            this.setHasOptionsMenu(var13);
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = var14;
            if(var2.readInt() != 0) {
               var13 = true;
            }

            this.setMenuVisibility(var13);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = var15;
            if(var2.readInt() != 0) {
               var13 = true;
            }

            this.setRetainInstance(var13);
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var13 = var16;
            if(var2.readInt() != 0) {
               var13 = true;
            }

            this.setUserVisibleHint(var13);
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var17 = (Intent)var22;
            if(var2.readInt() != 0) {
               var17 = (Intent)Intent.CREATOR.createFromParcel(var2);
            }

            this.startActivity(var17);
            var3.writeNoException();
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            var17 = (Intent)var23;
            if(var2.readInt() != 0) {
               var17 = (Intent)Intent.CREATOR.createFromParcel(var2);
            }

            this.startActivityForResult(var17, var2.readInt());
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            this.e(d.a.ap(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.dynamic.IFragmentWrapper");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements c {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void d(d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(d param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public Bundle getArguments() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();
         boolean var5 = false;

         Bundle var1;
         label36: {
            try {
               var5 = true;
               var2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
               this.le.transact(3, var2, var3, 0);
               var3.readException();
               if(var3.readInt() != 0) {
                  var1 = (Bundle)Bundle.CREATOR.createFromParcel(var3);
                  var5 = false;
                  break label36;
               }

               var5 = false;
            } finally {
               if(var5) {
                  var3.recycle();
                  var2.recycle();
               }
            }

            var1 = null;
         }

         var3.recycle();
         var2.recycle();
         return var1;
      }

      public int getId() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(4, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean getRetainInstance() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(7, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public String getTag() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         String var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(8, var1, var2, 0);
            var2.readException();
            var3 = var2.readString();
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public int getTargetRequestCode() throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         int var1;
         try {
            var2.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(10, var2, var3, 0);
            var3.readException();
            var1 = var3.readInt();
         } finally {
            var3.recycle();
            var2.recycle();
         }

         return var1;
      }

      public boolean getUserVisibleHint() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(11, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public d getView() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(12, var1, var2, 0);
            var2.readException();
            var3 = d.a.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public boolean isAdded() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(13, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isDetached() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(14, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isHidden() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(15, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isInLayout() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(16, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isRemoving() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(17, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isResumed() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(18, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public boolean isVisible() throws RemoteException {
         boolean var2 = false;
         Parcel var3 = Parcel.obtain();
         Parcel var4 = Parcel.obtain();
         boolean var7 = false;

         int var1;
         try {
            var7 = true;
            var3.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(19, var3, var4, 0);
            var4.readException();
            var1 = var4.readInt();
            var7 = false;
         } finally {
            if(var7) {
               var4.recycle();
               var3.recycle();
            }
         }

         if(var1 != 0) {
            var2 = true;
         }

         var4.recycle();
         var3.recycle();
         return var2;
      }

      public d jf() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(2, var1, var2, 0);
            var2.readException();
            var3 = d.a.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public c jg() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         c var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(5, var1, var2, 0);
            var2.readException();
            var3 = c.a.ao(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public d jh() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         d var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(6, var1, var2, 0);
            var2.readException();
            var3 = d.a.ap(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public c ji() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         c var3;
         try {
            var1.writeInterfaceToken("com.google.android.gms.dynamic.IFragmentWrapper");
            this.le.transact(9, var1, var2, 0);
            var2.readException();
            var3 = c.a.ao(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var3;
      }

      public void setHasOptionsMenu(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setMenuVisibility(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setRetainInstance(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setUserVisibleHint(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void startActivity(Intent param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void startActivityForResult(Intent param1, int param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
