package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;

public final class LeaderboardVariantRef extends d implements LeaderboardVariant {
   LeaderboardVariantRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public boolean equals(Object var1) {
      return LeaderboardVariantEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mN();
   }

   public int getCollection() {
      return this.getInteger("collection");
   }

   public String getDisplayPlayerRank() {
      return this.getString("player_display_rank");
   }

   public String getDisplayPlayerScore() {
      return this.getString("player_display_score");
   }

   public long getNumScores() {
      return this.aS("total_scores")?-1L:this.getLong("total_scores");
   }

   public long getPlayerRank() {
      return this.aS("player_rank")?-1L:this.getLong("player_rank");
   }

   public String getPlayerScoreTag() {
      return this.getString("player_score_tag");
   }

   public long getRawPlayerScore() {
      return this.aS("player_raw_score")?-1L:this.getLong("player_raw_score");
   }

   public int getTimeSpan() {
      return this.getInteger("timespan");
   }

   public boolean hasPlayerInfo() {
      return !this.aS("player_raw_score");
   }

   public int hashCode() {
      return LeaderboardVariantEntity.a(this);
   }

   public String mK() {
      return this.getString("top_page_token_next");
   }

   public String mL() {
      return this.getString("window_page_token_prev");
   }

   public String mM() {
      return this.getString("window_page_token_next");
   }

   public LeaderboardVariant mN() {
      return new LeaderboardVariantEntity(this);
   }

   public String toString() {
      return LeaderboardVariantEntity.b(this);
   }
}
