package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestRef;

public final class GameRequestBuffer extends g {
   public GameRequestBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.o(var1, var2);
   }

   protected String ha() {
      return "external_request_id";
   }

   protected GameRequest o(int var1, int var2) {
      return new GameRequestRef(this.JG, var1, var2);
   }
}
