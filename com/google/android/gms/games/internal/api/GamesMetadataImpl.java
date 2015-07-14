package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {
   public Game getCurrentGame(GoogleApiClient var1) {
      return Games.d(var1).lk();
   }

   public PendingResult loadGame(final GoogleApiClient var1) {
      return var1.a((BaseImplementation.a)(new GamesMetadataImpl.LoadGamesImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.f(this);
         }
      }));
   }

   private abstract static class LoadExtendedGamesImpl extends Games.BaseGamesApiMethodImpl {
      public GamesMetadata.LoadExtendedGamesResult P(final Status var1) {
         return new GamesMetadata.LoadExtendedGamesResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.P(var1);
      }
   }

   private abstract static class LoadGameInstancesImpl extends Games.BaseGamesApiMethodImpl {
      public GamesMetadata.LoadGameInstancesResult Q(final Status var1) {
         return new GamesMetadata.LoadGameInstancesResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.Q(var1);
      }
   }

   private abstract static class LoadGameSearchSuggestionsImpl extends Games.BaseGamesApiMethodImpl {
      public GamesMetadata.LoadGameSearchSuggestionsResult R(final Status var1) {
         return new GamesMetadata.LoadGameSearchSuggestionsResult() {
            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.R(var1);
      }
   }

   private abstract static class LoadGamesImpl extends Games.BaseGamesApiMethodImpl {
      private LoadGamesImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadGamesImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public GamesMetadata.LoadGamesResult S(final Status var1) {
         return new GamesMetadata.LoadGamesResult() {
            public GameBuffer getGames() {
               return new GameBuffer(DataHolder.av(14));
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
         return this.S(var1);
      }
   }
}
