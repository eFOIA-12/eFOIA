package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Query;

public interface DriveFolder extends DriveResource {
   String MIME_TYPE = "application/vnd.google-apps.folder";

   PendingResult createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3);

   PendingResult createFile(GoogleApiClient var1, MetadataChangeSet var2, DriveContents var3, ExecutionOptions var4);

   PendingResult createFolder(GoogleApiClient var1, MetadataChangeSet var2);

   PendingResult listChildren(GoogleApiClient var1);

   PendingResult queryChildren(GoogleApiClient var1, Query var2);

   public interface DriveFileResult extends Result {
      DriveFile getDriveFile();
   }

   public interface DriveFolderResult extends Result {
      DriveFolder getDriveFolder();
   }
}
