package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import java.util.HashMap;

public final class ScoreSubmissionData {
   private static final String[] adl = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
   private int Iv;
   private String Xh;
   private HashMap adR;
   private String adn;

   public ScoreSubmissionData(DataHolder var1) {
      this.Iv = var1.getStatusCode();
      this.adR = new HashMap();
      int var3 = var1.getCount();
      boolean var5;
      if(var3 == 3) {
         var5 = true;
      } else {
         var5 = false;
      }

      jx.L(var5);

      for(int var2 = 0; var2 < var3; ++var2) {
         int var4 = var1.au(var2);
         if(var2 == 0) {
            this.adn = var1.c("leaderboardId", var2, var4);
            this.Xh = var1.c("playerId", var2, var4);
         }

         if(var1.d("hasResult", var2, var4)) {
            this.a(new ScoreSubmissionData.Result(var1.a("rawScore", var2, var4), var1.c("formattedScore", var2, var4), var1.c("scoreTag", var2, var4), var1.d("newBest", var2, var4)), var1.b("timeSpan", var2, var4));
         }
      }

   }

   private void a(ScoreSubmissionData.Result var1, int var2) {
      this.adR.put(Integer.valueOf(var2), var1);
   }

   public String getLeaderboardId() {
      return this.adn;
   }

   public String getPlayerId() {
      return this.Xh;
   }

   public ScoreSubmissionData.Result getScoreResult(int var1) {
      return (ScoreSubmissionData.Result)this.adR.get(Integer.valueOf(var1));
   }

   public String toString() {
      jv.a var3 = jv.h(this).a("PlayerId", this.Xh).a("StatusCode", Integer.valueOf(this.Iv));

      for(int var1 = 0; var1 < 3; ++var1) {
         ScoreSubmissionData.Result var2 = (ScoreSubmissionData.Result)this.adR.get(Integer.valueOf(var1));
         var3.a("TimesSpan", TimeSpan.dZ(var1));
         String var4;
         if(var2 == null) {
            var4 = "null";
         } else {
            var4 = var2.toString();
         }

         var3.a("Result", var4);
      }

      return var3.toString();
   }

   public static final class Result {
      public final String formattedScore;
      public final boolean newBest;
      public final long rawScore;
      public final String scoreTag;

      public Result(long var1, String var3, String var4, boolean var5) {
         this.rawScore = var1;
         this.formattedScore = var3;
         this.scoreTag = var4;
         this.newBest = var5;
      }

      public String toString() {
         return jv.h(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
      }
   }
}
