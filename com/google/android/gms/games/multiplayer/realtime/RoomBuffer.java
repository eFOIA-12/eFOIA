package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomRef;

public final class RoomBuffer extends g {
   public RoomBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.l(var1, var2);
   }

   protected String ha() {
      return "external_match_id";
   }

   protected Room l(int var1, int var2) {
      return new RoomRef(this.JG, var1, var2);
   }
}
