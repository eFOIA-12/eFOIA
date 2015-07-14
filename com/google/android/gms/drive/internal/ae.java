package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;
import com.google.android.gms.drive.internal.CancelPendingActionsRequest;
import com.google.android.gms.drive.internal.CheckResourceIdsExistRequest;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.DeleteResourceRequest;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.LoadRealtimeRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.SetDrivePreferencesRequest;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.drive.internal.ag;

public interface ae extends IInterface {
   IntentSender a(CreateFileIntentSenderRequest var1) throws RemoteException;

   IntentSender a(OpenFileIntentSenderRequest var1) throws RemoteException;

   void a(RealtimeDocumentSyncRequest var1, af var2) throws RemoteException;

   void a(AddEventListenerRequest var1, ag var2, String var3, af var4) throws RemoteException;

   void a(AuthorizeAccessRequest var1, af var2) throws RemoteException;

   void a(CancelPendingActionsRequest var1, af var2) throws RemoteException;

   void a(CheckResourceIdsExistRequest var1, af var2) throws RemoteException;

   void a(CloseContentsAndUpdateMetadataRequest var1, af var2) throws RemoteException;

   void a(CloseContentsRequest var1, af var2) throws RemoteException;

   void a(CreateContentsRequest var1, af var2) throws RemoteException;

   void a(CreateFileRequest var1, af var2) throws RemoteException;

   void a(CreateFolderRequest var1, af var2) throws RemoteException;

   void a(DeleteResourceRequest var1, af var2) throws RemoteException;

   void a(DisconnectRequest var1) throws RemoteException;

   void a(GetDriveIdFromUniqueIdentifierRequest var1, af var2) throws RemoteException;

   void a(GetMetadataRequest var1, af var2) throws RemoteException;

   void a(ListParentsRequest var1, af var2) throws RemoteException;

   void a(LoadRealtimeRequest var1, af var2) throws RemoteException;

   void a(OpenContentsRequest var1, af var2) throws RemoteException;

   void a(QueryRequest var1, af var2) throws RemoteException;

   void a(RemoveEventListenerRequest var1, ag var2, String var3, af var4) throws RemoteException;

   void a(SetDrivePreferencesRequest var1, af var2) throws RemoteException;

   void a(SetFileUploadPreferencesRequest var1, af var2) throws RemoteException;

   void a(SetResourceParentsRequest var1, af var2) throws RemoteException;

   void a(TrashResourceRequest var1, af var2) throws RemoteException;

   void a(UpdateMetadataRequest var1, af var2) throws RemoteException;

   void a(af var1) throws RemoteException;

   void b(QueryRequest var1, af var2) throws RemoteException;

   void b(af var1) throws RemoteException;

   void c(af var1) throws RemoteException;

   void d(af var1) throws RemoteException;

   void e(af var1) throws RemoteException;

   void f(af var1) throws RemoteException;

   void g(af var1) throws RemoteException;

   void h(af var1) throws RemoteException;

