package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.c;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.s;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.y;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SearchableField;

public class v extends y implements DriveFolder {
   public v(DriveId var1) {
      super(var1);
   }

   private PendingResult a(final GoogleApiClient var1, final MetadataChangeSet var2, final int var3, final int var4, final ExecutionOptions var5) {
      ExecutionOptions.a(var1, var5);
      return var1.b(new v.d(var1) {
         protected void a(r var1) throws RemoteException {
            var2.iz().setContext(var1.getContext());
            CreateFileRequest var2x = new CreateFileRequest(v.this.getDriveId(), var2.iz(), var3, var4, var5);
            var1.iG().a((CreateFileRequest)var2x, new v.a(this));
         }
      });
   }

   private PendingResult a(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
      int var5;
      if(var3 != null) {
         if(!(var3 instanceof s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
         }

         if(var3.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
         }

         if(var3.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
         }

         var5 = var3.ir().getRequestId();
         var3.is();
      } else {
         var5 = 1;
      }

      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if("application/vnd.google-apps.folder".equals(var2.getMimeType())) {
         throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
      } else {
         return this.a(var1, var2, var5, 0, var4);
      }
   }

   public PendingResult createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3) {
      return this.createFile(var1, var2, var3, (ExecutionOptions)null);
   }

   public PendingResult createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4) {
      ExecutionOptions var5 = var4;
      if(var4 == null) {
         var5 = (new ExecutionOptions.Builder()).build();
      }

      if(var5.ix() != 0) {
         throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
      } else {
         return this.a(var1, var2, var3, var5);
      }
   }

   public PendingResult createFolder(final GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      } else if(var2.getMimeType() != null && !var2.getMimeType().equals("application/vnd.google-apps.folder")) {
         throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
      } else {
         return var1.b(new v.f(var1) {
            protected void a(r var1) throws RemoteException {
               var2.iz().setContext(var1.getContext());
               var1.iG().a((CreateFolderRequest)(new CreateFolderRequest(v.this.getDriveId(), var2.iz())), new v.b(this));
            }
         });
      }
   }

   public PendingResult listChildren(GoogleApiClient var1) {
      return this.queryChildren(var1, (Query)null);
   }

   public PendingResult queryChildren(GoogleApiClient var1, Query var2) {
      Query.Builder var3 = (new Query.Builder()).addFilter(Filters.in(SearchableField.PARENTS, this.getDriveId()));
      if(var2 != null) {
         if(var2.getFilter() != null) {
            var3.addFilter(var2.getFilter());
         }

         var3.setPageToken(var2.getPageToken());
         var3.setSortOrder(var2.getSortOrder());
      }

      return (new p()).query(var1, var3.build());
   }

   private static class a extends c {
      private final BaseImplementation.b Ea;

      public a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnDriveIdResponse var1) throws RemoteException {
         this.Ea.b(new v.c(Status.Kw, new t(var1.getDriveId())));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new v.c(var1, (DriveFile)null));
      }
   }

   private static class b extends c {
      private final BaseImplementation.b Ea;

      public b(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnDriveIdResponse var1) throws RemoteException {
         this.Ea.b(new v.e(Status.Kw, new v(var1.getDriveId())));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new v.e(var1, (DriveFolder)null));
      }
   }

   private static class c implements DriveFolder.DriveFileResult {
      private final Status Eb;
      private final DriveFile Qn;

      public c(Status var1, DriveFile var2) {
         this.Eb = var1;
         this.Qn = var2;
      }

      public DriveFile getDriveFile() {
         return this.Qn;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   abstract static class d extends q {
      d(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.r(var1);
      }

      public DriveFolder.DriveFileResult r(Status var1) {
         return new v.c(var1, (DriveFile)null);
      }
   }

   private static class e implements DriveFolder.DriveFolderResult {
      private final Status Eb;
      private final DriveFolder Qo;

      public e(Status var1, DriveFolder var2) {
         this.Eb = var1;
         this.Qo = var2;
      }

      public DriveFolder getDriveFolder() {
         return this.Qo;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   abstract static class f extends q {
      f(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.s(var1);
      }

      public DriveFolder.DriveFolderResult s(Status var1) {
         return new v.e(var1, (DriveFolder)null);
      }
   }
}
