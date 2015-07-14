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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {
   public Intent getInvitationInboxIntent(GoogleApiClient var1) {
      return Games.d(var1).lo();
   }

   public PendingResult loadInvitations(GoogleApiClient var1) {
      return this.loadInvitations(var1, 0);
   }

   public PendingResult loadInvitations(final GoogleApiClient var1, final int var2) {
      return var1.a((BaseImplementation.a)(new InvitationsImpl.LoadInvitationsImpl(var1, null) {
         protected void a(GamesClientImpl var1) {
            var1.c(this, var2);
         }
      }));
   }

   public void registerInvitationListener(GoogleApiClient var1, OnInvitationReceivedListener var2) {
      d var3 = var1.d(var2);
      Games.d(var1).a(var3);
   }

   public void unregisterInvitationListener(GoogleApiClient var1) {
      Games.d(var1).lp();
   }

   private abstract static class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl {
      private LoadInvitationsImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      LoadInvitationsImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Invitations.LoadInvitationsResult T(final Status var1) {
         return new Invitations.LoadInvitationsResult() {
            public InvitationBuffer getInvitations() {
               return new InvitationBuffer(DataHolder.av(14));
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
         return this.T(var1);
      }
   }
}
