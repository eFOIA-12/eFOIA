package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {
   public Player getCurrentPlayer(GoogleApiClient var1) {
      return Games.d(var1).lj();
   }

   public String getCurrentPlayerId(GoogleApiClient var1) {
      return Games.d(var1).li();
   }

   public Intent getPlayerSearchIntent(GoogleApiClient var1) {
      return Games.d(var1).lt();
   }

   public PendingResult loadConnectedPlayers(final GoogleApiClient var1, final boolean var2) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2);
         }
      }));
   }

   public PendingResult loadInvitablePlayers(final GoogleApiClient var1, final int var2, final boolean var3) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, false, var3);
         }
      }));
   }

   public PendingResult loadMoreInvitablePlayers(final GoogleApiClient var1, final int var2) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, true, false);
         }
      }));
   }

   public PendingResult loadMoreRecentlyPlayedWithPlayers(final GoogleApiClient var1, final int var2) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, "played_with", var2, true, false);
         }
      }));
   }

   public PendingResult loadPlayer(final GoogleApiClient var1, final String var2) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, false);
         }
      }));
   }

   public PendingResult loadPlayer(final GoogleApiClient var1, final String var2, final boolean var3) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3);
         }
      }));
   }

   public PendingResult loadRecentlyPlayedWithPlayers(final GoogleApiClient var1, final int var2, final boolean var3) {
      return var1.a((BaseImplementation.a)(new PlayersImpl.LoadPlayersImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, "played_with", var2, false, var3);
         }
      }));
   }

   private abstract static class LoadOwnerCoverPhotoUrisImpl extends Games.BaseGamesApiMethodImpl {
      public Players.LoadOwnerCoverPhotoUrisResult ac(final Status var1) {
         return new Players.LoadOwnerCoverPhotoUrisResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ac(var1);
      }
   }

   private abstract static class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl {
      private LoadPlayersImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadPlayersImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Players.LoadPlayersResult ad(final Status var1) {
         return new Players.LoadPlayersResult() {
            public PlayerBuffer getPlayers() {
               return new PlayerBuffer(DataHolder.av(14));
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
         return this.ad(var1);
      }
   }

   private abstract static class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl {
      protected Players.LoadProfileSettingsResult ae(final Status var1) {
         return new Players.LoadProfileSettingsResult() {
            public Status getStatus() {
               return var1;
            }

            public boolean isProfileVisible() {
               return true;
            }

            public boolean isVisibilityExplicitlySet() {
               return false;
            }
         };
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.ae(var1);
      }
   }

   private abstract static class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl {
      public Players.LoadXpForGameCategoriesResult af(final Status var1) {
         return new Players.LoadXpForGameCategoriesResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.af(var1);
      }
   }

   private abstract static class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl {
      public Players.LoadXpStreamResult ag(final Status var1) {
         return new Players.LoadXpStreamResult() {
            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ag(var1);
      }
   }

   private abstract static class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl {
      protected Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      protected Result c(Status var1) {
         return this.b(var1);
      }
   }
}
