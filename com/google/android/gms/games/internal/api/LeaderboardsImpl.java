package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {
   public Intent getAllLeaderboardsIntent(GoogleApiClient var1) {
      return Games.d(var1).ll();
   }

   public Intent getLeaderboardIntent(GoogleApiClient var1, String var2) {
      return this.getLeaderboardIntent(var1, var2, -1);
   }

   public Intent getLeaderboardIntent(GoogleApiClient var1, String var2, int var3) {
      return Games.d(var1).n(var2, var3);
   }

   public PendingResult loadCurrentPlayerLeaderboardScore(final GoogleApiClient var1, final String var2, final int var3, final int var4) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadPlayerScoreImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, (String)null, var2, var3, var4);
         }
      }));
   }

   public PendingResult loadLeaderboardMetadata(final GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadMetadataImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, var2, var3);
         }
      }));
   }

   public PendingResult loadLeaderboardMetadata(final GoogleApiClient var1, final boolean var2) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadMetadataImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, var2);
         }
      }));
   }

   public PendingResult loadMoreScores(final GoogleApiClient var1, final LeaderboardScoreBuffer var2, final int var3, final int var4) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3, var4);
         }
      }));
   }

   public PendingResult loadPlayerCenteredScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadPlayerCenteredScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult loadPlayerCenteredScores(final GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, var2, var3, var4, var5, var6);
         }
      }));
   }

   public PendingResult loadTopScores(GoogleApiClient var1, String var2, int var3, int var4, int var5) {
      return this.loadTopScores(var1, var2, var3, var4, var5, false);
   }

   public PendingResult loadTopScores(final GoogleApiClient var1, final String var2, final int var3, final int var4, final int var5, final boolean var6) {
      return var1.a((BaseImplementation.a)(new LeaderboardsImpl.LoadScoresImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3, var4, var5, var6);
         }
      }));
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3) {
      this.submitScore(var1, var2, var3, (String)null);
   }

   public void submitScore(GoogleApiClient var1, String var2, long var3, String var5) {
      Games.d(var1).a((BaseImplementation.b)null, var2, var3, var5);
   }

   public PendingResult submitScoreImmediate(GoogleApiClient var1, String var2, long var3) {
      return this.submitScoreImmediate(var1, var2, var3, (String)null);
   }

   public PendingResult submitScoreImmediate(final GoogleApiClient var1, final String var2, final long var3, final String var5) {
      return var1.b(new LeaderboardsImpl.SubmitScoreImpl(var1) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3, var5);
         }
      });
   }

   private abstract static class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl {
      private LoadMetadataImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMetadataImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Leaderboards.LeaderboardMetadataResult U(final Status var1) {
         return new Leaderboards.LeaderboardMetadataResult() {
            public LeaderboardBuffer getLeaderboards() {
               return new LeaderboardBuffer(DataHolder.av(14));
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
         return this.U(var1);
      }
   }

   private abstract static class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl {
      private LoadPlayerScoreImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadPlayerScoreImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Leaderboards.LoadPlayerScoreResult V(final Status var1) {
         return new Leaderboards.LoadPlayerScoreResult() {
            public LeaderboardScore getScore() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.V(var1);
      }
   }

   private abstract static class LoadScoresImpl extends Games.BaseGamesApiMethodImpl {
      private LoadScoresImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadScoresImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Leaderboards.LoadScoresResult W(final Status var1) {
         return new Leaderboards.LoadScoresResult() {
            public Leaderboard getLeaderboard() {
               return null;
            }

            public LeaderboardScoreBuffer getScores() {
               return new LeaderboardScoreBuffer(DataHolder.av(14));
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
         return this.W(var1);
      }
   }

   protected abstract static class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl {
      protected SubmitScoreImpl(GoogleApiClient var1) {
         super(var1);
      }

      public Leaderboards.SubmitScoreResult X(final Status var1) {
         return new Leaderboards.SubmitScoreResult() {
            public ScoreSubmissionData getScoreData() {
               return new ScoreSubmissionData(DataHolder.av(14));
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
         return this.X(var1);
      }
   }
}
