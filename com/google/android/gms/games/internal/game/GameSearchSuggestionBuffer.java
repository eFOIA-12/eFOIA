package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.game.GameSearchSuggestion;
import com.google.android.gms.games.internal.game.GameSearchSuggestionRef;

public final class GameSearchSuggestionBuffer extends DataBuffer {
   public GameSearchSuggestionBuffer(DataHolder var1) {
      super(var1);
   }

   public GameSearchSuggestion ef(int var1) {
      return new GameSearchSuggestionRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.ef(var1);
   }
}
