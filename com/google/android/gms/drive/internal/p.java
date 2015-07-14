package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.af;
import com.google.android.gms.drive.internal.bg;
import com.google.android.gms.drive.internal.c;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.s;
import com.google.android.gms.drive.internal.t;
import com.google.android.gms.drive.internal.v;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class p implements DriveApi {
   public PendingResult a(final GoogleApiClient var1, final int var2) {
      return var1.a((BaseImplementation.a)(new p.b(var1) {
         protected void a(r var1) throws RemoteException {
            var1.iG().a((CreateContentsRequest)(new CreateContentsRequest(var2)), new p.h(this));
         }
      }));
   }

   public PendingResult cancelPendingActions(GoogleApiClient var1, List var2) {
      return ((r)var1.a(Drive.DQ)).cancelPendingActions(var1, var2);
   }

   public PendingResult fetchDriveId(final GoogleApiClient var1, final String var2) {
      return var1.a((BaseImplementation.a)(new p.e(var1) {
         protected void a(r var1) throws RemoteException {
            var1.iG().a((GetMetadataRequest)(new GetMetadataRequest(DriveId.bi(var2))), new p.c(this));
         }
      }));
   }

   public DriveFolder getAppFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         DriveId var2 = ((r)var1.a(Drive.DQ)).iI();
         return var2 != null?new v(var2):null;
      }
   }

   public DriveFile getFile(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new t(var2);
      }
   }

   public DriveFolder getFolder(GoogleApiClient var1, DriveId var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Id must be provided.");
      } else if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new v(var2);
      }
   }

   public DriveFolder getRootFolder(GoogleApiClient var1) {
      if(!var1.isConnected()) {
         throw new IllegalStateException("Client must be connected");
      } else {
         return new v(((r)var1.a(Drive.DQ)).iH());
      }
   }

   public CreateFileActivityBuilder newCreateFileActivityBuilder() {
      return new CreateFileActivityBuilder();
   }

   public PendingResult newDriveContents(GoogleApiClient var1) {
      return this.a(var1, 536870912);
   }

   public OpenFileActivityBuilder newOpenFileActivityBuilder() {
      return new OpenFileActivityBuilder();
   }

   public PendingResult query(final GoogleApiClient var1, final Query var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("Query must be provided.");
      } else {
         return var1.a((BaseImplementation.a)(new p.g(var1) {
            protected void a(r var1) throws RemoteException {
               var1.iG().a((QueryRequest)(new QueryRequest(var2)), new p.i(this));
            }
         }));
      }
   }

   public PendingResult requestSync(final GoogleApiClient var1) {
      return var1.b(new q.a(var1) {
         protected void a(r var1) throws RemoteException {
            var1.iG().a((af)(new bg(this)));
         }
      });
   }

   static class a implements DriveApi.DriveContentsResult {
      private final Status Eb;
      private final DriveContents Om;

      public a(Status var1, DriveContents var2) {
         this.Eb = var1;
         this.Om = var2;
      }

      public DriveContents getDriveContents() {
         return this.Om;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   abstract static class b extends q {
      b(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.o(var1);
      }

      public DriveApi.DriveContentsResult o(Status var1) {
         return new p.a(var1, (DriveContents)null);
      }
   }

   static class c extends c {
      private final BaseImplementation.b Ea;

      public c(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnDriveIdResponse var1) throws RemoteException {
         this.Ea.b(new p.d(Status.Kw, var1.getDriveId()));
      }

      public void a(OnMetadataResponse var1) throws RemoteException {
         this.Ea.b(new p.d(Status.Kw, (new m(var1.iU())).getDriveId()));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new p.d(var1, (DriveId)null));
      }
   }

   private static class d implements DriveApi.DriveIdResult {
      private final Status Eb;
      private final DriveId Oj;

      public d(Status var1, DriveId var2) {
         this.Eb = var1;
         this.Oj = var2;
      }

      public DriveId getDriveId() {
         return this.Oj;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   abstract static class e extends q {
      e(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.p(var1);
      }

      public DriveApi.DriveIdResult p(Status var1) {
         return new p.d(var1, (DriveId)null);
      }
   }

   static class f implements DriveApi.MetadataBufferResult {
      private final Status Eb;
      private final MetadataBuffer PI;
      private final boolean PJ;

      public f(Status var1, MetadataBuffer var2, boolean var3) {
         this.Eb = var1;
         this.PI = var2;
         this.PJ = var3;
      }

      public MetadataBuffer getMetadataBuffer() {
         return this.PI;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   abstract static class g extends q {
      g(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.q(var1);
      }

      public DriveApi.MetadataBufferResult q(Status var1) {
         return new p.f(var1, (MetadataBuffer)null, false);
      }
   }

   private static class h extends c {
      private final BaseImplementation.b Ea;

      public h(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnContentsResponse var1) throws RemoteException {
         this.Ea.b(new p.a(Status.Kw, new s(var1.iL())));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new p.a(var1, (DriveContents)null));
      }
   }

   private static class i extends c {
      private final BaseImplementation.b Ea;

      public i(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnListEntriesResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.iR(), (String)null);
         this.Ea.b(new p.f(Status.Kw, var2, var1.iS()));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new p.f(var1, (MetadataBuffer)null, false));
      }
   }

   static class j extends q.a {
      j(GoogleApiClient var1, Status var2) {
         super(var1);
         this.b(var2);
      }

      protected void a(r var1) {
      }
   }
}
