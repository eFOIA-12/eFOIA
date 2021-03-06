package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.internal.jx;

public final class RoomConfigImpl extends RoomConfig {
   private final String YG;
   private final int adW;
   private final RoomUpdateListener aeh;
   private final RoomStatusUpdateListener aei;
   private final RealTimeMessageReceivedListener aej;
   private final Bundle aem;
   private final boolean aen;
   private final String[] aeo;

   RoomConfigImpl(RoomConfig.Builder var1) {
      this.aeh = var1.aeh;
      this.aei = var1.aei;
      this.aej = var1.aej;
      this.YG = var1.aek;
      this.adW = var1.adW;
      this.aem = var1.aem;
      this.aen = var1.aen;
      int var2 = var1.ael.size();
      this.aeo = (String[])var1.ael.toArray(new String[var2]);
      if(this.aej == null) {
         jx.a(this.aen, "Must either enable sockets OR specify a message listener");
      }

   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public String getInvitationId() {
      return this.YG;
   }

   public String[] getInvitedPlayerIds() {
      return this.aeo;
   }

   public RealTimeMessageReceivedListener getMessageReceivedListener() {
      return this.aej;
   }

   public RoomStatusUpdateListener getRoomStatusUpdateListener() {
      return this.aei;
   }

   public RoomUpdateListener getRoomUpdateListener() {
      return this.aeh;
   }

   public int getVariant() {
      return this.adW;
   }

   public boolean isSocketEnabled() {
      return this.aen;
   }
}
