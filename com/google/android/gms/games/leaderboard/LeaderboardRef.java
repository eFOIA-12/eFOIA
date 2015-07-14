package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardVariantRef;
import java.util.ArrayList;

public final class LeaderboardRef extends d implements Leaderboard {
   private final int Ya;
   private final Game adq;

   LeaderboardRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.Ya = var3;
      this.adq = new GameRef(var1, var2);
   }

   public boolean equals(Object var1) {
      return LeaderboardEntity.a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mG();
   }

   public String getDisplayName() {
      return this.getString("name");
   }

   public void getDisplayName(CharArrayBuffer var1) {
      this.a("name", var1);
   }

   public Game getGame() {
      return this.adq;
   }

   public Uri getIconImageUri() {
      return this.aR("board_icon_image_uri");
   }

   public String getIconImageUrl() {
      return this.getString("board_icon_image_url");
   }

   public String getLeaderboardId() {
      return this.getString("external_leaderboard_id");
   }

   public int getScoreOrder() {
      return this.getInteger("score_order");
   }

   public ArrayList getVariants() {
      ArrayList var2 = new ArrayList(this.Ya);

      for(int var1 = 0; var1 < this.Ya; ++var1) {
         var2.add(new LeaderboardVariantRef(this.JG, this.KZ + var1));
      }

      return var2;
   }

   public int hashCode() {
      return LeaderboardEntity.a(this);
   }

   public Leaderboard mG() {
      return new LeaderboardEntity(this);
   }

   public String toString() {
      return LeaderboardEntity.b(this);
   }
}
