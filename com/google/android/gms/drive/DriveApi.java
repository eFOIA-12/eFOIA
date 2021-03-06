package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public interface DriveApi {
   PendingResult cancelPendingActions(GoogleApiClient var1, List var2);

   PendingResult fetchDriveId(GoogleApiClient var1, String var2);

   DriveFolder getAppFolder(GoogleApiClient var1);

   DriveFile getFile(GoogleApiClient var1, DriveId var2);

   DriveFolder getFolder(GoogleApiClient var1, DriveId var2);

   DriveFolder getRootFolder(GoogleApiClient var1);

   CreateFileActivityBuilder newCreateFileActivityBuilder();

   PendingResult newDriveContents(GoogleApiClient var1);

   OpenFileActivityBuilder newOpenFileActivityBuilder();

   PendingResult query(GoogleApiClient var1, Query var2);

   PendingResult requestSync(GoogleApiClient var1);

   public interface DriveContentsResult extends Result {
      DriveContents getDriveContents();
   }

   public interface DriveIdResult extends Result {
      DriveId getDriveId();
   }

   public interface MetadataBufferResult extends Result {
      MetadataBuffer getMetadataBuffer();
   }
}
