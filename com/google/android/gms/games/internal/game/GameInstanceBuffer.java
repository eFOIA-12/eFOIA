package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.game.GameInstance;
import com.google.android.gms.games.internal.game.GameInstanceRef;

public final class GameInstanceBuffer extends DataBuffer {
   public GameInstanceBuffer(DataHolder var1) {
      super(var1);
   }

   public GameInstance ee(int var1) {
      return new GameInstanceRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.ee(var1);
   }
}
