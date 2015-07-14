package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.az;
import com.google.android.gms.drive.internal.bg;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.jx;
import java.io.InputStream;
import java.io.OutputStream;

public class s implements DriveContents {
   private final Contents PW;
   private boolean PX = false;
   private boolean PY = false;
   private boolean mClosed = false;

   public s(Contents var1) {
      this.PW = (Contents)jx.i(var1);
   }

   public PendingResult commit(GoogleApiClient var1, MetadataChangeSet var2) {
      return this.commit(var1, var2, (ExecutionOptions)null);
   }

   public PendingResult commit(final GoogleApiClient var1, final MetadataChangeSet var2, ExecutionOptions var3) {
      final ExecutionOptions var4 = var3;
      if(var3 == null) {
         var4 = (new ExecutionOptions.Builder()).build();
      }

      if(this.PW.getMode() == 268435456) {
         throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
      } else if(ExecutionOptions.ba(var4.ix()) && !this.PW.ip()) {
         throw new IllegalStateException("DriveContents must be valid for conflict detection.");
      } else {
         ExecutionOptions.a(var1, var4);
         if(this.it()) {
            throw new IllegalStateException("DriveContents already closed.");
         } else if(this.getDriveId() == null) {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
         } else {
            if(var2 == null) {
               var2 = MetadataChangeSet.OE;
            }

            this.is();
            return var1.b(new q.a(var1) {
               protected void a(r var1) throws RemoteException {
                  var2.iz().setContext(var1.getContext());
                  var1.iG().a((CloseContentsAndUpdateMetadataRequest)(new CloseContentsAndUpdateMetadataRequest(s.this.PW.getDriveId(), var2.iz(), s.this.PW, var4)), new bg(this));
               }
            });
         }
      }
   }

   public void discard(final GoogleApiClient var1) {
      if(this.it()) {
         throw new IllegalStateException("DriveContents already closed.");
      } else {
         this.is();
         ((<undefinedtype>)var1.b(new q.a(var1) {
            protected void a(r var1) throws RemoteException {
               var1.iG().a((CloseContentsRequest)(new CloseContentsRequest(s.this.PW, false)), new bg(this));
            }
         })).setResultCallback(new ResultCallback() {
            public void j(Status var1) {
               if(!var1.isSuccess()) {
                  w.p("DriveContentsImpl", "Error discarding contents");
               } else {
                  w.m("DriveContentsImpl", "Contents discarded");
               }
            }

            // $FF: synthetic method
            public void onResult(Result var1) {
               this.j((Status)var1);
            }
         });
      }
   }

   public DriveId getDriveId() {
      return this.PW.getDriveId();
   }

   public InputStream getInputStream() {
      if(this.it()) {
         throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
      } else if(this.PW.getMode() != 268435456) {
         throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
      } else if(this.PX) {
         throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
      } else {
         this.PX = true;
         return this.PW.getInputStream();
      }
   }

   public int getMode() {
      return this.PW.getMode();
   }

   public OutputStream getOutputStream() {
      if(this.it()) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else if(this.PW.getMode() != 536870912) {
         throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
      } else if(this.PY) {
         throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
      } else {
         this.PY = true;
         return this.PW.getOutputStream();
      }
   }

   public ParcelFileDescriptor getParcelFileDescriptor() {
      if(this.it()) {
         throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
      } else {
         return this.PW.getParcelFileDescriptor();
      }
   }

   public Contents ir() {
      return this.PW;
   }

   public void is() {
      this.mClosed = true;
   }

   public boolean it() {
      return this.mClosed;
   }

   public PendingResult reopenForWrite(final GoogleApiClient var1) {
      if(this.it()) {
         throw new IllegalStateException("DriveContents already closed.");
      } else if(this.PW.getMode() != 268435456) {
         throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
      } else {
         this.is();
         return var1.a((BaseImplementation.a)(new p.b(var1) {
            protected void a(r var1) throws RemoteException {
               var1.iG().a((OpenContentsRequest)(new OpenContentsRequest(s.this.getDriveId(), 536870912, s.this.PW.getRequestId())), new az(this, (DriveFile.DownloadProgressListener)null));
            }
         }));
      }
   }
}
