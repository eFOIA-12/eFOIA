package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.c;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.s;

class az extends c {
   private final BaseImplementation.b Ea;
   private final DriveFile.DownloadProgressListener QU;

   az(BaseImplementation.b var1, DriveFile.DownloadProgressListener var2) {
      this.Ea = var1;
      this.QU = var2;
   }

   public void a(OnContentsResponse var1) throws RemoteException {
      Status var2;
      if(var1.iM()) {
         var2 = new Status(-1);
      } else {
         var2 = Status.Kw;
      }

      this.Ea.b(new p.a(var2, new s(var1.iL())));
   }

   public void a(OnDownloadProgressResponse var1) throws RemoteException {
      if(this.QU != null) {
         this.QU.onProgress(var1.iO(), var1.iP());
      }

   }

   public void n(Status var1) throws RemoteException {
      this.Ea.b(new p.a(var1, (DriveContents)null));
   }
}
