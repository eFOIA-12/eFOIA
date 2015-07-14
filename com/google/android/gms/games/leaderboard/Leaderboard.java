package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

public interface Leaderboard extends Freezable {
   int SCORE_ORDER_LARGER_IS_BETTER = 1;
   int SCORE_ORDER_SMALLER_IS_BETTER = 0;

   String getDisplayName();

   void getDisplayName(CharArrayBuffer var1);

   Game getGame();

   Uri getIconImageUri();

   @Deprecated
   String getIconImageUrl();

   String getLeaderboardId();

   int getScoreOrder();

   ArrayList getVariants();
}
