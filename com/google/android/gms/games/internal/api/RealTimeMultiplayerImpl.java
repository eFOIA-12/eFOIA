package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.d;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
   private static d a(GoogleApiClient var0, Object var1) {
      return var1 == null?null:var0.d(var1);
   }

   public void create(GoogleApiClient var1, RoomConfig var2) {
      d var3 = var1.d(var2.getRoomUpdateListener());
      d var4 = a(var1, var2.getRoomStatusUpdateListener());
      d var5 = a(var1, var2.getMessageReceivedListener());
      Games.d(var1).a(var3, var4, var5, var2);
   }

   public void declineInvitation(GoogleApiClient var1, String var2) {
      Games.d(var1).q(var2, 0);
   }

   public void dismissInvitation(GoogleApiClient var1, String var2) {
      Games.d(var1).p(var2, 0);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3) {
      return Games.d(var1).b(var2, var3, true);
   }

   public Intent getSelectOpponentsIntent(GoogleApiClient var1, int var2, int var3, boolean var4) {
      return Games.d(var1).b(var2, var3, var4);
   }

   public RealTimeSocket getSocketForParticipant(GoogleApiClient var1, String var2, String var3) {
      return Games.d(var1).s(var2, var3);
   }

   public Intent getWaitingRoomIntent(GoogleApiClient var1, Room var2, int var3) {
      return Games.d(var1).a(var2, var3);
   }

   public void join(GoogleApiClient var1, RoomConfig var2) {
      d var3 = var1.d(var2.getRoomUpdateListener());
      d var4 = a(var1, var2.getRoomStatusUpdateListener());
      d var5 = a(var1, var2.getMessageReceivedListener());
      Games.d(var1).b(var3, var4, var5, var2);
   }

   public void leave(GoogleApiClient var1, RoomUpdateListener var2, String var3) {
      d var4 = var1.d(var2);
      Games.d(var1).a(var4, var3);
   }

   public int sendReliableMessage(GoogleApiClient var1, RealTimeMultiplayer.ReliableMessageSentCallback var2, byte[] var3, String var4, String var5) {
      d var6 = a(var1, var2);
      return Games.d(var1).a(var6, var3, var4, var5);
   }

   public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, String var4) {
      return Games.d(var1).a(var2, var3, new String[]{var4});
   }

   public int sendUnreliableMessage(GoogleApiClient var1, byte[] var2, String var3, List var4) {
      String[] var5 = (String[])var4.toArray(new String[var4.size()]);
      return Games.d(var1).a(var2, var3, var5);
   }

   public int sendUnreliableMessageToOthers(GoogleApiClient var1, byte[] var2, String var3) {
      return Games.d(var1).d(var2, var3);
   }
}
