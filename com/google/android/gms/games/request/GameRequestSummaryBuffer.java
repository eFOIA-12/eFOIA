package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.games.request.GameRequestSummary;
import com.google.android.gms.games.request.GameRequestSummaryRef;

public final class GameRequestSummaryBuffer extends DataBuffer {
   public GameRequestSummary ep(int var1) {
      return new GameRequestSummaryRef(this.JG, var1);
   }

   // $FF: synthetic method
   public Object get(int var1) {
      return this.ep(var1);
   }
}
