package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.nk;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

public class nb implements ActivityRecognitionApi {
   public PendingResult removeActivityUpdates(final GoogleApiClient var1, final PendingIntent var2) {
      return var1.b(new nb.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.a(var2);
            this.b(Status.Kw);
         }
      });
   }

   public PendingResult requestActivityUpdates(final GoogleApiClient var1, final long var2, final PendingIntent var4) {
      return var1.b(new nb.a(var1) {
         protected void a(nk var1) throws RemoteException {
            var1.a(var2, var4);
            this.b(Status.Kw);
         }
      });
   }

   private abstract static class a extends ActivityRecognition.a {
      public a(GoogleApiClient var1) {
         super(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }
}
