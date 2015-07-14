package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnDrivePreferencesResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnLoadRealtimeResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.OnResourceIdSetResponse;
import com.google.android.gms.drive.internal.OnStorageStatsResponse;
import com.google.android.gms.drive.internal.OnSyncMoreResponse;

public interface af extends IInterface {
   void a(OnContentsResponse var1) throws RemoteException;

   void a(OnDeviceUsagePreferenceResponse var1) throws RemoteException;

   void a(OnDownloadProgressResponse var1) throws RemoteException;

   void a(OnDriveIdResponse var1) throws RemoteException;

   void a(OnDrivePreferencesResponse var1) throws RemoteException;

   void a(OnListEntriesResponse var1) throws RemoteException;

   void a(OnListParentsResponse var1) throws RemoteException;

   void a(OnLoadRealtimeResponse var1, com.google.android.gms.drive.realtime.internal.m var2) throws RemoteException;

   void a(OnMetadataResponse var1) throws RemoteException;

   void a(OnResourceIdSetResponse var1) throws RemoteException;

   void a(OnStorageStatsResponse var1) throws RemoteException;

   void a(OnSyncMoreResponse var1) throws RemoteException;

   void n(Status var1) throws RemoteException;

   void onSuccess() throws RemoteException;

   public abstract static class a extends Binder implements af {
      public a() {
         this.attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      }

      public static af Y(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (af)(var1 != null && var1 instanceof af?(af)var1:new af.a(var0));
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
         Object var17 = null;
         OnDownloadProgressResponse var5 = null;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            if(var2.readInt() != 0) {
               var5 = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var5);
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnListEntriesResponse var29 = (OnListEntriesResponse)var6;
            if(var2.readInt() != 0) {
               var29 = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var29);
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnDriveIdResponse var28 = (OnDriveIdResponse)var7;
            if(var2.readInt() != 0) {
               var28 = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var28);
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnMetadataResponse var27 = (OnMetadataResponse)var8;
            if(var2.readInt() != 0) {
               var27 = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var27);
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnContentsResponse var26 = (OnContentsResponse)var9;
            if(var2.readInt() != 0) {
               var26 = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var26);
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            Status var25 = (Status)var10;
            if(var2.readInt() != 0) {
               var25 = Status.CREATOR.createFromParcel(var2);
            }

            this.n(var25);
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            this.onSuccess();
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnListParentsResponse var24 = (OnListParentsResponse)var11;
            if(var2.readInt() != 0) {
               var24 = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var24);
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnSyncMoreResponse var23 = (OnSyncMoreResponse)var12;
            if(var2.readInt() != 0) {
               var23 = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var23);
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnStorageStatsResponse var22 = (OnStorageStatsResponse)var13;
            if(var2.readInt() != 0) {
               var22 = (OnStorageStatsResponse)OnStorageStatsResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var22);
            var3.writeNoException();
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnLoadRealtimeResponse var21 = (OnLoadRealtimeResponse)var14;
            if(var2.readInt() != 0) {
               var21 = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var21, com.google.android.gms.drive.realtime.internal.m.al(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnResourceIdSetResponse var20 = (OnResourceIdSetResponse)var15;
            if(var2.readInt() != 0) {
               var20 = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var20);
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnDrivePreferencesResponse var19 = (OnDrivePreferencesResponse)var16;
            if(var2.readInt() != 0) {
               var19 = (OnDrivePreferencesResponse)OnDrivePreferencesResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var19);
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            OnDeviceUsagePreferenceResponse var18 = (OnDeviceUsagePreferenceResponse)var17;
            if(var2.readInt() != 0) {
               var18 = (OnDeviceUsagePreferenceResponse)OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(var2);
            }

            this.a(var18);
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class a implements af {
      private IBinder le;

      a(IBinder var1) {
         this.le = var1;
      }

      public void a(OnContentsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnDeviceUsagePreferenceResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnDownloadProgressResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnDriveIdResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnDrivePreferencesResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnListEntriesResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnListParentsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnLoadRealtimeResponse param1, com.google.android.gms.drive.realtime.internal.m param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnMetadataResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnResourceIdSetResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnStorageStatsResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OnSyncMoreResponse param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void n(Status param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onSuccess() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            this.le.transact(7, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
