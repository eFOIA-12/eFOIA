package com.google.android.gms.games.leaderboard;

import android.os.Bundle;

public final class LeaderboardScoreBufferHeader {
   private final Bundle DJ;

   public LeaderboardScoreBufferHeader(Bundle var1) {
      Bundle var2 = var1;
      if(var1 == null) {
         var2 = new Bundle();
      }

      this.DJ = var2;
   }

   public Bundle mI() {
      return this.DJ;
   }

   public static final class Builder {
   }
}
