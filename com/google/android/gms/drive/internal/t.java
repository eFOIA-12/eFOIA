package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.az;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.y;

public class t extends y implements DriveFile {
   public t(DriveId var1) {
      super(var1);
   }

   private static DriveFile.DownloadProgressListener a(GoogleApiClient var0, DriveFile.DownloadProgressListener var1) {
      return var1 == null?null:new t.a(var0.d(var1));
   }

   public PendingResult open(final GoogleApiClient var1, final int var2, DriveFile.DownloadProgressListener var3) {
      if(var2 != 268435456 && var2 != 536870912 && var2 != 805306368) {
         throw new IllegalArgumentException("Invalid mode provided.");
      } else {
         return var1.a((BaseImplementation.a)(new p.b(var1) {
            // $FF: synthetic field
            final DriveFile.DownloadProgressListener Qc;

            {
               this.Qc = var4;
            }

            protected void a(r var1) throws RemoteException {
               var1.iG().a((OpenContentsRequest)(new OpenContentsRequest(t.this.getDriveId(), var2, 0)), new az(this, this.Qc));
            }
         }));
      }
   }

   private static class a implements DriveFile.DownloadProgressListener {
      private final com.google.android.gms.common.api.d Qe;

      public a(com.google.android.gms.common.api.d var1) {
         this.Qe = var1;
      }

      public void onProgress(final long var1, final long var3) {
         this.Qe.a(new com.google.android.gms.common.api.d() {
            public void a(DriveFile.DownloadProgressListener var1x) {
               var1x.onProgress(var1, var3);
            }

            // $FF: synthetic method
            public void c(Object var1x) {
               this.a((DriveFile.DownloadProgressListener)var1x);
            }

            public void gG() {
            }
         });
      }
   }
}
