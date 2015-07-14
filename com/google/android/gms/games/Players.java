package com.google.android.gms.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;

public interface Players {
   String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";

   Player getCurrentPlayer(GoogleApiClient var1);

   String getCurrentPlayerId(GoogleApiClient var1);

   Intent getPlayerSearchIntent(GoogleApiClient var1);

   PendingResult loadConnectedPlayers(GoogleApiClient var1, boolean var2);

   PendingResult loadInvitablePlayers(GoogleApiClient var1, int var2, boolean var3);

   PendingResult loadMoreInvitablePlayers(GoogleApiClient var1, int var2);

   PendingResult loadMoreRecentlyPlayedWithPlayers(GoogleApiClient var1, int var2);

   PendingResult loadPlayer(GoogleApiClient var1, String var2);

   PendingResult loadPlayer(GoogleApiClient var1, String var2, boolean var3);

   PendingResult loadRecentlyPlayedWithPlayers(GoogleApiClient var1, int var2, boolean var3);

   public interface LoadOwnerCoverPhotoUrisResult extends Result {
   }

   public interface LoadPlayersResult extends Releasable, Result {
      PlayerBuffer getPlayers();
   }

   public interface LoadProfileSettingsResult extends Result {
      boolean isProfileVisible();

      boolean isVisibilityExplicitlySet();
   }

   public interface LoadXpForGameCategoriesResult extends Result {
   }

   public interface LoadXpForGamesResult extends Result {
   }

   public interface LoadXpStreamResult extends Result {
   }
}
