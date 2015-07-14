package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.Set;

public interface DriveResource {
   PendingResult addChangeListener(GoogleApiClient var1, ChangeListener var2);

   PendingResult addChangeSubscription(GoogleApiClient var1);

   DriveId getDriveId();

   PendingResult getMetadata(GoogleApiClient var1);

   PendingResult listParents(GoogleApiClient var1);

   PendingResult removeChangeListener(GoogleApiClient var1, ChangeListener var2);

   PendingResult removeChangeSubscription(GoogleApiClient var1);

   PendingResult setParents(GoogleApiClient var1, Set var2);

   PendingResult updateMetadata(GoogleApiClient var1, MetadataChangeSet var2);

   public interface MetadataResult extends Result {
      Metadata getMetadata();
   }
}
