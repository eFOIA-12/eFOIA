package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchRef;

public final class TurnBasedMatchBuffer extends g {
   public TurnBasedMatchBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.m(var1, var2);
   }

   protected String ha() {
      return "external_match_id";
   }

   protected TurnBasedMatch m(int var1, int var2) {
      return new TurnBasedMatchRef(this.JG, var1, var2);
   }
}
