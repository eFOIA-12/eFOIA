package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameRef;

public final class ExtendedGameBuffer extends g {
   public ExtendedGameBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.i(var1, var2);
   }

   protected String ha() {
      return "external_game_id";
   }

   protected ExtendedGame i(int var1, int var2) {
      return new ExtendedGameRef(this.JG, var1, var2);
   }
}
