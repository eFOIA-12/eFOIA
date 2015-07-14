package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.bg;
import com.google.android.gms.drive.internal.c;
import com.google.android.gms.drive.internal.m;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;
import java.util.List;
import java.util.Set;

public class y implements DriveResource {
   protected final DriveId Oj;

   protected y(DriveId var1) {
      this.Oj = var1;
   }

   public PendingResult addChangeListener(GoogleApiClient var1, ChangeListener var2) {
      return ((r)var1.a(Drive.DQ)).a(var1, this.Oj, 1, var2);
   }

   public PendingResult addChangeSubscription(GoogleApiClient var1) {
      return ((r)var1.a(Drive.DQ)).a(var1, this.Oj, 1);
   }

   public DriveId getDriveId() {
      return this.Oj;
   }

   public PendingResult getMetadata(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new y.d(var1, null) {
         protected void a(r var1) throws RemoteException {
            var1.iG().a((GetMetadataRequest)(new GetMetadataRequest(y.this.Oj)), new y.b(this));
         }
      }));
   }

   public PendingResult listParents(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new p.g(var1) {
         protected void a(r var1) throws RemoteException {
            var1.iG().a((ListParentsRequest)(new ListParentsRequest(y.this.Oj)), new y.a(this));
         }
      }));
   }

   public PendingResult removeChangeListener(GoogleApiClient var1, ChangeListener var2) {
      return ((r)var1.a(Drive.DQ)).b(var1, this.Oj, 1, var2);
   }

   public PendingResult removeChangeSubscription(GoogleApiClient var1) {
      return ((r)var1.a(Drive.DQ)).b(var1, this.Oj, 1);
   }

   public PendingResult setParents(final GoogleApiClient var1, Set var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("ParentIds must be provided.");
      } else if(var2.isEmpty()) {
         throw new IllegalArgumentException("ParentIds must contain at least one parent.");
      } else {
         return var1.b(new q.a(var1) {
            // $FF: synthetic field
            final List Qu;

            {
               this.Qu = var3;
            }

            protected void a(r var1) throws RemoteException {
               var1.iG().a((SetResourceParentsRequest)(new SetResourceParentsRequest(y.this.Oj, this.Qu)), new bg(this));
            }
         });
      }
   }

   public PendingResult updateMetadata(final GoogleApiClient var1, final MetadataChangeSet var2) {
      if(var2 == null) {
         throw new IllegalArgumentException("ChangeSet must be provided.");
      } else {
         return var1.b(new y.d(var1, null) {
            protected void a(r var1) throws RemoteException {
               var2.iz().setContext(var1.getContext());
               var1.iG().a((UpdateMetadataRequest)(new UpdateMetadataRequest(y.this.Oj, var2.iz())), new y.b(this));
            }
         });
      }
   }

   private static class a extends c {
      private final BaseImplementation.b Ea;

      public a(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnListParentsResponse var1) throws RemoteException {
         MetadataBuffer var2 = new MetadataBuffer(var1.iT(), (String)null);
         this.Ea.b(new p.f(Status.Kw, var2, false));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new p.f(var1, (MetadataBuffer)null, false));
      }
   }

   private static class b extends c {
      private final BaseImplementation.b Ea;

      public b(BaseImplementation.b var1) {
         this.Ea = var1;
      }

      public void a(OnMetadataResponse var1) throws RemoteException {
         this.Ea.b(new y.c(Status.Kw, new m(var1.iU())));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(new y.c(var1, (Metadata)null));
      }
   }

   private static class c implements DriveResource.MetadataResult {
      private final Status Eb;
      private final Metadata Qv;

      public c(Status var1, Metadata var2) {
         this.Eb = var1;
         this.Qv = var2;
      }

      public Metadata getMetadata() {
         return this.Qv;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private abstract class d extends q {
      private d(GoogleApiClient var2) {
         super(var2);
      }

      // $FF: synthetic method
      d(GoogleApiClient var2, Object var3) {
         this();
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.u(var1);
      }

      public DriveResource.MetadataResult u(Status var1) {
         return new y.c(var1, (Metadata)null);
      }
   }
}
