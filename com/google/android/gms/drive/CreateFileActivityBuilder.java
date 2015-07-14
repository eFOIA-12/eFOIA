package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.s;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;

public class CreateFileActivityBuilder {
   public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
   private final com.google.android.gms.drive.internal.i Ol = new com.google.android.gms.drive.internal.i(0);
   private DriveContents Om;
   private boolean On;

   public IntentSender build(GoogleApiClient var1) {
      jx.b((Object)Boolean.valueOf(this.On), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
      boolean var2;
      if(!var1.a(Drive.SCOPE_FILE) && !var1.a(Drive.Oo)) {
         var2 = false;
      } else {
         var2 = true;
      }

      jx.b(var2, "The apiClient must have suitable scope to create files");
      if(this.Om != null) {
         lh.a(this.Om.getParcelFileDescriptor());
         this.Om.is();
      }

      return this.Ol.build(var1);
   }

   public CreateFileActivityBuilder setActivityStartFolder(DriveId var1) {
      this.Ol.a(var1);
      return this;
   }

   public CreateFileActivityBuilder setActivityTitle(String var1) {
      this.Ol.bl(var1);
      return this;
   }

   public CreateFileActivityBuilder setInitialDriveContents(DriveContents var1) {
      if(var1 != null) {
         if(!(var1 instanceof s)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
         }

         if(var1.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
         }

         if(var1.it()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
         }

         this.Ol.bq(var1.ir().getRequestId());
         this.Om = var1;
      } else {
         this.Ol.bq(1);
      }

      this.On = true;
      return this;
   }

   public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet var1) {
      this.Ol.a(var1);
      return this;
   }
}
