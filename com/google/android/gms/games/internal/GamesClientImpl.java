package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.AbstractGamesCallbacks;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.internal.IGamesCallbacks;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.PopupManager;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.ExtendedGameBuffer;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ll;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class GamesClientImpl extends jl implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   private final String DZ;
   EventIncrementManager Yk = new EventIncrementManager() {
      public EventIncrementCache lF() {
         return GamesClientImpl.this.new GameClientEventIncrementCache();
      }
   };
   private final String Yl;
   private final Map Ym;
   private PlayerEntity Yn;
   private GameEntity Yo;
   private final PopupManager Yp;
   private boolean Yq = false;
   private final Binder Yr;
   private final long Ys;
   private final Games.GamesOptions Yt;

   public GamesClientImpl(Context var1, Looper var2, String var3, String var4, GoogleApiClient.ConnectionCallbacks var5, GoogleApiClient.OnConnectionFailedListener var6, String[] var7, int var8, View var9, Games.GamesOptions var10) {
      super(var1, var2, var5, var6, var7);
      this.Yl = var3;
      this.DZ = (String)jx.i(var4);
      this.Yr = new Binder();
      this.Ym = new HashMap();
      this.Yp = PopupManager.a(this, var8);
      this.k(var9);
      this.Ys = (long)this.hashCode();
      this.Yt = var10;
      this.registerConnectionCallbacks(this);
      this.registerConnectionFailedListener(this);
   }

   private static Room R(DataHolder var0) {
      RoomBuffer var1 = new RoomBuffer(var0);
      Room var4 = null;

      try {
         if(var1.getCount() > 0) {
            var4 = (Room)((Room)var1.get(0)).freeze();
         }
      } finally {
         var1.release();
      }

      return var4;
   }

   private RealTimeSocket bB(String var1) {
      RealTimeSocket var2;
      if(ll.ii()) {
         var2 = this.bD(var1);
      } else {
         var2 = this.bC(var1);
      }

      if(var2 != null) {
         this.Ym.put(var1, var2);
      }

      return var2;
   }

   private RealTimeSocket bC(String param1) {
      // $FF: Couldn't be decompiled
   }

   private RealTimeSocket bD(String param1) {
      // $FF: Couldn't be decompiled
   }

   private void lD() {
      Iterator var1 = this.Ym.values().iterator();

      while(var1.hasNext()) {
         RealTimeSocket var2 = (RealTimeSocket)var1.next();

         try {
            var2.close();
         } catch (IOException var3) {
            GamesLog.c("GamesClientImpl", "IOException:", var3);
         }
      }

      this.Ym.clear();
   }

   private void lg() {
      this.Yn = null;
   }

   public int a(d var1, byte[] var2, String var3, String var4) {
      try {
         int var5 = ((IGamesService)this.hw()).a(new GamesClientImpl.RealTimeReliableMessageBinderCallbacks(var1), (byte[])var2, (String)var3, (String)var4);
         return var5;
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public int a(byte[] var1, String var2, String[] var3) {
      jx.b((Object)var3, "Participant IDs must not be null");

      try {
         int var4 = ((IGamesService)this.hw()).b(var1, var2, var3);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public Intent a(int var1, int var2, boolean var3) {
      try {
         Intent var4 = ((IGamesService)this.hw()).a(var1, var2, var3);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent a(int var1, byte[] var2, int var3, Bitmap var4, String var5) {
      try {
         Intent var7 = ((IGamesService)this.hw()).a(var1, var2, var3, var5);
         jx.b((Object)var4, "Must provide a non null icon");
         var7.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", var4);
         return var7;
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent a(Room var1, int var2) {
      try {
         Intent var4 = ((IGamesService)this.hw()).a((RoomEntity)var1.freeze(), var2);
         return var4;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent a(String var1, boolean var2, boolean var3, int var4) {
      try {
         Intent var6 = ((IGamesService)this.hw()).a(var1, var2, var3, var4);
         return var6;
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   protected void a(int var1, IBinder var2, Bundle var3) {
      if(var1 == 0 && var3 != null) {
         this.Yq = var3.getBoolean("show_welcome_popup");
      }

      super.a(var1, var2, var3);
   }

   public void a(IBinder var1, Bundle var2) {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.hw()).a(var1, var2);
         } catch (RemoteException var3) {
            GamesLog.o("GamesClientImpl", "service died");
            return;
         }
      }

   }

   public void a(BaseImplementation.b var1, int var2, int var3, int var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2, String var3, String[] var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.AppContentLoadedBinderCallbacks(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int var2, int[] var3) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, LeaderboardScoreBuffer var2, int var3, int var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2.mH().mI(), var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, TurnBasedMatchConfig var2) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2.getVariant(), var2.mO(), var2.getInvitedPlayerIds(), var2.getAutoMatchCriteria());
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, Snapshot var2, SnapshotMetadataChange var3) {
      SnapshotContents var5 = var2.getSnapshotContents();
      boolean var4;
      if(!var5.isClosed()) {
         var4 = true;
      } else {
         var4 = false;
      }

      jx.a(var4, "Snapshot already closed");
      a var6 = var3.mT();
      if(var6 != null) {
         var6.a(this.getContext().getCacheDir());
      }

      Contents var8 = var5.ir();
      var5.close();

      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.SnapshotCommittedBinderCallbacks(var1), (String)var2.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity)((SnapshotMetadataChangeEntity)var3), (Contents)var8);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void a(BaseImplementation.b param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(BaseImplementation.b var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      byte var6 = -1;
      switch(var2.hashCode()) {
      case 156408498:
         if(var2.equals("played_with")) {
            var6 = 0;
         }
      default:
         switch(var6) {
         case 0:
            try {
               ((IGamesService)this.hw()).d(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
               return;
            } catch (RemoteException var7) {
               GamesLog.o("GamesClientImpl", "service died");
               return;
            }
         default:
            throw new IllegalArgumentException("Invalid player collection: " + var2);
         }
      }
   }

   public void a(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var8) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, int var3, int[] var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.TurnBasedMatchesLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b param1, String param2, long param3, String param5) {
      // $FF: Couldn't be decompiled
   }

   public void a(BaseImplementation.b var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, int var4, int var5) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.PlayerLeaderboardScoreLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, int var4, int var5, int var6) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.RequestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var8) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, int var4, boolean var5, boolean var6) {
      byte var7 = -1;
      switch(var2.hashCode()) {
      case -1049482625:
         if(var2.equals("nearby")) {
            var7 = 2;
         }
         break;
      case 156408498:
         if(var2.equals("played_with")) {
            var7 = 1;
         }
         break;
      case 782949780:
         if(var2.equals("circled")) {
            var7 = 0;
         }
      }

      switch(var7) {
      case 0:
      case 1:
      case 2:
         try {
            ((IGamesService)this.hw()).a(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
            return;
         } catch (RemoteException var8) {
            GamesLog.o("GamesClientImpl", "service died");
            return;
         }
      default:
         throw new IllegalArgumentException("Invalid player collection: " + var2);
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, SnapshotMetadataChange var4, SnapshotContents var5) {
      boolean var6;
      if(!var5.isClosed()) {
         var6 = true;
      } else {
         var6 = false;
      }

      jx.a(var6, "SnapshotContents already closed");
      a var7 = var4.mT();
      if(var7 != null) {
         var7.a(this.getContext().getCacheDir());
      }

      Contents var9 = var5.ir();
      var5.close();

      try {
         ((IGamesService)this.hw()).a((IGamesCallbacks)(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1)), var2, (String)var3, (SnapshotMetadataChangeEntity)((SnapshotMetadataChangeEntity)var4), (Contents)var9);
      } catch (RemoteException var8) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, boolean var4, String[] var5) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var5, var4);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, int[] var4, int var5, boolean var6) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String var3, String[] var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), (String)var2, (String)var3, (String[])var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).f(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) {
      try {
         ((IGamesService)this.hw()).a((IGamesCallbacks)(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1)), var2, (byte[])var3, (String)var4, (ParticipantResult[])var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, byte[] var3, ParticipantResult[] var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.TurnBasedMatchUpdatedBinderCallbacks(var1), (String)var2, (byte[])var3, (ParticipantResult[])var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String var2, String[] var3, int var4, byte[] var5, int var6) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.RequestSentBinderCallbacks(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, boolean var2, Bundle var3) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.ContactSettingsUpdatedBinderCallback(var1), var2, (Bundle)var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, boolean var2, String... var3) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2, (String[])var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, int[] var2, int var3, boolean var4) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), (int[])var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(BaseImplementation.b var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.PlayersLoadedBinderCallback(var1), (String[])var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(d var1) {
      try {
         GamesClientImpl.InvitationReceivedBinderCallback var3 = new GamesClientImpl.InvitationReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).a(var3, this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(d var1, d var2, d var3, RoomConfig var4) {
      this.lD();

      try {
         GamesClientImpl.RoomBinderCallbacks var6 = new GamesClientImpl.RoomBinderCallbacks(var1, var2, var3);
         ((IGamesService)this.hw()).a(var6, this.Yr, var4.getVariant(), var4.getInvitedPlayerIds(), var4.getAutoMatchCriteria(), var4.isSocketEnabled(), this.Ys);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(d var1, String var2) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.RoomBinderCallbacks(var1), (String)var2);
         this.lD();
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void a(Snapshot var1) {
      SnapshotContents var5 = var1.getSnapshotContents();
      boolean var2;
      if(!var5.isClosed()) {
         var2 = true;
      } else {
         var2 = false;
      }

      jx.a(var2, "Snapshot already closed");
      Contents var3 = var5.ir();
      var5.close();

      try {
         ((IGamesService)this.hw()).a(var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   protected void a(jt var1, jl.e var2) throws RemoteException {
      String var3 = this.getContext().getResources().getConfiguration().locale.toString();
      Bundle var4 = new Bundle();
      var4.putBoolean("com.google.android.gms.games.key.isHeadless", this.Yt.Xa);
      var4.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.Yt.Xb);
      var4.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.Yt.Xc);
      var4.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.Yt.Xd);
      var4.putInt("com.google.android.gms.games.key.sdkVariant", this.Yt.Xe);
      var4.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.Yt.Xf);
      var4.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.Yt.Xg);
      var1.a(var2, 6587000, this.getContext().getPackageName(), this.DZ, this.hv(), this.Yl, this.Yp.lV(), var3, var4);
   }

   protected IGamesService aC(IBinder var1) {
      return IGamesService.Stub.aE(var1);
   }

   public Intent b(int var1, int var2, boolean var3) {
      try {
         Intent var4 = ((IGamesService)this.hw()).b(var1, var2, var3);
         return var4;
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent b(int[] var1) {
      try {
         Intent var3 = ((IGamesService)this.hw()).b(var1);
         return var3;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public void b(BaseImplementation.b var1) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a((IGamesCallbacks)(new GamesClientImpl.SignOutCompleteBinderCallbacks(var1)));
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void b(BaseImplementation.b param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void b(BaseImplementation.b var1, String var2, int var3, int var4, int var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, String var3) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).f(new GamesClientImpl.QuestMilestoneClaimBinderCallbacks(var1, var3), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, String var3, int var4, int var5, int var6, boolean var7) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.LeaderboardScoresLoadedBinderCallback(var1), var2, var3, var4, var5, var6, var7);
      } catch (RemoteException var8) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, String var3, int var4, boolean var5, boolean var6) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5, var6);
      } catch (RemoteException var7) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, boolean var2, String[] var3) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).a(new GamesClientImpl.QuestsLoadedBinderCallbacks(var1), (String[])var3, var2);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(BaseImplementation.b var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).a((IGamesCallbacks)(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1)), (String[])var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(d var1) {
      try {
         GamesClientImpl.MatchUpdateReceivedBinderCallback var3 = new GamesClientImpl.MatchUpdateReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).b(var3, this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void b(d var1, d var2, d var3, RoomConfig var4) {
      this.lD();

      try {
         GamesClientImpl.RoomBinderCallbacks var6 = new GamesClientImpl.RoomBinderCallbacks(var1, var2, var3);
         ((IGamesService)this.hw()).a(var6, this.Yr, var4.getInvitationId(), var4.isSocketEnabled(), this.Ys);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void bA(String var1) {
      try {
         ((IGamesService)this.hw()).bL(var1);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public Intent bE(String var1) {
      try {
         Intent var3 = ((IGamesService)this.hw()).bE(var1);
         return var3;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public void bF(String var1) {
      try {
         ((IGamesService)this.hw()).a(var1, this.Yp.lV(), this.Yp.lU());
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   protected String bK() {
      return "com.google.android.gms.games.service.START";
   }

   protected String bL() {
      return "com.google.android.gms.games.internal.IGamesService";
   }

   public void c(BaseImplementation.b var1, int var2) {
      try {
         ((IGamesService)this.hw()).a((IGamesCallbacks)(new GamesClientImpl.InvitationsLoadedBinderCallback(var1)), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).l(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).b((IGamesCallbacks)(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1)), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).d(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2, String var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.SnapshotOpenedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.AchievementsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(BaseImplementation.b var1, String[] var2) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.RequestsUpdatedBinderCallbacks(var1), (String[])var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void c(d var1) {
      try {
         GamesClientImpl.QuestUpdateBinderCallback var3 = new GamesClientImpl.QuestUpdateBinderCallback(var1);
         ((IGamesService)this.hw()).d(var3, this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   protected void c(String... var1) {
      int var2 = 0;
      boolean var3 = false;

      boolean var4;
      boolean var5;
      for(var4 = false; var2 < var1.length; var4 = var5) {
         String var6 = var1[var2];
         if(var6.equals("https://www.googleapis.com/auth/games")) {
            var5 = true;
         } else {
            var5 = var4;
            if(var6.equals("https://www.googleapis.com/auth/games.firstparty")) {
               var3 = true;
               var5 = var4;
            }
         }

         ++var2;
      }

      if(var3) {
         if(!var4) {
            var4 = true;
         } else {
            var4 = false;
         }

         jx.a(var4, "Cannot have both %s and %s!", new Object[]{"https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"});
      } else {
         jx.a(var4, "Games APIs requires %s to function.", new Object[]{"https://www.googleapis.com/auth/games"});
      }
   }

   public void connect() {
      this.lg();
      super.connect();
   }

   public int d(byte[] var1, String var2) {
      try {
         int var3 = ((IGamesService)this.hw()).b((byte[])var1, var2, (String[])null);
         return var3;
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public void d(BaseImplementation.b var1, int var2, boolean var3, boolean var4) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4);
      } catch (RemoteException var5) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).m(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).c((IGamesCallbacks)(new GamesClientImpl.PlayerXpStreamLoadedBinderCallback(var1)), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).f(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, String var2, String var3) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.TurnBasedMatchInitiatedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).d(new GamesClientImpl.LeaderboardsLoadedBinderCallback(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(BaseImplementation.b var1, boolean var2) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).f(new GamesClientImpl.EventsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void d(d var1) {
      try {
         GamesClientImpl.RequestReceivedBinderCallback var3 = new GamesClientImpl.RequestReceivedBinderCallback(var1);
         ((IGamesService)this.hw()).c(var3, this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void dS(int var1) {
      this.Yp.setGravity(var1);
   }

   public void dT(int var1) {
      try {
         ((IGamesService)this.hw()).dT(var1);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void disconnect() {
      this.Yq = false;
      if(this.isConnected()) {
         try {
            IGamesService var1 = (IGamesService)this.hw();
            var1.lE();
            this.Yk.flush();
            var1.q(this.Ys);
         } catch (RemoteException var2) {
            GamesLog.o("GamesClientImpl", "Failed to notify client disconnect.");
         }
      }

      this.lD();
      super.disconnect();
   }

   public void e(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).o(new GamesClientImpl.TurnBasedMatchLeftBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void e(BaseImplementation.b var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2, var3, false);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void e(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).c(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void e(BaseImplementation.b var1, String var2, boolean var3) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.GameMuteStatusChangedBinderCallback(var1), (String)var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void e(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).d(new GamesClientImpl.SnapshotsLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void f(BaseImplementation.b var1) {
      try {
         ((IGamesService)this.hw()).d(new GamesClientImpl.GamesLoadedBinderCallback(var1));
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void f(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).n(new GamesClientImpl.TurnBasedMatchCanceledBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void f(BaseImplementation.b var1, String var2, int var3) {
      try {
         ((IGamesService)this.hw()).a(new GamesClientImpl.RequestSummariesLoadedBinderCallbacks(var1), var2, var3);
      } catch (RemoteException var4) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void f(BaseImplementation.b var1, String var2, int var3, boolean var4, boolean var5) {
      try {
         ((IGamesService)this.hw()).b(new GamesClientImpl.PlayersLoadedBinderCallback(var1), var2, var3, var4, var5);
      } catch (RemoteException var6) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void f(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).g(new GamesClientImpl.ProfileSettingsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public Bundle fX() {
      // $FF: Couldn't be decompiled
   }

   public void g(BaseImplementation.b var1) {
      try {
         ((IGamesService)this.hw()).j(new GamesClientImpl.OwnerCoverPhotoUrisLoadedBinderCallback(var1));
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void g(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).p(new GamesClientImpl.TurnBasedMatchLoadedBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void g(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).h(new GamesClientImpl.ProfileSettingsUpdatedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void h(BaseImplementation.b var1) {
      try {
         ((IGamesService)this.hw()).h((IGamesCallbacks)(new GamesClientImpl.NotifyAclLoadedBinderCallback(var1)));
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void h(BaseImplementation.b var1, String var2) {
      try {
         this.Yk.flush();
         ((IGamesService)this.hw()).u((IGamesCallbacks)(new GamesClientImpl.QuestAcceptedBinderCallbacks(var1)), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void h(BaseImplementation.b var1, boolean var2) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.ContactSettingsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void i(BaseImplementation.b var1) {
      try {
         ((IGamesService)this.hw()).t((IGamesCallbacks)(new GamesClientImpl.InboxCountsLoadedBinderCallback(var1)), (String)null);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void i(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).r(new GamesClientImpl.SnapshotDeletedBinderCallbacks(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void j(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).e(new GamesClientImpl.ExtendedGamesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void k(View var1) {
      this.Yp.l(var1);
   }

   public void k(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).f(new GamesClientImpl.GameInstancesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   // $FF: synthetic method
   protected IInterface l(IBinder var1) {
      return this.aC(var1);
   }

   public void l(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).q(new GamesClientImpl.GameSearchSuggestionsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public int lA() {
      try {
         int var1 = ((IGamesService)this.hw()).lA();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public int lB() {
      try {
         int var1 = ((IGamesService)this.hw()).lB();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public int lC() {
      try {
         int var1 = ((IGamesService)this.hw()).lC();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public void lE() {
      if(this.isConnected()) {
         try {
            ((IGamesService)this.hw()).lE();
         } catch (RemoteException var2) {
            GamesLog.o("GamesClientImpl", "service died");
            return;
         }
      }

   }

   public String lh() {
      try {
         String var1 = ((IGamesService)this.hw()).lh();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public String li() {
      try {
         String var1 = ((IGamesService)this.hw()).li();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Player lj() {
      // $FF: Couldn't be decompiled
   }

   public Game lk() {
      // $FF: Couldn't be decompiled
   }

   public Intent ll() {
      try {
         Intent var1 = ((IGamesService)this.hw()).ll();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent lm() {
      try {
         Intent var1 = ((IGamesService)this.hw()).lm();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent ln() {
      try {
         Intent var1 = ((IGamesService)this.hw()).ln();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent lo() {
      try {
         Intent var1 = ((IGamesService)this.hw()).lo();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public void lp() {
      try {
         ((IGamesService)this.hw()).r(this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void lq() {
      try {
         ((IGamesService)this.hw()).s(this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void lr() {
      try {
         ((IGamesService)this.hw()).u(this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void ls() {
      try {
         ((IGamesService)this.hw()).t(this.Ys);
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public Intent lt() {
      try {
         Intent var1 = ((IGamesService)this.hw()).lt();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public Intent lu() {
      try {
         Intent var1 = ((IGamesService)this.hw()).lu();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public int lv() {
      try {
         int var1 = ((IGamesService)this.hw()).lv();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return 4368;
      }
   }

   public String lw() {
      try {
         String var1 = ((IGamesService)this.hw()).lw();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public int lx() {
      try {
         int var1 = ((IGamesService)this.hw()).lx();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public Intent ly() {
      try {
         Intent var1 = ((IGamesService)this.hw()).ly();
         return var1;
      } catch (RemoteException var2) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public int lz() {
      try {
         int var1 = ((IGamesService)this.hw()).lz();
         return var1;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return -1;
      }
   }

   public void m(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).s(new GamesClientImpl.PlayerXpForGameCategoriesLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public Intent n(String var1, int var2) {
      try {
         Intent var4 = ((IGamesService)this.hw()).u(var1, var2);
         return var4;
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
         return null;
      }
   }

   public void n(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).k(new GamesClientImpl.InvitationsLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void o(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).j(new GamesClientImpl.NotifyAclUpdatedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void o(String var1, int var2) {
      this.Yk.o(var1, var2);
   }

   public void onConnected(Bundle var1) {
      if(this.Yq) {
         this.Yp.lT();
         this.Yq = false;
      }

   }

   public void onConnectionFailed(ConnectionResult var1) {
      this.Yq = false;
   }

   public void onConnectionSuspended(int var1) {
   }

   public void p(BaseImplementation.b var1, String var2) {
      try {
         ((IGamesService)this.hw()).i(new GamesClientImpl.GameMuteStatusLoadedBinderCallback(var1), var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void p(String var1, int var2) {
      try {
         ((IGamesService)this.hw()).p(var1, var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public void q(String var1, int var2) {
      try {
         ((IGamesService)this.hw()).q(var1, var2);
      } catch (RemoteException var3) {
         GamesLog.o("GamesClientImpl", "service died");
      }
   }

   public RealTimeSocket s(String var1, String var2) {
      if(var2 != null && ParticipantUtils.bY(var2)) {
         RealTimeSocket var3 = (RealTimeSocket)this.Ym.get(var2);
         RealTimeSocket var4;
         if(var3 != null) {
            var4 = var3;
            if(!var3.isClosed()) {
               return var4;
            }
         }

         var4 = this.bB(var2);
         return var4;
      } else {
         throw new IllegalArgumentException("Bad participant ID");
      }
   }

   private abstract static class AbstractPeerStatusNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      private final ArrayList Yv = new ArrayList();

      AbstractPeerStatusNotifier(DataHolder var1, String[] var2) {
         super(var1);
         int var3 = 0;

         for(int var4 = var2.length; var3 < var4; ++var3) {
            this.Yv.add(var2[var3]);
         }

      }

      protected void a(RoomStatusUpdateListener var1, Room var2) {
         this.a(var1, var2, this.Yv);
      }

      protected abstract void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3);
   }

   private abstract static class AbstractRoomNotifier extends com.google.android.gms.common.api.a {
      AbstractRoomNotifier(DataHolder var1) {
         super(var1);
      }

      protected void a(RoomUpdateListener var1, DataHolder var2) {
         this.a(var1, GamesClientImpl.R(var2), var2.getStatusCode());
      }

      protected abstract void a(RoomUpdateListener var1, Room var2, int var3);
   }

   private abstract static class AbstractRoomStatusNotifier extends com.google.android.gms.common.api.a {
      AbstractRoomStatusNotifier(DataHolder var1) {
         super(var1);
      }

      protected void a(RoomStatusUpdateListener var1, DataHolder var2) {
         this.a(var1, GamesClientImpl.R(var2));
      }

      protected abstract void a(RoomStatusUpdateListener var1, Room var2);
   }

   private static final class AcceptQuestResultImpl extends b implements Quests.AcceptQuestResult {
      private final Quest Yw;

      AcceptQuestResultImpl(DataHolder var1) {
         super(var1);
         QuestBuffer var5 = new QuestBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.Yw = new QuestEntity((Quest)var5.get(0));
            } else {
               this.Yw = null;
            }
         } finally {
            var5.release();
         }

      }

      public Quest getQuest() {
         return this.Yw;
      }
   }

   private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      AchievementUpdatedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void g(int var1, String var2) {
         this.Ea.b(new GamesClientImpl.UpdateAchievementResultImpl(var1, var2));
      }
   }

   private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      AchievementsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void c(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadAchievementsResultImpl(var1));
      }
   }

   private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Yx;

      public AppContentLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.Yx = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void a(DataHolder[] var1) {
         this.Yx.b(new GamesClientImpl.LoadAppContentsResultImpl(var1));
      }
   }

   private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
      private final Status Eb;
      private final String Yy;

      CancelMatchResultImpl(Status var1, String var2) {
         this.Eb = var1;
         this.Yy = var2;
      }

      public String getMatchId() {
         return this.Yy;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class ClaimMilestoneResultImpl extends b implements Quests.ClaimMilestoneResult {
      private final Quest Yw;
      private final Milestone Yz;

      ClaimMilestoneResultImpl(DataHolder param1, String param2) {
         // $FF: Couldn't be decompiled
      }

      public Milestone getMilestone() {
         return this.Yz;
      }

      public Quest getQuest() {
         return this.Yw;
      }
   }

   private static final class CommitSnapshotResultImpl extends b implements Snapshots.CommitSnapshotResult {
      private final SnapshotMetadata YA;

      CommitSnapshotResultImpl(DataHolder var1) {
         super(var1);
         SnapshotMetadataBuffer var5 = new SnapshotMetadataBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.YA = new SnapshotMetadataEntity(var5.get(0));
            } else {
               this.YA = null;
            }
         } finally {
            var5.release();
         }

      }

      public SnapshotMetadata getSnapshotMetadata() {
         return this.YA;
      }
   }

   private static final class ConnectedToRoomNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      ConnectedToRoomNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomStatusUpdateListener var1, Room var2) {
         var1.onConnectedToRoom(var2);
      }
   }

   private static final class ContactSettingLoadResultImpl extends b implements Notifications.ContactSettingLoadResult {
      ContactSettingLoadResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      ContactSettingsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void D(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.ContactSettingLoadResultImpl(var1));
      }
   }

   private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      ContactSettingsUpdatedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void dP(int var1) {
         this.Ea.b(new Status(var1));
      }
   }

   private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
      private final Status Eb;
      private final String YB;

      DeleteSnapshotResultImpl(int var1, String var2) {
         this.Eb = new Status(var1);
         this.YB = var2;
      }

      public String getSnapshotId() {
         return this.YB;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class DisconnectedFromRoomNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      DisconnectedFromRoomNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomStatusUpdateListener var1, Room var2) {
         var1.onDisconnectedFromRoom(var2);
      }
   }

   private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      EventsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void d(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadEventResultImpl(var1));
      }
   }

   private static final class ExtendedGamesLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      ExtendedGamesLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void j(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadExtendedGamesResultImpl(var1));
      }
   }

   private class GameClientEventIncrementCache extends EventIncrementCache {
      public GameClientEventIncrementCache() {
         super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
      }

      protected void r(String var1, int var2) {
         try {
            if(GamesClientImpl.this.isConnected()) {
               ((IGamesService)GamesClientImpl.this.hw()).o(var1, var2);
            } else {
               GamesLog.p("GamesClientImpl", "Unable to increment event " + var1 + " by " + var2 + " because the games client is no longer connected");
            }
         } catch (RemoteException var3) {
            GamesLog.o("GamesClientImpl", "service died");
         }
      }
   }

   private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      GameInstancesLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void k(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadGameInstancesResultImpl(var1));
      }
   }

   private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
      private final Status Eb;
      private final String YC;
      private final boolean YD;

      public GameMuteStatusChangeResultImpl(int var1, String var2, boolean var3) {
         this.Eb = new Status(var1);
         this.YC = var2;
         this.YD = var3;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      GameMuteStatusChangedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void a(int var1, String var2, boolean var3) {
         this.Ea.b(new GamesClientImpl.GameMuteStatusChangeResultImpl(var1, var2, var3));
      }
   }

   private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
      private final Status Eb;
      private final String YC;
      private final boolean YD;

      public GameMuteStatusLoadResultImpl(DataHolder var1) {
         try {
            this.Eb = new Status(var1.getStatusCode());
            if(var1.getCount() > 0) {
               this.YC = var1.c("external_game_id", 0, 0);
               this.YD = var1.d("muted", 0, 0);
            } else {
               this.YC = null;
               this.YD = false;
            }
         } finally {
            var1.close();
         }

      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      GameMuteStatusLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void B(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.GameMuteStatusLoadResultImpl(var1));
      }
   }

   private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      GameSearchSuggestionsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void l(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadGameSearchSuggestionsResultImpl(var1));
      }
   }

   private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      GamesLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void i(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadGamesResultImpl(var1));
      }
   }

   private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
      private final Status Eb;
      private final Bundle YE;

      InboxCountResultImpl(Status var1, Bundle var2) {
         this.Eb = var1;
         this.YE = var2;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      InboxCountsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void f(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.Ea.b(new GamesClientImpl.InboxCountResultImpl(var3, var2));
      }
   }

   private static final class InitiateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
      InitiateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
      private final d Qe;

      InvitationReceivedBinderCallback(d var1) {
         this.Qe = var1;
      }

      public void n(DataHolder var1) {
         InvitationBuffer var2 = new InvitationBuffer(var1);
         Invitation var5 = null;

         try {
            if(var2.getCount() > 0) {
               var5 = (Invitation)((Invitation)var2.get(0)).freeze();
            }
         } finally {
            var2.release();
         }

         if(var5 != null) {
            this.Qe.a(new GamesClientImpl.InvitationReceivedNotifier(var5));
         }

      }

      public void onInvitationRemoved(String var1) {
         this.Qe.a(new GamesClientImpl.InvitationRemovedNotifier(var1));
      }
   }

   private static final class InvitationReceivedNotifier implements d.b {
      private final Invitation YF;

      InvitationReceivedNotifier(Invitation var1) {
         this.YF = var1;
      }

      public void a(OnInvitationReceivedListener var1) {
         var1.onInvitationReceived(this.YF);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnInvitationReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class InvitationRemovedNotifier implements d.b {
      private final String YG;

      InvitationRemovedNotifier(String var1) {
         this.YG = var1;
      }

      public void a(OnInvitationReceivedListener var1) {
         var1.onInvitationRemoved(this.YG);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnInvitationReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      InvitationsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void m(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadInvitationsResultImpl(var1));
      }
   }

   private static final class JoinedRoomNotifier extends GamesClientImpl.AbstractRoomNotifier {
      public JoinedRoomNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomUpdateListener var1, Room var2, int var3) {
         var1.onJoinedRoom(var3, var2);
      }
   }

   private static final class LeaderboardMetadataResultImpl extends b implements Leaderboards.LeaderboardMetadataResult {
      private final LeaderboardBuffer YH;

      LeaderboardMetadataResultImpl(DataHolder var1) {
         super(var1);
         this.YH = new LeaderboardBuffer(var1);
      }

      public LeaderboardBuffer getLeaderboards() {
         return this.YH;
      }
   }

   private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      LeaderboardScoresLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void a(DataHolder var1, DataHolder var2) {
         this.Ea.b(new GamesClientImpl.LoadScoresResultImpl(var1, var2));
      }
   }

   private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      LeaderboardsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void e(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LeaderboardMetadataResultImpl(var1));
      }
   }

   private static final class LeaveMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
      LeaveMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LeftRoomNotifier implements d.b {
      private final int Iv;
      private final String YI;

      LeftRoomNotifier(int var1, String var2) {
         this.Iv = var1;
         this.YI = var2;
      }

      public void a(RoomUpdateListener var1) {
         var1.onLeftRoom(this.Iv, this.YI);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((RoomUpdateListener)var1);
      }

      public void gG() {
      }
   }

   private static final class LoadAchievementsResultImpl extends b implements Achievements.LoadAchievementsResult {
      private final AchievementBuffer YJ;

      LoadAchievementsResultImpl(DataHolder var1) {
         super(var1);
         this.YJ = new AchievementBuffer(var1);
      }

      public AchievementBuffer getAchievements() {
         return this.YJ;
      }
   }

   private static final class LoadAclResultImpl extends b implements Acls.LoadAclResult {
      LoadAclResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadAppContentsResultImpl extends b implements AppContents.LoadAppContentResult {
      private final ArrayList YK;

      LoadAppContentsResultImpl(DataHolder[] var1) {
         super(var1[0]);
         this.YK = new ArrayList(Arrays.asList(var1));
      }
   }

   private static final class LoadEventResultImpl extends b implements Events.LoadEventsResult {
      private final EventBuffer YL;

      LoadEventResultImpl(DataHolder var1) {
         super(var1);
         this.YL = new EventBuffer(var1);
      }

      public EventBuffer getEvents() {
         return this.YL;
      }
   }

   private static final class LoadExtendedGamesResultImpl extends b implements GamesMetadata.LoadExtendedGamesResult {
      private final ExtendedGameBuffer YM;

      LoadExtendedGamesResultImpl(DataHolder var1) {
         super(var1);
         this.YM = new ExtendedGameBuffer(var1);
      }
   }

   private static final class LoadGameInstancesResultImpl extends b implements GamesMetadata.LoadGameInstancesResult {
      private final GameInstanceBuffer YN;

      LoadGameInstancesResultImpl(DataHolder var1) {
         super(var1);
         this.YN = new GameInstanceBuffer(var1);
      }
   }

   private static final class LoadGameSearchSuggestionsResultImpl extends b implements GamesMetadata.LoadGameSearchSuggestionsResult {
      private final GameSearchSuggestionBuffer YO;

      LoadGameSearchSuggestionsResultImpl(DataHolder var1) {
         super(var1);
         this.YO = new GameSearchSuggestionBuffer(var1);
      }
   }

   private static final class LoadGamesResultImpl extends b implements GamesMetadata.LoadGamesResult {
      private final GameBuffer YP;

      LoadGamesResultImpl(DataHolder var1) {
         super(var1);
         this.YP = new GameBuffer(var1);
      }

      public GameBuffer getGames() {
         return this.YP;
      }
   }

   private static final class LoadInvitationsResultImpl extends b implements Invitations.LoadInvitationsResult {
      private final InvitationBuffer YQ;

      LoadInvitationsResultImpl(DataHolder var1) {
         super(var1);
         this.YQ = new InvitationBuffer(var1);
      }

      public InvitationBuffer getInvitations() {
         return this.YQ;
      }
   }

   private static final class LoadMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
      LoadMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
      private final Status Eb;
      private final LoadMatchesResponse YR;

      LoadMatchesResultImpl(Status var1, Bundle var2) {
         this.Eb = var1;
         this.YR = new LoadMatchesResponse(var2);
      }

      public LoadMatchesResponse getMatches() {
         return this.YR;
      }

      public Status getStatus() {
         return this.Eb;
      }

      public void release() {
         this.YR.release();
      }
   }

   private static final class LoadOwnerCoverPhotoUrisResultImpl implements Players.LoadOwnerCoverPhotoUrisResult {
      private final Bundle DJ;
      private final Status Eb;

      LoadOwnerCoverPhotoUrisResultImpl(int var1, Bundle var2) {
         this.Eb = new Status(var1);
         this.DJ = var2;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class LoadPlayerScoreResultImpl extends b implements Leaderboards.LoadPlayerScoreResult {
      private final LeaderboardScoreEntity YS;

      LoadPlayerScoreResultImpl(DataHolder var1) {
         super(var1);
         LeaderboardScoreBuffer var5 = new LeaderboardScoreBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.YS = (LeaderboardScoreEntity)var5.get(0).freeze();
            } else {
               this.YS = null;
            }
         } finally {
            var5.release();
         }

      }

      public LeaderboardScore getScore() {
         return this.YS;
      }
   }

   private static final class LoadPlayersResultImpl extends b implements Players.LoadPlayersResult {
      private final PlayerBuffer YT;

      LoadPlayersResultImpl(DataHolder var1) {
         super(var1);
         this.YT = new PlayerBuffer(var1);
      }

      public PlayerBuffer getPlayers() {
         return this.YT;
      }
   }

   private static final class LoadProfileSettingsResultImpl extends b implements Players.LoadProfileSettingsResult {
      private final boolean YU;
      private final boolean Yh;

      LoadProfileSettingsResultImpl(DataHolder var1) {
         super(var1);

         try {
            if(var1.getCount() > 0) {
               int var2 = var1.au(0);
               this.Yh = var1.d("profile_visible", 0, var2);
               this.YU = var1.d("profile_visibility_explicitly_set", 0, var2);
            } else {
               this.Yh = true;
               this.YU = false;
            }
         } finally {
            var1.close();
         }

      }

      public Status getStatus() {
         return this.Eb;
      }

      public boolean isProfileVisible() {
         return this.Yh;
      }

      public boolean isVisibilityExplicitlySet() {
         return this.YU;
      }
   }

   private static final class LoadQuestsResultImpl extends b implements Quests.LoadQuestsResult {
      private final DataHolder JG;

      LoadQuestsResultImpl(DataHolder var1) {
         super(var1);
         this.JG = var1;
      }

      public QuestBuffer getQuests() {
         return new QuestBuffer(this.JG);
      }
   }

   private static final class LoadRequestSummariesResultImpl extends b implements Requests.LoadRequestSummariesResult {
      LoadRequestSummariesResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
      private final Status Eb;
      private final Bundle YV;

      LoadRequestsResultImpl(Status var1, Bundle var2) {
         this.Eb = var1;
         this.YV = var2;
      }

      public GameRequestBuffer getRequests(int var1) {
         String var2 = RequestType.dZ(var1);
         return !this.YV.containsKey(var2)?null:new GameRequestBuffer((DataHolder)this.YV.get(var2));
      }

      public Status getStatus() {
         return this.Eb;
      }

      public void release() {
         Iterator var1 = this.YV.keySet().iterator();

         while(var1.hasNext()) {
            String var2 = (String)var1.next();
            DataHolder var3 = (DataHolder)this.YV.getParcelable(var2);
            if(var3 != null) {
               var3.close();
            }
         }

      }
   }

   private static final class LoadScoresResultImpl extends b implements Leaderboards.LoadScoresResult {
      private final LeaderboardEntity YW;
      private final LeaderboardScoreBuffer YX;

      LoadScoresResultImpl(DataHolder var1, DataHolder var2) {
         super(var2);
         LeaderboardBuffer var5 = new LeaderboardBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.YW = (LeaderboardEntity)((Leaderboard)var5.get(0)).freeze();
            } else {
               this.YW = null;
            }
         } finally {
            var5.release();
         }

         this.YX = new LeaderboardScoreBuffer(var2);
      }

      public Leaderboard getLeaderboard() {
         return this.YW;
      }

      public LeaderboardScoreBuffer getScores() {
         return this.YX;
      }
   }

   private static final class LoadSnapshotsResultImpl extends b implements Snapshots.LoadSnapshotsResult {
      LoadSnapshotsResultImpl(DataHolder var1) {
         super(var1);
      }

      public SnapshotMetadataBuffer getSnapshots() {
         return new SnapshotMetadataBuffer(this.JG);
      }
   }

   private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
      private final Status Eb;
      private final List YY;
      private final Bundle YZ;

      LoadXpForGameCategoriesResultImpl(Status var1, Bundle var2) {
         this.Eb = var1;
         this.YY = var2.getStringArrayList("game_category_list");
         this.YZ = var2;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class LoadXpStreamResultImpl extends b implements Players.LoadXpStreamResult {
      private final ExperienceEventBuffer Za;

      LoadXpStreamResultImpl(DataHolder var1) {
         super(var1);
         this.Za = new ExperienceEventBuffer(var1);
      }
   }

   private static final class MatchRemovedNotifier implements d.b {
      private final String Zb;

      MatchRemovedNotifier(String var1) {
         this.Zb = var1;
      }

      public void a(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchRemoved(this.Zb);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
      private final d Qe;

      MatchUpdateReceivedBinderCallback(d var1) {
         this.Qe = var1;
      }

      public void onTurnBasedMatchRemoved(String var1) {
         this.Qe.a(new GamesClientImpl.MatchRemovedNotifier(var1));
      }

      public void t(DataHolder var1) {
         TurnBasedMatchBuffer var2 = new TurnBasedMatchBuffer(var1);
         TurnBasedMatch var5 = null;

         try {
            if(var2.getCount() > 0) {
               var5 = (TurnBasedMatch)((TurnBasedMatch)var2.get(0)).freeze();
            }
         } finally {
            var2.release();
         }

         if(var5 != null) {
            this.Qe.a(new GamesClientImpl.MatchUpdateReceivedNotifier(var5));
         }

      }
   }

   private static final class MatchUpdateReceivedNotifier implements d.b {
      private final TurnBasedMatch Zc;

      MatchUpdateReceivedNotifier(TurnBasedMatch var1) {
         this.Zc = var1;
      }

      public void a(OnTurnBasedMatchUpdateReceivedListener var1) {
         var1.onTurnBasedMatchReceived(this.Zc);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnTurnBasedMatchUpdateReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class MessageReceivedNotifier implements d.b {
      private final RealTimeMessage Zd;

      MessageReceivedNotifier(RealTimeMessage var1) {
         this.Zd = var1;
      }

      public void a(RealTimeMessageReceivedListener var1) {
         var1.onRealTimeMessageReceived(this.Zd);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((RealTimeMessageReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class NearbyPlayerDetectedNotifier implements d.b {
      private final Player Ze;

      public void a(OnNearbyPlayerDetectedListener var1) {
         var1.a(this.Ze);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnNearbyPlayerDetectedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      NotifyAclLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void C(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadAclResultImpl(var1));
      }
   }

   private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      NotifyAclUpdatedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void dO(int var1) {
         this.Ea.b(new Status(var1));
      }
   }

   private static final class OpenSnapshotResultImpl extends b implements Snapshots.OpenSnapshotResult {
      private final Snapshot Zf;
      private final String Zg;
      private final Snapshot Zh;
      private final Contents Zi;
      private final SnapshotContents Zj;

      OpenSnapshotResultImpl(DataHolder var1, Contents var2) {
         this(var1, (String)null, var2, (Contents)null, (Contents)null);
      }

      OpenSnapshotResultImpl(DataHolder param1, String param2, Contents param3, Contents param4, Contents param5) {
         // $FF: Couldn't be decompiled
      }

      public String getConflictId() {
         return this.Zg;
      }

      public Snapshot getConflictingSnapshot() {
         return this.Zh;
      }

      public SnapshotContents getResolutionSnapshotContents() {
         return this.Zj;
      }

      public Snapshot getSnapshot() {
         return this.Zf;
      }
   }

   private static final class OwnerCoverPhotoUrisLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      OwnerCoverPhotoUrisLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void d(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         this.Ea.b(new GamesClientImpl.LoadOwnerCoverPhotoUrisResultImpl(var1, var2));
      }
   }

   private static final class P2PConnectedNotifier implements d.b {
      private final String Zk;

      P2PConnectedNotifier(String var1) {
         this.Zk = var1;
      }

      public void a(RoomStatusUpdateListener var1) {
         var1.onP2PConnected(this.Zk);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((RoomStatusUpdateListener)var1);
      }

      public void gG() {
      }
   }

   private static final class P2PDisconnectedNotifier implements d.b {
      private final String Zk;

      P2PDisconnectedNotifier(String var1) {
         this.Zk = var1;
      }

      public void a(RoomStatusUpdateListener var1) {
         var1.onP2PDisconnected(this.Zk);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((RoomStatusUpdateListener)var1);
      }

      public void gG() {
      }
   }

   private static final class PeerConnectedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerConnectedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeersConnected(var2, var3);
      }
   }

   private static final class PeerDeclinedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerDeclinedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeerDeclined(var2, var3);
      }
   }

   private static final class PeerDisconnectedNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerDisconnectedNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeersDisconnected(var2, var3);
      }
   }

   private static final class PeerInvitedToRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerInvitedToRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeerInvitedToRoom(var2, var3);
      }
   }

   private static final class PeerJoinedRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerJoinedRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeerJoined(var2, var3);
      }
   }

   private static final class PeerLeftRoomNotifier extends GamesClientImpl.AbstractPeerStatusNotifier {
      PeerLeftRoomNotifier(DataHolder var1, String[] var2) {
         super(var1, var2);
      }

      protected void a(RoomStatusUpdateListener var1, Room var2, ArrayList var3) {
         var1.onPeerLeft(var2, var3);
      }
   }

   private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      PlayerLeaderboardScoreLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void E(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadPlayerScoreResultImpl(var1));
      }
   }

   private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      PlayerXpForGameCategoriesLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void e(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.Ea.b(new GamesClientImpl.LoadXpForGameCategoriesResultImpl(var3, var2));
      }
   }

   static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      PlayerXpStreamLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void P(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadXpStreamResultImpl(var1));
      }
   }

   private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      PlayersLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void g(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }

      public void h(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadPlayersResultImpl(var1));
      }
   }

   static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      ProfileSettingsLoadedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void Q(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.LoadProfileSettingsResultImpl(var1));
      }
   }

   private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      ProfileSettingsUpdatedBinderCallback(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void dQ(int var1) {
         this.Ea.b(new Status(var1));
      }
   }

   private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zl;

      public QuestAcceptedBinderCallbacks(BaseImplementation.b var1) {
         this.Zl = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void L(DataHolder var1) {
         this.Zl.b(new GamesClientImpl.AcceptQuestResultImpl(var1));
      }
   }

   private static final class QuestCompletedNotifier implements d.b {
      private final Quest Yw;

      QuestCompletedNotifier(Quest var1) {
         this.Yw = var1;
      }

      public void a(QuestUpdateListener var1) {
         var1.onQuestCompleted(this.Yw);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((QuestUpdateListener)var1);
      }

      public void gG() {
      }
   }

   private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zm;
      private final String Zn;

      public QuestMilestoneClaimBinderCallbacks(BaseImplementation.b var1, String var2) {
         this.Zm = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
         this.Zn = (String)jx.b((Object)var2, "MilestoneId must not be null");
      }

      public void K(DataHolder var1) {
         this.Zm.b(new GamesClientImpl.ClaimMilestoneResultImpl(var1, this.Zn));
      }
   }

   private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
      private final d Qe;

      QuestUpdateBinderCallback(d var1) {
         this.Qe = var1;
      }

      private Quest T(DataHolder var1) {
         QuestBuffer var2 = new QuestBuffer(var1);
         Quest var5 = null;

         try {
            if(var2.getCount() > 0) {
               var5 = (Quest)((Quest)var2.get(0)).freeze();
            }
         } finally {
            var2.release();
         }

         return var5;
      }

      public void M(DataHolder var1) {
         Quest var2 = this.T(var1);
         if(var2 != null) {
            this.Qe.a(new GamesClientImpl.QuestCompletedNotifier(var2));
         }

      }
   }

   private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zo;

      public QuestsLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.Zo = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void O(DataHolder var1) {
         this.Zo.b(new GamesClientImpl.LoadQuestsResultImpl(var1));
      }
   }

   private static final class RealTimeMessageSentNotifier implements d.b {
      private final int Iv;
      private final String Zp;
      private final int Zq;

      RealTimeMessageSentNotifier(int var1, int var2, String var3) {
         this.Iv = var1;
         this.Zq = var2;
         this.Zp = var3;
      }

      public void a(RealTimeMultiplayer.ReliableMessageSentCallback var1) {
         if(var1 != null) {
            var1.onRealTimeMessageSent(this.Iv, this.Zq, this.Zp);
         }

      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((RealTimeMultiplayer.ReliableMessageSentCallback)var1);
      }

      public void gG() {
      }
   }

   private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
      final d Zr;

      public RealTimeReliableMessageBinderCallbacks(d var1) {
         this.Zr = var1;
      }

      public void b(int var1, int var2, String var3) {
         if(this.Zr != null) {
            this.Zr.a(new GamesClientImpl.RealTimeMessageSentNotifier(var1, var2, var3));
         }

      }
   }

   private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
      private final d Qe;

      RequestReceivedBinderCallback(d var1) {
         this.Qe = var1;
      }

      public void o(DataHolder var1) {
         GameRequestBuffer var2 = new GameRequestBuffer(var1);
         GameRequest var5 = null;

         try {
            if(var2.getCount() > 0) {
               var5 = (GameRequest)((GameRequest)var2.get(0)).freeze();
            }
         } finally {
            var2.release();
         }

         if(var5 != null) {
            this.Qe.a(new GamesClientImpl.RequestReceivedNotifier(var5));
         }

      }

      public void onRequestRemoved(String var1) {
         this.Qe.a(new GamesClientImpl.RequestRemovedNotifier(var1));
      }
   }

   private static final class RequestReceivedNotifier implements d.b {
      private final GameRequest Zs;

      RequestReceivedNotifier(GameRequest var1) {
         this.Zs = var1;
      }

      public void a(OnRequestReceivedListener var1) {
         var1.onRequestReceived(this.Zs);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnRequestReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class RequestRemovedNotifier implements d.b {
      private final String Zt;

      RequestRemovedNotifier(String var1) {
         this.Zt = var1;
      }

      public void a(OnRequestReceivedListener var1) {
         var1.onRequestRemoved(this.Zt);
      }

      // $FF: synthetic method
      public void c(Object var1) {
         this.a((OnRequestReceivedListener)var1);
      }

      public void gG() {
      }
   }

   private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zu;

      public RequestSentBinderCallbacks(BaseImplementation.b var1) {
         this.Zu = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void G(DataHolder var1) {
         this.Zu.b(new GamesClientImpl.SendRequestResultImpl(var1));
      }
   }

   private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zv;

      public RequestSummariesLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.Zv = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void H(DataHolder var1) {
         this.Zv.b(new GamesClientImpl.LoadRequestSummariesResultImpl(var1));
      }
   }

   private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zw;

      public RequestsLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.Zw = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void c(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.Zw.b(new GamesClientImpl.LoadRequestsResultImpl(var3, var2));
      }
   }

   private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Zx;

      public RequestsUpdatedBinderCallbacks(BaseImplementation.b var1) {
         this.Zx = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void F(DataHolder var1) {
         this.Zx.b(new GamesClientImpl.UpdateRequestsResultImpl(var1));
      }
   }

   private static final class RoomAutoMatchingNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      RoomAutoMatchingNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomAutoMatching(var2);
      }
   }

   private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
      private final d ZA;
      private final d Zy;
      private final d Zz;

      public RoomBinderCallbacks(d var1) {
         this.Zy = (d)jx.b((Object)var1, "Callbacks must not be null");
         this.Zz = null;
         this.ZA = null;
      }

      public RoomBinderCallbacks(d var1, d var2, d var3) {
         this.Zy = (d)jx.b((Object)var1, "Callbacks must not be null");
         this.Zz = var2;
         this.ZA = var3;
      }

      public void A(DataHolder var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.DisconnectedFromRoomNotifier(var1));
         }

      }

      public void a(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerInvitedToRoomNotifier(var1, var2));
         }

      }

      public void b(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerJoinedRoomNotifier(var1, var2));
         }

      }

      public void c(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerLeftRoomNotifier(var1, var2));
         }

      }

      public void d(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerDeclinedNotifier(var1, var2));
         }

      }

      public void e(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerConnectedNotifier(var1, var2));
         }

      }

      public void f(DataHolder var1, String[] var2) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.PeerDisconnectedNotifier(var1, var2));
         }

      }

      public void onLeftRoom(int var1, String var2) {
         this.Zy.a(new GamesClientImpl.LeftRoomNotifier(var1, var2));
      }

      public void onP2PConnected(String var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.P2PConnectedNotifier(var1));
         }

      }

      public void onP2PDisconnected(String var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.P2PDisconnectedNotifier(var1));
         }

      }

      public void onRealTimeMessageReceived(RealTimeMessage var1) {
         if(this.ZA != null) {
            this.ZA.a(new GamesClientImpl.MessageReceivedNotifier(var1));
         }

      }

      public void u(DataHolder var1) {
         this.Zy.a(new GamesClientImpl.RoomCreatedNotifier(var1));
      }

      public void v(DataHolder var1) {
         this.Zy.a(new GamesClientImpl.JoinedRoomNotifier(var1));
      }

      public void w(DataHolder var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.RoomConnectingNotifier(var1));
         }

      }

      public void x(DataHolder var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.RoomAutoMatchingNotifier(var1));
         }

      }

      public void y(DataHolder var1) {
         this.Zy.a(new GamesClientImpl.RoomConnectedNotifier(var1));
      }

      public void z(DataHolder var1) {
         if(this.Zz != null) {
            this.Zz.a(new GamesClientImpl.ConnectedToRoomNotifier(var1));
         }

      }
   }

   private static final class RoomConnectedNotifier extends GamesClientImpl.AbstractRoomNotifier {
      RoomConnectedNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomConnected(var3, var2);
      }
   }

   private static final class RoomConnectingNotifier extends GamesClientImpl.AbstractRoomStatusNotifier {
      RoomConnectingNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomStatusUpdateListener var1, Room var2) {
         var1.onRoomConnecting(var2);
      }
   }

   private static final class RoomCreatedNotifier extends GamesClientImpl.AbstractRoomNotifier {
      public RoomCreatedNotifier(DataHolder var1) {
         super(var1);
      }

      public void a(RoomUpdateListener var1, Room var2, int var3) {
         var1.onRoomCreated(var3, var2);
      }
   }

   private static final class SendRequestResultImpl extends b implements Requests.SendRequestResult {
      private final GameRequest Zs;

      SendRequestResultImpl(DataHolder var1) {
         super(var1);
         GameRequestBuffer var5 = new GameRequestBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.Zs = (GameRequest)((GameRequest)var5.get(0)).freeze();
            } else {
               this.Zs = null;
            }
         } finally {
            var5.release();
         }

      }
   }

   private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      public SignOutCompleteBinderCallbacks(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void fK() {
         Status var1 = new Status(0);
         this.Ea.b(var1);
      }
   }

   private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZB;

      public SnapshotCommittedBinderCallbacks(BaseImplementation.b var1) {
         this.ZB = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void J(DataHolder var1) {
         this.ZB.b(new GamesClientImpl.CommitSnapshotResultImpl(var1));
      }
   }

   static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      public SnapshotDeletedBinderCallbacks(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void i(int var1, String var2) {
         this.Ea.b(new GamesClientImpl.DeleteSnapshotResultImpl(var1, var2));
      }
   }

   private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZC;

      public SnapshotOpenedBinderCallbacks(BaseImplementation.b var1) {
         this.ZC = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void a(DataHolder var1, Contents var2) {
         this.ZC.b(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2));
      }

      public void a(DataHolder var1, String var2, Contents var3, Contents var4, Contents var5) {
         this.ZC.b(new GamesClientImpl.OpenSnapshotResultImpl(var1, var2, var3, var4, var5));
      }
   }

   private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZD;

      public SnapshotsLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.ZD = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void I(DataHolder var1) {
         this.ZD.b(new GamesClientImpl.LoadSnapshotsResultImpl(var1));
      }
   }

   private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b Ea;

      public SubmitScoreBinderCallbacks(BaseImplementation.b var1) {
         this.Ea = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void f(DataHolder var1) {
         this.Ea.b(new GamesClientImpl.SubmitScoreResultImpl(var1));
      }
   }

   private static final class SubmitScoreResultImpl extends b implements Leaderboards.SubmitScoreResult {
      private final ScoreSubmissionData ZE;

      public SubmitScoreResultImpl(DataHolder var1) {
         super(var1);

         try {
            this.ZE = new ScoreSubmissionData(var1);
         } finally {
            var1.close();
         }

      }

      public ScoreSubmissionData getScoreData() {
         return this.ZE;
      }
   }

   private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZF;

      public TurnBasedMatchCanceledBinderCallbacks(BaseImplementation.b var1) {
         this.ZF = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void h(int var1, String var2) {
         Status var3 = new Status(var1);
         this.ZF.b(new GamesClientImpl.CancelMatchResultImpl(var3, var2));
      }
   }

   private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZG;

      public TurnBasedMatchInitiatedBinderCallbacks(BaseImplementation.b var1) {
         this.ZG = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void q(DataHolder var1) {
         this.ZG.b(new GamesClientImpl.InitiateMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZH;

      public TurnBasedMatchLeftBinderCallbacks(BaseImplementation.b var1) {
         this.ZH = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void s(DataHolder var1) {
         this.ZH.b(new GamesClientImpl.LeaveMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZI;

      public TurnBasedMatchLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.ZI = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void p(DataHolder var1) {
         this.ZI.b(new GamesClientImpl.LoadMatchResultImpl(var1));
      }
   }

   private abstract static class TurnBasedMatchResult extends b {
      final TurnBasedMatch Zc;

      TurnBasedMatchResult(DataHolder var1) {
         super(var1);
         TurnBasedMatchBuffer var5 = new TurnBasedMatchBuffer(var1);

         try {
            if(var5.getCount() > 0) {
               this.Zc = (TurnBasedMatch)((TurnBasedMatch)var5.get(0)).freeze();
            } else {
               this.Zc = null;
            }
         } finally {
            var5.release();
         }

      }

      public TurnBasedMatch getMatch() {
         return this.Zc;
      }
   }

   private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZJ;

      public TurnBasedMatchUpdatedBinderCallbacks(BaseImplementation.b var1) {
         this.ZJ = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void r(DataHolder var1) {
         this.ZJ.b(new GamesClientImpl.UpdateMatchResultImpl(var1));
      }
   }

   private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
      private final BaseImplementation.b ZK;

      public TurnBasedMatchesLoadedBinderCallbacks(BaseImplementation.b var1) {
         this.ZK = (BaseImplementation.b)jx.b((Object)var1, "Holder must not be null");
      }

      public void b(int var1, Bundle var2) {
         var2.setClassLoader(this.getClass().getClassLoader());
         Status var3 = new Status(var1);
         this.ZK.b(new GamesClientImpl.LoadMatchesResultImpl(var3, var2));
      }
   }

   private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
      private final Status Eb;
      private final String Xx;

      UpdateAchievementResultImpl(int var1, String var2) {
         this.Eb = new Status(var1);
         this.Xx = var2;
      }

      public String getAchievementId() {
         return this.Xx;
      }

      public Status getStatus() {
         return this.Eb;
      }
   }

   private static final class UpdateMatchResultImpl extends GamesClientImpl.TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
      UpdateMatchResultImpl(DataHolder var1) {
         super(var1);
      }
   }

   private static final class UpdateRequestsResultImpl extends b implements Requests.UpdateRequestsResult {
      private final RequestUpdateOutcomes ZL;

      UpdateRequestsResultImpl(DataHolder var1) {
         super(var1);
         this.ZL = RequestUpdateOutcomes.W(var1);
      }

      public Set getRequestIds() {
         return this.ZL.getRequestIds();
      }

      public int getRequestOutcome(String var1) {
         return this.ZL.getRequestOutcome(var1);
      }
   }
}
