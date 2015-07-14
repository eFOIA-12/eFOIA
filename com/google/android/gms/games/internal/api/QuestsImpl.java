package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

public final class QuestsImpl implements Quests {
   public PendingResult accept(final GoogleApiClient var1, final String var2) {
      return var1.b(new QuestsImpl.AcceptImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.h(this, var2);
         }
      });
   }

   public PendingResult claim(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.b(new QuestsImpl.ClaimImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, var2, var3);
         }
      });
   }

   public Intent getQuestIntent(GoogleApiClient var1, String var2) {
      return Games.d(var1).bE(var2);
   }

   public Intent getQuestsIntent(GoogleApiClient var1, int[] var2) {
      return Games.d(var1).b(var2);
   }

   public PendingResult load(final GoogleApiClient var1, final int[] var2, final int var3, final boolean var4) {
      return var1.a((BaseImplementation.a)(new QuestsImpl.LoadsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3, var4);
         }
      }));
   }

   public PendingResult loadByIds(final GoogleApiClient var1, final boolean var2, final String... var3) {
      return var1.a((BaseImplementation.a)(new QuestsImpl.LoadsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.b(this, var2, var3);
         }
      }));
   }

   public void registerQuestUpdateListener(GoogleApiClient var1, QuestUpdateListener var2) {
      d var3 = var1.d(var2);
      Games.d(var1).c(var3);
   }

   public void showStateChangedPopup(GoogleApiClient var1, String var2) {
      Games.d(var1).bF(var2);
   }

   public void unregisterQuestUpdateListener(GoogleApiClient var1) {
      Games.d(var1).lr();
   }

   private abstract static class AcceptImpl extends Games.BaseGamesApiMethodImpl {
      private AcceptImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      AcceptImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Quests.AcceptQuestResult ah(final Status var1) {
         return new Quests.AcceptQuestResult() {
            public Quest getQuest() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ah(var1);
      }
   }

   private abstract static class ClaimImpl extends Games.BaseGamesApiMethodImpl {
      private ClaimImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      ClaimImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Quests.ClaimMilestoneResult ai(final Status var1) {
         return new Quests.ClaimMilestoneResult() {
            public Milestone getMilestone() {
               return null;
            }

            public Quest getQuest() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ai(var1);
      }
   }

   private abstract static class LoadsImpl extends Games.BaseGamesApiMethodImpl {
      private LoadsImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadsImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Quests.LoadQuestsResult aj(final Status var1) {
         return new Quests.LoadQuestsResult() {
            public QuestBuffer getQuests() {
               return new QuestBuffer(DataHolder.av(var1.getStatusCode()));
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
         return this.aj(var1);
      }
   }
}
