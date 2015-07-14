package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.le;

public final class LeaderboardScoreEntity implements LeaderboardScore {
   private final PlayerEntity adA;
   private final String adB;
   private final String adC;
   private final String adD;
   private final long ads;
   private final String adt;
   private final String adu;
   private final long adv;
   private final long adw;
   private final String adx;
   private final Uri ady;
   private final Uri adz;

   public LeaderboardScoreEntity(LeaderboardScore var1) {
      this.ads = var1.getRank();
      this.adt = (String)jx.i(var1.getDisplayRank());
      this.adu = (String)jx.i(var1.getDisplayScore());
      this.adv = var1.getRawScore();
      this.adw = var1.getTimestampMillis();
      this.adx = var1.getScoreHolderDisplayName();
      this.ady = var1.getScoreHolderIconImageUri();
      this.adz = var1.getScoreHolderHiResImageUri();
      Player var2 = var1.getScoreHolder();
      PlayerEntity var3;
      if(var2 == null) {
         var3 = null;
      } else {
         var3 = (PlayerEntity)var2.freeze();
      }

      this.adA = var3;
      this.adB = var1.getScoreTag();
      this.adC = var1.getScoreHolderIconImageUrl();
      this.adD = var1.getScoreHolderHiResImageUrl();
   }

   static int a(LeaderboardScore var0) {
      return jv.hashCode(new Object[]{Long.valueOf(var0.getRank()), var0.getDisplayRank(), Long.valueOf(var0.getRawScore()), var0.getDisplayScore(), Long.valueOf(var0.getTimestampMillis()), var0.getScoreHolderDisplayName(), var0.getScoreHolderIconImageUri(), var0.getScoreHolderHiResImageUri(), var0.getScoreHolder()});
   }

   static boolean a(LeaderboardScore var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof LeaderboardScore)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            LeaderboardScore var4 = (LeaderboardScore)var1;
            if(jv.equal(Long.valueOf(var4.getRank()), Long.valueOf(var0.getRank())) && jv.equal(var4.getDisplayRank(), var0.getDisplayRank()) && jv.equal(Long.valueOf(var4.getRawScore()), Long.valueOf(var0.getRawScore())) && jv.equal(var4.getDisplayScore(), var0.getDisplayScore()) && jv.equal(Long.valueOf(var4.getTimestampMillis()), Long.valueOf(var0.getTimestampMillis())) && jv.equal(var4.getScoreHolderDisplayName(), var0.getScoreHolderDisplayName()) && jv.equal(var4.getScoreHolderIconImageUri(), var0.getScoreHolderIconImageUri()) && jv.equal(var4.getScoreHolderHiResImageUri(), var0.getScoreHolderHiResImageUri()) && jv.equal(var4.getScoreHolder(), var0.getScoreHolder())) {
               var2 = var3;
               if(jv.equal(var4.getScoreTag(), var0.getScoreTag())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(LeaderboardScore var0) {
      jv.a var2 = jv.h(var0).a("Rank", Long.valueOf(var0.getRank())).a("DisplayRank", var0.getDisplayRank()).a("Score", Long.valueOf(var0.getRawScore())).a("DisplayScore", var0.getDisplayScore()).a("Timestamp", Long.valueOf(var0.getTimestampMillis())).a("DisplayName", var0.getScoreHolderDisplayName()).a("IconImageUri", var0.getScoreHolderIconImageUri()).a("IconImageUrl", var0.getScoreHolderIconImageUrl()).a("HiResImageUri", var0.getScoreHolderHiResImageUri()).a("HiResImageUrl", var0.getScoreHolderHiResImageUrl());
      Player var1;
      if(var0.getScoreHolder() == null) {
         var1 = null;
      } else {
         var1 = var0.getScoreHolder();
      }

      return var2.a("Player", var1).a("ScoreTag", var0.getScoreTag()).toString();
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mJ();
   }

   public String getDisplayRank() {
      return this.adt;
   }

   public void getDisplayRank(CharArrayBuffer var1) {
      le.b(this.adt, var1);
   }

   public String getDisplayScore() {
      return this.adu;
   }

   public void getDisplayScore(CharArrayBuffer var1) {
      le.b(this.adu, var1);
   }

   public long getRank() {
      return this.ads;
   }

   public long getRawScore() {
      return this.adv;
   }

   public Player getScoreHolder() {
      return this.adA;
   }

   public String getScoreHolderDisplayName() {
      return this.adA == null?this.adx:this.adA.getDisplayName();
   }

   public void getScoreHolderDisplayName(CharArrayBuffer var1) {
      if(this.adA == null) {
         le.b(this.adx, var1);
      } else {
         this.adA.getDisplayName(var1);
      }
   }

   public Uri getScoreHolderHiResImageUri() {
      return this.adA == null?this.adz:this.adA.getHiResImageUri();
   }

   public String getScoreHolderHiResImageUrl() {
      return this.adA == null?this.adD:this.adA.getHiResImageUrl();
   }

   public Uri getScoreHolderIconImageUri() {
      return this.adA == null?this.ady:this.adA.getIconImageUri();
   }

   public String getScoreHolderIconImageUrl() {
      return this.adA == null?this.adC:this.adA.getIconImageUrl();
   }

   public String getScoreTag() {
      return this.adB;
   }

   public long getTimestampMillis() {
      return this.adw;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public LeaderboardScore mJ() {
      return this;
   }

   public String toString() {
      return b(this);
   }
}
