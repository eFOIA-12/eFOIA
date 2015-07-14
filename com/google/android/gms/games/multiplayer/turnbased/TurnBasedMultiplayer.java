package com.google.android.gms.games.multiplayer.turnbased;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import java.util.List;

public interface TurnBasedMultiplayer {
   PendingResult acceptInvitation(GoogleApiClient var1, String var2);

   PendingResult cancelMatch(GoogleApiClient var1, String var2);

   PendingResult createMatch(GoogleApiClient var1, TurnBasedMatchConfig var2);

   void declineInvitation(GoogleApiClient var1, String var2);

   void dismissInvitation(GoogleApiClient var1, String var2);

   void dismissMatch(GoogleApiClient var1, String var2);

   PendingResult finishMatch(GoogleApiClient var1, String var2);

   PendingResult finishMatch(GoogleApiClient var1, String var2, byte[] var3, List var4);

   PendingResult finishMatch(GoogleApiClient var1, String var2, byte[] var3, ParticipantResult... var4);

   Intent getInboxIntent(GoogleApiClient var1);

   int getMaxMatchDataSize(GoogleApiClient var1);

   Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3);

   Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4);

   PendingResult leaveMatch(GoogleApiClient var1, String var2);

   PendingResult leaveMatchDuringTurn(GoogleApiClient var1, String var2, String var3);

   PendingResult loadMatch(GoogleApiClient var1, String var2);

   PendingResult loadMatchesByStatus(GoogleApiClient var1, int var2, int[] var3);

   PendingResult loadMatchesByStatus(GoogleApiClient var1, int[] var2);

   void registerMatchUpdateListener(GoogleApiClient var1, OnTurnBasedMatchUpdateReceivedListener var2);

   PendingResult rematch(GoogleApiClient var1, String var2);

   PendingResult takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4);

   PendingResult takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4, List var5);

   PendingResult takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4, ParticipantResult... var5);

   void unregisterMatchUpdateListener(GoogleApiClient var1);

   public interface CancelMatchResult extends Result {
      String getMatchId();
   }

   public interface InitiateMatchResult extends Result {
      TurnBasedMatch getMatch();
   }

   public interface LeaveMatchResult extends Result {
      TurnBasedMatch getMatch();
   }

   public interface LoadMatchResult extends Result {
      TurnBasedMatch getMatch();
   }

   public interface LoadMatchesResult extends Releasable, Result {
      LoadMatchesResponse getMatches();
   }

   public interface UpdateMatchResult extends Result {
      TurnBasedMatch getMatch();
   }
}
