package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {
   public Intent getAchievementsIntent(GoogleApiClient var1) {
      return Games.d(var1).lm();
   }

   public void increment(final GoogleApiClient var1, final String var2, final int var3) {
      var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)null, var2, var3);
         }
      });
   }

   public PendingResult incrementImmediate(final GoogleApiClient var1, final String var2, final int var3) {
      return var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.a(this, var2, var3);
         }
      });
   }

   public PendingResult load(final GoogleApiClient var1, final boolean var2) {
      return var1.a((BaseImplementation.a)(new AchievementsImpl.LoadImpl(var1, null) {
         public void a(GamesClientImpl var1) {
            var1.c(this, var2);
         }
      }));
   }

   public void reveal(final GoogleApiClient var1, final String var2) {
      var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)null, (String)var2);
         }
      });
   }

   public PendingResult revealImmediate(final GoogleApiClient var1, final String var2) {
      return var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)this, (String)var2);
         }
      });
   }

   public void setSteps(final GoogleApiClient var1, final String var2, final int var3) {
      var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.b((BaseImplementation.b)null, var2, var3);
         }
      });
   }

   public PendingResult setStepsImmediate(final GoogleApiClient var1, final String var2, final int var3) {
      return var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.b(this, var2, var3);
         }
      });
   }

   public void unlock(final GoogleApiClient var1, final String var2) {
      var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.b((BaseImplementation.b)null, (String)var2);
         }
      });
   }

   public PendingResult unlockImmediate(final GoogleApiClient var1, final String var2) {
      return var1.b(new AchievementsImpl.UpdateImpl(var2, var1) {
         public void a(GamesClientImpl var1) {
            var1.b(this, (String)var2);
         }
      });
   }

   private abstract static class LoadImpl extends Games.BaseGamesApiMethodImpl {
      private LoadImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Achievements.LoadAchievementsResult I(final Status var1) {
         return new Achievements.LoadAchievementsResult() {
            public AchievementBuffer getAchievements() {
               return new AchievementBuffer(DataHolder.av(14));
            }

            public Status getStatus() {
               return var1;
            }

            public void release() {
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.I(var1);
      }
   }

   private abstract static class UpdateImpl extends Games.BaseGamesApiMethodImpl {
      private final String CE;

      public UpdateImpl(String var1, GoogleApiClient var2) {
         super(var2);
         this.CE = var1;
      }

      public Achievements.UpdateAchievementResult J(final Status var1) {
         return new Achievements.UpdateAchievementResult() {
            public String getAchievementId() {
               return UpdateImpl.this.CE;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.J(var1);
      }
   }
}