   public abstract static class a extends Binder implements ae {
      public static ae X(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (ae)(var1 != null && var1 instanceof ae?(ae)var1:new ae.a(var0));
         }
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
         Object var18 = null;
         Object var19 = null;
         Object var20 = null;
         Object var21 = null;
         Object var22 = null;
         Object var23 = null;
         Object var24 = null;
         Object var25 = null;
         Object var26 = null;
         Object var27 = null;
         Object var28 = null;
         Object var29 = null;
         Object var30 = null;
         Object var31 = null;
         GetMetadataRequest var5 = null;
         IntentSender var32;
         QueryRequest var42;
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            if(var2.readInt() != 0) {
               var5 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var5, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            var42 = (QueryRequest)var6;
            if(var2.readInt() != 0) {
               var42 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var42, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            UpdateMetadataRequest var57 = (UpdateMetadataRequest)var7;
            if(var2.readInt() != 0) {
               var57 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var57, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CreateContentsRequest var56 = (CreateContentsRequest)var8;
            if(var2.readInt() != 0) {
               var56 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var56, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CreateFileRequest var55 = (CreateFileRequest)var9;
            if(var2.readInt() != 0) {
               var55 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var55, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CreateFolderRequest var54 = (CreateFolderRequest)var10;
            if(var2.readInt() != 0) {
               var54 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var54, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            OpenContentsRequest var53 = (OpenContentsRequest)var11;
            if(var2.readInt() != 0) {
               var53 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var53, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CloseContentsRequest var52 = (CloseContentsRequest)var12;
            if(var2.readInt() != 0) {
               var52 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var52, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.a(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            OpenFileIntentSenderRequest var51 = (OpenFileIntentSenderRequest)var13;
            if(var2.readInt() != 0) {
               var51 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            var32 = this.a(var51);
            var3.writeNoException();
            if(var32 != null) {
               var3.writeInt(1);
               var32.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CreateFileIntentSenderRequest var50 = (CreateFileIntentSenderRequest)var14;
            if(var2.readInt() != 0) {
               var50 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(var2);
            }

            var32 = this.a(var50);
            var3.writeNoException();
            if(var32 != null) {
               var3.writeInt(1);
               var32.writeToParcel(var3, 1);
            } else {
               var3.writeInt(0);
            }

            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            AuthorizeAccessRequest var49 = (AuthorizeAccessRequest)var15;
            if(var2.readInt() != 0) {
               var49 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var49, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            ListParentsRequest var48 = (ListParentsRequest)var16;
            if(var2.readInt() != 0) {
               var48 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var48, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            AddEventListenerRequest var47 = (AddEventListenerRequest)var17;
            if(var2.readInt() != 0) {
               var47 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var47, ag.a.Z(var2.readStrongBinder()), var2.readString(), af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            RemoveEventListenerRequest var46 = (RemoveEventListenerRequest)var18;
            if(var2.readInt() != 0) {
               var46 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var46, ag.a.Z(var2.readStrongBinder()), var2.readString(), af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            DisconnectRequest var45 = (DisconnectRequest)var19;
            if(var2.readInt() != 0) {
               var45 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var45);
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            TrashResourceRequest var44 = (TrashResourceRequest)var20;
            if(var2.readInt() != 0) {
               var44 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var44, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CloseContentsAndUpdateMetadataRequest var43 = (CloseContentsAndUpdateMetadataRequest)var21;
            if(var2.readInt() != 0) {
               var43 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var43, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            var42 = (QueryRequest)var22;
            if(var2.readInt() != 0) {
               var42 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(var2);
            }

            this.b(var42, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.b(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.c(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.d(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.e(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            DeleteResourceRequest var41 = (DeleteResourceRequest)var23;
            if(var2.readInt() != 0) {
               var41 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var41, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            LoadRealtimeRequest var40 = (LoadRealtimeRequest)var24;
            if(var2.readInt() != 0) {
               var40 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var40, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            SetResourceParentsRequest var39 = (SetResourceParentsRequest)var25;
            if(var2.readInt() != 0) {
               var39 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var39, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            GetDriveIdFromUniqueIdentifierRequest var38 = (GetDriveIdFromUniqueIdentifierRequest)var26;
            if(var2.readInt() != 0) {
               var38 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var38, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CheckResourceIdsExistRequest var37 = (CheckResourceIdsExistRequest)var27;
            if(var2.readInt() != 0) {
               var37 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var37, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.f(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.g(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            SetDrivePreferencesRequest var36 = (SetDrivePreferencesRequest)var28;
            if(var2.readInt() != 0) {
               var36 = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var36, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            RealtimeDocumentSyncRequest var35 = (RealtimeDocumentSyncRequest)var29;
            if(var2.readInt() != 0) {
               var35 = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var35, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            this.h(af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            SetFileUploadPreferencesRequest var34 = (SetFileUploadPreferencesRequest)var30;
            if(var2.readInt() != 0) {
               var34 = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var34, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            CancelPendingActionsRequest var33 = (CancelPendingActionsRequest)var31;
            if(var2.readInt() != 0) {
               var33 = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(var2);
            }

            this.a(var33, af.a.Y(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.drive.internal.IDriveService");
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

      public IntentSender a(CreateFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IntentSender a(OpenFileIntentSenderRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(RealtimeDocumentSyncRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(AddEventListenerRequest param1, ag param2, String param3, af param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(AuthorizeAccessRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CancelPendingActionsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CheckResourceIdsExistRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CloseContentsAndUpdateMetadataRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CloseContentsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CreateContentsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CreateFileRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(CreateFolderRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DeleteResourceRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(DisconnectRequest param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(GetDriveIdFromUniqueIdentifierRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(GetMetadataRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(ListParentsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(LoadRealtimeRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(OpenContentsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(QueryRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(RemoveEventListenerRequest param1, ag param2, String param3, af param4) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(SetDrivePreferencesRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(SetFileUploadPreferencesRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(SetResourceParentsRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(TrashResourceRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(UpdateMetadataRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void a(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.le;
      }

      public void b(QueryRequest param1, af param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void b(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void c(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void d(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void e(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void f(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void g(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void h(af param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }
   }
}
