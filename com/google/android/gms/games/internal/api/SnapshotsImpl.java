package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.Snapshots;

public final class SnapshotsImpl implements Snapshots {
   public PendingResult commitAndClose(final GoogleApiClient var1, final Snapshot var2, final SnapshotMetadataChange var3) {
      return var1.b(new SnapshotsImpl.CommitImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)this, (Snapshot)var2, (SnapshotMetadataChange)var3);
         }
      });
   }

   public PendingResult delete(final GoogleApiClient var1, final SnapshotMetadata var2) {
      return var1.b(new SnapshotsImpl.DeleteImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.i(this, var2.getSnapshotId());
         }
      });
   }

   public void discardAndClose(GoogleApiClient var1, Snapshot var2) {
      Games.d(var1).a(var2);
   }

   public int getMaxCoverImageSize(GoogleApiClient var1) {
      return Games.d(var1).lC();
   }

   public int getMaxDataSize(GoogleApiClient var1) {
      return Games.d(var1).lB();
   }

   public Intent getSelectSnapshotIntent(GoogleApiClient var1, String var2, boolean var3, boolean var4, int var5) {
      return Games.d(var1).a(var2, var3, var4, var5);
   }

   public SnapshotMetadata getSnapshotFromBundle(Bundle var1) {
      return var1 != null && var1.containsKey("com.google.android.gms.games.SNAPSHOT_METADATA")?(SnapshotMetadata)var1.getParcelable("com.google.android.gms.games.SNAPSHOT_METADATA"):null;
   }

   public PendingResult load(final GoogleApiClient var1, final boolean var2) {
      return var1.a((BaseImplementation.a)(new SnapshotsImpl.LoadImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.e(this, var2);
         }
      }));
   }

   public PendingResult open(GoogleApiClient var1, SnapshotMetadata var2) {
      return this.open(var1, var2.getUniqueName(), false);
   }

   public PendingResult open(final GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.b(new SnapshotsImpl.OpenImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.c(this, var2, var3);
         }
      });
   }

   public PendingResult resolveConflict(GoogleApiClient var1, String var2, Snapshot var3) {
      SnapshotMetadata var4 = var3.getMetadata();
      SnapshotMetadataChange var5 = (new SnapshotMetadataChange.Builder()).fromMetadata(var4).build();
      return this.resolveConflict(var1, var2, var4.getSnapshotId(), var5, var3.getSnapshotContents());
   }

   public PendingResult resolveConflict(final GoogleApiClient var1, final String var2, final String var3, final SnapshotMetadataChange var4, final SnapshotContents var5) {
      return var1.b(new SnapshotsImpl.OpenImpl(var1, null) {
         protected void a(GamesClientImpl var1) throws RemoteException {
            var1.a(this, var2, (String)var3, (SnapshotMetadataChange)var4, (SnapshotContents)var5);
         }
      });
   }

   private abstract static class CommitImpl extends Games.BaseGamesApiMethodImpl {
      private CommitImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      CommitImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Snapshots.CommitSnapshotResult ao(final Status var1) {
         return new Snapshots.CommitSnapshotResult() {
            public SnapshotMetadata getSnapshotMetadata() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ao(var1);
      }
   }

   private abstract static class DeleteImpl extends Games.BaseGamesApiMethodImpl {
      private DeleteImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      DeleteImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Snapshots.DeleteSnapshotResult ap(final Status var1) {
         return new Snapshots.DeleteSnapshotResult() {
            public String getSnapshotId() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ap(var1);
      }
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Snapshots.LoadSnapshotsResult aq(final Status var1) {
         return new Snapshots.LoadSnapshotsResult() {
            public SnapshotMetadataBuffer getSnapshots() {
               return new SnapshotMetadataBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.aq(var1);
      }
   }

   private abstract static class OpenImpl extends Games.BaseGamesApiMethodImpl {
      private OpenImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      OpenImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Snapshots.OpenSnapshotResult ar(final Status var1) {
         return new Snapshots.OpenSnapshotResult() {
            public String getConflictId() {
               return null;
            }

            public Snapshot getConflictingSnapshot() {
               return null;
            }

            public SnapshotContents getResolutionSnapshotContents() {
               return null;
            }

            public Snapshot getSnapshot() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ar(var1);
      }
   }
}
