package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardRef;

public final class LeaderboardBuffer extends g {
   public LeaderboardBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.j(var1, var2);
   }

   protected String ha() {
      return "external_leaderboard_id";
   }

   protected Leaderboard j(int var1, int var2) {
      return new LeaderboardRef(this.JG, var1, var2);
   }
}
