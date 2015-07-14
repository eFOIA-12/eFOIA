package com.google.android.gms.games.leaderboard;

import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.games.leaderboard.LeaderboardVariant;
import com.google.android.gms.internal.jv;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
   private final int adF;
   private final int adG;
   private final boolean adH;
   private final long adI;
   private final String adJ;
   private final long adK;
   private final String adL;
   private final String adM;
   private final long adN;
   private final String adO;
   private final String adP;
   private final String adQ;

   public LeaderboardVariantEntity(LeaderboardVariant var1) {
      this.adF = var1.getTimeSpan();
      this.adG = var1.getCollection();
      this.adH = var1.hasPlayerInfo();
      this.adI = var1.getRawPlayerScore();
      this.adJ = var1.getDisplayPlayerScore();
      this.adK = var1.getPlayerRank();
      this.adL = var1.getDisplayPlayerRank();
      this.adM = var1.getPlayerScoreTag();
      this.adN = var1.getNumScores();
      this.adO = var1.mK();
      this.adP = var1.mL();
      this.adQ = var1.mM();
   }

   static int a(LeaderboardVariant var0) {
      return jv.hashCode(new Object[]{Integer.valueOf(var0.getTimeSpan()), Integer.valueOf(var0.getCollection()), Boolean.valueOf(var0.hasPlayerInfo()), Long.valueOf(var0.getRawPlayerScore()), var0.getDisplayPlayerScore(), Long.valueOf(var0.getPlayerRank()), var0.getDisplayPlayerRank(), Long.valueOf(var0.getNumScores()), var0.mK(), var0.mM(), var0.mL()});
   }

   static boolean a(LeaderboardVariant var0, Object var1) {
      boolean var3 = true;
      boolean var2;
      if(!(var1 instanceof LeaderboardVariant)) {
         var2 = false;
      } else {
         var2 = var3;
         if(var0 != var1) {
            LeaderboardVariant var4 = (LeaderboardVariant)var1;
            if(jv.equal(Integer.valueOf(var4.getTimeSpan()), Integer.valueOf(var0.getTimeSpan())) && jv.equal(Integer.valueOf(var4.getCollection()), Integer.valueOf(var0.getCollection())) && jv.equal(Boolean.valueOf(var4.hasPlayerInfo()), Boolean.valueOf(var0.hasPlayerInfo())) && jv.equal(Long.valueOf(var4.getRawPlayerScore()), Long.valueOf(var0.getRawPlayerScore())) && jv.equal(var4.getDisplayPlayerScore(), var0.getDisplayPlayerScore()) && jv.equal(Long.valueOf(var4.getPlayerRank()), Long.valueOf(var0.getPlayerRank())) && jv.equal(var4.getDisplayPlayerRank(), var0.getDisplayPlayerRank()) && jv.equal(Long.valueOf(var4.getNumScores()), Long.valueOf(var0.getNumScores())) && jv.equal(var4.mK(), var0.mK()) && jv.equal(var4.mM(), var0.mM())) {
               var2 = var3;
               if(jv.equal(var4.mL(), var0.mL())) {
                  return var2;
               }
            }

            return false;
         }
      }

      return var2;
   }

   static String b(LeaderboardVariant var0) {
      jv.a var2 = jv.h(var0).a("TimeSpan", TimeSpan.dZ(var0.getTimeSpan())).a("Collection", LeaderboardCollection.dZ(var0.getCollection()));
      Object var1;
      if(var0.hasPlayerInfo()) {
         var1 = Long.valueOf(var0.getRawPlayerScore());
      } else {
         var1 = "none";
      }

      var2 = var2.a("RawPlayerScore", var1);
      String var3;
      if(var0.hasPlayerInfo()) {
         var3 = var0.getDisplayPlayerScore();
      } else {
         var3 = "none";
      }

      var2 = var2.a("DisplayPlayerScore", var3);
      if(var0.hasPlayerInfo()) {
         var1 = Long.valueOf(var0.getPlayerRank());
      } else {
         var1 = "none";
      }

      var2 = var2.a("PlayerRank", var1);
      if(var0.hasPlayerInfo()) {
         var3 = var0.getDisplayPlayerRank();
      } else {
         var3 = "none";
      }

      return var2.a("DisplayPlayerRank", var3).a("NumScores", Long.valueOf(var0.getNumScores())).a("TopPageNextToken", var0.mK()).a("WindowPageNextToken", var0.mM()).a("WindowPagePrevToken", var0.mL()).toString();
   }

   public boolean equals(Object var1) {
      return a(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.mN();
   }

   public int getCollection() {
      return this.adG;
   }

   public String getDisplayPlayerRank() {
      return this.adL;
   }

   public String getDisplayPlayerScore() {
      return this.adJ;
   }

   public long getNumScores() {
      return this.adN;
   }

   public long getPlayerRank() {
      return this.adK;
   }

   public String getPlayerScoreTag() {
      return this.adM;
   }

   public long getRawPlayerScore() {
      return this.adI;
   }

   public int getTimeSpan() {
      return this.adF;
   }

   public boolean hasPlayerInfo() {
      return this.adH;
   }

   public int hashCode() {
      return a(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public String mK() {
      return this.adO;
   }

   public String mL() {
      return this.adP;
   }

   public String mM() {
      return this.adQ;
   }

   public LeaderboardVariant mN() {
      return this;
   }

   public String toString() {
      return b(this);
   }
}
