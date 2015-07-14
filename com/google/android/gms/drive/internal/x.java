package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.FileUploadPreferencesImpl;
import com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.bg;
import com.google.android.gms.drive.internal.c;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.drive.internal.r;

public class x implements DrivePreferencesApi {
   public PendingResult getFileUploadPreferences(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new x.c(var1) {
         protected void a(r var1) throws RemoteException {
            var1.iG().h(x.this.new a(this, null));
         }
      }));
   }

   public PendingResult setFileUploadPreferences(final GoogleApiClient var1, FileUploadPreferences var2) {
      if(!(var2 instanceof FileUploadPreferencesImpl)) {
         throw new IllegalArgumentException("Invalid preference value");
      } else {
         return var1.b(new q.a(var1) {
            // $FF: synthetic field
            final FileUploadPreferencesImpl Qr;

            {
               this.Qr = var3;
            }

            protected void a(r var1) throws RemoteException {
               var1.iG().a((SetFileUploadPreferencesRequest)(new SetFileUploadPreferencesRequest(this.Qr)), new bg(this));
            }
         });
      }
   }

   private class a extends c {
      private final BaseImplementation.b Ea;

      private a(BaseImplementation.b var2) {
         this.Ea = var2;
      }

      // $FF: synthetic method
      a(BaseImplementation.b var2, Object var3) {
         this();
      }

      public void a(OnDeviceUsagePreferenceResponse var1) throws RemoteException {
         this.Ea.b(x.this.new b(Status.Kw, var1.iN(), null));
      }

      public void n(Status var1) throws RemoteException {
         this.Ea.b(x.this.new b(var1, (FileUploadPreferences)null, null));
      }
   }

   private class b implements DrivePreferencesApi.FileUploadPreferencesResult {
      private final Status Eb;
      private final FileUploadPreferences Qs;

      private b(Status var2, FileUploadPreferences var3) {
         this.Eb = var2;
         this.Qs = var3;
      }

      // $FF: synthetic method
      b(Status var2, FileUploadPreferences var3, Object var4) {
         this();
      }

      public FileUploadPreferences getFileUploadPreferences() {
         return this.Qs;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private abstract class c extends q {
      public c(GoogleApiClient var2) {
         super(var2);
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.t(var1);
      }

      protected DrivePreferencesApi.FileUploadPreferencesResult t(Status var1) {
         return x.this.new b(var1, (FileUploadPreferences)null, null);
      }
   }
}
