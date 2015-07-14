package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeRef;

public final class GameBadgeBuffer extends DataBuffer {
   public GameBadge ec(int var1) {
      return new GameBadgeRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.ec(var1);
   }
}
