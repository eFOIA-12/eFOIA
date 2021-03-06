package com.google.android.gms.games.snapshot;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;

public interface Snapshots {
   int DISPLAY_LIMIT_NONE = -1;
   String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";
   String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";

   PendingResult commitAndClose(GoogleApiClient var1, Snapshot var2, SnapshotMetadataChange var3);

   PendingResult delete(GoogleApiClient var1, SnapshotMetadata var2);

   void discardAndClose(GoogleApiClient var1, Snapshot var2);

   int getMaxCoverImageSize(GoogleApiClient var1);

   int getMaxDataSize(GoogleApiClient var1);

   Intent getSelectSnapshotIntent(GoogleApiClient var1, String var2, boolean var3, boolean var4, int var5);

   SnapshotMetadata getSnapshotFromBundle(Bundle var1);

   PendingResult load(GoogleApiClient var1, boolean var2);

   PendingResult open(GoogleApiClient var1, SnapshotMetadata var2);

   PendingResult open(GoogleApiClient var1, String var2, boolean var3);

   PendingResult resolveConflict(GoogleApiClient var1, String var2, Snapshot var3);

   PendingResult resolveConflict(GoogleApiClient var1, String var2, String var3, SnapshotMetadataChange var4, SnapshotContents var5);

   public interface CommitSnapshotResult extends Result {
      SnapshotMetadata getSnapshotMetadata();
   }

   public interface DeleteSnapshotResult extends Result {
      String getSnapshotId();
   }

   public interface LoadSnapshotsResult extends Releasable, Result {
      SnapshotMetadataBuffer getSnapshots();
   }

   public interface OpenSnapshotResult extends Result {
      String getConflictId();

      Snapshot getConflictingSnapshot();

      SnapshotContents getResolutionSnapshotContents();

      Snapshot getSnapshot();
   }
}
