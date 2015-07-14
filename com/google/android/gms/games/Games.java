package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public final class Games {
   public static final Api API;
   public static final Achievements Achievements;
   static final Api.c DQ = new Api.c();
   private static final Api.b DR = new Api.b() {
      public GamesClientImpl a(Context var1, Looper var2, jg var3, Games.GamesOptions var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6) {
         if(var4 == null) {
            var4 = new Games.GamesOptions(null);
         }

         return new GamesClientImpl(var1, var2, var3.hq(), var3.hm(), var5, var6, var3.hp(), var3.hn(), var3.hr(), var4);
      }

      public int getPriority() {
         return 1;
      }
   };
   public static final String EXTRA_PLAYER_IDS = "players";
   public static final Events Events;
   public static final GamesMetadata GamesMetadata;
   public static final Invitations Invitations;
   public static final Leaderboards Leaderboards;
   public static final Notifications Notifications;
   public static final Players Players;
   public static final Quests Quests;
   public static final RealTimeMultiplayer RealTimeMultiplayer;
   public static final Requests Requests;
   public static final Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
   public static final Snapshots Snapshots;
   public static final TurnBasedMultiplayer TurnBasedMultiplayer;
   public static final Scope WV;
   public static final Api WW;
   public static final AppContents WX;
   public static final Multiplayer WY;
   public static final Acls WZ;

   static {
      API = new Api(DR, DQ, new Scope[]{SCOPE_GAMES});
      WV = new Scope("https://www.googleapis.com/auth/games.firstparty");
      WW = new Api(DR, DQ, new Scope[]{WV});
      GamesMetadata = new GamesMetadataImpl();
      Achievements = new AchievementsImpl();
      WX = new AppContentsImpl();
      Events = new EventsImpl();
      Leaderboards = new LeaderboardsImpl();
      Invitations = new InvitationsImpl();
      TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
      RealTimeMultiplayer = new RealTimeMultiplayerImpl();
      WY = new MultiplayerImpl();
      Players = new PlayersImpl();
      Notifications = new NotificationsImpl();
      Quests = new QuestsImpl();
      Requests = new RequestsImpl();
      Snapshots = new SnapshotsImpl();
      WZ = new AclsImpl();
   }

   public static GamesClientImpl d(GoogleApiClient var0) {
      boolean var1;
      if(var0 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.b(var1, "GoogleApiClient parameter is required.");
      jx.a(var0.isConnected(), "GoogleApiClient must be connected.");
      return e(var0);
   }

   public static GamesClientImpl e(GoogleApiClient var0) {
      GamesClientImpl var2 = (GamesClientImpl)var0.a(DQ);
      boolean var1;
      if(var2 != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      jx.a(var1, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
      return var2;
   }

   public static String getAppId(GoogleApiClient var0) {
      return d(var0).lw();
   }

   public static String getCurrentAccountName(GoogleApiClient var0) {
      return d(var0).lh();
   }

   public static int getSdkVariant(GoogleApiClient var0) {
      return d(var0).lv();
   }

   public static Intent getSettingsIntent(GoogleApiClient var0) {
      return d(var0).lu();
   }

   public static void setGravityForPopups(GoogleApiClient var0, int var1) {
      d(var0).dS(var1);
   }

   public static void setViewForPopups(GoogleApiClient var0, View var1) {
      jx.i(var1);
      d(var0).k(var1);
   }

   public static PendingResult signOut(final GoogleApiClient var0) {
      return var0.b(new Games.SignOutImpl(var0, null) {
         protected void a(GamesClientImpl var1) {
            var1.b((BaseImplementation.b)this);
         }
      });
   }

   public abstract static class BaseGamesApiMethodImpl extends BaseImplementation.a {
      public BaseGamesApiMethodImpl(GoogleApiClient var1) {
         super(Games.DQ, var1);
      }
   }

   public static final class GamesOptions implements Api.Optional {
      public final boolean Xa;
      public final boolean Xb;
      public final int Xc;
      public final boolean Xd;
      public final int Xe;
      public final String Xf;
      public final ArrayList Xg;

      private GamesOptions() {
         this.Xa = false;
         this.Xb = true;
         this.Xc = 17;
         this.Xd = false;
         this.Xe = 4368;
         this.Xf = null;
         this.Xg = new ArrayList();
      }

      // $FF: synthetic method
      GamesOptions(Object var1) {
         this();
      }

      private GamesOptions(Games.Builder var1) {
         this.Xa = var1.Xa;
         this.Xb = var1.Xb;
         this.Xc = var1.Xc;
         this.Xd = var1.Xd;
         this.Xe = var1.Xe;
         this.Xf = var1.Xf;
         this.Xg = var1.Xg;
      }

      // $FF: synthetic method
      GamesOptions(Games.Builder var1, Object var2) {
         this(var1);
      }

      public static Games.Builder builder() {
         return new Games.Builder(null);
      }
   }

   public static final class Builder {
      boolean Xa;
      boolean Xb;
      int Xc;
      boolean Xd;
      int Xe;
      String Xf;
      ArrayList Xg;

      private Builder() {
         this.Xa = false;
         this.Xb = true;
         this.Xc = 17;
         this.Xd = false;
         this.Xe = 4368;
         this.Xf = null;
         this.Xg = new ArrayList();
      }

      // $FF: synthetic method
      Builder(Object var1) {
         this();
      }

      public Games.GamesOptions build() {
         return new Games.GamesOptions(this, null);
      }

      public Games.Builder setSdkVariant(int var1) {
         this.Xe = var1;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1) {
         this.Xb = var1;
         this.Xc = 17;
         return this;
      }

      public Games.Builder setShowConnectingPopup(boolean var1, int var2) {
         this.Xb = var1;
         this.Xc = var2;
         return this;
      }
   }

   private abstract static class SignOutImpl extends Games.BaseGamesApiMethodImpl {
      private SignOutImpl(GoogleApiClient var1) {
         super(var1);
      }

      // $FF: synthetic method
      SignOutImpl(GoogleApiClient var1, Object var2) {
         this(var1);
      }

      public Status b(Status var1) {
         return var1;
      }

      // $FF: synthetic method
      public Result c(Status var1) {
         return this.b(var1);
      }
   }
}
