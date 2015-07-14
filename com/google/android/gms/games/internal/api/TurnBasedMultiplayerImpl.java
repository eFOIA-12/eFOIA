package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {
   public PendingResult acceptInvitation(final GoogleApiClient var1, final String var2) {
      return var1.b(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.d((BaseImplementation.b)this, var2);
         }
      });
   }

   public PendingResult cancelMatch(final GoogleApiClient var1, final String var2) {
      return var1.b(new TurnBasedMultiplayerImpl.CancelMatchImpl(var2, var1) {
         protected void a(GamesClientImpl var1) {
            var1.f(this, var2);
         }
      });
   }

   public PendingResult createMatch(final GoogleApiClient var1, final TurnBasedMatchConfig var2) {
      return var1.b(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)this, (TurnBasedMatchConfig)var2);
         }
      });
   }

   public void declineInvitation(GoogleApiClient var1, String var2) {
      Games.d(var1).q(var2, 1);
   }

   public void dismissInvitation(GoogleApiClient var1, String var2) {
      Games.d(var1).p(var2, 1);
   }

   public void dismissMatch(GoogleApiClient var1, String var2) {
      Games.d(var1).bA(var2);
   }

   public PendingResult finishMatch(GoogleApiClient var1, String var2) {
      return this.finishMatch(var1, var2, (byte[])null, (ParticipantResult[])((ParticipantResult[])null));
   }

   public PendingResult finishMatch(GoogleApiClient var1, String var2, byte[] var3, List var4) {
      ParticipantResult[] var5;
      if(var4 == null) {
         var5 = null;
      } else {
         var5 = (ParticipantResult[])var4.toArray(new ParticipantResult[var4.size()]);
      }

      return this.finishMatch(var1, var2, var3, var5);
   }

   public PendingResult finishMatch(final GoogleApiClient var1, final String var2, final byte[] var3, final ParticipantResult... var4) {
      return var1.b(new TurnBasedMultiplayerImpl.UpdateMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)this, (String)var2, (byte[])var3, (ParticipantResult[])var4);
         }
      });
   }

   public Intent getInboxIntent(GoogleApiClient var1) {
      return Games.d(var1).ln();
   }

   public int getMaxMatchDataSize(GoogleApiClient var1) {
      return Games.d(var1).lx();
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
      return Games.d(var1).a(var2, var3, true);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
      return Games.d(var1).a(var2, var3, var4);
   }

   public PendingResult leaveMatch(final GoogleApiClient var1, final String var2) {
      return var1.b(new TurnBasedMultiplayerImpl.LeaveMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.e(this, var2);
         }
      });
   }

   public PendingResult leaveMatchDuringTurn(final GoogleApiClient var1, final String var2, final String var3) {
      return var1.b(new TurnBasedMultiplayerImpl.LeaveMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a((BaseImplementation.b)this, (String)var2, (String)var3);
         }
      });
   }

   public PendingResult loadMatch(final GoogleApiClient var1, final String var2) {
      return var1.a((BaseImplementation.a)(new TurnBasedMultiplayerImpl.LoadMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.g(this, var2);
         }
      }));
   }

   public PendingResult loadMatchesByStatus(final GoogleApiClient var1, final int var2, final int[] var3) {
      return var1.a((BaseImplementation.a)(new TurnBasedMultiplayerImpl.LoadMatchesImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, var3);
         }
      }));
   }

   public PendingResult loadMatchesByStatus(GoogleApiClient var1, int[] var2) {
      return this.loadMatchesByStatus(var1, 0, var2);
   }

   public void registerMatchUpdateListener(GoogleApiClient var1, OnTurnBasedMatchUpdateReceivedListener var2) {
      d var3 = var1.d(var2);
      Games.d(var1).b(var3);
   }

   public PendingResult rematch(final GoogleApiClient var1, final String var2) {
      return var1.b(new TurnBasedMultiplayerImpl.InitiateMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.c(this, (String)var2);
         }
      });
   }

   public PendingResult takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4) {
      return this.takeTurn(var1, var2, var3, var4, (ParticipantResult[])null);
   }

   public PendingResult takeTurn(GoogleApiClient var1, String var2, byte[] var3, String var4, List var5) {
      ParticipantResult[] var6;
      if(var5 == null) {
         var6 = null;
      } else {
         var6 = (ParticipantResult[])var5.toArray(new ParticipantResult[var5.size()]);
      }

      return this.takeTurn(var1, var2, var3, var4, var6);
   }

   public PendingResult takeTurn(final GoogleApiClient var1, final String var2, final byte[] var3, final String var4, final ParticipantResult... var5) {
      return var1.b(new TurnBasedMultiplayerImpl.UpdateMatchImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.a(this, var2, (byte[])var3, (String)var4, (ParticipantResult[])var5);
         }
      });
   }

   public void unregisterMatchUpdateListener(GoogleApiClient var1) {
      Games.d(var1).lq();
   }

   private abstract static class CancelMatchImpl extends Games.BaseGamesApiMethodImpl {
      private final String CE;

      public CancelMatchImpl(String var1, GoogleApiClient var2) {
         super(var2);
         this.CE = var1;
      }

      public TurnBasedMultiplayer.CancelMatchResult as(final Status var1) {
         return new TurnBasedMultiplayer.CancelMatchResult() {
            public String getMatchId() {
               return CancelMatchImpl.this.CE;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.as(var1);
      }
   }

   private abstract static class InitiateMatchImpl extends Games.BaseGamesApiMethodImpl {
      private InitiateMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      InitiateMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public TurnBasedMultiplayer.InitiateMatchResult at(final Status var1) {
         return new TurnBasedMultiplayer.InitiateMatchResult() {
            public TurnBasedMatch getMatch() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.at(var1);
      }
   }

   private abstract static class LeaveMatchImpl extends Games.BaseGamesApiMethodImpl {
      private LeaveMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LeaveMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public TurnBasedMultiplayer.LeaveMatchResult au(final Status var1) {
         return new TurnBasedMultiplayer.LeaveMatchResult() {
            public TurnBasedMatch getMatch() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.au(var1);
      }
   }

   private abstract static class LoadMatchImpl extends Games.BaseGamesApiMethodImpl {
      private LoadMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public TurnBasedMultiplayer.LoadMatchResult av(final Status var1) {
         return new TurnBasedMultiplayer.LoadMatchResult() {
            public TurnBasedMatch getMatch() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.av(var1);
      }
   }

   private abstract static class LoadMatchesImpl extends Games.BaseGamesApiMethodImpl {
      private LoadMatchesImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadMatchesImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public TurnBasedMultiplayer.LoadMatchesResult aw(final Status var1) {
         return new TurnBasedMultiplayer.LoadMatchesResult() {
            public LoadMatchesResponse getMatches() {
               return new LoadMatchesResponse(new Bundle());
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
         return this.aw(var1);
      }
   }

   private abstract static class UpdateMatchImpl extends Games.BaseGamesApiMethodImpl {
      private UpdateMatchImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      UpdateMatchImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public TurnBasedMultiplayer.UpdateMatchResult ax(final Status var1) {
         return new TurnBasedMultiplayer.UpdateMatchResult() {
            public TurnBasedMatch getMatch() {
               return null;
            }

            public Status getStatus() {
               return var1;
            }
         };
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.ax(var1);
      }
   }
}
