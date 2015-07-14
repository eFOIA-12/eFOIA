package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.games.leaderboard.LeaderboardVariantEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.le;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
   private final String OS;
   private final Uri WD;
   private final String WO;
   private final String adn;
   private final int ado;
   private final ArrayList adp;
   private final Game adq;

   public LeaderboardEntity(Leaderboard var1) {
      this.adn = var1.getLeaderboardId();
      this.OS = var1.getDisplayName();
      this.WD = var1.getIconImageUri();
      this.WO = var1.getIconImageUrl();
      this.ado = var1.getScoreOrder();
      Game var4 = var1.getGame();
      GameEntity var6;
      if(var4 == null) {
         var6 = null;
      } else {
         var6 = new GameEntity(var4);
      }

      this.adq = var6;
      ArrayList var5 = var1.getVariants();
      int var3 = var5.size();
      this.adp = new ArrayList(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         this.adp.add((LeaderboardVariantEntity)((LeaderboardVariantEntity)((LeaderboardVariant)var5.get(var2)).freeze()));
      }

   }

   static int a(Leaderboard var0) {
      return jv.hashCode(new Object[]{var0.getLeaderboardId(), var0.getDisplayName(), var0.getIconImageUri(), Integer.valueOf(var0.getScoreOrder()), var0.getVariants()});
   }

   static boolean a(Leaderboard var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof Leaderboard)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            Leaderboard var4 = (Leaderboard)var1;
            if(jv.equal(var4.getLeaderboardId(), var0.getLeaderboardId()) && jv.equal(var4.getDisplayName(), var0.getDisplayName()) && jv.equal(var4.getIconImageUri(), var0.getIconImageUri()) && jv.equal(Integer.valueOf(var4.getScoreOrder()), Integer.valueOf(var0.getScoreOrder()))) {
               var2 = var3;
               if(jv.equal(var4.getVariants(), var0.getVariants())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(Leaderboard var0) {
      return jv.h(var0).a("LeaderboardId", var0.getLeaderboardId()).a("DisplayName", var0.getDisplayName()).a("IconImageUri", var0.getIconImageUri()).a("IconImageUrl", var0.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(var0.getScoreOrder())).a("Variants", var0.getVariants()).toString();
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mG();
   }

   public String getDisplayName() {
      return this.OS;
   }

   public void getDisplayName(CharArrayBuffer var1) {
      le.b(this.OS, var1);
   }

   public Game getGame() {
      return this.adq;
   }

   public Uri getIconImageUri() {
      return this.WD;
   }

   public String getIconImageUrl() {
      return this.WO;
   }

   public String getLeaderboardId() {
      return this.adn;
   }

   public int getScoreOrder() {
      return this.ado;
   }

   public ArrayList getVariants() {
      return new ArrayList(this.adp);
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public Leaderboard mG() {
      return this;
   }

   public String toString() {
      return b(this);
   }
}
