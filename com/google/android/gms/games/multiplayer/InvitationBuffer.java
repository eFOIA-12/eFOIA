package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationRef;

public final class InvitationBuffer extends g {
   public InvitationBuffer(DataHolder var1) {
      super(var1);
   }

   // $FF: synthetic method
   protected Object f(int var1, int var2) {
      return this.k(var1, var2);
   }

   protected String ha() {
      return "external_invitation_id";
   }

   protected Invitation k(int var1, int var2) {
      return new InvitationRef(this.JG, var1, var2);
   }
}
